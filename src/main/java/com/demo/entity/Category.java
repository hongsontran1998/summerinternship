package com.demo.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "categories")
@Getter
@Setter
//@ToString
@NoArgsConstructor
@AllArgsConstructor
//@RequiredArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @NotNull
    private String name;

    //@NotBlank
    //@NotNull
    private String slug;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    // @JsonIgnore
    //@JsonBackReference
    //@JsonManagedReference
    private List<Article> articles;


}