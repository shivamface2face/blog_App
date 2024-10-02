package com.blogApp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user_name",nullable = false,length = 30)
    private String name;
    @Column(name = "user_email")
    private String email;
    @Column(name = "user_password",length = 30)
    private String password;
    @Column(name = "about_user",nullable = false,length = 30)
    private String about;


    @OneToMany(mappedBy = "user",cascade =CascadeType.ALL)
    private List<Post> posts=new ArrayList<>();
}
