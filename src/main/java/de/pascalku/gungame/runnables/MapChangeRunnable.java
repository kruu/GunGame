package de.pascalku.gungame.runnables;

import de.pascalku.gungame.cache.GunGameCache;

import static de.eintestnetzwerk.einemapapi.EineMapAPI.getMapList;
import static de.pascalku.gungame.cache.GunGameCache.setMap;

/**
 * Created by Pascal on 30.07.2017.
 */
public class MapChangeRunnable implements Runnable {

    private Integer mapChangeTime = 1;

    @Override
    public void run() {
        mapChangeTime -= 1;

        trigger();

        if(mapChangeTime == 0) {
            mapChangeTime = 511;

            changeMap();
        } else if(mapChangeTime <= 500) {
            System.out.println("LUHL. 1 MapChangeRunnable iz da.");
        }
    }

    private void trigger() {
        Integer minutes = mapChangeTime / 60;
        Integer seconds = mapChangeTime - minutes * 60;

        String mm = (minutes < 10 ? "0" + minutes : "" + minutes);
        String ss = (seconds < 10 ? "0" + seconds : "" + seconds);

        GunGameCache.getGunScoreBoardMap().values().forEach(gunScoreBoard -> {

        });
    }

    private void changeMap() {
        try {
            setMap(getMapList().get(getMapList().size() - 1));
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}