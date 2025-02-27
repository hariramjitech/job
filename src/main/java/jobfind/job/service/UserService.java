package jobfind.job.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;


import jobfind.job.entity.User;
import jobfind.job.repository.UserRepository;


@Service
public class UserService {
    @Autowired
    UserRepository repodetailuser;


     public User postdata(User userDetails)  
     {
        return repodetailuser.save(userDetails);
     }
     
     public User getdata(long id)
     {
        return repodetailuser.findById(id).orElse(null);
     }
     public List<User> getalldata(){
        return repodetailuser.findAll();
     }
     public User putdata(long id,User user){
        user.setId(id);
        return repodetailuser.save(user);
     }
     public String deletedata(long id){
        repodetailuser.deleteById(id);
        return "success";
     }
     public Page<User> getAllUser(int page, int size) {
     Pageable pageable=PageRequest.of(page,size);
     return repodetailuser.findAll(pageable);
   }
   public List<User>getsorted(String name)
   {
       return repodetailuser.findAll(Sort.by(Direction.ASC,name) );}


}
