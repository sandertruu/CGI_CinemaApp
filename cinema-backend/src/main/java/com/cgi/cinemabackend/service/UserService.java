package com.cgi.cinemabackend.service;

import com.cgi.cinemabackend.dto.UserDTO;
import com.cgi.cinemabackend.models.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public UserDTO login(User user);
}
