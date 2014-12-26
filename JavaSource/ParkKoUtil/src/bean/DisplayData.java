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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((carId == null) ? 0 : carId.hashCode());
		result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
		result = prime * result + moneyChange;
		result = prime * result + moneyReceive;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + parkFee;
		result = prime * result + ((picture == null) ? 0 : picture.hashCode());
		result = prime * result
				+ ((province == null) ? 0 : province.hashCode());
		result = prime * result
				+ ((startTime == null) ? 0 : startTime.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
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
		DisplayData other = (DisplayData) obj;
		if (carId == null) {
			if (other.carId != null)
				return false;
		} else if (!carId.equals(other.carId))
			return false;
		if (endTime == null) {
			if (other.endTime != null)
				return false;
		} else if (!endTime.equals(other.endTime))
			return false;
		if (moneyChange != other.moneyChange)
			return false;
		if (moneyReceive != other.moneyReceive)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (parkFee != other.parkFee)
			return false;
		if (picture == null) {
			if (other.picture != null)
				return false;
		} else if (!picture.equals(other.picture))
			return false;
		if (province == null) {
			if (other.province != null)
				return false;
		} else if (!province.equals(other.province))
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DisplayData [carId=" + carId + ", province=" + province
				+ ", name=" + name + ", surname=" + surname + ", picture="
				+ picture + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", moneyReceive=" + moneyReceive + ", moneyChange="
				+ moneyChange + ", parkFee=" + parkFee + "]";
	}

}
