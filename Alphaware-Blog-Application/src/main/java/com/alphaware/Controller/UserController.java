package com.alphaware.Controller;

import com.alphaware.Exception.UserException;
import com.alphaware.Model.User;
import com.alphaware.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/register")
    public ResponseEntity<User>  createUserHandler(@RequestBody User user){
        User user1=userService.createUser(user);

        return new ResponseEntity<>(user1, HttpStatus.CREATED);
    }

    @GetMapping("/getAllUser")
    public ResponseEntity<List<User>> getAllUsersHandler(){

        List<User> users = userService.getAllUsers();

        return new ResponseEntity<>(users,HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserByIdHandler(@PathVariable Integer userId)throws UserException{

        User user = userService.getUserById(userId);

        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUserHandler(@PathVariable Integer userId, @RequestBody User userDetails)throws UserException {
        User updatedUser = userService.updateUser(userId, userDetails);

        return new ResponseEntity<>(updatedUser, HttpStatus.OK);

    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUserHandler(@PathVariable Integer userId)throws UserException {
        userService.deleteUser(userId);

        return new ResponseEntity<>(HttpStatus.OK);
    }


}
