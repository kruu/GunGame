package de.pascalku.gungame.listeners;

import de.pascalku.gungame.cache.GunGameCache;
import de.pascalku.gungame.cache.GunPlayerCache;
import de.pascalku.gungame.events.GunInventoryUpdateEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.spigotmc.event.player.PlayerSpawnLocationEvent;

/**
 * Created by Pascal on 30.07.2017.
 */
public class PlayerJoinListener implements Listener {

    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.setJoinMessage(null);

        if(!event.getPlayer().hasPlayedBefore()) {
            PlayerSpawnLocationEvent playerSpawnLocationEvent = new PlayerSpawnLocationEvent(event.getPlayer(), event.getPlayer().getLocation());
            Bukkit.getPluginManager().callEvent(playerSpawnLocationEvent);

            event.getPlayer().teleport(playerSpawnLocationEvent.getSpawnLocation());
        } else {
            event.getPlayer().setHealth(20d);
            event.getPlayer().setFoodLevel(20);

            event.getPlayer().setExp(0f);
            event.getPlayer().setLevel(0);

            event.getPlayer().getInventory().clear();
            event.getPlayer().getInventory().setArmorContents(null);
        }

        GunGameCache.getGunPlayerCacheHashMap().put(event.getPlayer(),
                new GunPlayerCache(0, 0, 0));

        GunInventoryUpdateEvent gunInventoryUpdateEvent = new GunInventoryUpdateEvent(event.getPlayer(), 0);
        Bukkit.getPluginManager().callEvent(gunInventoryUpdateEvent);
    }
}