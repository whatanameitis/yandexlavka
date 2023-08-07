package ru.grisha.myspring.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import ru.grisha.myspring.entity.Order;
import ru.grisha.myspring.entity.Region;
import ru.grisha.myspring.utility.CourierType;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class CourierDTO {
    private Set<Region> regions;
    private CourierType courierType;
    private List<Order> orders;
}
