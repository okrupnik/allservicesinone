package by.epam.controller.command.impl;

import java.util.HashMap;
import java.util.Map;

public final class JSPPagePath {

	public static final String MAIN_PAGE = "/jsp/main.jsp";
	public static final String ERROR_PAGE = "/jsp/error.jsp";
	public static final String ERROR_CHOSE_PERFORMER_PAGE = "/jsp/error_choose_performer.jsp";
	public static final String ERROR_SHOW_ORDER_OR_OFFERING_PAGE = "/jsp/error_show_ordder_offernig.jsp";
	public static final String USER_SIGNIN_PAGE = "/jsp/login.jsp";
	public static final String USER_REGISTRATION_PAGE = "/jsp/register.jsp";
	public static final String USER_SETTING_PAGE = "/jsp/user_settings.jsp";
	public static final String USER_SETTING_ADMIN_PAGE = "/jsp/user_settings_admin.jsp";
	public static final String USER_EDITOR_PAGE = "/jsp/user_editor.jsp";
	public static final String USER_EDIT_SUCCESS_PAGE = "/jsp/user_edit_success.jsp";
	public static final String ADMIN_EDIT_USER_SUCCESS_PAGE = "/jsp/admin_edit_user_success.jsp";
	public static final String USER_ORDERS_PAGE = "/jsp/user_show_orders.jsp";
	public static final String ADMIN_USER_ORDERS_PAGE = "/jsp/admin_user_show_orders.jsp";
	public static final String ORDER_EDIT_SUCCESS_PAGE = "/jsp/order_edit_success.jsp";
	public static final String PERFORMER_SELECTED_SUCCESS_PAGE = "/jsp/performer_select_success.jsp";
	public static final String ALL_ORDERS_OF_USER_PAGE = "/jsp/show_all_orders_of_users.jsp";	
	
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
	
	public static final String ORDER_TRUCKING_EDIT_PAGE = "/jsp/order_trucking_edit.jsp";
	public static final String ORDER_REPAIR_EDIT_PAGE = "/jsp/order_repair_edit.jsp";
	public static final String ORDER_COURIER_EDIT_PAGE = "/jsp/order_courier_edit.jsp";
	public static final String ORDER_CLEANING_EDIT_PAGE = "/jsp/order_cleaning_edit.jsp";
	public static final String ORDER_COMPUTER_EDIT_PAGE = "/jsp/order_computer_edit.jsp";
	public static final String ORDER_EVENTS_EDIT_PAGE = "/jsp/order_events_edit.jsp";
	public static final String ORDER_DESIGN_EDIT_PAGE = "/jsp/order_design_edit.jsp";
	public static final String ORDER_PHOTO_EDIT_PAGE = "/jsp/order_photo_edit.jsp";
	public static final String ORDER_WEB_EDIT_PAGE = "/jsp/order_web_edit.jsp";
	public static final String ORDER_INSTALL_EDIT_PAGE = "/jsp/order_install_edit.jsp";
	public static final String ORDER_BEAUTY_EDIT_PAGE = "/jsp/order_beauty_edit.jsp";
	public static final String ORDER_LEGAL_EDIT_PAGE = "/jsp/order_legal_edit.jsp";
	public static final String ORDER_EDUCATION_EDIT_PAGE = "/jsp/order_education_edit.jsp";
	public static final String ORDER_REPAIR_TRANCPORT_EDIT_PAGE = "/jsp/order_repairtransport_edit.jsp";
	
	public static final String ORDER_OFFERING_PAGE = "/jsp/show_offering_orders.jsp";
	public static final String ADD_OFFERING_SUCCESS_PAGE = "/jsp/add_offering_success.jsp";
	public static final String ADD_OFFERING_ERROR_PAGE = "/jsp/error_add_offering.jsp";
	public static final String OFFERINGS_OF_PERFORMER_PAGE = "/jsp/offerings_performer.jsp";
	public static final String EDIT_OFFERING_SUCCESS_PAGE = "/jsp/edit_offering_success.jsp";
	public static final String EDIT_OFFERING_ERROR_PAGE = "/jsp/error_edit_offering.jsp";
	
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
	private static Map<String, String> goToPageEdit = new HashMap<>();
	
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
		
		goToPageEdit.put(TRUCKING_PARAM_NAME, ORDER_TRUCKING_EDIT_PAGE);
		goToPageEdit.put(REPAIR_PARAM_NAME, ORDER_REPAIR_EDIT_PAGE);
		goToPageEdit.put(COURIER_PARAM_NAME, ORDER_COURIER_EDIT_PAGE);
		goToPageEdit.put(CLEANING_PARAM_NAME, ORDER_CLEANING_EDIT_PAGE);
		goToPageEdit.put(COMPUTER_PARAM_NAME, ORDER_COMPUTER_EDIT_PAGE);
		goToPageEdit.put(EVENTS_PARAM_NAME, ORDER_EVENTS_EDIT_PAGE);
		goToPageEdit.put(DESIGN_PARAM_NAME, ORDER_DESIGN_EDIT_PAGE);
		goToPageEdit.put(PHOTO_PARAM_NAME, ORDER_PHOTO_EDIT_PAGE);
		goToPageEdit.put(WEB_PARAM_NAME, ORDER_WEB_EDIT_PAGE);
		goToPageEdit.put(INSTALL_PARAM_NAME, ORDER_INSTALL_EDIT_PAGE);
		goToPageEdit.put(BEAUTY_PARAM_NAME, ORDER_BEAUTY_EDIT_PAGE);
		goToPageEdit.put(LEGAL_PARAM_NAME, ORDER_LEGAL_EDIT_PAGE);
		goToPageEdit.put(EDUCATION_PARAM_NAME, ORDER_EDUCATION_EDIT_PAGE);
		goToPageEdit.put(REPAIR_TRANCPORT_PARAM_NAME, ORDER_REPAIR_TRANCPORT_EDIT_PAGE);
	}

	private JSPPagePath() {
		
	}

	public static String getGoToPage(String activitie) {		
		return goToPage.get(activitie);
	}
	
	public static String getGoToPageEdit(String activitie) {		
		return goToPageEdit.get(activitie);
	}
		
}
