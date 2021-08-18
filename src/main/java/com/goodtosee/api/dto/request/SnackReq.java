package com.goodtosee.api.dto.request;

import com.goodtosee.api.entity.Snack;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SnackReq {
    String name;
    int size;
    int calories;
    String allergies;

    public Snack toEntity() {
        Snack snack = new Snack();
        snack.setName(this.name);
        snack.setSize(this.size);
        snack.setCalories(this.calories);
        snack.setAllergies(this.allergies);
        return snack;
    }
}
