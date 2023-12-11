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
    private Integer x;

    @Min(-5)
    @Max(5)
    @NotNull
    private Long y;

    @Min(-2)
    @Max(2)
    @NotNull
    private Integer r;
}
