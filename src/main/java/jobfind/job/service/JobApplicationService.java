package jobfind.job.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import jobfind.job.entity.JobApplication;
import jobfind.job.repository.JobApplicationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class JobApplicationService {

    @Autowired
    private JobApplicationRepository jobApplicationRepository;

    // Create or Update a Job Application
    public JobApplication saveJobApplication(JobApplication jobApplication) {
        return jobApplicationRepository.save(jobApplication);
    }

    // Get Job Application by ID
    public Optional<JobApplication> getJobApplicationById(Long id) {
        return jobApplicationRepository.findById(id);
    }

    // Get All Job Applications
    public List<JobApplication> getAllJobApplications() {
        return jobApplicationRepository.findAll();
    }

    // Delete Job Application by ID
    public void deleteJobApplication(Long id) {
        jobApplicationRepository.deleteById(id);
    }

       public List<JobApplication>getsorted(String name)
   {
       return jobApplicationRepository.findAll(Sort.by(Direction.ASC,name) );}
         public Page<JobApplication> getAllUser(int page, int size) {
     Pageable pageable=PageRequest.of(page,size);
     return  jobApplicationRepository.findAll(pageable);
   }
}