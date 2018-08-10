package by.epam.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.epam.controller.command.Command;
import by.epam.domain.error.ErrorMap;
import by.epam.domain.user.User;
import by.epam.service.ServiceFactory;
import by.epam.service.UserService;
import by.epam.service.exception.ServiceException;

public class ChangeUserPassword implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String oldPassword;
		String newPassword;
		String confirmPassword;
		
		User user = (User) request.getSession().getAttribute("user"); 
		oldPassword = request.getParameter(ParamAndAttribute.OLD_PASSWORD_PARAM_NAME);
		newPassword = request.getParameter(ParamAndAttribute.NEW_PASSWORD_PARAM_NAME);
		confirmPassword = request.getParameter(ParamAndAttribute.CONFIRM_PASSWORD_PARAM_NAME);
		
		ServiceFactory serviceFactory = ServiceFactory.getInstatnce();
		UserService userService = serviceFactory.getUserService();
		HttpSession session = request.getSession();
		String locale = (String) request.getSession().getAttribute(ParamAndAttribute.LOCALE_ATTRIBUTE);

		try {
			if (userService.changePassword(user, oldPassword, newPassword, confirmPassword, locale)) {				
				if (locale.equals(ControllerConstant.LOCALE_RU_PARAM_NAME)) {
					session.setAttribute(ParamAndAttribute.SUCCESS_EDIT_ATTRIBUTE, "Пароль пользователя успешно изменен");
				} else {
					session.setAttribute(ParamAndAttribute.SUCCESS_EDIT_ATTRIBUTE, "Password of user changed successfully");
				}
				RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPagePath.USER_EDIT_SUCCESS_PAGE);
				dispatcher.forward(request, response);
			} else {
				if (locale.equals(ControllerConstant.LOCALE_RU_PARAM_NAME)) {
					session.setAttribute(ParamAndAttribute.ERROR_MESSAGE_ATTRIBUTE, "Ошибка изменения пароля");
					response.sendRedirect(request.getHeader("Referer"));
				} else {
					session.setAttribute(ParamAndAttribute.ERROR_MESSAGE_ATTRIBUTE, "Error of changing password");
					response.sendRedirect(request.getHeader("Referer"));
				}
			}
		} catch (ServiceException e) {
			String errorMessage = e.getMessage();
			session.setAttribute(ParamAndAttribute.ERROR_MESSAGE_ATTRIBUTE, errorMessage);
			session.setAttribute(ParamAndAttribute.ERROR_INPUT_ATTRIBUTE, ErrorMap.getErrorsOfCreating());
			response.sendRedirect(request.getHeader("Referer"));
		}
	}

}
