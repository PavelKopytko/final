package by.tc.task01.entity;

import java.util.Objects;

public class Laptop extends Appliance {

	private static final long serialVersionUID = 1L;

	private int batteryCapacity;
	private String operatingSystem;
	private int memoryRom;
	private int systemMemory;
	private double cpu;
	private double displayInches;

	public Laptop() {
		super();
	}

	public Laptop(int price, int batteryCapacity, String operatingSystem, int memoryRom, int systemMemory, double cpu,
			double displayInches) {
		super(price);
		this.batteryCapacity = batteryCapacity;
		this.operatingSystem = operatingSystem;
		this.memoryRom = memoryRom;
		this.systemMemory = systemMemory;
		this.cpu = cpu;
		this.displayInches = displayInches;
	}

	public int getBatteryCapacity() {
		return batteryCapacity;
	}

	public void setBatteryCapacity(int batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}

	public String getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

	public int getMemoryRom() {
		return memoryRom;
	}

	public void setMemoryRom(int memoryRom) {
		this.memoryRom = memoryRom;
	}

	public int getSystemMemory() {
		return systemMemory;
	}

	public void setSystemMemory(int systemMemory) {
		this.systemMemory = systemMemory;
	}

	public double getCpu() {
		return cpu;
	}

	public void setCpu(double cpu) {
		this.cpu = cpu;
	}

	public double getDisplayInches() {
		return displayInches;
	}

	public void setDisplayInches(double displayInches) {
		this.displayInches = displayInches;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ Objects.hash(batteryCapacity, cpu, displayInches, memoryRom, operatingSystem, systemMemory);
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
		Laptop other = (Laptop) obj;
		return batteryCapacity == other.batteryCapacity
				&& Double.doubleToLongBits(cpu) == Double.doubleToLongBits(other.cpu)
				&& Double.doubleToLongBits(displayInches) == Double.doubleToLongBits(other.displayInches)
				&& memoryRom == other.memoryRom && Objects.equals(operatingSystem, other.operatingSystem)
				&& systemMemory == other.systemMemory;
	}

	@Override
	public String toString() {
		return getClass().getName() + super.toString() + " [batteryCapacity=" + batteryCapacity + ", operatingSystem="
				+ operatingSystem + ", memoryRom=" + memoryRom + ", systemMemory=" + systemMemory + ", cpu=" + cpu
				+ ", displayInches=" + displayInches + "]";
	}

}
