package de.rexlmanu.bewerbung.listeners.player;
/*
* Class created by rexlManu
* Twitter: @rexlManu | Website: rexlManu.de
* Coded with IntelliJ
*/

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void on(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        event.setJoinMessage("§7Der Spieler §a"+player.getDisplayName()+"§7 hat den Server betreten.");
        ItemStack itemStack = new ItemStack(Material.COMPASS, 1);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName("");
        itemStack.setItemMeta(itemMeta);
        player.getInventory().setItem(0,itemStack);
    }
}
