package by.epam.controller.command.impl;

import java.util.HashMap;
import java.util.Map;

public class JSPPagePath {

	public static final String MAIN_PAGE = "/jsp/main.jsp";
	public static final String USER_SETTING_PAGE = "/jsp/user_settings.jsp";
	public static final String USER_EDIT_SUCCESS_PAGE = "/jsp/user_edit_success.jsp";
	
	public static final String ORDER_TRUCKING_PAGE = "/jsp/order_trucking.jsp";
	public static final String ORDER_REPAIR_PAGE = "/jsp/order_repair.jsp";
	public static final String ORDER_COURIER_PAGE = "/jsp/order_courier.jsp";
	public static final String ORDER_CLEANING_PAGE = "/jsp/order_cleaning.jsp";
	public static final String ORDER_COMPUTER_PAGE = "/jsp/order_computer.jsp";
	public static final String ORDER_EVENTS_PAGE = "/jsp/order_events.jsp";
	public static final String ORDER_DESIGN_PAGE = "/jsp/order_design.jsp";
	public static final String ORDER_PHOTO_PAGE = "/jsp/order_photo.jsp";
	public static final String ORDER_WEB_PAGE = "/jsp/order_web.jsp";
	public static final String ORDER_INSTALL_PAGE = "/jsp/order_install.jsp";
	public static final String ORDER_BEAUTY_PAGE = "/jsp/order_beauty.jsp";
	public static final String ORDER_LEGAL_PAGE = "/jsp/order_legal.jsp";
	public static final String ORDER_EDUCATION_PAGE = "/jsp/order_education.jsp";
	public static final String ORDER_REPAIR_TRANCPORT_PAGE = "/jsp/order_repairtransport.jsp";
	
	public static final String TRUCKING_PARAM_NAME = "trucking";
	public static final String REPAIR_PARAM_NAME = "repair";
	public static final String COURIER_PARAM_NAME = "courier";
	public static final String CLEANING_PARAM_NAME = "cleaning";
	public static final String COMPUTER_PARAM_NAME = "computer";
	public static final String EVENTS_PARAM_NAME = "events";
	public static final String DESIGN_PARAM_NAME = "design";
	public static final String PHOTO_PARAM_NAME = "photo";
	public static final String WEB_PARAM_NAME = "web";
	public static final String INSTALL_PARAM_NAME = "install";
	public static final String BEAUTY_PARAM_NAME = "beauty";
	public static final String LEGAL_PARAM_NAME = "legal";
	public static final String EDUCATION_PARAM_NAME = "education";
	public static final String REPAIR_TRANCPORT_PARAM_NAME = "repairtransport";
	
	private static Map<String, String> goToPage = new HashMap<>();
	
	static {
		goToPage.put(TRUCKING_PARAM_NAME, ORDER_TRUCKING_PAGE);
		goToPage.put(REPAIR_PARAM_NAME, ORDER_REPAIR_PAGE);
		goToPage.put(COURIER_PARAM_NAME, ORDER_COURIER_PAGE);
		goToPage.put(CLEANING_PARAM_NAME, ORDER_CLEANING_PAGE);
		goToPage.put(COMPUTER_PARAM_NAME, ORDER_COMPUTER_PAGE);
		goToPage.put(EVENTS_PARAM_NAME, ORDER_EVENTS_PAGE);
		goToPage.put(DESIGN_PARAM_NAME, ORDER_DESIGN_PAGE);
		goToPage.put(PHOTO_PARAM_NAME, ORDER_PHOTO_PAGE);
		goToPage.put(WEB_PARAM_NAME, ORDER_WEB_PAGE);
		goToPage.put(INSTALL_PARAM_NAME, ORDER_INSTALL_PAGE);
		goToPage.put(BEAUTY_PARAM_NAME, ORDER_BEAUTY_PAGE);
		goToPage.put(LEGAL_PARAM_NAME, ORDER_LEGAL_PAGE);
		goToPage.put(EDUCATION_PARAM_NAME, ORDER_EDUCATION_PAGE);
		goToPage.put(REPAIR_TRANCPORT_PARAM_NAME, ORDER_REPAIR_TRANCPORT_PAGE);
	}

	private JSPPagePath() {
		
	}

	public static String getGoToPage(String activitie) {		
		return goToPage.get(activitie);
	}
		
}
