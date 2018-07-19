package by.epam.service.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

	private static final String PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,40}$";
	private static final String EMAIL_PATTERN = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
	private static final String PHONE_NUMBER_PATTERN = "^(\\+375|80)-\\d{2}-\\d{3}\\d{2}\\d{2}$";

	private static Pattern pattern;
	private static Matcher matcher;

	private Validator() {

	}

	public static boolean validatePassword(String password) {
		pattern = Pattern.compile(PASSWORD_PATTERN);
		matcher = pattern.matcher(password);
		return matcher.matches();
	}

	public static boolean validateEmail(String email) {
		pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
		matcher = pattern.matcher(email);
		return matcher.matches();
	}

	public static boolean validatePhoneNumber(String phoneNumber) {
		pattern = Pattern.compile(PHONE_NUMBER_PATTERN);
		matcher = pattern.matcher(phoneNumber);
		return matcher.matches();
	}

}
