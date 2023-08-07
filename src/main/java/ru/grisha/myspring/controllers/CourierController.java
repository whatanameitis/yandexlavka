package ru.grisha.myspring.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.grisha.myspring.dto.CourierDTO;
import ru.grisha.myspring.requests.CourierRequestDTO;
import ru.grisha.myspring.services.CourierService;


import java.util.List;


@RestController
@RequestMapping("")
@RequiredArgsConstructor
public class CourierController {

    private final CourierService courierService;

    @GetMapping(value = "/couriers")
    public ResponseEntity<Page<CourierDTO>> getCouriers(
            @RequestParam(value = "offset", defaultValue = "0") Integer offset,
            @RequestParam(value = "limit", defaultValue = "1") Integer limit
    ) {
        return ResponseEntity.ok(courierService.getCouriers(offset, limit));
    }

    @GetMapping(value = "/couriers/{courier_id}")
    public ResponseEntity<CourierDTO> getCourier(@PathVariable Long courier_id) {
        return ResponseEntity.ok(courierService.getCourier(courier_id));
    }

    @PostMapping(value = "/couriers")
    public void postCouriers(@RequestBody List<CourierRequestDTO> courierRequestDTOs) {
        courierService.postCouriers(courierRequestDTOs);
    }
}




















