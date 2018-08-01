package by.epam.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.controller.command.Command;
import by.epam.domain.command.CommandXML;

public class CommandProvider {
	private static final Logger log = LogManager.getLogger(CommandProvider.class.getName());

	private ArrayList<CommandXML> commandXML = CommandNameXMLParser.getInstance().getCommandClass();
	private Map<String, Command> commands = new HashMap<>();

	public CommandProvider() {
		for (CommandXML commandXMLtmp : commandXML) {
			try {
				commands.put(commandXMLtmp.getCommandName(),
						(Command) Class.forName(commandXMLtmp.getClassName()).newInstance());
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				for (StackTraceElement stackTraceElement : e.getStackTrace()) {
					log.error(stackTraceElement);
				}
			}
		}
	}

	public Command getCommand(String commandName) {
		Command command = commands.get(commandName);

		return command;
	}
}