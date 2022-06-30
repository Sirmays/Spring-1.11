package com.sirmays.security.controllers;

import com.sirmays.security.entities.User;
import com.sirmays.security.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
public class SecurityController {
    private final UserService userService;

    @GetMapping("/")
    public String homePage() {
        return "home";
    }

    @GetMapping("/pageforusers")
    public String pageForUsers() {
        return "Page For Users";
    }

    @GetMapping("/pageforadmins")
    // @PreAuthorize("hasRole('ADMIN')")
    public String pageForAdmins() {
        return "Page For Admins";
    }

    @GetMapping("/pageforsuperadmins")
    // @PreAuthorize("hasRole('ADMIN')")
    public String pageForSuperadmins() {
        return "Page For Superadmins";
    }

    @GetMapping("/auth_page")
    public String authenticatedPage() {
        return "authenticated";
    }


    @GetMapping("/user_info")
    public String daoTestPage(Principal principal) {
        User user = userService
                .findByUsername(principal.getName())
                .orElseThrow(() -> new RuntimeException("Unable to find user by username: " + principal.getName()));
        return "Authenticated user info: " + user.getUsername() + " : " + user.getEmail();
    }
}
