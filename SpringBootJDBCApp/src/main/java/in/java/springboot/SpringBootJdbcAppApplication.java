package in.java.springboot;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import in.java.springboot.entity.Book;
import in.java.springboot.repository.BookRepository;
import in.java.springboot.repository.NamedParameterJdbcBookRepository;
import in.java.springboot.repository.jdbcBookRepository;

@SpringBootApplication
public class SpringBootJdbcAppApplication {
	
	public static void main(String[] args) {
	   ConfigurableApplicationContext context =	SpringApplication.run(SpringBootJdbcAppApplication.class, args);
	
//	jdbcBookRepository bookRepository = context.getBean(jdbcBookRepository.class);

//	
//	List<Book> books = bookRepository.findAll();
//	books.forEach(System.out::println);
//	
//	
//
//	int noOfRecords = bookRepository.count();
//	System.out.println("Total no of records::" + noOfRecords);
//	
//	System.out.println("****************************");
//
//	List<Book> records = bookRepository.findByNameAndPrice("CoreJava",3500);
//	records.forEach(System.out::println);
	
	NamedParameterJdbcBookRepository repository = context.getBean(NamedParameterJdbcBookRepository.class);
//	
//	Book book = new Book();
//	book.setCost(15000);
//	book.setId(2);
//	
//	repository.update(book);
	   
	   Optional<Book> optional = repository.findById(2);
	   if(optional.isPresent()) {
		   System.out.println(optional.get());
	   }
	   else {
		   System.out.println(optional.get());
	   }
	
	
	}
}
