package ru.grisha.myspring.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.grisha.myspring.dto.CourierDTO;

import ru.grisha.myspring.entity.Courier;
import ru.grisha.myspring.mappers.CourierDTOMapper;
import ru.grisha.myspring.mappers.CourierRequestDTOMapper;
import ru.grisha.myspring.repositories.CouriersRepository;
import ru.grisha.myspring.requests.CourierRequestDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class CourierService {
    private final CouriersRepository couriersRepository;
    private final CourierDTOMapper toCourierDTO;

    private final CourierRequestDTOMapper toCourier;
    public Page<CourierDTO> getCouriers(Integer offset, Integer limit) {
        List<CourierDTO> listResponse = couriersRepository.
                findAll(PageRequest.of(offset, limit)).
                stream().
                map(toCourierDTO).
                collect(Collectors.toList());

        return new PageImpl<>(listResponse);
    }

    public void postCouriers(List<CourierRequestDTO> courierRequestDTOS) {
        List<Courier> couriers = courierRequestDTOS.stream().map(toCourier).toList();
        couriersRepository.saveAll(couriers);
    }
    public CourierDTO getCourier(Long id) {
        return couriersRepository.findById(id).map(toCourierDTO).orElse(null);
    }
}
