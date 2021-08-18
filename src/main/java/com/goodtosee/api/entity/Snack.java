package com.goodtosee.api.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Snack {
    @Id
    String name;
    int size;
    int calories;
    String allergies;
}