package by.epam.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.controller.command.Command;
import by.epam.controller.command.impl.Localization;
import by.epam.controller.command.impl.MainPage;
import by.epam.dao.impl.SQLUserDAO;

public class CommandProvider {
	private static final Logger log = LogManager.getLogger(CommandProvider.class.getName());
	
	Command command = null;

	private CommandResourceManager commandResourceManager = CommandResourceManager.getInstance();

	public CommandProvider() {
	}

	public Command getCommand(String commandName) {
		String classNameProp = commandResourceManager.getValue(commandName);
		try {
			command = (Command) Class.forName(classNameProp).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			for (StackTraceElement stackTraceElement : e.getStackTrace()) {
				log.error(stackTraceElement);
			}
		}

		return command;
	}
}
