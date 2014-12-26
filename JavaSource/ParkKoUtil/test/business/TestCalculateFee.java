package business;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCalculateFee {

	CalculateFee calculateFee = new CalculateFee();

	@Test
	public void seven_hours_in_normal_case_and_three_hours_in_abnormal_case_should_fees_equal_840_baht() {
		int expectedResult = 840;
		int actualResult = calculateFee.calculateFee(7, 3);
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void six_hours_in_normal_case_should_fees_equal_70_baht() {
		int expectedResult = 70;
		int actualResult = calculateFee.calculateFee(6, 0);
		assertEquals(expectedResult, actualResult);
	}
}
