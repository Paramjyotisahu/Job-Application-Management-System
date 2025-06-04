package com.embarkx.firstjobapp.company.impl;

import com.embarkx.firstjobapp.company.Company;
import com.embarkx.firstjobapp.company.CompanyRepository;
import com.embarkx.firstjobapp.company.CompanyService;
import com.embarkx.firstjobapp.job.Job;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
    private CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();

    }

    @Override
    public boolean UpdateCompany(Company updatedcompany, Long id) {
        Optional<Company> companyOptional = companyRepository.findById(id);
        if (companyOptional.isPresent()){
            Company company = companyOptional.get();
            company.setName(updatedcompany.getName());
            company.setDescription(updatedcompany.getDescription());
            company.setJobs(updatedcompany.getJobs());
            companyRepository.save(company);
            return true;
        }
        return false;
    }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public boolean deleteById(Long id) {
       try{
        if(companyRepository.existsById(id)){
            companyRepository.deleteById(id);
            return true;
        }
       } catch (Exception e){
           return false;
       }
        return false;
    }

    @Override
    public Company getCompanybyId(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

}
