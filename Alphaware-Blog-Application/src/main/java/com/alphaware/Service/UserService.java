package com.alphaware.Service;

import com.alphaware.Exception.UserException;
import com.alphaware.Model.User;

import java.util.List;

public interface UserService {


    public User createUser(User user);
    public List<User> getAllUsers();
    public User getUserById(Integer userId)throws UserException;
    public User updateUser(Integer userId, User userDetails)throws UserException;
    public void deleteUser(Integer userId)throws UserException;






}
