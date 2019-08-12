package com.sandbox.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sandbox.models.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
