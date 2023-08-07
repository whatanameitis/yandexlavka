package ru.grisha.myspring.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "order", schema = "yandex")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DynamicInsert
@DynamicUpdate
@EqualsAndHashCode(of = {"orderId"})
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "weight")
    private Integer weight;

    @Column(name = "price")
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "courier_id")
    private Courier courier;

    @OneToOne
    @PrimaryKeyJoinColumn(name = "region_id")
    private Region region;
}

















