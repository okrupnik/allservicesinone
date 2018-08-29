package by.epam.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.controller.command.Command;


@WebServlet(name = "Controler", urlPatterns = { "/Controler" })
public final class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String COMMAND_PARAM_NAME = "command";

	private final CommandProvider commandProvider = new CommandProvider();

	public Controller() {
		super();
	}

	protected void doGet(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {
		String commandName = request.getParameter(COMMAND_PARAM_NAME);

		Command command = commandProvider.getCommand(commandName);
		command.execute(request, response);
	}

	protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
