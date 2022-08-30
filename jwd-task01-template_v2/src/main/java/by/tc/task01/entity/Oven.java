package by.tc.task01.entity;

import java.util.Objects;

public class Oven extends Appliance {

	private static final long serialVersionUID = 1L;

	private int powerConsuption;
	private double weight;
	private double capacity;
	private double depth;
	private double height;
	private double width;

	public Oven() {
		super();
	}

	public Oven(int price, int powerConsuption, double weight, double capacity, double depth, double height,
			double width) {
		super(price);
		this.powerConsuption = powerConsuption;
		this.weight = weight;
		this.capacity = capacity;
		this.depth = depth;
		this.height = height;
		this.width = width;
	}

	public int getPowerConsuption() {
		return powerConsuption;
	}

	public void setPowerConsuption(int powerConsuption) {
		this.powerConsuption = powerConsuption;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getCapacity() {
		return capacity;
	}

	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}

	public double getDepth() {
		return depth;
	}

	public void setDepth(double depth) {
		this.depth = depth;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(capacity, depth, height, powerConsuption, weight, width);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Oven other = (Oven) obj;
		return Double.doubleToLongBits(capacity) == Double.doubleToLongBits(other.capacity)
				&& Double.doubleToLongBits(depth) == Double.doubleToLongBits(other.depth)
				&& Double.doubleToLongBits(height) == Double.doubleToLongBits(other.height)
				&& powerConsuption == other.powerConsuption
				&& Double.doubleToLongBits(weight) == Double.doubleToLongBits(other.weight)
				&& Double.doubleToLongBits(width) == Double.doubleToLongBits(other.width);
	}

	@Override
	public String toString() {
		return getClass().getName() + super.toString() + " [powerConsuption=" + powerConsuption + ", weight=" + weight
				+ ", capacity=" + capacity + ", depth=" + depth + ", height=" + height + ", width=" + width + "]";
	}

}
