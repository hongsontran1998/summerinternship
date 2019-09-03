package com.demo.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.List;

@Entity
@Table(name = "articles")
@Getter
@Setter
//@ToString //StackOverflowException
@NoArgsConstructor
@AllArgsConstructor
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = Category.class)
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE) //note: CascadeType.MERGE
	@JoinColumn(name = "category_id")
	//@JsonManagedReference
	//@JsonBackReference
	private Category category;

	private String name;

	@Column(columnDefinition = "varchar(255) default 'sonthh'")
	private String description;

	@Column(columnDefinition = "TEXT")
	private String detail;

	private String slug;

}