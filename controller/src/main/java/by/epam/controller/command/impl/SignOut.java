package by.epam.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.epam.controller.command.Command;

public class SignOut implements Command {
	private static final Logger log = LoggerFactory.getLogger(SignOut.class.getName());

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		request.getSession(true).setAttribute(ParamAndAttribute.USER_ATTRIBUTE, null);
		request.getSession(true).removeAttribute(ParamAndAttribute.USER_ATTRIBUTE);
		request.getSession(true).removeValue(ParamAndAttribute.USER_ATTRIBUTE);
		request.getSession(true).removeAttribute(ParamAndAttribute.ERROR_MESSAGE_ATTRIBUTE);
		request.getSession(true).removeValue(ParamAndAttribute.ERROR_MESSAGE_ATTRIBUTE);
		request.getSession(true).removeAttribute(ParamAndAttribute.ERROR_INPUT_ATTRIBUTE);
		request.getSession(true).removeValue(ParamAndAttribute.ERROR_INPUT_ATTRIBUTE);
		request.getSession(true).removeAttribute(ParamAndAttribute.ERROR_TEMP_DATA_ATTRIBUTE);
		request.getSession(true).removeValue(ParamAndAttribute.ERROR_TEMP_DATA_ATTRIBUTE);
//		request.getSession(true).removeAttribute(ParamAndAttribute.ACTIVE_TAB_ATTRIBUTE);
//		request.getSession(true).removeValue(ParamAndAttribute.ACTIVE_TAB_ATTRIBUTE);
//		request.getSession(true).invalidate();
//		request.getSession(false);
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
