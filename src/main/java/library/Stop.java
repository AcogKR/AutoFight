package library;

/*
 * Created by IntelliJ IDEA
 * Developer : Acog Date : 2020-10-08/오후 7:45
 */

import org.bukkit.entity.Player;

public class Stop {
    public static boolean stop(Player player, String message) {
        player.sendMessage(Colorize.colorize(message.replace("%player%", player.getDisplayName())));
        return false;
    }
}
