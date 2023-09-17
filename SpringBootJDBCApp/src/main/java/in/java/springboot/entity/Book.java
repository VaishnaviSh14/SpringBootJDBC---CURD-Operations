package in.java.springboot.entity;

public class Book {
	private Integer id;
	private String name;
	private Integer cost;
	
	static {
		System.out.println("Book.class file is loading");
		
	}
	
	public Book() {
		System.out.println("Book object is created....");
		
	}
	
	public Book(Integer id , String name , Integer cost) {
		this.id = id;
		this.name = name;
		this.cost = cost;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCost() {
		return cost;
	}
	public void setCost(Integer cost) {
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", cost=" + cost + "]";
	}

}
