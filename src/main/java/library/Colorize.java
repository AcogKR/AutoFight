package library;

/*
 * Created by IntelliJ IDEA
 * Developer : Acog Date : 2020-10-08/오후 5:19
 */

import org.bukkit.ChatColor;

public class Colorize {
    public static String colorize(String value) {
        return ChatColor.translateAlternateColorCodes('&', value);
    }
}
