package in.java.springboot.repository;

import java.util.List;
import java.util.Optional;

import in.java.springboot.entity.Book;

public interface BookRepository {
	int save(Book book);
	int update(Book book);
	int deletedById(Integer Id);
	
	Optional<Book> findById(Integer id);
	
	List<Book> findAll();
	
	//to count number of records
	int count();
	
	List<Book> findByNameAndPrice(String name , Integer Price);
	
	

}
