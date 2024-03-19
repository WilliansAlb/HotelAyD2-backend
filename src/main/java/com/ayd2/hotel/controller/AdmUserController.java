package com.ayd2.hotel.controller;

import com.ayd2.hotel.dto.CollectionPage;
import com.ayd2.hotel.exception.HtlException;
import com.ayd2.hotel.model.AdmUser;
import com.ayd2.hotel.service.AdmUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class AdmUserController {

    private final AdmUserService userService;

    @GetMapping
    public CollectionPage<List<AdmUser>, Long> findAll(Pageable pageable) {
        return userService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdmUser> findById(@PathVariable("id") Long userId) {
        return userService.findById(userId)
                .map(user -> new ResponseEntity<>(user, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<AdmUser> create(@RequestBody AdmUser user) throws HtlException {
        return new ResponseEntity<>(userService.create(user), HttpStatus.CREATED);
    }
}
