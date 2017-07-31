package de.pascalku.gungame.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Created by Pascal on 30.07.2017.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class PlayerLevelUpEvent extends Event implements Cancellable {

    public static HandlerList handlers = new HandlerList();

    private boolean cancelled = false;

    private Player player;

    public PlayerLevelUpEvent(Player player) {
        this.player = player;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    public static HandlerList getHandlerList(){
        return handlers;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

}
