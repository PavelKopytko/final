package by.tc.task01.entity;

import java.util.Objects;

public class Refrigerator extends Appliance {

	private static final long serialVersionUID = 1L;

	private int powerConsuption;
	private double weight;
	private int freezerCapacity;
	private double overalCapacity;
	private double height;
	private double width;

	public Refrigerator() {
		super();
	}

	public Refrigerator(int price, int powerConsuption, double weight, int freezerCapacity, double overalCapacity,
			double height, double width) {
		super(price);
		this.powerConsuption = powerConsuption;
		this.weight = weight;
		this.freezerCapacity = freezerCapacity;
		this.overalCapacity = overalCapacity;
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

	public int getFreezerCapacity() {
		return freezerCapacity;
	}

	public void setFreezerCapacity(int freezerCapacity) {
		this.freezerCapacity = freezerCapacity;
	}

	public double getOveralCapacity() {
		return overalCapacity;
	}

	public void setOveralCapacity(double overalCapacity) {
		this.overalCapacity = overalCapacity;
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
		result = prime * result + Objects.hash(freezerCapacity, height, overalCapacity, powerConsuption, weight, width);
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
		Refrigerator other = (Refrigerator) obj;
		return freezerCapacity == other.freezerCapacity
				&& Double.doubleToLongBits(height) == Double.doubleToLongBits(other.height)
				&& Double.doubleToLongBits(overalCapacity) == Double.doubleToLongBits(other.overalCapacity)
				&& powerConsuption == other.powerConsuption
				&& Double.doubleToLongBits(weight) == Double.doubleToLongBits(other.weight)
				&& Double.doubleToLongBits(width) == Double.doubleToLongBits(other.width);
	}

	@Override
	public String toString() {
		return getClass().getName() + super.toString() + " [powerConsuption=" + powerConsuption + ", weight=" + weight
				+ ", freezerCapacity=" + freezerCapacity + ", overalCapacity=" + overalCapacity + ", height=" + height
				+ ", width=" + width + "]";
	}

}
