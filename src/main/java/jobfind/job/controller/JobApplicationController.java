package jobfind.job.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import jobfind.job.entity.JobApplication;
import jobfind.job.service.JobApplicationService;


@RestController
@RequestMapping("/applications")
public class JobApplicationController {

    @Autowired
    private JobApplicationService jobApplicationService;

    // Create a new Job Application
    @PostMapping
    public ResponseEntity<JobApplication> createJobApplication(@RequestBody JobApplication jobApplication) {
        return ResponseEntity.ok(jobApplicationService.saveJobApplication(jobApplication));
    }

    // Get a Job Application by ID
    @GetMapping("/{id}")
    public ResponseEntity<JobApplication> getJobApplicationById(@PathVariable Long id) {
        Optional<JobApplication> jobApplication = jobApplicationService.getJobApplicationById(id);
        return jobApplication.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get all Job Applications
    @GetMapping
    public List<JobApplication> getAllJobApplications() {
        return jobApplicationService.getAllJobApplications();
    }

    // Delete a Job Application by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJobApplication(@PathVariable Long id) {
        jobApplicationService.deleteJobApplication(id);
        return ResponseEntity.noContent().build();
    }
       
    
     @GetMapping("/page")
           public  Page<JobApplication> getUserPage(@RequestParam (defaultValue = "0")int page,@RequestParam (defaultValue = "3")int size){
            return  jobApplicationService.getAllUser(page,size);}

    @GetMapping("/sort/{name}") 
public List<JobApplication>getSorted(@PathVariable String name)
{
    return jobApplicationService.getsorted(name);

}

}
