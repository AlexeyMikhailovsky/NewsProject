package by.htp.ll.controller.command;

import java.util.HashMap;
import java.util.Map;

import by.htp.ll.controller.command.impl.GoToRegistrationPage;
import by.htp.ll.controller.command.impl.Logination;
import by.htp.ll.controller.command.impl.SaveNewUser;

public class CommandProvider {
	private Map<CommandName, Command> commands = new HashMap<>();
	
	public CommandProvider() {
		commands.put(CommandName.LOGINATION, new Logination());
		commands.put(CommandName.REGISTRATION, new GoToRegistrationPage());
		commands.put(CommandName.SAVENEWUSER ,new SaveNewUser());
	}
	
	public Command takeCommand(String name) {
		CommandName commandName;
		
		commandName = CommandName.valueOf(name.toUpperCase());
		
		return commands.get(commandName);
	}

}
