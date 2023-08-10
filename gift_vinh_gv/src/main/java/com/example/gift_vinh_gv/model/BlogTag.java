package com.example.gift_vinh_gv.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class BlogTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "blog_id")
    private Blog blog;
    @ManyToOne
    @JoinColumn(name = "tag_id")
    private Tag tag;
}
