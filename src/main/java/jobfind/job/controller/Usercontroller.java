package jobfind.job.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jobfind.job.entity.User;
import jobfind.job.service.UserService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/users")
public class Usercontroller 
{
    @Autowired
    UserService details;


    @PostMapping()
    public User postuser(@RequestBody User userDetails ){
        return details.postdata(userDetails);
    }
    @GetMapping("/{id}")
    public User getuser(@PathVariable long id) {
        return details.getdata(id);
    }
    @GetMapping()
    public List <User> getalluser( ){
        return details.getalldata();
    }
    @PutMapping("/{id}")
    public User putuser(@PathVariable long id,@RequestBody User user)
    {
        return details.putdata(id,user);
    }
    @DeleteMapping("/{id}")
    public String deleteuser(@PathVariable long id)
    {
        return details.deletedata(id);
    }
    @GetMapping("/page")
           public  Page<User> getUserPage(@RequestParam (defaultValue = "0")int page,@RequestParam (defaultValue = "3")int size){
            return  details.getAllUser(page,size);}

@GetMapping("/sort/{name}")
   
    
public List<User>getSorted(@PathVariable String name)
{
    return details.getsorted(name);
}
}