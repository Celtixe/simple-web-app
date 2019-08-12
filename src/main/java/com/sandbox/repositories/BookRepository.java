package com.sandbox.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sandbox.models.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
