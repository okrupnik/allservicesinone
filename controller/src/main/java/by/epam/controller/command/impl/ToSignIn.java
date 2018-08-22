package by.epam.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.epam.controller.command.Command;

public class ToSignIn implements Command{
	private static final Logger log = LoggerFactory.getLogger(ToSignIn.class.getName());

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPagePath.USER_SIGNIN_PAGE);
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			for (StackTraceElement stackTraceElement : e.getStackTrace()) {
				log.error(stackTraceElement.toString());
			}
		}
			
	}

}
