package com.firststep.dao.entities;

public class DestNumber {
	private Double destinationNumber;

	public Double getDestNumber() {
		return destinationNumber;
	}

	public void setDestNumber(Double destinationNumber) {
		this.destinationNumber = destinationNumber;
	}

	@Override
	public String toString() {
		return "DestNumber [destinationNumber=" + destinationNumber.longValue() + "]";
	}

	
}
