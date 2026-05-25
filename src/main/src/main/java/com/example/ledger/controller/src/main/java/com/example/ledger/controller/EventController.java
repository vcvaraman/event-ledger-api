package com.example.ledger.controller;

import com.example.ledger.dto.EventRequest;
import com.example.ledger.entity.Event;
import com.example.ledger.service.EventService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class EventController {

    private final EventService service;

    @PostMapping("/events")
    @ResponseStatus(HttpStatus.CREATED)
    public Event create(@Valid @RequestBody EventRequest request) {
        return service.create(request);
    }

    @GetMapping("/events/{id}")
    public Event getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/events")
    public List<Event> getByAccount(@RequestParam String account) {
        return service.getByAccount(account);
    }

    @GetMapping("/accounts/{accountId}/balance")
    public Map<String, BigDecimal> getBalance(@PathVariable String accountId) {
        return Map.of("balance", service.getBalance(accountId));
    }
}
