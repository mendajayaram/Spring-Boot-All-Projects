package com.nt.jai.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document

public class Book {
	@Id
	private Integer bookId;
	private String bookName;
	private String bookAuthor;
	private Double bookCost;
	private String bookType;
}
