import java.time.LocalDate;

public class Validator {

	public static boolean phoneNoValidator(String phoneNumber) {
        if (phoneNumber.charAt(0) != '0' || phoneNumber.length() != 10) {
            return false;
        }
        return true;
    }
    
    public static boolean salaryValidator(double salary){
		if(salary<0){
				return false;
		}
		return true;
	}
	
	public static boolean birthdayValidator(String birthday) {
        if ((birthday.substring(4, 5)).equals("-") && (birthday.substring(7, 8)).equals("-")) {
            int year = Integer.parseInt(birthday.substring(0, 4));
            int month = Integer.parseInt(birthday.substring(5, 7));
            int day = Integer.parseInt(birthday.substring(8, 10));
            LocalDate today = LocalDate.now();
            
            if (year == today.getYear() && month == today.getMonthValue() && day == today.getDayOfMonth()) {
                return false;
            } else if (year > today.getYear() || month > 12 || month <= 0 || day > 31 || day <= 0) {
                return false;
            } else {
                switch (month) {
                    case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                        return true;
                    case 4: case 6: case 9: case 11:
                        return day <= 30;
                    case 2:
                        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                            return day <= 29;
                        } else {
                            return day <= 28;
                        }
                    default:
                        return false;
                }
            }
        }
        return false;
    }
}
