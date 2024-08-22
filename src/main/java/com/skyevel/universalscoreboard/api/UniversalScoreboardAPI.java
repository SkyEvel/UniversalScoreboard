package com.skyevel.universalscoreboard.api;

import com.skyevel.universalscoreboard.ComponentUtil;
import com.skyevel.universalscoreboard.workers.BoardWorker;
import fr.mrmicky.fastboard.adventure.FastBoard;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;

import java.util.List;

public class UniversalScoreboardAPI {
    /**
     * Get the FastBoard instance attached to a player.
     *
     * @param player the player
     * @return the scoreboard instance
     */
    public static FastBoard getBoard(Player player) {
        return BoardWorker.findFor(player);
    }

    /**
     * Set the title of a player's scoreboard.
     *
     * @param player the player
     * @param titleComponent the title
     */
    public static void setBoardTitle(Player player, Component titleComponent) {
        getBoard(player).updateTitle(titleComponent);
    }

    // Adventure API - start
    // Dan66ika77 changes start

    /**
     * Create the board instance for a player.
     *
     * @param player the player
     */
    public static void createBoard(Player player) {
        FastBoard board = new FastBoard(player);
        board.updateTitle(Component.empty());
        BoardWorker.getBoards().add(board);
    }

    /**
     * Create the board instance for a player with initial title.
     *
     * @param player the player
     * @param initialTitleComponent the initial title
     */
    public static void createBoard(Player player, Component initialTitleComponent) {
        FastBoard board = new FastBoard(player);
        board.updateTitle(initialTitleComponent);
        BoardWorker.getBoards().add(board);
    }

    /**
     * Create the board instance for a player with initial lines.
     *
     * @param player the player
     * @param initialTitleComponent the initial title
     * @param initialLineComponents the initial lines
     */
    public static void createBoard(Player player, Component initialTitleComponent, List<Component> initialLineComponents) {
        FastBoard board = new FastBoard(player);
        board.updateTitle(initialTitleComponent);
        board.updateLines(initialLineComponents);
        BoardWorker.getBoards().add(board);
    }

    // Dan66ika77 changes end
    // Adventure API - end

    // Legacy API - start

    /**
     * Set the title of a player's scoreboard.
     *
     * @param player the player
     * @param titleString the title
     */
    public static void setBoardTitle(Player player, String titleString) {
        getBoard(player).updateTitle(ComponentUtil.formatToComponent(titleString));
    }

    /**
     * Create the board instance for a player with initial title.
     *
     * @param player the player
     * @param initialTitleComponent the initial title
     */
    public static void createBoard(Player player, String initialTitleComponent) {
        FastBoard board = new FastBoard(player);
        board.updateTitle(ComponentUtil.formatToComponent(initialTitleComponent));
        BoardWorker.getBoards().add(board);
    }

    /**
     * Create the board instance for a player with initial lines.
     *
     * @param player the player
     * @param initialTitleComponent the initial title
     * @param initialLineComponents the initial lines
     */
    public static void createBoard(Player player, String initialTitleComponent, List<String> initialLineComponents) {
        FastBoard board = new FastBoard(player);
        board.updateTitle(ComponentUtil.formatToComponent(initialTitleComponent));
        board.updateLines(ComponentUtil.formatComponentList(initialLineComponents));
        BoardWorker.getBoards().add(board);
    }

    // Legacy API - end

    /**
     * Safely delete the board instance of a player.
     *
     * @param player the player
     */
    public static void destroyBoard(Player player) {
        FastBoard board = BoardWorker.findFor(player);
        if (board != null) board.delete();
    }
}
