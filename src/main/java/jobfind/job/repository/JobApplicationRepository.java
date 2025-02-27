package jobfind.job.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jobfind.job.entity.JobApplication;


@Repository
public interface JobApplicationRepository extends JpaRepository<JobApplication, Long>
 {
}
