package com.github.maxsouldrake.restaurantvote.model;

import java.util.Set;

/**
 * @author SoulDrake
 * @create 2021-11-22 12:54
 **/

public class User extends AbstractBaseEntity {
    private String email;
    private String password;
    private Set<Role> roles;
    private Vote vote;

    public User(Integer id, String email, String password, Set<Role> roles, Vote vote) {
        super(id);
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.vote = vote;
    }

    public User(String email, String password, Set<Role> roles, Vote vote) {
        this(null, email, password, roles, vote);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Vote getVote() {
        return vote;
    }

    public void setVote(Vote vote) {
        this.vote = vote;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                ", vote=" + vote +
                '}';
    }
}
