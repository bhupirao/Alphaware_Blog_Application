//package com.alphaware.Service;
//
//
//import com.alphaware.Exception.UserException;
//import com.alphaware.Model.User;
//import com.alphaware.Repository.UserRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService{
//
//    @Autowired
//    private UserRepo userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        User user = userRepository.findByEmail(email);
//
//        return org.springframework.security.core.userdetails.User
//                .withUsername(email)
//                .password(user.getPassword())
//                .authorities(user.getRole().name())
//                .accountExpired(false)
//                .accountLocked(false)
//                .credentialsExpired(false)
//                .disabled(false)
//                .build();
//    }
//}
