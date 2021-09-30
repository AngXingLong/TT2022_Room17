package com.example.demo.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

@Component
@Scope("session")
public class Session {
    private HttpSession httpSession;
    private Long id;
    private String username;
    private String sessionId;
    public Session(HttpSession httpSession){
        this.httpSession = httpSession;
    }

    public String getSessionId() {
        return httpSession.getId();
    }

    public Long getId() {
        return (Long) httpSession.getAttribute("id");
    }

    public void setId(Long id) {
        httpSession.setAttribute("id", id);
    }

    public String getUsername() {
        return (String) httpSession.getAttribute("username");
    }

    public void setUsername(String username) {
        httpSession.setAttribute("username", username);
    }


}
