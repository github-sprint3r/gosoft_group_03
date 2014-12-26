package bean;

import java.sql.Timestamp;

public class DisplayData {
	private String carId;
	private String province;
	private String name;
	private String surname;
	private String picture;
	private Timestamp startTime;
	private Timestamp endTime;
	
	private int totalNormalParkTime;
	private int totalSpecialTime;
	private int moneyReceive;
	private int moneyChange;
	private int parkFee;
	

	public DisplayData() {
		
	}


	public String getCarId() {
		return carId;
	}


	public void setCarId(String carId) {
		this.carId = carId;
	}


	public String getProvince() {
		return province;
	}


	public void setProvince(String province) {
		this.province = province;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public String getPicture() {
		return picture;
	}


	public void setPicture(String picture) {
		this.picture = picture;
	}


	public Timestamp getStartTime() {
		return startTime;
	}


	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}


	public Timestamp getEndTime() {
		return endTime;
	}


	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}


	public int getMoneyReceive() {
		return moneyReceive;
	}


	public void setMoneyReceive(int moneyReceive) {
		this.moneyReceive = moneyReceive;
	}


	public int getMoneyChange() {
		return moneyChange;
	}


	public void setMoneyChange(int moneyChange) {
		this.moneyChange = moneyChange;
	}


	public int getParkFee() {
		return parkFee;
	}


	public void setParkFee(int parkFee) {
		this.parkFee = parkFee;
	}	

	public int getTotalNormalParkTime() {
		return totalNormalParkTime;
	}


	public void setTotalNormalParkTime(int totalNormalParkTime) {
		this.totalNormalParkTime = totalNormalParkTime;
	}


	public int getTotalSpecialTime() {
		return totalSpecialTime;
	}


	public void setTotalSpecialTime(int totalSpecialTime) {
		this.totalSpecialTime = totalSpecialTime;
	}


	@Override
	public String toString() {
		return "DisplayData [carId=" + carId + ", province=" + province
				+ ", name=" + name + ", surname=" + surname + ", picture="
				+ picture + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", totalNormalParkTime=" + totalNormalParkTime
				+ ", totalSpecialTime=" + totalSpecialTime + ", moneyReceive="
				+ moneyReceive + ", moneyChange=" + moneyChange + ", parkFee="
				+ parkFee + "]";
	}

	
	

	
	
}
