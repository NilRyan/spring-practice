package com.indifferentcat.practice.controller;

import com.google.firebase.auth.FirebaseAuthException;
import com.indifferentcat.practice.security.Permissions;
import com.indifferentcat.practice.service.UserManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final UserManagementService userManagementService;

    @Secured("ROLE_ANONYMOUS")
    @PostMapping(path = "/user-claims/{uid}")
    public void setUserClaims(@PathVariable String uid, @RequestBody List<Permissions> requestedClaims) throws FirebaseAuthException {
        userManagementService.setUserClaims(uid, requestedClaims);
    }
}
