package kr.acog.autofight.command;

/*
 * Created by IntelliJ IDEA
 * Developer : Acog Date : 2020-10-07/오후 3:43
 */

import kr.acog.autofight.AutoFight;
import kr.acog.autofight.manager.LocationManager;
import kr.acog.autofight.manager.PlayerManager;
import library.Tool;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.List;

import static library.Lists.listOf;
import static library.Colorize.colorize;
import static library.Stop.stop;

public class FightManagerCommand implements CommandExecutor {

    final private AutoFight autoFight;
    final private LocationManager locationManager;
    final private PlayerManager playerManager;

    final private String option = "&b대전 &f: ";

    public FightManagerCommand(
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
        Tool tool = new Tool(sender, command, label, args);
        if (!tool.onCheck(true, true)) return true;
        if (args.length == 0) sender.sendMessage(colorize(getMessage(1)));
        Player player = (Player) sender;
        switch (args[0]) {
            case "명령어":
                for(String message : getGuide()) player.sendMessage(colorize(message));
            case "지역":
                if(!(args.length > 1)) return stop(player, option + "/대전관리 지역 도움말");
                switch (args[1]) {
                    case "도움말":
                        for(String message : getAreaGuide()) player.sendMessage(colorize(message));
                    default:
                        return stop(player, option + "/대전관리 지역 도움말");
                }
            case "강제종료":
                // STOPSHIP: 2020-10-08
            case "지역목록":
                player.openInventory(getAreaList());
            default:
                sender.sendMessage(colorize(getMessage(1)));
        }
        return false;
    }

    private List<String> getGuide() {
        return listOf(
                "",
                "",
                "");
    }

    private List<String> getAreaGuide() {
        return listOf(
                "",
                "",
                "");
    }

    private String getMessage(int index) {
        switch (index) {
            case 1: return option + "대전관리 명령어를 확인하실려면 \"/대전관리 명령어\"을 입력해주세요";
            case 2: return option + "dsf";
            default: return "?";
        }
    }

    private Inventory getAreaList() {
        Inventory inventory = Bukkit.createInventory(null, 6*9, "지역목록");

        return inventory;
    }
    /*
     * 명령어 목록
     * /대전관리 명령어 # 대전관리의 명령어 목록을 보여준다
     * /대전관리 지역 [이름] 생성
     * /대전관리 지역 [이름] 좌표설정
     * /대전관리 지역 [이름] 삭제
     * /대전관리 지역 [이름] 정보
     * /대전관리 강제종료 [이름]
     * /대전관리 지역목록 ( Gui )
     */
}
