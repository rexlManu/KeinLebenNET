package de.rexlmanu.bewerbung.commands;
/*
* Class created by rexlManu
* Twitter: @rexlManu | Website: rexlManu.de
* Coded with IntelliJ
*/

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReloadCommand extends Command {
    public ReloadCommand() {
        super("lbreload");
    }

    @Override
    public boolean execute(CommandSender commandSender, String s, String[] strings) {
        if (!(commandSender instanceof Player)) {
            return true;
        }
        Player player = (Player) commandSender;
        if (!player.hasPermission("lb.reload")) {
            player.sendMessage("§cDu hast dazu keine Berechtigung.");
            return true;
        }
        
        return false;
    }
}
