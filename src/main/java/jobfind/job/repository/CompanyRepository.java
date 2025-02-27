package jobfind.job.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jobfind.job.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
