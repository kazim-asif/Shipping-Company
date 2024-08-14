package methods;

import containers.Container;
import items.Item;

import java.util.ArrayList;
import java.util.List;

public class Calculation {
	
	
	private List<Item> items;
	private List<Integer> order;
	private List<Container> containers;
	private double shipPrice = 0.0;
	private String bestShipMethod = "";

	public Calculation() {
		items = new ArrayList<>();
		order = new ArrayList<>();
		containers = new ArrayList<>();
	}

	public void addItems(Item item) {
		items.add(item);
	}

	public void addOrder(int quantity) {
		order.add(quantity);
	}

	public double totalVolume() {
		double totalVolume = 0;
		for (int i = 0; i < items.size(); i++) {
			totalVolume += items.get(i).calculateVolume() * order.get(i);
		}
		return totalVolume;
	}

	public double totalWeight() {
		double totalWeight = 0;
		for (int i = 0; i < items.size(); i++) {
			totalWeight += items.get(i).getWeight() * order.get(i);
		}
		return totalWeight;
	}

	public void bestShipping() {
		containers.add(new Container("Small Container", 6.06, 2.43, 2.59));
		containers.add(new Container("Big Container", 12.01, 2.43, 2.59));

		double totalVolume = totalVolume();
		double totalWeight = totalWeight();

		System.out.println("Total Volume: " + totalVolume + "m\u00B3");
		System.out.println("Total Weight: " + totalWeight + " kg");

		if (totalWeight <= 500) {
			bestShipMethod ="Best shipping method: 1 Small Container";
			System.out.println(bestShipMethod);
			shipPrice = shippingPrice(1, 0, totalWeight);
			System.out.println("Shipping cost: " + shipPrice + " Euro");

		} else {
			if (totalVolume <= containers.get(1).calculateVolume()) {
				bestShipMethod = "Best shipping method: 1 Big Container";
				System.out.println(bestShipMethod);
				shipPrice = shippingPrice(0, 1, totalWeight);
				System.out.println("Shipping cost: " + shipPrice + " Euro");

			} else {
				int numBigContainers = (int) Math.ceil(totalVolume / containers.get(1).calculateVolume());
				int numSmallContainers = 0;

				if (totalWeight > 500) {
					numSmallContainers = (int) Math.ceil((totalWeight - 500) / 500);
				}

				bestShipMethod = "Best shipping method: " + numBigContainers + " Big Container(s) and "
						+ numSmallContainers + " Small Container(s)";
				
				System.out.println(bestShipMethod);
				
				shipPrice = shippingPrice(numSmallContainers, numBigContainers, totalWeight);

				
				System.out.println(
						"Shipping cost: " + shipPrice + " Euro");
				
			}
		}
	}

	public double shippingPrice(int numSmallContainers, int numBigContainers, double totalWeight) {
		
		if (totalWeight <= 500) {
			double shippingCost = numSmallContainers * 1000;
			return shippingCost;
		}

		double shippingCost = numSmallContainers * 1200 + numBigContainers * 1800;
		return shippingCost;
	}

	public void printItemInfo() {
		for (Item item : items) {
			item.printItemInfo();
		}
	}

	public void printOrder() {
		for (int i = 0; i < items.size(); i++) {
			System.out.println("Item: " + items.get(i).getName());
			System.out.println("Quantity: " + order.get(i));
			System.out.println();
		}
	}

	public double getShipPrice() {
		return shipPrice;
	}

	public void setShipPrice(double shipCost) {
		this.shipPrice = shipCost;
	}

	public String getBestShipMethod() {
		return bestShipMethod;
	}

	public void setBestShipMethod(String bestShipMethod) {
		this.bestShipMethod = bestShipMethod;
	}
}
