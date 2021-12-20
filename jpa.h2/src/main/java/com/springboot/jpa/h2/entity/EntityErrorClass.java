package com.springboot.jpa.h2.entity;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntityErrorClass {
	private HttpStatus statusCode;
	private String message;
}
