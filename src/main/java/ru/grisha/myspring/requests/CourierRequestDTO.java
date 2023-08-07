package ru.grisha.myspring.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import ru.grisha.myspring.utility.CourierType;

import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class CourierRequestDTO {
    private Set<Long> regionIds;
    private CourierType courierType;
}
