package com.demo.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "roles")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Role implements Serializable {
    public static final String ROLE_ADMIN = "ADMIN";
    public static final String ROLE_USER = "USER";
    public static final String ROLE_MOD = "MOD";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String name;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_role",
            joinColumns = {
                    @JoinColumn(name = "role_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "user_id")
            },
            uniqueConstraints = {
                    @UniqueConstraint(columnNames = {"user_id","role_id"})
            }
    )
    private List<User> users;

}