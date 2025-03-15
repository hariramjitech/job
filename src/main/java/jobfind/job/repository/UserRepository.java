package jobfind.job.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jobfind.job.entity.User;
@Repository 
public interface UserRepository extends JpaRepository<User,Long>{
    //JPA
    public List<User>findByName(String name);
    //JPQL
    @Query("select u.email from User u where u.name=:name")
    public String findEmailByName(@Param("name")String name);
}

