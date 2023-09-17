package in.java.springboot.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import in.java.springboot.entity.Book;

@Repository
public class jdbcBookRepository implements BookRepository {

	@Autowired
	private JdbcTemplate jdbctemplate;
	
	@Override
	public int save(Book book) {
		System.out.println(jdbctemplate);
		
		//code to perform insert operation
		int rowAffected = jdbctemplate.update("insert into books(name,cost)values(?,?)",book.getName(),book.getCost());		
		return rowAffected;
	}

	@Override
	public int update(Book book) {
		int rowAffected = jdbctemplate.update("update books set cost=? where id=?",book.getCost(),book.getId());
		return rowAffected;
	}

	@Override
	public int deletedById(Integer Id) {
      return jdbctemplate.update("delete from books where id=?",Id);
	}

	@Override
	public Optional<Book> findById(Integer id) {
		
		return jdbctemplate.queryForObject("select id,name,cost from books where id =?",new Object[] {id}, (rs,rowNum) -> Optional.of(new Book(rs.getInt(1),rs.getString(2),rs.getInt(3))));
		
	}

	@Override
	public List<Book> findAll() {
		
		
		return jdbctemplate.query("select * from books", 
				new RowMapper<Book>() {
			
			public Book mapRow(ResultSet rs , int rowNum) throws SQLException{
				
				System.out.println(rowNum);
				return new Book(rs.getInt(1),rs.getString(2),rs.getInt(3));
			}
			
		}
				);
	}

	@Override
	public int count() {
		return jdbctemplate.queryForObject("select count(*) from books", Integer.class);
	}

	@Override
	public List<Book> findByNameAndPrice(String name, Integer Price) {
		return jdbctemplate.query("select * from books where name like ? and cost<=?", new Object[] {"%"+name+"%",Price}, (rs, rowNum) -> new Book(rs.getInt(1), rs.getString(2), rs.getInt(3)));
	}

	
}
