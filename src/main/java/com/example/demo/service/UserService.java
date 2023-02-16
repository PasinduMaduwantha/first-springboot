package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.repo.UserRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepo repo;
    @Autowired
    private ModelMapper modelMapper;

    public UserDto saveUser(UserDto dto) {
        repo.save(modelMapper.map(dto, User.class));
        return dto;
    }

    public List<UserDto> getAllUsers() {
        List<User> userList = repo.findAll();
        return modelMapper.map(userList, new TypeToken<List<UserDto>>(){}.getType() );
    }

    public UserDto updateUser(UserDto dto){
        repo.save(modelMapper.map(dto, User.class));
        return dto;
    }

    public boolean deleteUser(UserDto dto){
        repo.delete(modelMapper.map(dto, User.class));
        return true;
    }

    public UserDto findUserById(int id){
        User user = repo.findUserById(id);
        return modelMapper.map(user, UserDto.class);
    }

    public UserDto findUserByIdAndAddress(String id, String address){
        User user=repo.findUserByIdAndAddress(id, address);
        return modelMapper.map(user, UserDto.class);
    }
}
