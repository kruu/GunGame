package de.pascalku.gungame.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 * Created by Pascal on 30.07.2017.
 */
public class PlayerInteractListener implements Listener {

    @EventHandler
    public void onPlayerInt(PlayerInteractEvent event) {
        if(event.getAction() == Action.PHYSICAL) {
            event.setCancelled(true);
        }
    }
}