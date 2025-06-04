package com.embarkx.firstjobapp.job;

import com.embarkx.firstjobapp.company.Company;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


@Entity
@Table(name="Job")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="title")
    private String title;
    @Column(name="description")
    private String description;
    @Column(name="min_salary")
    private String minSalary;
    @Column(name="max_salary")
    private String maxSalary;
    @Column(name="location")
    private String location;

    // It will ignore the recurcive call-backs as comapnyhas job object and job has comapany object inside it, which will result in infinite loop
    @JsonIgnore // Here also to igonre the infite loop of the recursion in the objects inside objects
    @ManyToOne // Mapping to many jobs to one company
    private Company company;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }



    public Job(){}

    public Job(String location, String maxSalary, String minSalary, String description, String title,Long id) {
        this.location = location;
        this.maxSalary = maxSalary;
        this.minSalary = minSalary;
        this.description = description;
        this.title = title;
        this.id = id;

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(String maxSalary) {
        this.maxSalary = maxSalary;
    }

    public String getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(String minSalary) {
        this.minSalary = minSalary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", minSalary='" + minSalary + '\'' +
                ", maxSalary='" + maxSalary + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
