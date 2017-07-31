package de.pascalku.gungame.listeners;

import de.pascalku.gungame.events.PlayerLevelLostEvent;
import de.pascalku.gungame.events.PlayerLevelUpEvent;
import de.pascalku.gungame.cache.GunGameCache;
import de.pascalku.gungame.cache.GunPlayerCache;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

/**
 * Created by Pascal on 30.07.2017.
 */
public class PlayerDeathListener implements Listener {

    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player entity = event.getEntity();

        PlayerLevelLostEvent playerLevelLostEvent = new PlayerLevelLostEvent(entity);
        Bukkit.getServer().getPluginManager().callEvent(playerLevelLostEvent);

        try {
            GunPlayerCache gunPlayerCache = GunGameCache.getGunPlayerCacheHashMap().get(entity);

            gunPlayerCache.setKillStreak(0);
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        if(event.getEntity().getKiller() != null
                && event.getEntity().getKiller() instanceof Player) {
            Player killer = event.getEntity().getKiller();

            PlayerLevelUpEvent killerLevelEvent = new PlayerLevelUpEvent(killer);
            Bukkit.getServer().getPluginManager().callEvent(killerLevelEvent);

            try {
                GunPlayerCache gunKillerCache = GunGameCache.getGunPlayerCacheHashMap().get(killer);

                gunKillerCache.setKillStreak(gunKillerCache.getKillStreak() + 1);

                if(gunKillerCache.getKillStreak() > gunKillerCache.getBestKillStreak()) {
                    gunKillerCache.setBestKillStreak(gunKillerCache.getKillStreak());
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }

        /* GunGame.getExecutorService().scheduleWithFixedDelay(() -> {
            event.getEntity().sendMessage("RESPAWN NOW2");

            if(event.getEntity().isDead()) {
                event.getEntity().sendMessage("RESPAWN NOW1");
                entity.spigot().respawn();
            }
        }, 0L, 50L, TimeUnit.MILLISECONDS); */
    }
}