package kr.acog.autofight;

/*
 * Created by IntelliJ IDEA
 * Developer : Acog Date : 2020-10-07/오후 3:15
 */

import kr.acog.autofight.command.FightCommand;
import kr.acog.autofight.command.FightManagerCommand;
import kr.acog.autofight.manager.LocationManager;
import kr.acog.autofight.manager.PlayerManager;
import library.Pair;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class AutoFight extends JavaPlugin {

    final public LocationManager locationManager = new LocationManager(this);
    final public PlayerManager playerManager = new PlayerManager(this);

    @Override
    public void onDisable() {
        super.onDisable();
    }

    @Override
    public void onEnable() {
        registerCommand(
                new Pair("대전", new FightCommand(this, locationManager)),
                new Pair("", new FightManagerCommand(this, locationManager))
        );
    }

    @SafeVarargs
    private final void registerCommand(Pair<String, CommandExecutor>... commands) {
        for (Pair<String, CommandExecutor> command : commands) {
            getCommand(command.getFirst()).setExecutor(command.getSecond());
        }
    }
    
    @SafeVarargs
    private final void registerEvents(Listener... listeners) {
        for (Listener listener : listeners) {
            Bukkit.getPluginManager().registerEvents(listener, this);
        }
    }

}
