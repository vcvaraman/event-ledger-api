package com.example.ledger.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "events", uniqueConstraints = @UniqueConstraint(columnNames = "eventId"))
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String eventId;
    private String accountId;

    @Enumerated(EnumType.STRING)
    private EventType type;

    private BigDecimal amount;
    private String currency;
    private Instant eventTimestamp;

    @Lob
    private String metadata;
}
