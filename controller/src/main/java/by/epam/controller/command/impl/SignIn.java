package by.epam.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.epam.controller.command.Command;
import by.epam.domain.user.User;
import by.epam.service.ServiceFactory;
import by.epam.service.UserService;
import by.epam.service.exception.ServiceException;

public class SignIn implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String login = request.getParameter(ParamAndAttribute.USERNAME_PARAM_NAME);
		String password = request.getParameter(ParamAndAttribute.PASSWORD_PARAM_NAME);

		ServiceFactory serviceFactory = ServiceFactory.getInstatnce();
		UserService userService = serviceFactory.getUserService();
		User user = null;
		HttpSession session = request.getSession();
		String locale = (String) request.getSession().getAttribute(ParamAndAttribute.LOCALE_ATTRIBUTE);

		try {
			user = userService.logination(login, password, locale);
			if (user != null) {
				session.setAttribute(ParamAndAttribute.USER_ATTRIBUTE, user);
				response.sendRedirect("Controler?command=cn.main.page");
			} else {
				if (locale.equals(ControllerConstant.LOCALE_RU_PARAM_NAME)) {
					session.setAttribute(ParamAndAttribute.ERROR_MESSAGE_ATTRIBUTE, "Неправильное имя пользователя или пароль");
					response.sendRedirect(request.getHeader("Referer"));
				} else {
					session.setAttribute(ParamAndAttribute.ERROR_MESSAGE_ATTRIBUTE, "Incorrect username or password");
					response.sendRedirect(request.getHeader("Referer"));
				}
			}
		} catch (ServiceException e) {
			String errorMessage = e.getMessage();
			session.setAttribute(ParamAndAttribute.ERROR_MESSAGE_ATTRIBUTE, errorMessage);
			response.sendRedirect(request.getHeader("Referer"));
		}

	}

}
