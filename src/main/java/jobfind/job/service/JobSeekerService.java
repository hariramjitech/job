package jobfind.job.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import jobfind.job.entity.JobSeeker;
import jobfind.job.repository.JobSeekerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class JobSeekerService {

    @Autowired
    private JobSeekerRepository jobSeekerRepository;


    public JobSeeker saveJobSeeker(JobSeeker jobSeeker) {
        return jobSeekerRepository.save(jobSeeker);
    }


    public Optional<JobSeeker> getJobSeekerById(Long id) {
        return jobSeekerRepository.findById(id);
    }

    public List<JobSeeker> getAllJobSeekers() {
        return jobSeekerRepository.findAll();
    }

 
    public void deleteJobSeeker(Long id) {
        jobSeekerRepository.deleteById(id);
    }
         public Page<JobSeeker> getAllUser(int page, int size) {
     Pageable pageable=PageRequest.of(page,size);
     return jobSeekerRepository.findAll(pageable);
   }
     public List<JobSeeker>getsorted(String name)
   {
       return jobSeekerRepository.findAll(Sort.by(Direction.ASC,name) );}

}
