package com.fluex404.springboot_export_n_import.controller;

import com.fluex404.springboot_export_n_import.model.Person;
import com.fluex404.springboot_export_n_import.myapachepoi.ExcelGenerator;
import com.fluex404.springboot_export_n_import.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.util.List;

@RestController
public class HttpMappingRestController {

    private PersonRepository personRepository;
    private ExcelGenerator excel;

    @Autowired
    public HttpMappingRestController(PersonRepository personRepository, ExcelGenerator excel) {
        this.personRepository = personRepository;
        this.excel = excel;
    }

    @GetMapping("/export")
    public ResponseEntity<InputStreamResource> excelPersonReport() throws Exception {
        List<Person> persons = personRepository.findAll();

        ByteArrayInputStream in = excel.exportExcel(persons);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=siswa.xlsx");

        return ResponseEntity.ok().headers(headers).body(new InputStreamResource(in));

    }


}
