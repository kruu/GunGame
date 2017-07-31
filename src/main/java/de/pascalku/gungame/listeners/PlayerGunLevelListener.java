package de.pascalku.gungame.listeners;

import de.pascalku.gungame.events.PlayerLevelUpEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

/**
 * Created by Pascal on 30.07.2017.
 */
public class PlayerGunLevelListener implements Listener {

    @EventHandler(priority = EventPriority.LOW)
    public void onPlayerLvl(PlayerLevelUpEvent event) {
        /**
         * event.getLevelUp()
         * -> true: means level up (by kill)
         * -> false: means level down (by death)
         *
         *  event.getPlayer() -> Player
         */

        if(event.isCancelled()) {
            return;
        }
    }
}