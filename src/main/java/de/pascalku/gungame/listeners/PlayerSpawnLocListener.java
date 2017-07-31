package de.pascalku.gungame.listeners;

import de.pascalku.gungame.cache.GunGameCache;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.spigotmc.event.player.PlayerSpawnLocationEvent;

/**
 * Created by Pascal on 30.07.2017.
 */
public class PlayerSpawnLocListener implements Listener {

    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void onPlayerSpawnLoc(PlayerSpawnLocationEvent event) {
        System.out.println(GunGameCache.getLocation().getX() + "  - " + GunGameCache.getLocation().getY() + " - " + GunGameCache.getLocation().getZ());
        event.setSpawnLocation(GunGameCache.getLocation());
    }
}