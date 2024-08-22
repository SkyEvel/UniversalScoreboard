package com.skyevel.universalscoreboard.workers;

import com.skyevel.universalscoreboard.UniversalScoreboard;
import com.skyevel.universalscoreboard.event.player.AsyncPlayerBoardUpdateEvent;
import fr.mrmicky.fastboard.adventure.FastBoard;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.*;

public class BoardWorker {
    private static final List<FastBoard> BOARDS = new ArrayList<>();

    public static void updateBoard(FastBoard board) {
        AsyncPlayerBoardUpdateEvent event = new AsyncPlayerBoardUpdateEvent(board);
        Bukkit.getPluginManager().callEvent(event);
        board.updateLines(event.getLinesAsComponents());
    }

    public static List<FastBoard> getBoards() {
        return BOARDS;
    }

    public static void initialize() {
        Bukkit.getServer().getScheduler().runTaskTimer(UniversalScoreboard.getInstance(), () -> {
            for (FastBoard board : BOARDS) updateBoard(board);
        }, 0, UniversalScoreboard.instance.getConfig().getInt("update-speed"));
    }

    public static FastBoard findFor(Player player) {
        for (FastBoard board : BOARDS) {
            if (board.getPlayer().equals(player)) return board;
        }
        return null;
    }
}
