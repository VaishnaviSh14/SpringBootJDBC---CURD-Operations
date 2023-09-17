package in.java.springboot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import in.java.springboot.entity.Book;

@Component
public class NamedParameterJdbcBookRepository implements BookRepository {

	@Autowired
	private NamedParameterJdbcTemplate JdbcTemplate;
	
	@Override
	public int save(Book book) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Book book) {
		return JdbcTemplate.update("update books set cost =:cost where id=:id ", new BeanPropertySqlParameterSource(book));
		
	}

	@Override
	public int deletedById(Integer Id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Optional<Book> findById(Integer id) {
		return JdbcTemplate.queryForObject("select * from books where id=:id", new MapSqlParameterSource("id", id),

				(rs, rowNum) -> Optional.of(new Book(rs.getInt(1),

				rs.getString(2), rs.getInt(3))));
	}

	@Override
	public List<Book> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Book> findByNameAndPrice(String name, Integer Price) {
		// TODO Auto-generated method stub
		return null;
	}

}
