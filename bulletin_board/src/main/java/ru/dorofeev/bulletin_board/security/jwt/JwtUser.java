package ru.dorofeev.bulletin_board.security.jwt;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class JwtUser implements UserDetails {
    private static final long serialVersionUID = 1L;

    private final Long id;
    private final String login;
    private final String password;
    private final String username;
    private final String phoneNumber;
    private final boolean enabled;
    private final Collection<? extends GrantedAuthority> authorities;

    public JwtUser(Long id,
                   String login,
                   String password,
                   String username,
                   String phoneNumber,
                   boolean enabled,
                   Collection<? extends GrantedAuthority> authorities)
    {
        this.id = id;
        this.login = login;
        this.password = password;
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.enabled = enabled;
        this.authorities = authorities;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    @JsonIgnore
    @Override
    public String getUsername() {
        return username;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @JsonIgnore
    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }


}
