package com.app.blog.entity;

import jakarta.persistence.*;


@Entity
@Table(name="roles")
public class Roles  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="role_id")
    private Long roleId;
    @Column(unique = true)
    private String authority;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String toString() {
        return "Roles{" +
                "roleId=" + roleId +
                ", authority='" + authority + '\'' +
                '}';
    }
}
