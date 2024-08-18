package com.skyevel.universalscoreboard.api;

import com.skyevel.universalscoreboard.feature.fastboard.FastBoard;
import com.skyevel.universalscoreboard.workers.BoardWorker;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class UniversalScoreboardAPI {

    /**
     * Get the FastBoard instance attached to a player.
     *
     * @param player the player
     * @return the scoreboard instance
     */
    public static FastBoard getBoard(Player player) {
        return BoardWorker.getBoards().get(player.getName());
    }

    /**
     * Set the title of a player's scoreboard.
     *
     * @param player the player
     * @param title the title
     */
    public static void setBoardTitle(Player player, String title) {

        getBoard(player).updateTitle(title);

    }

    /**
     * Create the board instance for a player.
     *
     * @param player the player
     */
    public static void createBoard(Player player) {

        FastBoard board = new FastBoard(player);
        board.updateTitle(" ");
        BoardWorker.getBoards().put(player.getName(), board);
    }

    /**
     * Safely delete the board instance of a player.
     *
     * @param player the player
     */
    public static void destroyBoard(Player player) {

        String playerName = player.getName();

        FastBoard board = BoardWorker.getBoards().remove(playerName);

        if(board != null) {
            board.delete();
        }

    }
}
