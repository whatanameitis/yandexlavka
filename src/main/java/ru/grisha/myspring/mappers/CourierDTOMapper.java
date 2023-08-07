package ru.grisha.myspring.mappers;

import org.springframework.stereotype.Service;
import ru.grisha.myspring.dto.CourierDTO;
import ru.grisha.myspring.entity.Courier;

import java.util.function.Function;

@Service
public class CourierDTOMapper implements Function<Courier, CourierDTO> {
    @Override
    public CourierDTO apply(Courier courier) {
        return CourierDTO.builder().
                regions(courier.getRegions()).
                courierType(courier.getCourierType()).
                orders(courier.getOrders()).
                build();
    }
}
