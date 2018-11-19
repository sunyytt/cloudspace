package com.example.springcloud.oauth2.entity;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

/**
 * @Auther: sunyy
 * @Date: 2018/11/13 16:27
 * @Description:
 */
@Entity
public class Role implements GrantedAuthority {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=false)
    private String name;

    @Override
    public String getAuthority() {
        return name;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
