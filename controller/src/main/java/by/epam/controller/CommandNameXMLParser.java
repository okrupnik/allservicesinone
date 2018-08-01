package by.epam.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import by.epam.domain.command.CommandXML;

public class CommandNameXMLParser {

	private static final Logger log = LogManager.getLogger(CommandNameXMLParser.class.getName());

	private final static CommandNameXMLParser instance = new CommandNameXMLParser();
	private static ArrayList<CommandXML> commands = new ArrayList<>();
		
	private CommandNameXMLParser() {	
	}

	public static CommandNameXMLParser getInstance( ) {
		return instance;
	}
	
	private static class XMLHandler extends DefaultHandler {

		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes)
				throws SAXException {
			if (qName.equals("command")) {
				String commandName = attributes.getValue("commandName");
				String className = attributes.getValue("className");
				commands.add(new CommandXML(commandName, className));
			}
		}
	}

	public ArrayList<CommandXML> getCommandClass() {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser;
		try {
			parser = factory.newSAXParser();
			XMLHandler handler = new XMLHandler();
			ClassLoader classLoader = getClass().getClassLoader();
			parser.parse(new File(classLoader.getResource("command_name.xml").getFile()), handler);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			for (StackTraceElement stackTraceElement : e.getStackTrace()) {
				log.error(stackTraceElement);
			}
		}

		return commands;
	}

}
