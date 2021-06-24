package com.nt.jai.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nt.jai.model.Project;

public interface ProjectRepository
extends MongoRepository<Project, Integer> {
}
