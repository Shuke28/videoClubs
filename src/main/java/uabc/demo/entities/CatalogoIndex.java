package uabc.demo.entities;

public class CatalogoIndex {
	
	private Integer film_id;
	private String title;
	private String category;
	private Integer copies;
	
	
	public CatalogoIndex(Integer film_id, String title, String category, Integer copies) {
		super();
		this.film_id = film_id;
		this.title = title;
		this.category = category;
		if(copies==null) this.copies=0;
		else this.copies =copies;
		
	}
	public Integer getFilm_id() {
		return film_id;
	}
	public void setFilm_id(Integer film_id) {
		this.film_id = film_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Integer getCopies() {
		return copies;
	}
	public void setCopies(Integer copies) {
		this.copies = copies;
	}
	
	//toString
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CatalogoIndex [film_id=");
		builder.append(film_id);
		builder.append(", title=");
		builder.append(title);
		builder.append(", category=");
		builder.append(category);
		builder.append(", copies=");
		builder.append(copies);
		builder.append("]");
		return builder.toString();
	}

	
}
