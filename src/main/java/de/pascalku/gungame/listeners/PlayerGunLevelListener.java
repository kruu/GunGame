package de.pascalku.gungame.listeners;

import de.pascalku.gungame.GunGame;
import de.pascalku.gungame.cache.GunGameCache;
import de.pascalku.gungame.data.GunHash;
import de.pascalku.gungame.events.GunInventoryUpdateEvent;
import de.pascalku.gungame.events.PlayerLevelLostEvent;
import de.pascalku.gungame.events.PlayerLevelUpEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

/**
 * Created by Pascal on 30.07.2017.
 */
public class PlayerGunLevelListener implements Listener {

    @EventHandler(priority = EventPriority.LOW)
    public void onLevelUp(PlayerLevelUpEvent event) {
        /**
         *  event.getPlayer() -> Player
         */

        if(event.isCancelled()) {
            return;
        }


    }

    @EventHandler(priority = EventPriority.LOW)
    public void onLevelLost(PlayerLevelLostEvent event) {

    }

    @EventHandler(priority = EventPriority.LOW, ignoreCancelled = true)
    public void onGunInvUpdate(GunInventoryUpdateEvent event) {
        if(GunGameCache.getItemSetHashMap().containsKey(event.getLevelNow())) {
            GunHash gunHash = GunGameCache.getItemSetHashMap().get(event.getLevelNow());

            if(gunHash != null) {
                gunHash.setToPlayer(event.getPlayer());
            }
        } else {
            GunHash gunHash = GunGameCache.getDefaultGunHash();

            if(gunHash != null) {
                gunHash.setToPlayer(event.getPlayer());
            }
        }
    }
}