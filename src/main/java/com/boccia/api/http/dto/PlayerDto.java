package com.boccia.api.http.dto;

import com.boccia.api.enums.GenderType;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PlayerDto {
    @NotBlank(message = "El nombre no puede estar vacío")
    private String name;

    private int age;

    private GenderType gender;

    private Long countryId;

    private Long teamId;

}
