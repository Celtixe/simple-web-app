package com.sandbox.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sandbox.models.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
