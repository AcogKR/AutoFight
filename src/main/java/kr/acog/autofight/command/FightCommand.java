package kr.acog.autofight.command;

/*
 * Created by IntelliJ IDEA
 * Developer : Acog Date : 2020-10-07/오후 3:43
 */

import kr.acog.autofight.AutoFight;
import kr.acog.autofight.manager.LocationManager;
import kr.acog.autofight.manager.PlayerManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class FightCommand implements CommandExecutor {

    final private AutoFight autoFight;
    final private LocationManager locationManager;
    final private PlayerManager playerManager;

    public FightCommand(
            AutoFight autoFight,
            LocationManager locationManager,
            PlayerManager playerManager
    ) {
        this.autoFight = autoFight;
        this.locationManager = locationManager;
        this.playerManager = playerManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        return false;
    }


}