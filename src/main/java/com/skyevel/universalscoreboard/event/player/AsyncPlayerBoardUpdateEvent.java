package com.skyevel.universalscoreboard.event.player;

import com.skyevel.universalscoreboard.feature.fastboard.FastBoard;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class AsyncPlayerBoardUpdateEvent extends Event {

    private static final HandlerList HANDLERS = new HandlerList();
    private List<String> lines = new ArrayList<>();
    private final FastBoard board;

    /**
     * Get the Handler list of the Event.
     *
     * @return a list of the handlers
     */
    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

    public AsyncPlayerBoardUpdateEvent(FastBoard board) {
        this.board = board;
    }

    /**
     * Get the Player who is attached to the current Scoreboard.
     *
     * @return the player
     */
    public Player getPlayer() {
        return this.board.getPlayer();
    }

    /**
     * Get the lines of the current Scoreboard.
     *
     * @return a list of Strings
     */
    public List<String> getLines() {
        return lines;
    }

    /**
     * Overwrite the lines of the current Scoreboard.
     *
     * @param lines a list of Strings
     */
    public void setLines(List<String> lines) {

        this.lines = lines;
    }

    /**
     * Overwrite the lines of the current Scoreboard.
     *
     * @param lines a listing of Strings
     */
    public void setLines(String... lines) {
        this.lines = List.of(lines);
    }


}
