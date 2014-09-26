package com.coderme.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "sys_role")
public class Role implements Serializable {
	private static final long serialVersionUID = -542489446418514509L;
	private Long id; //id 
    private String role; //角色标识 程序中判断使用,如"admin"
    private String description; //角色描述,UI界面显示使用
    private Boolean available = Boolean.FALSE; //是否可用,如果不可用将不会添加给用户

    private List<Permission> permissions;
    
    private String permIds;
    
    public Role() {
    }

    public Role(String role, String description, Boolean available) {
        this.role = role;
        this.description = description;
        this.available = available;
    }
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "r_role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "available")
    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        if (id != null ? !id.equals(role.id) : role.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", description='" + description + '\'' +
                ", available=" + available +
                '}';
    }

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Permission.class, cascade=CascadeType.ALL)
	@JoinTable(name = "sys_role_permission", 
			joinColumns = {@JoinColumn(name = "ROLE_ID")},
			inverseJoinColumns = {@JoinColumn(name = "PERMISSION_ID")})
	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}

	@Transient
	public String getPermIds() {
		return permIds;
	}

	public void setPermIds(String permIds) {
		this.permIds = permIds;
	}
}
