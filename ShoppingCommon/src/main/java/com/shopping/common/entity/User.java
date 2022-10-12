package com.shopping.common.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="email", length=128, nullable=false, unique=true)
	private String email;
	
	@Column(name="password",length=64,nullable=false)
	private String password;
	
	public User(String email, String password, String firstName, String lastName,boolean enabled) {
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.enabled=enabled;
	}

	@Column(name="first_name",length=45,nullable=false)
	private String firstName;
	
	@Column(name="last_name",length=45,nullable=false)
	private String lastName;
	
	@Column(length=64)
	private String photos;
	
	@Column(name="enabled")
	private Boolean enabled;
	
	@ManyToMany
	@JoinTable(name="user_roles",
	joinColumns=@JoinColumn(name="user_id"),
	inverseJoinColumns=@JoinColumn(name="role_id"))
	private Set<Role> roles=new HashSet<Role>();
	
	public void addRole(Role role)
	{
		this.roles.add(role);
	}
}
