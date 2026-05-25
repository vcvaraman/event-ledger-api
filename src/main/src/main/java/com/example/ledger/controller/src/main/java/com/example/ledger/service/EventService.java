package com.example.ledger.service;

import com.example.ledger.dto.EventRequest;
import com.example.ledger.entity.Event;
import com.example.ledger.entity.EventType;
import com.example.ledger.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository repository;

    @Transactional
    public Event create(EventRequest request) {

        return repository.findByEventId(request.getEventId())
                .orElseGet(() -> repository.save(
                        Event.builder()
                                .eventId(request.getEventId())
                                .accountId(request.getAccountId())
                                .type(request.getType())
                                .amount(request.getAmount())
                                .currency(request.getCurrency())
                                .eventTimestamp(request.getEventTimestamp())
                                .metadata(request.getMetadata())
                                .build()
                ));
    }

    public Event getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));
    }

    public List<Event> getByAccount(String accountId) {
        return repository.findByAccountIdOrderByEventTimestampAsc(accountId);
    }

    public BigDecimal getBalance(String accountId) {
        return repository.findByAccountIdOrderByEventTimestampAsc(accountId)
                .stream()
                .map(event -> event.getType() == EventType.CREDIT
                        ? event.getAmount()
                        : event.getAmount().negate())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
