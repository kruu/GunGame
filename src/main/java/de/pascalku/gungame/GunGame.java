package de.pascalku.gungame;

import de.eintestnetzwerk.einemapapi.EineMapAPI;
import de.pascalku.gungame.cache.GunGameCache;
import de.pascalku.gungame.listeners.*;
import de.pascalku.gungame.runnables.MapChangeRunnable;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static de.eintestnetzwerk.einemapapi.EineMapAPI.getMapList;

/**
 * Created by Pascal on 30.07.2017.
 */
public class GunGame extends JavaPlugin {

    public GunGame() {
        instance = this;
    }

    @Getter
    private static GunGameCache gunGameCache = new GunGameCache();

    @Getter
    private static GunGame instance;

    @Getter
    private static ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

    @Override
    public void onLoad() {
        File folder = new File("mapList");

        if(!folder.exists()
                || !folder.isDirectory()) {
            folder.mkdir();
        }

        for(File file : folder.listFiles()) {
            System.out.println(file.toPath());
            try {
                getMapList().add(EineMapAPI.load(file));
            } catch(FileNotFoundException exception) {
                exception.printStackTrace();
            }
        }
    }

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new CanvasListener(), this);

        getServer().getPluginManager().registerEvents(new PlayerBlockListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerSpawnLocListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerInteractListener(), this);

        getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerQuitListener(), this);

        getServer().getPluginManager().registerEvents(new PlayerDamageListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerDeathListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerRespawnListener(), this);

        getServer().getPluginManager().registerEvents(new PlayerFoodListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerMoveListener(), this);

        getServer().getPluginManager().registerEvents(new PlayerGunLevelListener(), this);

        MapChangeRunnable mapChangeRunnable = new MapChangeRunnable();
        executorService.scheduleWithFixedDelay(mapChangeRunnable, 0L, 1L, TimeUnit.SECONDS);
    }

    @Override
    public void onDisable() {

    }
}