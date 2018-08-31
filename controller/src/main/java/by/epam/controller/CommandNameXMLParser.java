package by.epam.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import by.epam.domain.command.CommandXML;

public class CommandNameXMLParser {

	private static final Logger log = LoggerFactory.getLogger(CommandNameXMLParser.class.getName());

	private static final String COMMAND_PARAM_NAME = "command";
	private static final String COMMAND_NAME = "commandName";
	private static final String CLASS_NAME = "className";
	private static final String XML_FILE = "command_name.xml";
	private final static CommandNameXMLParser instance = new CommandNameXMLParser();
	private static ArrayList<CommandXML> commands = new ArrayList<>();
		
	private CommandNameXMLParser() {	
	}

	public static CommandNameXMLParser getInstance( ) {
		return instance;
	}
	
	private static class XMLHandler extends DefaultHandler {

		@Override
		public void startElement(final String uri, final String localName, final String qName, final Attributes attributes)
				throws SAXException {
			if (qName.equals(COMMAND_PARAM_NAME)) {
				String commandName = attributes.getValue(COMMAND_NAME);
				String className = attributes.getValue(CLASS_NAME);
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
			parser.parse(new File(classLoader.getResource(XML_FILE).getFile()), handler);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			for (StackTraceElement stackTraceElement : e.getStackTrace()) {
				log.error(stackTraceElement.toString());
			}
		}

		return commands;
	}

}
