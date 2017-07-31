package de.pascalku.gungame.listeners;

import de.pascalku.gungame.cache.GunGameCache;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

/**
 * Created by Pascal on 30.07.2017.
 */
public class PlayerDamageListener implements Listener {

    @EventHandler(priority = EventPriority.HIGH)
    public void onEntDamage(EntityDamageEvent event) {
        if(GunGameCache.getSpawnExt().isSpawn(event.getEntity().getLocation())) {
            event.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onEntDamageByEnt(EntityDamageByEntityEvent event) {
        if(GunGameCache.getSpawnExt().isSpawn(event.getEntity().getLocation())
                || GunGameCache.getSpawnExt().isSpawn(event.getDamager().getLocation())) {
            event.setCancelled(true);
        }
    }
}