package com.alphaware.Service.Impl;

import com.alphaware.Exception.UserException;
import com.alphaware.Model.User;
import com.alphaware.Repository.UserRepo;
import com.alphaware.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepo userRepo;


    @Override
    public User createUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User getUserById(Integer userId) throws UserException {
        Optional<User> opt=userRepo.findById(userId);

        if(opt.isPresent()){
            return opt.get();
        }throw  new UserException("UserId not found!");

    }

    @Override
    public User updateUser(Integer userId, User userDetails) throws UserException {

        Optional<User> opt=userRepo.findById(userId);

        if(opt.isPresent()){
            User user=opt.get();
            user.setName(userDetails.getName());
            user.setEmail(userDetails.getEmail());
            user.setRole(userDetails.getRole());
            user.setAbout(userDetails.getAbout());
            user.setActive(userDetails.getActive());

            return userRepo.save(user);
        }throw new UserException("UserId not found!");

    }

    @Override
    public void deleteUser(Integer userId) throws UserException {

        Optional<User> opt=userRepo.findById(userId);
        if(opt.isPresent()){
            userRepo.delete(opt.get());
            return;
        }throw  new UserException("UserId not found!");
    }


}
