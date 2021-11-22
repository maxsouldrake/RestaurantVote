package com.github.maxsouldrake.restaurantvote.model;

import java.util.Set;

/**
 * @author SoulDrake
 * @create 2021-11-22 12:54
 **/

public class User extends AbstractBaseEntity {
    private String email;
    private String password;
    private Role role;
    private Vote vote;

    public User(Integer id, String email, String password, Role role, Vote vote) {
        super(id);
        this.email = email;
        this.password = password;
        this.role = role;
        this.vote = vote;
    }

    public User(String email, String password, Role role, Vote vote) {
        this(null, email, password, role, vote);
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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
                ", role=" + role +
                ", vote=" + vote +
                '}';
    }
}
