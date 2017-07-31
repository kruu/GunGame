package de.pascalku.gungame.spawn;

import org.bukkit.Location;

/**
 * Created by Pascal on 30.07.2017.
 */
public class CircleSpawn extends SpawnExtension {

    public CircleSpawn(Double spawn_size, Location spawn_center) {
        super(spawn_size, spawn_center);
    }

    @Override
    public Boolean isSpawn(Location location) {
        getCenterLocation().setY(location.getY());
        if(location.distance(getCenterLocation()) < getSpawnSize()) {
            return true;
        }
        return false;
    }
}
