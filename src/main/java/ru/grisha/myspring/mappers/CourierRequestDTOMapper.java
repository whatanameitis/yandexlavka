package ru.grisha.myspring.mappers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.grisha.myspring.entity.Courier;
import ru.grisha.myspring.repositories.RegionsRepository;
import ru.grisha.myspring.requests.CourierRequestDTO;

import java.util.function.Function;

@AllArgsConstructor
@Service
public class CourierRequestDTOMapper implements Function<CourierRequestDTO, Courier> {
    private final RegionsRepository regionsRepository;

    @Override
    public Courier apply(CourierRequestDTO courierRequestDTO) {
        return Courier.builder().
                courierType(courierRequestDTO.getCourierType()).
                regions(regionsRepository.findAllByRegionIdIsIn(courierRequestDTO.getRegionIds())).
                build();
    }
}
