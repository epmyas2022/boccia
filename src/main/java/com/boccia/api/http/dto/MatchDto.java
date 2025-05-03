package com.boccia.api.http.dto;


import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MatchDto {
    @NotNull
    private Long homeTeamId;

    @NotNull
    private Long awayTeamId;
}