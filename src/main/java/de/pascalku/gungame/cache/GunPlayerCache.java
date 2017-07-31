package de.pascalku.gungame.cache;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by Pascal on 30.07.2017.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GunPlayerCache {

    private Integer killStreak, bestKillStreak;
}
