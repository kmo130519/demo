package com.goodtosee.api.dto.response;

import com.goodtosee.api.entity.Snack;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SnackRes {
    String name;
    int size;
    int calories;
    String allergies;

    public static SnackRes of(Snack snack) {
        return SnackRes.builder()
                .name(snack.getName())
                .size(snack.getSize())
                .calories(snack.getCalories())
                .allergies(snack.getAllergies())
                .build();
    }
}
