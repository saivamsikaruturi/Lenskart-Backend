package com.capgemini.lenskart.exceptions;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Data
@Getter
@Setter
public class ExceptionResponse {
    private Date timestamp;
    private String message;
    private String details;
}
