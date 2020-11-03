package com.sapient.entity;

import java.util.Date;

import lombok.Data;

@Data
public class Greeting {
	private String message;
	private Date timestamp = new Date();
}
