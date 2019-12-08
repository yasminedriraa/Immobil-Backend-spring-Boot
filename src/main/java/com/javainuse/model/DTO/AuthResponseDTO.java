package com.javainuse.model.DTO;

import com.javainuse.model.DAOUser;
import com.javainuse.model.JwtResponse;
import io.jsonwebtoken.Claims;

public class AuthResponseDTO {
    private String token;
    private Claims claims;
    private DAOUser user;
    public AuthResponseDTO() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Claims getClaims() {
        return claims;
    }

    public void setClaims(Claims claims) {
        this.claims = claims;
    }

    public DAOUser getUser() {
        return user;
    }

    public void setUser(DAOUser user) {
        this.user = user;
    }
}
