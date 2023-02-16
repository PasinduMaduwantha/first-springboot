package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api/v1/user")
@CrossOrigin
public class DemoController {
    @Autowired
    private UserService userService;

    @GetMapping("/getuser")
    public List<UserDto> getUser() {
        return userService.getAllUsers();

    }

    @PostMapping("/postuser")
    public UserDto postUser(@RequestBody UserDto dto) {
        return userService.saveUser(dto);
    }

    @PutMapping("/putuser")
    public UserDto putUser(@RequestBody UserDto dto) {
        return userService.updateUser(dto);
    }

    @DeleteMapping("/deleteuser")
    public boolean deleteUser(@RequestBody UserDto dto) {
        return userService.deleteUser(dto);
    }

    @GetMapping("/finduser/{id}")
    public UserDto findUserById(@PathVariable int id){
        return userService.findUserById(id);
    }

    @GetMapping("/finduser/{id}/{address}")
    public UserDto finUserByIdAndAddress(@PathVariable String id, @PathVariable String address){
        return userService.findUserByIdAndAddress(id, address);
    }

}

