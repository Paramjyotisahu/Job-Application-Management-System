package com.embarkx.firstjobapp.company;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();
    boolean UpdateCompany(Company company, Long id);
    void createCompany(Company company);
    boolean deleteById(Long id);
    Company getCompanybyId(Long id);
}
