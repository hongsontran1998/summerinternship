package com.demo.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private String username;

    private String password;

    private Integer active;
    private String fullName;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(
            name = "user_role",
            joinColumns = {
                    @JoinColumn(name = "userId")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "roleId")
            },
            uniqueConstraints = {
                    @UniqueConstraint(columnNames = {"userId","roleId"})
            }
    )
    private List<Role> roles;

}