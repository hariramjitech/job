package jobfind.job.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import jobfind.job.entity.Job;

import jobfind.job.repository.JobRepository;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    // Create or Update a Job
    public Job saveJob(Job job) {
        return jobRepository.save(job);
    }

    // Get Job by ID
    public Optional<Job> getJobById(Long id) {
        return jobRepository.findById(id);
    }

    // Get All Jobs
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    // Delete Job by ID
    public void deleteJob(Long id) {
        jobRepository.deleteById(id);
    }
     public Page<Job> getAllUser(int page, int size) {
     Pageable pageable=PageRequest.of(page,size);
     return jobRepository.findAll(pageable);
   }
   public List<Job>getsorted(String name)
   {
       return jobRepository.findAll(Sort.by(Direction.ASC,name) );}



}
