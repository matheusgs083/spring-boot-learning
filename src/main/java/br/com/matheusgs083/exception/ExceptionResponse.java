package br.com.matheusgs083.exception;

import java.util.Date;

public record ExceptionResponse(Date timestamp, String message, String details) {}
