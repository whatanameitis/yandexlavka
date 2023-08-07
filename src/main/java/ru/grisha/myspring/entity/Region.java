package ru.grisha.myspring.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.Set;

@Entity
@Table(name = "region", schema = "yandex")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DynamicInsert
@DynamicUpdate
@EqualsAndHashCode(of = {"regionId"})
public class Region {
    @Id
    @Column(name = "region_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long regionId;

    @Column(name = "region", updatable = false, insertable = false)
    private Integer region;

    @ManyToMany(mappedBy = "regions")
    private Set<Courier> couriers;
}
