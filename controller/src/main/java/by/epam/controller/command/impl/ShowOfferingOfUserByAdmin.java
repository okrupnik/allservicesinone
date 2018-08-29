package by.epam.controller.command.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.epam.controller.command.Command;
import by.epam.domain.order.Offering;
import by.epam.domain.page.PageDetail;
import by.epam.domain.user.User;
import by.epam.service.OfferingService;
import by.epam.service.ServiceFactory;
import by.epam.service.UserService;
import by.epam.service.exception.ServiceException;

public class ShowOfferingOfUserByAdmin implements Command{
	private static final Logger log = LoggerFactory.getLogger(ShowOfferingOfUserByAdmin.class.getName());

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String locale = null;
		User selectedUser = null;
		String username = null;
		String page = null;
		List<Offering> offeringList = null;
				
		page = request.getParameter(ParamAndAttribute.PAGE_ATTRIBUTE);
		selectedUser = (User) request.getSession().getAttribute(ParamAndAttribute.SELECTED_USER_ATTRIBUTE);
		if (selectedUser != null) {
			username = selectedUser.getUsername();
		} else {
			username = request.getParameter(ParamAndAttribute.USERNAME_PARAM_NAME);
		}
		locale = (String) request.getSession().getAttribute(ParamAndAttribute.LOCALE_ATTRIBUTE);
		
		ServiceFactory serviceFactory = ServiceFactory.getInstatnce();
		UserService userService = serviceFactory.getUserService();
		OfferingService offeringService = serviceFactory.getOfferingService();
		HttpSession session = request.getSession();
		
		try {
			selectedUser = userService.getUser(username, locale);
			offeringList = offeringService.getOfferingsOfUserByAdmin(selectedUser, page, locale);
			session.setAttribute(ParamAndAttribute.SELECTED_USER_ATTRIBUTE, selectedUser);			
			session.setAttribute(ParamAndAttribute.OFFERING_LIST_ATTRIBUTE, offeringList);
			session.setAttribute(ParamAndAttribute.NO_OF_PAGES_PARAM_NAME, PageDetail.getPagesDetails().get(ParamAndAttribute.NO_OF_PAGES_PARAM_NAME));
			session.setAttribute(ParamAndAttribute.CURRENT_PAGE_PARAM_NAME, PageDetail.getPagesDetails().get(ParamAndAttribute.CURRENT_PAGE_PARAM_NAME));
			RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPagePath.ADMIN_USER_OFFERING_PAGE);
			dispatcher.forward(request, response);	
			try {
				dispatcher.forward(request, response);
			} catch (ServletException | IOException e) {
				for (StackTraceElement stackTraceElement : e.getStackTrace()) {
					log.error(stackTraceElement.toString());
				}
			}
		} catch (ServiceException e) {
			String errorMessage = e.getMessage();
			session.setAttribute(ParamAndAttribute.ERROR_MESSAGE_ATTRIBUTE, errorMessage);
			RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPagePath.ERROR_SHOW_ORDER_OR_OFFERING_PAGE);
			try {
				dispatcher.forward(request, response);
			} catch (ServletException | IOException e1) {
				for (StackTraceElement stackTraceElement : e.getStackTrace()) {
					log.error(stackTraceElement.toString());
				}
			}
		}
		
	}

}
