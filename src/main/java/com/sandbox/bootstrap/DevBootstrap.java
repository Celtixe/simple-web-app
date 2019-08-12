package com.sandbox.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.sandbox.models.Author;
import com.sandbox.models.Book;
import com.sandbox.models.Publisher;
import com.sandbox.repositories.AuthorRepository;
import com.sandbox.repositories.BookRepository;
import com.sandbox.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;
	
	@Autowired
	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository,
			PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		initData();
		
	}

	private void initData() {
		//publisher
		Publisher publisher = new Publisher();
		publisher.setName("foo");
		publisher.setAddress("UK");
		
		Publisher pub = new Publisher();
		pub.setName("bar");
		pub.setAddress("PL");
		
		publisherRepository.save(publisher);
		publisherRepository.save(pub);

		//Eric
		Author eric = new Author("Eric","Evans");
		Book ddd = new Book("Domain Driven Design", "3421",publisher);
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		
		authorRepository.save(eric);
		bookRepository.save(ddd);
		
		//Rod
		Author rod= new Author("Rod","Johnson");
		Book noEJB = new Book("J2EE Development without EJB","1241234",pub);
		rod.getBooks().add(noEJB);
		noEJB.getAuthors().add(rod);
		
		authorRepository.save(rod);
		bookRepository.save(noEJB);
	}
}
