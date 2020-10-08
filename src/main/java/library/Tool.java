package library;

/*
 * Created by IntelliJ IDEA
 * Developer : Acog Date : 2020-10-08/오후 4:05
 */

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Tool {

    final private CommandSender sender;
    final private Command command;
    final private String label;
    final private String[] args;

    public Tool(CommandSender sender, Command command, String label, String[] args) {
        this.sender = sender;
        this.command = command;
        this.label = label;
        this.args = args;
    }

    public boolean onCheck(boolean isPlayer, boolean isOp) {
        if(isPlayer) {
            if(isOp) {
                return this.sender instanceof Player && sender.isOp();
            } else {
                return this.sender instanceof Player;
            }
        } else if(isOp) {
            return this.sender instanceof Player;
        }
        return true;
    }

    /*
     * GETTER Function
     */

    public CommandSender getSender() {
        return this.sender;
    }

    public Command getCommand() {
        return this.command;
    }

    public String getLabel() {
        return this.label;
    }

    public String[] getArgs() {
        return this.args;
    }

}
