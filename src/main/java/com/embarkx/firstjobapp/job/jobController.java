package com.embarkx.firstjobapp.job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/jobs")
public class jobController {
    private JobService jobService;//here we are intializing on runtime using service(looseCoupling)
    //Retriving the job

    public jobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public ResponseEntity<List<Job>> findAll(){
        return ResponseEntity.ok(jobService.findAll());
    }

    @PostMapping
    public ResponseEntity<String> createJob(@RequestBody Job job){//@requestBody it request ther object and return it as a String
        jobService.createJob(job);
        return new ResponseEntity<>("Student Created successfully",HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> findById(@PathVariable Long id){
        Job job = jobService.findByID(id);
        if(job!=null){
            return new ResponseEntity<>(job,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEntity(@PathVariable Long id){
        boolean deleted = jobService.deleteById(id);
        if(deleted)
            return new ResponseEntity<>("Deleted successfully",HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateEntity(@PathVariable Long id,@RequestBody Job updatedjob){
        boolean updated = jobService.updateById(id,updatedjob);
        if(updated)
            return new ResponseEntity<>("Updated",HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}

/*
All the endpoints to be created
GET /jobs: GET all teh jobs
GET /jobs/{ID}: Get job with specific id
POST /jobs: Create a new job
DELETE /jobs/{id} : Delete specific job with id
PUT /jobs/{id}: Update a specific job by ID
GET /jobs/{id}/company: Get the company associate with the id
*/
