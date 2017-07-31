package de.pascalku.gungame.listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

/**
 * Created by Pascal on 30.07.2017.
 */
public class PlayerMoveListener implements Listener {

    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerMove(PlayerMoveEvent event) {
        if(event.getPlayer().isDead()) {
            return;
        }
        if(event.getPlayer().getLocation().getBlock().getType() == Material.WATER
                || event.getPlayer().getLocation().getBlock().getType() == Material.STATIONARY_WATER) {
            event.getPlayer().setHealth(0f);
        }
    }
}