package com.boccia.api.http.dto;


import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MatchResultDto {
    @Min(0)
    private int homeScore;

    @Min(0)
    private int awayScore;

}