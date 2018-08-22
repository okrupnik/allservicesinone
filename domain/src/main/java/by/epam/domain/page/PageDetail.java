package by.epam.domain.page;

import java.util.HashMap;
import java.util.Map;

public class PageDetail {
	
	private static Map<String,Integer> pagesDetails = new HashMap<>();

	public static Map<String, Integer> getPagesDetails() {
		return pagesDetails;
	}

	public static void setPagesDetails(Map<String, Integer> pagesDetails) {
		PageDetail.pagesDetails = pagesDetails;
	}
	
	
}
