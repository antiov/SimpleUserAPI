package dev.antval.SimpleUserAPI.controller;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/")
    public String login(OAuth2AuthenticationToken oauthToken){
        System.out.println("TOKEN:"+oauthToken.getPrincipal());
        return "home.html";
    }
}
