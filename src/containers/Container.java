package containers;

import main.ParentClass;

public class Container extends ParentClass {

    public Container(String name, double length, double width, double height) {
    	setName(name);
		setLength(length);
		setWidth(width);
		setHeight(height);
    }

    @Override
	public double calculateVolume() {
		return getLength() * getWidth() * getHeight();
	}
    
    public void printContainerInfo() {
        System.out.println("Container: " + getName());
        System.out.println("Dimensions: " + getLength() + "x" + getHeight() + "x" + getWidth() + "cm\u33A1");
        System.out.println("Volume: " + calculateVolume() + "m\u00B3");
        System.out.println();
    }
}
