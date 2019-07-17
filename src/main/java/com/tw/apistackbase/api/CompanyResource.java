package com.tw.apistackbase.api;

import com.tw.apistackbase.core.Company;
import com.tw.apistackbase.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyResource {

    @Autowired
    CompanyRepository companyRepository;

    @GetMapping(produces = {"application/json"})
    public Iterable<Company> list() {
        return companyRepository.findAll();
    }

    @PostMapping(produces = {"application/json"})
    public Company add(@RequestBody Company company) {
        return companyRepository.save(company);
    }

    @DeleteMapping(produces = {"application/json"})
    public void deleteAll(@RequestBody List<Company> companies) {
        companyRepository.deleteAll(companies);
    }

    @PutMapping
    public void updateCompany(@RequestBody Company company) {
        companyRepository.save(company);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        companyRepository.deleteById(id);
    }
}
