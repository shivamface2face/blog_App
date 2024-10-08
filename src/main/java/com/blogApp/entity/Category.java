package com.blogApp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Category")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;
    @Column(name = "title")
    private String categoryTitle;
    @Column(name = "discription")
    private String categoryDescription;

    @OneToMany(mappedBy = "category",cascade =CascadeType.ALL)
    private List<Post> posts=new ArrayList<>();

}
