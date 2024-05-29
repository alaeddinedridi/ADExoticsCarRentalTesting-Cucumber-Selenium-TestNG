package models;

public class Car {
	
	public Car(String model,String name,String energy,String transmission,String modelYear,String price, String description){
		this.model=model;
		this.name=name;
		this.energy=energy;
		this.transmission=transmission;
		this.modelYear=modelYear;
		this.price=price;
		this.description=description;
	}
	
	private String model;
	private String name;
	private String energy;
	private String transmission;
	private String modelYear;
	private String price;
	private String description;
	
	
	public String getModel() {
		return this.model;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getEnergy() {
		return this.energy;
	}
	
	public String getTransmission() {
		return this.transmission;
	}
	
	public String getModelYear() {
		return this.modelYear;
	}
	
	public String getPrice() {
		return this.price;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	
}
