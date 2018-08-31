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

public class SignIn implements Command {
	private static final Logger log = LoggerFactory.getLogger(SignIn.class.getName());

	@Override
	public void execute(final HttpServletRequest request, final HttpServletResponse response) {

		String login = request.getParameter(ParamAndAttribute.USERNAME_PARAM_NAME);
		String password = request.getParameter(ParamAndAttribute.PASSWORD_PARAM_NAME);

		UserService userService = ServiceFactory.getInstatnce().getUserService();
		User user = null;
		HttpSession session = request.getSession();
		String locale = (String) request.getSession().getAttribute(ParamAndAttribute.LOCALE_ATTRIBUTE);

		try {
			user = userService.logination(login, password, locale);
			session.setAttribute(ParamAndAttribute.USER_ATTRIBUTE, user);
			response.sendRedirect("Controler?command=cn.main.page");
		} catch (ServiceException e) {
			String errorMessage = e.getMessage();
			session.setAttribute(ParamAndAttribute.ERROR_MESSAGE_ATTRIBUTE, errorMessage);
			RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPagePath.USER_SIGNIN_PAGE);
			try {
				dispatcher.forward(request, response);
			} catch (ServletException | IOException e1) {
				for (StackTraceElement stackTraceElement : e.getStackTrace()) {
					log.error(stackTraceElement.toString());
				}
			}
		} catch (IOException e) {
			for (StackTraceElement stackTraceElement : e.getStackTrace()) {
				log.error(stackTraceElement.toString());
			}
		} 

	}

}
