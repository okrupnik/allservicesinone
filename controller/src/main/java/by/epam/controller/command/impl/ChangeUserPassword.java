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
import by.epam.domain.error.ErrorMap;
import by.epam.domain.user.User;
import by.epam.service.ServiceFactory;
import by.epam.service.UserService;
import by.epam.service.exception.ServiceException;

public class ChangeUserPassword implements Command {
	private static final Logger log = LoggerFactory.getLogger(ChangeUserPassword.class.getName());
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		String oldPassword;
		String newPassword;
		String confirmPassword;
		
		User user = (User) request.getSession().getAttribute(ParamAndAttribute.USER_ATTRIBUTE); 
		oldPassword = request.getParameter(ParamAndAttribute.OLD_PASSWORD_PARAM_NAME);
		newPassword = request.getParameter(ParamAndAttribute.NEW_PASSWORD_PARAM_NAME);
		confirmPassword = request.getParameter(ParamAndAttribute.CONFIRM_PASSWORD_PARAM_NAME);
		
		ServiceFactory serviceFactory = ServiceFactory.getInstatnce();
		UserService userService = serviceFactory.getUserService();
		HttpSession session = request.getSession();
		String locale = (String) request.getSession().getAttribute(ParamAndAttribute.LOCALE_ATTRIBUTE);

		try {
			userService.changePassword(user, oldPassword, newPassword, confirmPassword, locale);	
			if (locale.equals(ControllerConstant.LOCALE_RU_PARAM_NAME)) {
				session.setAttribute(ParamAndAttribute.SUCCESS_EDIT_ATTRIBUTE, "Данные пользователя успешно измененны");
			} else {
				session.setAttribute(ParamAndAttribute.SUCCESS_EDIT_ATTRIBUTE, "Data of user changed successfully");
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPagePath.USER_EDIT_SUCCESS_PAGE);
			dispatcher.forward(request, response);				
			
		} catch (ServiceException e) {
			String errorMessage = e.getMessage();
			session.setAttribute(ParamAndAttribute.ERROR_MESSAGE_ATTRIBUTE, errorMessage);
			session.setAttribute(ParamAndAttribute.ERROR_INPUT_ATTRIBUTE, ErrorMap.getErrorsOfCreating());
			RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPagePath.USER_SETTING_PAGE);
			try {
				dispatcher.forward(request, response);
			} catch (ServletException | IOException e1) {
				for (StackTraceElement stackTraceElement : e.getStackTrace()) {
					log.error(stackTraceElement.toString());
				}
			}
		} catch (ServletException | IOException e) {
			for (StackTraceElement stackTraceElement : e.getStackTrace()) {
				log.error(stackTraceElement.toString());
			}
		} 
	}

}
