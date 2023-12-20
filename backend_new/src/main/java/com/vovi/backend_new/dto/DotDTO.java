package com.vovi.backend_new.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DotDTO {

    @Min(-2)
    @Max(2)
    @NotNull
    private Double x;

    @Min(-5)
    @Max(5)
    @NotNull
    private Float y;

    @Min(-2)
    @Max(2)
    @NotNull
    private Double r;
}
