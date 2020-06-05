package org.sid.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class User {
	@Id @GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long id;
	private String lastname;
	private String firstname;
	@Column(unique=true)
	private String email;
	private String password;

}
