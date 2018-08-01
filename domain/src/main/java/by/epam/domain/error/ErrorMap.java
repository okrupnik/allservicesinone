package by.epam.domain.error;

import java.util.HashMap;
import java.util.Map;

public class ErrorMap {
	
	private static Map<String,String> errorsOfCreating = new HashMap<>();
	private static Map<String,String> tempDataForErrors = new HashMap<>();

	public static Map<String, String> getErrorsOfCreating() {
		return errorsOfCreating;
	}

	public static void setErrorsOfCreating(Map<String, String> errorOfCreating) {
		ErrorMap.errorsOfCreating = errorOfCreating;
	}

	public static Map<String, String> getTempDataForErrors() {
		return tempDataForErrors;
	}

	public static void setTempDataForErrors(Map<String, String> tempDataForErrors) {
		ErrorMap.tempDataForErrors = tempDataForErrors;
	}
	
}
