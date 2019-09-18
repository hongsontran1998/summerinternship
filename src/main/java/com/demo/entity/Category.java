package com.demo.entity;

import lombok.*;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "categories")
@Getter
@Setter
//@ToString //StackOverflowException
@NoArgsConstructor
@AllArgsConstructor
//@RequiredArgsConstructor
//@SQLDelete(sql = "UPDATE categories SET state = 'DELETED' WHERE id = ?", check = ResultCheckStyle.COUNT)
//@Where(clause = "state <> 'DELETED'")
//@Where(clause="is_active = 1")
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

    /*@Column()
    @Enumerated(EnumType.STRING)
    private EntityState state;

    @PreRemove
    public void delete() {
        System.out.println("hhhhhhhhhhhhhhh");
        this.state = EntityState.DELETED;
    }*/
    @Column(name="is_active")
    private Boolean active;


}