package by.epam.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.epam.controller.command.Command;

public class MainPage implements Command {
	private static final Logger log = LoggerFactory.getLogger(MainPage.class.getName());

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String local = null;
		local = (String) request.getSession().getAttribute(ParamAndAttribute.LOCALE_ATTRIBUTE);
		if (local == null) {
			local = ControllerConstant.LOCALE_EN_PARAM_NAME;
		}
//		String getParam = request.getLocale().getLanguage();
		request.getSession(true).setAttribute(ParamAndAttribute.LOCALE_ATTRIBUTE, local);

		RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPagePath.MAIN_PAGE);
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			for (StackTraceElement stackTraceElement : e.getStackTrace()) {
				log.error(stackTraceElement.toString());
			}
		}
		
	}

}
