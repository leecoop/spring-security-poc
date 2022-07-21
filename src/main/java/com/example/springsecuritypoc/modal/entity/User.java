package com.example.springsecuritypoc.modal.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.CollectionUtils;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name= "users")
@Data
public class User implements UserDetails {
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    List<Role> roles;
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long userId;
    private String username;
    private String password;
    private boolean disabled;
    private boolean accountExpired;
    private boolean accountLocked;
    private boolean credentialsExpired;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        if (!CollectionUtils.isEmpty(this.roles)) {
            return roles.stream()
                    .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getRoleName()))
                    .collect(Collectors.toList());
        }

        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return !accountExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !accountLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !credentialsExpired;
    }

    @Override
    public boolean isEnabled() {
        return !disabled;
    }
}