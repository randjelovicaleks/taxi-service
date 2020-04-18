package com.taxiservice.security.authority;

public class TokenState {

    private String accessToken;
    private Long expiresIn;
    private Long id;
    private Authority role;

    public TokenState() {
        this.accessToken = null;
        this.expiresIn = null;
        this.id = null;
        this.role = null;
    }

    public TokenState(String accessToken, long expiresIn, Long id, Authority role) {
        this.accessToken = accessToken;
        this.expiresIn = expiresIn;
        this.id = id;
        this.role = role;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Long expiresIn) {
        this.expiresIn = expiresIn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Authority getRole() {
        return role;
    }

    public void setRole(Authority role) {
        this.role = role;
    }
}
