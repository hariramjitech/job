package jobfind.job.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jobfind.job.entity.Company;
import jobfind.job.entity.Job;
import jobfind.job.service.CompanyService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    // Create a new Company
    @PostMapping
    public ResponseEntity<Company> createCompany(@RequestBody Company company) {
        return ResponseEntity.ok(companyService.saveCompany(company));
    }

    // Get a Company by ID
    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long id) {
        Optional<Company> company = companyService.getCompanyById(id);
        return company.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get all Companies
    @GetMapping
    public List<Company> getAllCompanies() {
        return companyService.getAllCompanies();
    }

    // Delete a Company by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompany(@PathVariable Long id) {
        companyService.deleteCompany(id);
        return ResponseEntity.noContent().build();
    }
     @GetMapping("/page")
           public  Page<Company> getUserPage(@RequestParam (defaultValue = "0")int page,@RequestParam (defaultValue = "3")int size){
            return  ResponseEntity.getAllUser(page,size);}

    @GetMapping("/sort/{name}") 
public List<Company>getSorted(@PathVariable String name)
{
    return ResponseEntity.getsorted(name);
}
