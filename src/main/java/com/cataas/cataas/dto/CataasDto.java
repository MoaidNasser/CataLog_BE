package com.cataas.cataas.dto;

import java.util.List;

public record CataasDto(
        String id,
        String createdAt,
        List<String> tags
) {}
