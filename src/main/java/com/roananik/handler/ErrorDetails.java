package com.roananik.handler;

import lombok.Builder;

@Builder
public record ErrorDetails(Integer status, String message) {
}
