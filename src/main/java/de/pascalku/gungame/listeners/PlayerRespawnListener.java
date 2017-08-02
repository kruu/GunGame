package de.pascalku.gungame.listeners;

import de.pascalku.gungame.cache.GunGameCache;
import de.pascalku.gungame.cache.GunPlayerCache;
import de.pascalku.gungame.events.GunInventoryUpdateEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

import java.util.Random;

/**
 * Created by Pascal on 30.07.2017.
 */
public class PlayerRespawnListener implements Listener {

    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerRespawn(PlayerRespawnEvent event) {
        event.setRespawnLocation(GunGameCache.getLocation());

        Integer integer = 0;

        event.getPlayer().sendMessage("Test");

        if(GunGameCache.getGunPlayerCacheHashMap().containsKey(event.getPlayer())) {
            event.getPlayer().sendMessage("Test2");
            GunPlayerCache gunPlayerCache = GunGameCache.getGunPlayerCacheHashMap().get(event.getPlayer());

            integer = gunPlayerCache.getLevel();

            if(integer > 0) {
                Integer subtract = new Random().nextInt((gunPlayerCache.getLevel() > 5 ? gunPlayerCache.getLevel() / 2 : gunPlayerCache.getLevel())) + 1;
                integer -= subtract;

                event.getPlayer().sendMessage("integer now: " + integer + " from " + gunPlayerCache.getLevel());
            }

            if(integer < 0) {
                integer = 0;
            }

            event.getPlayer().sendMessage("Test3");

            gunPlayerCache.setLevel(integer);

            event.getPlayer().setLevel(integer);

            event.getPlayer().sendMessage("Test5");

            GunInventoryUpdateEvent gunInventoryUpdateEvent = new GunInventoryUpdateEvent(event.getPlayer(), integer);
            Bukkit.getPluginManager().callEvent(gunInventoryUpdateEvent);
        }
        event.getPlayer().sendMessage("Test6");
    }
}