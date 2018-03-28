package PresentationLayer;

import FunctionLayer.LegoException;
import FunctionLayer.LoginSampleException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract class Command {

    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put("login", new Login());
        commands.put("register", new Register());
        commands.put("Calculator", new Calculator());
        commands.put("toOrder", new toOrder());
        commands.put("toUserOrders", new toUserOrders());
        commands.put("toEmployeeOrders", new toEmployeeOrders());
    }

    static Command from(HttpServletRequest request) {
        String commandName = request.getParameter("command");
        if (commands == null) {
            initCommands();
        }
        return commands.getOrDefault(commandName, new UnknownCommand());
    }

    abstract String execute(HttpServletRequest request, HttpServletResponse response) throws LegoException, LoginSampleException;
   

}
