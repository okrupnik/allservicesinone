package by.epam.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.controller.command.Command;

public class MainPage implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String local = null;
		local = (String) request.getSession().getAttribute(ParamAndAttribute.LOCALE_ATTRIBUTE);
		if (local == null) {
			local = request.getParameter(ParamAndAttribute.LOCALE_PARAM_NAME);
		}
//		String getParam = request.getLocale().getLanguage();
		request.getSession(true).setAttribute(ParamAndAttribute.LOCALE_ATTRIBUTE, local);

		RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPagePath.MAIN_PAGE);
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			// e.printStackTrace(); !!!!!!!!
		}
	}

}
