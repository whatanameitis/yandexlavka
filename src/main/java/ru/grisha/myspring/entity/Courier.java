package ru.grisha.myspring.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import ru.grisha.myspring.utility.CourierType;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "courier", schema = "yandex")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DynamicInsert
@DynamicUpdate
@EqualsAndHashCode(of = {"courierId"})
public class Courier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "courier_id")
    private Long courierId;

    @Column(name = "type")
    private CourierType courierType;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "courier_region",
            schema = "yandex",
            joinColumns = {@JoinColumn(name = "courier_id")},
            inverseJoinColumns = {@JoinColumn(name = "region_id")}
    )
    private Set<Region> regions;

    @OneToMany(mappedBy = "courier", cascade = CascadeType.ALL)
    @Column(name = "order")
    private List<Order> orders;
}
