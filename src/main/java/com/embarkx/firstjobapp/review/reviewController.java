package com.embarkx.firstjobapp.review;


import com.embarkx.firstjobapp.company.Company;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class reviewController {
    private reviewService reviewservice;

    public reviewController(reviewService reviewservice) {
        this.reviewservice = reviewservice;
    }
    @GetMapping("/reviews")
    public ResponseEntity<List<review>> findByCompanyId(@PathVariable Long companyId){
        return new ResponseEntity<>(reviewservice.findByCompanyId(companyId), HttpStatus.OK);
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> addReview(@PathVariable Long companyId, @RequestBody review review){
        if(reviewservice.addReview(companyId,review)){
            return new ResponseEntity<>("Reveiw added successfully",HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<review> getreviewById(@PathVariable Long companyId, @PathVariable Long reviewId){
        if(reviewservice.getReviewByID(companyId,reviewId)!=null) {
            return new ResponseEntity<>(reviewservice.getReviewByID(companyId, reviewId), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<String> updateReviewById(@PathVariable Long companyId, @PathVariable Long reviewId, @RequestBody review review){
        if(reviewservice.updateReviewById(companyId,reviewId,review)){
            return new ResponseEntity<>("Review updated successfully",HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<String> deleteById(@PathVariable Long companyId,@PathVariable Long reviewId){
        if(reviewservice.deleteReviewByid(companyId,reviewId)){
            return  new ResponseEntity<>("Review deleted Successfully",HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
