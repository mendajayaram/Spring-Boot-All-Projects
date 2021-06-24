package com.nt.jai.model;

import javax.persistence.Id;

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
private Integer id;
private String title;
private Integer noOfPages;
private String writer;
private String category;
}