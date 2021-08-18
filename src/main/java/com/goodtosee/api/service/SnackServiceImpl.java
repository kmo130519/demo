package com.goodtosee.api.service;

import com.goodtosee.api.dto.request.SnackReq;
import com.goodtosee.api.dto.request.SnackUpdateReq;
import com.goodtosee.api.dto.response.SnackRes;
import com.goodtosee.api.entity.Snack;
import com.goodtosee.api.repository.SnackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SnackServiceImpl implements SnackService {

    @Autowired
    SnackRepository snackRepository;

    @Override
    public List<SnackRes> readAll() {
        List<Snack> entityList = snackRepository.findAll();
        return entityList.stream().map(nutrition -> SnackRes.of(nutrition)).collect(Collectors.toList());
    }

    @Override
    public SnackRes readByName(String name) {
        Optional<Snack> optionalNutrition = snackRepository.findByName(name);
//        Nutrition nutrition = optionalNutrition.get();
//
//        StringBuilder sb = new StringBuilder();
//        sb.append(nutrition.getName());
//        sb.append("의 알러지 정보는 ");
//        sb.append(nutrition.getAllergies());
//        sb.append("입니다.");
//
//        sb.toString();
        return optionalNutrition.map(nutrition -> SnackRes.of(nutrition)).orElse(null);
    }

    @Override
    public SnackRes update(SnackUpdateReq snackUpdateReq) {
        return SnackRes.of(snackRepository.save(snackUpdateReq.toEntity()));
    }

    @Override
    public void deleteByName(String name) {
        snackRepository.deleteById(name);
    }

    @Override
    public SnackRes create(SnackReq snackReq) {
        return SnackRes.of(snackRepository.save(snackReq.toEntity()));
    }
}
