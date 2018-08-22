package by.epam.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.epam.controller.command.Command;
import by.epam.domain.user.User;
import by.epam.service.ServiceFactory;
import by.epam.service.UserService;
import by.epam.service.exception.ServiceException;

public class ToChangingUserByAdmin implements Command{
	private static final Logger log = LoggerFactory.getLogger(ToChangingUserByAdmin.class.getName());

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String local = null;
		User selectedUser = null;
		String username = null;
		
		username = request.getParameter(ParamAndAttribute.USERNAME_PARAM_NAME);
		local = (String) request.getSession().getAttribute(ParamAndAttribute.LOCALE_ATTRIBUTE);
		
		ServiceFactory serviceFactory = ServiceFactory.getInstatnce();
		UserService userService = serviceFactory.getUserService();
		HttpSession session = request.getSession();
		
		try {
			selectedUser = userService.getUser(username, local);
			session.setAttribute(ParamAndAttribute.SELECTED_USER_ATTRIBUTE, selectedUser);
			RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPagePath.USER_SETTING_ADMIN_PAGE);		
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
			RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPagePath.ERROR_PAGE);
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
