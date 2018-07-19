package by.epam.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.controller.command.Command;

public class Localization implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String local = request.getParameter("local");
		request.getSession(true).setAttribute("local", local);

		String referer = request.getHeader("Referer");
		response.sendRedirect(referer);
	}

}
