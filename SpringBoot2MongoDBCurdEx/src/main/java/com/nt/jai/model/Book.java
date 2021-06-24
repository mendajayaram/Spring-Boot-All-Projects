package com.nt.jai.model;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
//@Document(collection = "sample") //optional
public class Book {
//auto-generated
@Id
private String id;
@NonNull
private Integer bookId;
@NonNull
private String bookName;
@NonNull
private Double bookCost;
}
