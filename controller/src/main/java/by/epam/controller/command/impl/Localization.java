package by.epam.controller.command.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.epam.controller.command.Command;

public class Localization implements Command {
	private static final Logger log = LoggerFactory.getLogger(Localization.class.getName());

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
//		String local = request.getParameter(ParamAndAttribute.LOCALE_PARAM_NAME);
//		request.getSession(true).setAttribute(ParamAndAttribute.LOCALE_ATTRIBUTE, local);
//
//		String referer = request.getHeader("Referer");
//		response.sendRedirect(referer);
		
			
		String goToPage = null;
		String local = request.getParameter(ParamAndAttribute.LOCALE_PARAM_NAME);
		goToPage = (String) request.getSession(true).getAttribute(ControllerConstant.PREVIOUS_COMMAND_AND_ATTRIBUTE);	
		if (goToPage == null) {
			goToPage = request.getContextPath();
		}		
		request.getSession(true).setAttribute(ParamAndAttribute.LOCALE_ATTRIBUTE, local);
		try {
			response.sendRedirect(goToPage);
		} catch (IOException e) {
			for (StackTraceElement stackTraceElement : e.getStackTrace()) {
				log.error(stackTraceElement.toString());
			}
		}
		
	}

}
