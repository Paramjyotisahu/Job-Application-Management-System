package com.embarkx.firstjobapp.review;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<review, Long> {
    List<review> findByCompanyId(Long companyId);
}
