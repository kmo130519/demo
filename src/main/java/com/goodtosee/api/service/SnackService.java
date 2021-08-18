package com.goodtosee.api.service;

import com.goodtosee.api.dto.request.SnackReq;
import com.goodtosee.api.dto.request.SnackUpdateReq;
import com.goodtosee.api.dto.response.SnackRes;

import java.util.List;

public interface SnackService {

    List<SnackRes> readAll();
    SnackRes readByName(String name);
    SnackRes update(SnackUpdateReq snackUpdateReq);
    void deleteByName(String name);
    SnackRes create(SnackReq snackReq);
}
