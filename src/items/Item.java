package items;

import main.ParentClass;

public class Item extends ParentClass {

	private double weight;


	public Item(String name, double length, double width, double height, double weight) {
		setName(name);
		setLength(length / 100.0);
		setWidth(width / 100.0);
		setHeight(height / 100.0);
		this.weight = weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getWeight() {
		return weight;
	}
	
	@Override
	public double calculateVolume() {
		return getLength() * getWidth() * getHeight();
	}

	public void printItemInfo() {
		System.out.println("Item: " + getName());
		System.out.println("Dimensions: " + getLength() + "x" + getHeight() + "x" + getWidth() + " cm");
		System.out.println("Weight: " + getWeight() + " kg");
		System.out.println("Volume: " + calculateVolume() + "m\u00B3");
		System.out.println();
	}
}
