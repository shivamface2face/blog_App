package com.blogApp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@Entity
@Table(name = "post")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "post_title",length = 100)
    private String title;
    @Column(name = "post_content")
    private String content;
    @Column(name = "post_imgName")
    private String imgName;
    @Column(name = "post_Date")
    private Date addDate;

    @ManyToOne
    private Category category;

    @ManyToOne
    private User user;



}
