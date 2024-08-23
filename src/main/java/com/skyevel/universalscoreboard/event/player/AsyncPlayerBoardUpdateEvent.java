package com.skyevel.universalscoreboard.event.player;

import com.skyevel.universalscoreboard.ComponentUtil;
import fr.mrmicky.fastboard.adventure.FastBoard;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Event that is called when a player's scoreboard is updated asynchronously.
 * <p>
 *   Now we don't recommend using Strings for updating lines, when using Strings
 *   the input will go through a processor to serialize it to a {@link Component}.
 *   For more information: <a href="https://docs.advntr.dev/">Kyori's Adventure API</a>
 *   <br><br>
 *   <i>To get help with {@link Component}s, you can use the {@link ComponentUtil} class.</i>
 * </p>
 * @see ComponentUtil
 * @see FastBoard
 */
public class AsyncPlayerBoardUpdateEvent extends Event {
  private static final HandlerList HANDLERS = new HandlerList();
  private final FastBoard board; // the FastBoard instance
  private List<Component> lines; // the initial lines

  public AsyncPlayerBoardUpdateEvent(FastBoard board) {
    this.board = board;
    this.lines = board.getLines();
  }

  public static HandlerList getHandlerList() {
    return HANDLERS;
  }

  /**
   * Get the Handler list of the Event.
   *
   * @return a list of the handlers
   */
  @Override
  public @NotNull HandlerList getHandlers() {
    return HANDLERS;
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
   * @return a list of {@link Component}s
   */
  public List<Component> getLinesAsComponents() {
    return this.lines;
  }

  /**
   * Get the lines of the current Scoreboard.
   *
   * @return a list of {@link String}s
   */
  public List<String> getLinesAsStrings() {
    return ComponentUtil.serializeComponentList(this.lines);
  }

  /**
   * Overwrite the lines of the current Scoreboard.
   *
   * @param lines a list of {@link Component}s
   */
  public void setLinesAsComponents(Component... lines) {
    this.lines = List.of(lines);
  }

  /**
   * Overwrite the lines of the current Scoreboard.
   * @param lines a list of {@link Component}s
   */
  public void setLineAsComponents(List<Component> lines) {
    this.lines = lines;
  }

  /**
   * Overwrite the lines of the current Scoreboard.
   *
   * @param lines a list of {@link String}s
   */
  public void setLinesAsStrings(String... lines) {
    this.lines = ComponentUtil.deserializeStringList(List.of(lines));
  }

  /**
   * Overwrite the lines of the current Scoreboard.
   *
   * @param lines a list of {@link String}s
   */
  public void setLinesAsStrings(List<String> lines) {
    this.lines = ComponentUtil.deserializeStringList(lines);
  }

  /**
   * Deprecated legacy method to overwrite the lines of the current Scoreboard.
   *
   * @param lines a list of {@link String}s
   */
  @Deprecated
  public void setLines(List<String> lines) { setLinesAsStrings(lines); }

  /**
   * Deprecated legacy method to overwrite the lines of the current Scoreboard.
   *
   * @param lines a list of {@link String}s
   */
  @Deprecated
  public void setLines(String... lines) { setLines(List.of(lines)); }

}
