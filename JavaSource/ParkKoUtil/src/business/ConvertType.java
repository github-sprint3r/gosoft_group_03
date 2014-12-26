package business;

public class ConvertType {

	public String convertCarIdWithArabicToCarIdWithThaiNumber(String carId) {
		char[] thaiChars = { '๐', '๑', '๒', '๓', '๔', '๕', '๖', '๗', '๘', '๙' };
		StringBuilder carIdWithThaiNumber = new StringBuilder();

		for (int index = 0; index < carId.length(); index++) {
			if (Character.isDigit(carId.charAt(index))) {
				carIdWithThaiNumber.append(thaiChars[(int) (carId.charAt(index)) - 48]);
			} else {
				carIdWithThaiNumber.append(carId.charAt(index));
			}
		}
		return carIdWithThaiNumber.toString();
	}
}
