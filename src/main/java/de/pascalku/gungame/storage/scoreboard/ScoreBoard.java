package de.pascalku.gungame.storage.scoreboard;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

/**
 * Created by Pascal on 30.07.2017.
 */
@Getter @Setter
public class ScoreBoard {

    private ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();
    private Scoreboard scoreboard;

    private Objective objective;

    private String header;
    private String[] lines;

    public ScoreBoard(String header, String[] lines) {
        this.header = header;
        this.lines = lines;

        scoreboard = scoreboardManager.getNewScoreboard();

        objective = scoreboard.registerNewObjective("", "");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        for(String string : lines) {
            
        }
    }
}