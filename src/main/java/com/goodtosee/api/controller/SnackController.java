package com.goodtosee.api.controller;

import com.goodtosee.api.dto.request.SnackReq;
import com.goodtosee.api.dto.request.SnackUpdateReq;
import com.goodtosee.api.dto.response.SnackRes;
import com.goodtosee.api.service.SnackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/snack")
@CrossOrigin(value = {"*"}, maxAge = 6000)
public class SnackController {

    @Autowired
    SnackService snackService;

    @GetMapping("/all")
    public ResponseEntity<List<SnackRes>> readAll() {
        return new ResponseEntity<>(snackService.readAll(), HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<SnackRes> readByName(@PathVariable("name") String name) {
        return new ResponseEntity<>(snackService.readByName(name), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<SnackRes> create(@RequestBody SnackReq snackReq) {
        return new ResponseEntity<>(snackService.create(snackReq), HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<SnackRes> update(@RequestBody SnackUpdateReq snackUpdateReq) {
        return new ResponseEntity<>(snackService.update(snackUpdateReq), HttpStatus.OK);
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<SnackRes> delete(@PathVariable("name") String name) {
        snackService.deleteByName(name);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
