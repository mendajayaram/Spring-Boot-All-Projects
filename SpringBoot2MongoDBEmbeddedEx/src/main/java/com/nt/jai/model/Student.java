package com.nt.jai.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Student {
@Id
private Integer sid;
private String sname;
private Double sfee;
private Address addr;
private List<Subject> sobs;
}
