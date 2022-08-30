package by.tc.task01.entity;

import java.util.Objects;

public class Speakers extends Appliance {

	private static final long serialVersionUID = 1L;

	private int powerConsuption;
	private int numberOfSpeakers;
	private String freqencyRange;
	private double cordLength;

	public Speakers() {
		super();
	}

	public Speakers(int price, int powerConsuption, int numberOfSpeakers, String freqencyRange, double cordLength) {
		super(price);
		this.powerConsuption = powerConsuption;
		this.numberOfSpeakers = numberOfSpeakers;
		this.freqencyRange = freqencyRange;
		this.cordLength = cordLength;
	}

	public int getPowerConsuption() {
		return powerConsuption;
	}

	public void setPowerConsuption(int powerConsuption) {
		this.powerConsuption = powerConsuption;
	}

	public int getNumberOfSpeakers() {
		return numberOfSpeakers;
	}

	public void setNumberOfSpeakers(int numberOfSpeakers) {
		this.numberOfSpeakers = numberOfSpeakers;
	}

	public String getFreqencyRange() {
		return freqencyRange;
	}

	public void setFreqencyRange(String freqencyRange) {
		this.freqencyRange = freqencyRange;
	}

	public double getCordLength() {
		return cordLength;
	}

	public void setCordLength(double cordLength) {
		this.cordLength = cordLength;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(cordLength, freqencyRange, numberOfSpeakers, powerConsuption);
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
		Speakers other = (Speakers) obj;
		return Double.doubleToLongBits(cordLength) == Double.doubleToLongBits(other.cordLength)
				&& Objects.equals(freqencyRange, other.freqencyRange) && numberOfSpeakers == other.numberOfSpeakers
				&& powerConsuption == other.powerConsuption;
	}

	@Override
	public String toString() {
		return getClass().getName() + super.toString() + " [powerConsuption=" + powerConsuption + ", numberOfSpeakers="
				+ numberOfSpeakers + ", freqencyRange=" + freqencyRange + ", cordLength=" + cordLength + "]";
	}

}
