package de.pascalku.gungame.listeners;

import de.pascalku.gungame.cache.GunGameCache;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

/**
 * Created by Pascal on 30.07.2017.
 */
public class PlayerRespawnListener implements Listener {

    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerRespawn(PlayerRespawnEvent event) {
        event.setRespawnLocation(GunGameCache.getLocation());
    }
}