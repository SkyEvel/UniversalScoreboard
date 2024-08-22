# SkyEvel UniversalScoreboard API
Open source easy-to-use scoreboard adapter with a FastBoard engine inside.

## Version support
- Versions that has Kyori's Adventure API support.

### Features
- RGB Support using MiniMessage.
- Easy-to-use API.
- FastBoard engine inside.

## Example
### To make a scoreboard
```java
  public void makeScoreboard(Player player) {
    // Create a scoreboard with a title and lines.
    FastBoard fastBoard = UniversalScoreboardAPI.createBoard(
      player,
      Component.text("Example Title"),
      List.of(
        Component.empty(), // Empty line
        Component.text("Line 1"),
        Component.text("Line 2"),
        Component.text("Line 3"),
        Component.text("Line 4"),
        Component.text("Line 5"),
        Component.text("Line 6")
      ));
  
    // Update the title of the scoreboard
    UniversalScoreboardAPI.setBoardTitle(player, Component.text("New Title"));
  }
```
### To update the lines of a scoreboard
```java
  // To update the lines of the scoreboard asynchronously, you can listen for the AsyncPlayerBoardUpdateEvent.
  @EventHandler
  public void onAsyncScoreboardUpdate(AsyncPlayerBoardUpdateEvent event) {
    // Get the player who's scoreboard is being updated
    Player player = event.getPlayer();
    
    event.setLinesAsComponents(
      Component.text("Your name is "+ player.getName()), // Empty line
      Component.text("Line new 1"),
      Component.text("Line new 2")
    );
  }
```

### TO-DO
- [ ] Remove it as a standalone Plugin.
- [ ] Make the documentation much better.
- [ ] Add Animation support.
- [ ] Add PlaceholderAPI support.
- [ ] Add more features.
- [ ] Add more documentation.
- [ ] Add more support for older version(s).
