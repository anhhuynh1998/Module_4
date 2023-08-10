package com.example.gift_vinh_gv.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String content;
    private String Title;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
    private Date publishDate;
    @OneToMany(mappedBy = "blog",cascade = CascadeType.PERSIST)
    private Set<BlogTag> blogTags;
}
