package jobfind.job.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jobfind.job.entity.Job;
@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
}
