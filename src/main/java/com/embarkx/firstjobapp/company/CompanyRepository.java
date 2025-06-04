package com.embarkx.firstjobapp.company;

import com.embarkx.firstjobapp.review.review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    Company getCompanyById(Long id);
}
