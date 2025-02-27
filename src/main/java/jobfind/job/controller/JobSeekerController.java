package jobfind.job.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jobfind.job.entity.JobSeeker;
import jobfind.job.service.JobSeekerService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jobseekers")
public class JobSeekerController {

    @Autowired
    private JobSeekerService jobSeekerService;

    // Create a new job seeker
    @PostMapping
    public ResponseEntity<JobSeeker> createJobSeeker(@RequestBody JobSeeker jobSeeker) {
        return ResponseEntity.ok(jobSeekerService.saveJobSeeker(jobSeeker));
    }

    // Get a job seeker by ID
    @GetMapping("/{id}")
    public ResponseEntity<JobSeeker> getJobSeekerById(@PathVariable Long id) {
        Optional<JobSeeker> jobSeeker = jobSeekerService.getJobSeekerById(id);
        return jobSeeker.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get all job seekers
    @GetMapping
    public List<JobSeeker> getAllJobSeekers() {
        return jobSeekerService.getAllJobSeekers();
    }

    // Delete a job seeker by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJobSeeker(@PathVariable Long id) {
        jobSeekerService.deleteJobSeeker(id);
        return ResponseEntity.noContent().build();
    }


@GetMapping("/sort/{name}")
   
    
public List<JobSeeker>getSorted(@PathVariable String name)
{
    return jobSeekerService.getsorted(name);
}
 @GetMapping("/page")
           public  Page<JobSeeker> getUserPage(@RequestParam (defaultValue = "0")int page,@RequestParam (defaultValue = "3")int size){
            return  jobSeekerService.getAllUser(page,size);}
}
