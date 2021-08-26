package com.fluex404.springboot_export_n_import.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@Entity
@Table(name="person")
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String full_name;
    private String address;
    private String phone_number;

    public Person() {
    }
}
