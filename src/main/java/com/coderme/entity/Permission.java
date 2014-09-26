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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "sys_permission")
@XmlRootElement
public class Permission implements Serializable {
	private static final long serialVersionUID = 3496879951172665027L;
	
	private Long id; //编号
	private String code;//权限字符串
    private String desc; //资源名称
    private String type ; //资源类型
    private String url; //资源路径
    private Long parentId; //父编号
    private Boolean available = Boolean.FALSE;
    
    private Integer rootNode ;

    private Integer isLeaf ;//是否叶子节点
    
    private List<Role> roleList;//已分配角色
    
    private String typeValue;
    

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "p_desc")
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Column(name = "p_type")
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "url")
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    @Column(name = "parent_id")
    public Long getParentId() {
        return parentId;
    }
    public void setParentId(Long parentId) {
        this.parentId = parentId;
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

        Permission resource = (Permission) o;

        if (id != null ? !id.equals(resource.id) : resource.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "id=" + id +
                ", desc='" + desc + '\'' +
                ", type=" + type +
                ", code=" + code +
                ", parentId=" + parentId +
                ", available=" + available +
                '}';
    }
    @Column(name = "p_code")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	@XmlTransient
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Role.class)
	@JoinTable(name = "sys_role_permission", 
			joinColumns = {@JoinColumn(name = "PERMISSION_ID")},
			inverseJoinColumns = {@JoinColumn(name = "ROLE_ID")})
	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	@Column(name = "root_node")
	public Integer getRootNode() {
		return rootNode;
	}

	public void setRootNode(Integer rootNode) {
		this.rootNode = rootNode;
	}

	@Transient
	public String getTypeValue() {
		return typeValue;
	}

	public void setTypeValue(String typeValue) {
		this.typeValue = typeValue;
	}
	@Column(name = "is_leaf")
	public Integer getIsLeaf() {
		return isLeaf;
	}

	public void setIsLeaf(Integer isLeaf) {
		this.isLeaf = isLeaf;
	}
}
