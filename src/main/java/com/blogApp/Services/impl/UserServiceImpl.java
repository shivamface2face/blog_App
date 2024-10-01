package com.blogApp.Services.impl;

import com.blogApp.Repostories.UserRepo;
import com.blogApp.Services.UserService;
import com.blogApp.entity.User;
import com.blogApp.exceptions.ResourceNotFoundException;
import com.blogApp.paylods.UserDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user=this.dtoToUser(userDto);
        User savedUser=userRepo.save(user);
        return this.userToDto(savedUser);


//
//        User toSaveUser=modelMapper.map(userDto,User.class);
//        User savedUser=userRepo.save(toSaveUser);
//        return modelMapper.map(savedUser,UserDto.class);


    }

    @Override
    public UserDto updateUser(UserDto userDto, Long id) {

        // find the user 1st

        User user=userRepo.findById(id).orElseThrow (()->new ResourceNotFoundException("user not found with given "+id));

        // now update the use

        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());

        User updateUser=userRepo.save(user);

       UserDto userDto1= userToDto(updateUser);
       return userDto1;

    }

    @Override
    public UserDto getUserById(Long id) {
        User user=userRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("user not found with id "+ id));
        return userToDto(user);
    }

    @Override
    public List<UserDto> getAllUser() {
        List<User>users=userRepo.findAll();
        List<UserDto> userDtos=users.stream().map(user -> userToDto(user)).collect(Collectors.toList());
        return userDtos;
    }

    @Override
    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }


    private User dtoToUser(UserDto userDto){
//        User user=new User();
//        user.setId(userDto.getId());
//        user.setName(userDto.getName());
//        user.setEmail(user.getEmail());
//        user.setPassword(userDto.getPassword());
//        user.setAbout(userDto.getAbout());

        User user=modelMapper.map(userDto,User.class);

        return user;
    }

    private UserDto userToDto(User user){
//        UserDto userDto=new UserDto();
//        userDto.setId(user.getId());
//        userDto.setName(user.getName());
//        userDto.setEmail(user.getEmail());
//        userDto.setPassword(user.getPassword());
//        userDto.setAbout(user.getAbout());

        UserDto userDto=modelMapper.map(user,UserDto.class);

        return userDto;
    }

}
