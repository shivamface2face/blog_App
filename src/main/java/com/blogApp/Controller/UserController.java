package com.blogApp.Controller;

import com.blogApp.Services.UserService;
import com.blogApp.paylods.UserDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private final UserService userService;

    //create User
      @PostMapping
      public ResponseEntity<UserDto>createUser(@Valid @RequestBody   UserDto userDto){
          UserDto userDto1=userService.createUser(userDto);
          return new ResponseEntity<>(userDto1, HttpStatus.CREATED);
      }


      // update user

    @PutMapping("/{id}")
    public ResponseEntity<UserDto>updateUser(@Valid @RequestBody UserDto userDto,@PathVariable  Long id){
     UserDto updateUser=userService.updateUser(userDto,id);
     return  ResponseEntity.ok(updateUser);
    }

    // delete user
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
          userService.deleteUser(id);
    }

    //All user

    @GetMapping()
    public ResponseEntity<List<UserDto>>getAllUser(){
          return ResponseEntity.ok(userService.getAllUser());
    }

    // single User

    @GetMapping("/{id}")
    public ResponseEntity<UserDto>getUserById(@PathVariable Long id){
          return ResponseEntity.ok(userService.getUserById(id));
    }







}
