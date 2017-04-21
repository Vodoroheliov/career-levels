package com.inthergroup.internship.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inthergroup.internship.models.User;
import com.inthergroup.internship.repositories.UserRepository;


/**
 * This class is used by spring controller to authenticate and authorize user
 **/
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    
    private UserRepository userRepo;
    
    @Autowired
    public UserDetailsServiceImpl(UserRepository repository) {
        this.userRepo = repository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {   
        User curruser = userRepo.findByUsername(username);
        
        UserDetails user = new org.springframework.security.core.userdetails.User(
                username, curruser.getPasswordHash(), true, true, true, true,
                AuthorityUtils.createAuthorityList(curruser.getGroup().getRole().toUpperCase()));
        
        System.out.println("ROLE: " + curruser.getGroup().getRole().toUpperCase());
        return user;
    }
}
