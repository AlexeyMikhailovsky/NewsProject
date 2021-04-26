package by.htp.ll.controller.command;

import java.util.HashMap;
import java.util.Map;

import by.htp.ll.controller.command.impl.DeleteNews;
import by.htp.ll.controller.command.impl.GoToEditPage;
import by.htp.ll.controller.command.impl.GoToFullNewsPage;
import by.htp.ll.controller.command.impl.GoToIndexPage;
import by.htp.ll.controller.command.impl.GoToMainPage;
import by.htp.ll.controller.command.impl.GoToRegistrationPage;
import by.htp.ll.controller.command.impl.Logination;
import by.htp.ll.controller.command.impl.Logout;
import by.htp.ll.controller.command.impl.SaveEditedNews;
import by.htp.ll.controller.command.impl.SaveNewUser;

public class CommandProvider {
	private Map<CommandName, Command> commands = new HashMap<>();
	
	public CommandProvider() {
		commands.put(CommandName.LOGINATION, new Logination());
		commands.put(CommandName.REGISTRATION, new GoToRegistrationPage());
		commands.put(CommandName.SAVENEWUSER ,new SaveNewUser());
		commands.put(CommandName.GOTOINDEXPAGE, new GoToIndexPage());
		commands.put(CommandName.GOTOMAINPAGE, new GoToMainPage());
		commands.put(CommandName.LOGOUT, new Logout());
		commands.put(CommandName.GOTOFULLNEWSPAGE, new GoToFullNewsPage());
		commands.put(CommandName.GOTOEDITPAGE, new GoToEditPage());
		commands.put(CommandName.SAVEEDITEDNEWS, new SaveEditedNews());
		commands.put(CommandName.DELETENEWS, new DeleteNews());
		
	}
	
	public Command takeCommand(String name) {
		CommandName commandName;
		
		commandName = CommandName.valueOf(name.toUpperCase());
		
		return commands.get(commandName);
	}

}
