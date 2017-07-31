package de.pascalku.gungame.spawn;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.Location;

/**
 * Created by Pascal on 30.07.2017.
 */
@Getter @Setter
public abstract class SpawnExtension {

    private Double spawnSize;
    private Location centerLocation;

    public SpawnExtension(Double spawn_size, Location spawn_center) {
        this.spawnSize = spawn_size;
        this.centerLocation = spawn_center;
    }

    public abstract Boolean isSpawn(Location location);
}