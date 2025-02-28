package jobfind.job.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import jobfind.job.entity.Company;
import jobfind.job.repository.CompanyRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    // Create or Update a Company
    public Company saveCompany(Company company) {
        return companyRepository.save(company);
    }

    // Get Company by ID
    public Optional<Company> getCompanyById(Long id) {
        return companyRepository.findById(id);
    }

    // Get All Companies
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    // Delete Company by ID
    public void deleteCompany(Long id) {
        companyRepository.deleteById(id);
    }

           public List<Company>getsorted(String name)
   {
       return companyRepository.findAll(Sort.by(Direction.ASC,name) );
    }

         public Page<Company> getAllUser(int page, int size) {
     Pageable pageable=PageRequest.of(page,size);
     return  companyRepository.findAll(pageable);
   }

}
