package com.embarkx.firstjobapp.review.implementation;

import com.embarkx.firstjobapp.company.Company;
import com.embarkx.firstjobapp.company.CompanyRepository;
import com.embarkx.firstjobapp.company.CompanyService;
import com.embarkx.firstjobapp.review.ReviewRepository;
import com.embarkx.firstjobapp.review.review;
import com.embarkx.firstjobapp.review.reviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class reviewServiceImplementaion implements reviewService {
    private final ReviewRepository reviewrepository;
    private final CompanyService companyservice;

    public reviewServiceImplementaion(ReviewRepository reviewrepository, CompanyService companyservice) {
        this.reviewrepository = reviewrepository;
        this.companyservice = companyservice;
    }

    @Override
    public List<review> findByCompanyId(Long companyId) {
        List<review> reviews = reviewrepository.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public boolean addReview(Long companyId, review review) {
        Company company = companyservice.getCompanybyId(companyId);
        if(company!=null){

            //set the particular company for this review
            review.setCompany(company);
            reviewrepository.save(review);
            return true;
        }
        return false;
    }

    @Override
    public review getReviewByID(Long companyId, Long reviewId) {
        List<review> reviews = reviewrepository.findByCompanyId(companyId);
        return reviews.stream().filter(review -> review.getId().equals(reviewId)).findFirst().orElse(null);
        //The above line: list is converted to stream, filtered by iterating the whole stream and returning equal reviewid, with the first one or null.
    }

    @Override
    public boolean updateReviewById(Long companyId, Long reviewId, review updatedreview) {
        if(companyservice.getCompanybyId(companyId)!=null){
            updatedreview.setCompany(companyservice.getCompanybyId(companyId));
            updatedreview.setId(reviewId);
            reviewrepository.save(updatedreview);
            return  true;
        }
        return false;
    }

    @Override
    public boolean deleteReviewByid(Long companyId, Long reviewid) {
        if(companyservice.getCompanybyId(companyId)!=null){
            reviewrepository.deleteById(reviewid);
            return true;
        }
        return false;
    }

}
