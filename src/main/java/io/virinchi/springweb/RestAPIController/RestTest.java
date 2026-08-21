package io.virinchi.springweb.RestAPIController;

import io.virinchi.springweb.Model.UserTbl;
import io.virinchi.springweb.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//Controller and RestController follows same pattern of
//Http Request and Response Handling
//However, rest controller helps creating RestAPI's that we can use and test
//as well
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class RestTest {

    private final UserRepository uRepo;


    @GetMapping("/getAllUsers")
        public List<UserTbl> getAllUsers()
        {
            List<UserTbl> totalUsers=        uRepo.findAll();
        return totalUsers;
        }

@PostMapping("/saveUser")
    public String userSave(@RequestBody UserTbl user)
{
uRepo.save(user);

return "SavedSuccesfully";
}

@GetMapping("/getOneUser/{id}")
public UserTbl eutaUser(@PathVariable("id") int id)
{

//      UserTbl user=  uRepo.getById(id);

UserTbl user= uRepo.findById(id).get();

//if(uRepo.findById(id).isPresent())
//{
//    UserTbl user  = uRepo.findById(id).get();
//    return  user;
//}
//else
//{
//    return "user not found";
//}

return user;
}

@GetMapping("/getIdRE/{id}")
    public ResponseEntity<?> getIdRE(@PathVariable("id") int id)
{
    if(uRepo.findById(id).isPresent())
    {
        return ResponseEntity.ok(uRepo.findById(id).get());
    }

return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Id Invalid");
}



}
