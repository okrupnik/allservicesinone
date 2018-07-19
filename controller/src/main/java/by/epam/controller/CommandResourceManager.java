package by.epam.controller;

import java.util.ResourceBundle;

public class CommandResourceManager {

	private final static CommandResourceManager instance = new CommandResourceManager();
	private ResourceBundle bundle = ResourceBundle.getBundle("command_name");
	
	private CommandResourceManager() {
	}
	
	public static CommandResourceManager getInstance( ) {
		return instance;
	}
	
	public String getValue(String key) {
		return bundle.getString(key);
	}
	
}
