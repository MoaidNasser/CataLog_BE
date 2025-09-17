package com.cataas.cataas.dto;

import java.time.Instant;
import java.util.List;

public record CataasDto(
        String id,
        Instant createdAt,
        List<String> tags
) {}
