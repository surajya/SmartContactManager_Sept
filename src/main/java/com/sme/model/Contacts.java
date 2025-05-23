package com.sme.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="CONTACTS")
public class Contacts {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cid;
	private String cname;
	private String cnickname;
	private String cwork;
	
	@Column(unique = true)
	private String cemail;

	@Transient
	private MultipartFile cimage;

	@Column(length = 1000)
	private String cdiscription;
	@Column(length = 10)
	private String cphoneNumber;
	
	@ManyToOne
	private User user;


	

}
