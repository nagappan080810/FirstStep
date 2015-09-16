package com.firststep.dao.pojo;
import javax.persistence.*;
@Entity
@Table(name="callLog")
public class CallLog {
	@Id
	private int callId;
	private Double sourceNumber;
	@Column(unique=true)
	private Double destinationNumber;
	public CallLog(){}
	public CallLog(int callId, double sourceNumber, double destinationNumber){
		this.callId = callId;
		this.sourceNumber = sourceNumber;
		this.destinationNumber = destinationNumber;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((destinationNumber == null) ? 0 : destinationNumber
						.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CallLog other = (CallLog) obj;
		if (destinationNumber == null) {
			if (other.destinationNumber != null)
				return false;
		} else if (!destinationNumber.equals(other.destinationNumber))
			return false;
		return true;
	}
	public int getCallId() {
		return callId;
	}
	public void setCallId(int callId) {
		this.callId = callId;
	}
	public double getSourceNumber() {
		return sourceNumber;
	}
	public void setSourceNumber(double sourceNumber) {
		this.sourceNumber = sourceNumber;
	}
	public double getDestinationNumber() {
		return destinationNumber;
	}
	public void setDestinationNumber(double destinationNumber) {
		this.destinationNumber = destinationNumber;
	}
	@Override
	public String toString() {
		Long srcno = sourceNumber == null ? 0 : sourceNumber.longValue();
		return "CallLog [callId=" + callId + ", sourceNumber=" + srcno
				+ ", destinationNumber=" + destinationNumber.longValue() + "]";
	}
	
	

}
