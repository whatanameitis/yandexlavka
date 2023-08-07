package ru.grisha.myspring.utility;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum CourierType {
    @JsonProperty("type")
    ONFEET,
    ONBIKE,
    ONCAR
}
