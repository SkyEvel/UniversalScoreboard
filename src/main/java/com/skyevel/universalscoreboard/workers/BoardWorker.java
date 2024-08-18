package com.skyevel.universalscoreboard.workers;

import com.skyevel.universalscoreboard.UniversalScoreboard;
import com.skyevel.universalscoreboard.event.player.AsyncPlayerBoardUpdateEvent;
import com.skyevel.universalscoreboard.feature.fastboard.FastBoard;
import org.bukkit.Bukkit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardWorker {

    private static Map<String, FastBoard> BOARDS = new HashMap<>();

    public static void updateBoard(FastBoard board) {
        List<String> empty = new ArrayList<>();

        AsyncPlayerBoardUpdateEvent event = new AsyncPlayerBoardUpdateEvent(board);
        Bukkit.getPluginManager().callEvent(event);

        List<String> lines = event.getLines();

        board.updateLines(lines);
    }

    public static Map<String, FastBoard> getBoards() {
        return BOARDS;
    }

    public static void initialize() {
        Bukkit.getServer().getScheduler().runTaskTimer(UniversalScoreboard.getInstance(), () -> {
            for(FastBoard board : BOARDS.values()) {
                updateBoard(board);
            }
        }, 0, 20L);
    }

}
