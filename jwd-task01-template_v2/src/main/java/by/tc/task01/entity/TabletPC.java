package by.tc.task01.entity;

import java.util.Objects;

public class TabletPC extends Appliance {

	private static final long serialVersionUID = 1L;

	private double batteryCapacity;
	private double displayInches;
	private int memoryRom;
	private int flashMemoryCapacity;
	private String color;

	public TabletPC() {
		super();
	}

	public TabletPC(int price, double batteryCapacity, double displayInches, int memoryRom, int flashMemoryCapacity,
			String color) {
		super(price);
		this.batteryCapacity = batteryCapacity;
		this.displayInches = displayInches;
		this.memoryRom = memoryRom;
		this.flashMemoryCapacity = flashMemoryCapacity;
		this.color = color;
	}

	public double getBatteryCapacity() {
		return batteryCapacity;
	}

	public void setBatteryCapacity(double batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}

	public double getDisplayInches() {
		return displayInches;
	}

	public void setDisplayInches(double displayInches) {
		this.displayInches = displayInches;
	}

	public int getMemoryRom() {
		return memoryRom;
	}

	public void setMemoryRom(int memoryRom) {
		this.memoryRom = memoryRom;
	}

	public int getFlashMemoryCapacity() {
		return flashMemoryCapacity;
	}

	public void setFlashMemoryCapacity(int flashMemoryCapacity) {
		this.flashMemoryCapacity = flashMemoryCapacity;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(batteryCapacity, color, displayInches, flashMemoryCapacity, memoryRom);
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
		TabletPC other = (TabletPC) obj;
		return Double.doubleToLongBits(batteryCapacity) == Double.doubleToLongBits(other.batteryCapacity)
				&& Objects.equals(color, other.color)
				&& Double.doubleToLongBits(displayInches) == Double.doubleToLongBits(other.displayInches)
				&& flashMemoryCapacity == other.flashMemoryCapacity && memoryRom == other.memoryRom;
	}

	@Override
	public String toString() {
		return getClass().getName() + super.toString() + " [batteryCapacity=" + batteryCapacity + ", displayInches="
				+ displayInches + ", memoryRom=" + memoryRom + ", flashMemoryCapacity=" + flashMemoryCapacity
				+ ", color=" + color + "]";
	}

}
