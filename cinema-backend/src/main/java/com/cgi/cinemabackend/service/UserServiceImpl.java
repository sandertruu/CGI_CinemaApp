package com.cgi.cinemabackend.service;

import com.cgi.cinemabackend.dto.UserDTO;
import com.cgi.cinemabackend.models.User;
import com.cgi.cinemabackend.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * logib kasutaja sisse võrreldes hetkel lihtsalt plain text paroole
     * @param user kasutaja andmed
     * @return leitud kasutaja DTO
     */
    @Override
    public UserDTO login(User user) {
        List<User> users = userRepository.findAll();
        Optional<User> usercreds = users.stream()
                .filter(userdata -> userdata.getEmail().equals(user.getEmail())
                && userdata.getPassword().equals(user.getPassword())).findFirst();
        UserDTO userDTO = modelMapper.map(usercreds, UserDTO.class);
        return userDTO;
    }
}
