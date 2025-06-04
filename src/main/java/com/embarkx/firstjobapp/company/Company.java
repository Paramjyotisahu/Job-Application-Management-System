package com.embarkx.firstjobapp.company;

import com.embarkx.firstjobapp.job.Job;
import com.embarkx.firstjobapp.review.review;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Company {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;


    //Mapping every company to the List od its jobs
    //@OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)// can be used to apply the changesto the child class when changes happens to parent class
    @OneToMany(mappedBy = "company") // Jobs is mapped by the variable company in job.java class
    private List<Job> jobs;

    //Mapping for  review
    //@OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)  Same as above
    @OneToMany(mappedBy = "company")
    private List<review> reviews;

    public List<review> getReviews() {
        return reviews;
    }

    public void setReviews(List<review> reviews) {
        this.reviews = reviews;
    }

    public Company() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }
}
