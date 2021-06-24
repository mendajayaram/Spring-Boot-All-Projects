package com.nt.jai.model;

import java.util.List;

import lombok.Data;

@Data
public class Employee {
private int eid;
private String ename;
private double esal;
private String empgen;
private String empproj;
private String empAddr;
private List<String> empLangs;
}
