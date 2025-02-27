package jobfind.job.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jobfind.job.entity.JobSeeker;
@Repository
public interface JobSeekerRepository extends JpaRepository<JobSeeker, Long> {
}
