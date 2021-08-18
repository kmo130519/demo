package com.goodtosee.api.repository;

import com.goodtosee.api.entity.Snack;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class SnackRepositoryTest {

    @Autowired
    SnackRepository snackRepository;

    @Test
    @Transactional
    void saveAndGet() {
        // given
        String name = "꼬깔콘";
        int size = 50;
        int calories = 400;
        String allergies = "쇠고기, 대두, 밀";

        Snack snack = new Snack();
        snack.setName(name);
        snack.setSize(size);
        snack.setCalories(calories);
        snack.setAllergies(allergies);

        // when
        snackRepository.save(snack);

        // then
        Optional<Snack> findedNutrition = snackRepository.findByName(name);
        assertThat(findedNutrition.get().getName()).isEqualTo(name);
    }

}