// exo 2
package fr.fms.entities;

public class Article {
	private int idArticle;
	private String description;
	private String brand;
	private double price;
	
	public Article(int idArticle, String description, String brand, double price) {
		super();
		this.idArticle = idArticle;
		this.description = description;
		this.brand = brand;
		this.price = price;
	}

	public int getIdArticle() {
		return idArticle;
	}

	public void setIdUser(int idArticle) {
		this.idArticle = idArticle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return idArticle + ", Description: "+ getDescription() + ", Brand: "
				+ getBrand() + ", Price: " + getPrice();
		
	}
	
	
}
