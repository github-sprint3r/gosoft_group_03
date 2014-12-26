package business;

public class CalculateFee {

	public int calculateFee(int hoursInNormalCase, int hoursInAbnomalCase) {

		return (10 + (hoursInNormalCase - 3) * 20) + (hoursInAbnomalCase * 250);
	}

}
