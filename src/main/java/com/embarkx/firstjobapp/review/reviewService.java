package com.embarkx.firstjobapp.review;

import java.util.List;

public interface reviewService {
    List<review> findByCompanyId(Long companyId);
    boolean addReview(Long companyId, review review);
    review getReviewByID(Long companyId, Long reviewId);
    boolean updateReviewById(Long companyId,Long reviewId, review review);
    boolean deleteReviewByid(Long companyId,Long reviewid);
}
