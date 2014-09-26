package com.coderme.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.hnky.core.base.BaseEntity;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sys_user")
public class User extends BaseEntity {

	private static final long serialVersionUID = -6798921448534313056L;
	private Integer id;
	private String username;
	private String password;
	private String telephone;
	private String email;
	private Integer type;

	private String roleIds;
	
	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String username) {
		this.username = username;
	}

	/** full constructor */
	public User(String username, String password, String telephone,
			String email, Integer type) {
		this.username = username;
		this.password = password;
		this.telephone = telephone;
		this.email = email;
		this.type = type;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "username", nullable = false)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", length = 50)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "telephone", length = 20)
	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Column(name = "email")
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "type")
	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Column(name = "role_ids")
	public String getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}

}