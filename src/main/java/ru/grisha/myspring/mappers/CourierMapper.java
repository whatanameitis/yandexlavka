package ru.grisha.myspring.mappers;

import org.springframework.stereotype.Service;
import ru.grisha.myspring.dto.CourierDTO;
import ru.grisha.myspring.entity.Courier;

import java.util.function.Function;

@Service
public class CourierMapper implements Function<CourierDTO, Courier> {
    @Override
    public Courier apply(CourierDTO courierDTO) {
        return Courier.builder().
                courierType(courierDTO.getCourierType()).
                regions(courierDTO.getRegions()).
                orders(courierDTO.getOrders()).
                build();
    }
}
