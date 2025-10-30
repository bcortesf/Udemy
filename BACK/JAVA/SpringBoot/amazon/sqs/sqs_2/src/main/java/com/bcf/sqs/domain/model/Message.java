package com.bcf.sqs.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
@Builder
public class Message {
    private final int id;
    private final String description;

    private LocalDateTime createdAt;
}


/*
@RequiredArgsConstructor
@Data
@Builder
public class Message {
    private final int id;
    private final String description;
    private final LocalDateTime createdAt;
}
*/