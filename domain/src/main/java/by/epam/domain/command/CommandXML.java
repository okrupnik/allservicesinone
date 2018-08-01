package by.epam.domain.command;

public class CommandXML {
	
	private String commandName;
	private String className;
	
	public CommandXML(String commandName, String className) {
		this.commandName = commandName;
		this.className = className;
	}

	public String getCommandName() {
		return commandName;
	}
	
	public String getClassName() {
		return className;
	}	

}
