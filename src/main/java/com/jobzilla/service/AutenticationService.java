package com.jobzilla.service;

import com.jobzilla.dto.request.auth.RegisterRequestDto;
import com.jobzilla.exception.ExistingEmailException;
import com.jobzilla.exception.InvalidDataException;
import com.jobzilla.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.jobzilla.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AutenticationService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        if(user.isPresent()){
            return user.get();
        }
        throw new UsernameNotFoundException("Dados inválidos");
    }

    public User loadUserByUsernameReturnUser(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        if(user.isPresent()){
            return user.get();
        }
        throw new UsernameNotFoundException("Dados inválidos");
    }

    public void userRegister(RegisterRequestDto request){
        if (request.isNullOrEmpty()) {
            throw new InvalidDataException();
        }

        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            throw new ExistingEmailException();
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(new BCryptPasswordEncoder().encode(request.getPassword()));
        user.setProfileType(request.getProfileType());
        userRepository.save(user);

    }

}
