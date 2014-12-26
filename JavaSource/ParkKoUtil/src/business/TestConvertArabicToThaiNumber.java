package business;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestConvertArabicToThaiNumber {

	ConvertType convertType = new ConvertType();

	@Test
	public void put_สฬ5420_should_be_convert_to_สฬ๕๔๒๗() {
		String expecterResult = "สฬ๕๔๒๐";
		String actualResult = convertType.convertCarIdWithArabicToCarIdWithThaiNumber("สฬ5420");

		assertEquals(expecterResult, actualResult);
	}

	@Test
	public void put_ณข9620_should_be_convert_to_ณข๙๖๒๐() {
		String expecterResult = "ณข๙๖๒๐";
		String actualResult = convertType.convertCarIdWithArabicToCarIdWithThaiNumber("ณข9620");

		assertEquals(expecterResult, actualResult);
	}
	@Test
	public void put_2014_12_25_21_00_00_should_be_convert_to_๒๐๑๔_๑๒_๒๕_๒๑_๐๐_๐๐() {
		String expecterResult = "๒๐๑๔-๑๒-๒๕ ๒๑:๐๐:๐๐";
		String actualResult = convertType.convertCarIdWithArabicToCarIdWithThaiNumber("2014-12-25 21:00:00");

		assertEquals(expecterResult, actualResult);
	}
	@Test
	public void put_2014_12_24_13_50_00_should_be_convert_to_๒๐๑๔_๑๒_๒๔_๑๓_๕๐_๐๐() {
		String expecterResult = "๒๐๑๔-๑๒-๒๔ ๑๓:๕๐:๐๐";
		String actualResult = convertType.convertCarIdWithArabicToCarIdWithThaiNumber("2014-12-24 13:50:00");

		assertEquals(expecterResult, actualResult);
	}

}
