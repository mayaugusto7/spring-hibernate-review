package br.com.code.hibernate.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String title;

	@ManyToOne(cascade = { 	CascadeType.PERSIST, CascadeType.MERGE, 
							CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "instructor_id")
	private Instructor instructor;

	public Course() {}

	public Course(String title) {
		this.title = title;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + "]";
	}
		
}
