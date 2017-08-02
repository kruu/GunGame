package de.pascalku.gungame.cache;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gson.internal.LinkedTreeMap;
import de.eintestnetzwerk.einemapapi.EineMapAPI;
import de.eintestnetzwerk.einemapapi.objects.Map;
import de.pascalku.gungame.data.GunHash;
import de.pascalku.gungame.spawn.CircleSpawn;
import de.pascalku.gungame.spawn.SpawnExtension;
import de.pascalku.gungame.storage.scoreboard.GunScoreBoard;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * Created by Pascal on 30.07.2017.
 */
public class GunGameCache {

    @Getter
    private static HashMap<Player, GunPlayerCache> gunPlayerCacheHashMap = Maps.newHashMap();

    @Getter
    private static HashMap<Player, GunScoreBoard> gunScoreBoardMap = Maps.newHashMap();

    @Setter
    private static Location location;

    public static Location getLocation() {
        location.setYaw((float) new Random().nextInt(360) - 180);
        return location;
    }

    @Getter
    private static SpawnExtension spawnExt;

    @Getter
    private static Map map;

    @Getter
    private static List<Map> mapList = Lists.newArrayList();

    public static void setMap(Map inputMap) {
        map = inputMap;

        try {
            switch(inputMap.getObjectMap().get("spawn_type").toString()) {
                case "CIRCLE":
                    spawnExt = new CircleSpawn((Double) inputMap.getObjectMap().get("spawn_size"),
                            EineMapAPI.getLocation((LinkedTreeMap) inputMap.getObjectMap().get("spawn_center")));
                    break;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        setLocation(EineMapAPI.getLocation((LinkedTreeMap) inputMap.getObjectMap().get("spawn_location")));
        System.out.println("NOW: " + getLocation().getX() + "  - " + getLocation().getY() + " - " + getLocation().getZ());
    }

    @Getter @Setter
    private static GunHash defaultGunHash = null;

    @Getter
    private static HashMap<Integer, GunHash> itemSetHashMap = Maps.newHashMap();
}