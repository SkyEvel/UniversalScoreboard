package com.skyevel.universalscoreboard;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Utility class for converting Strings to {@link Component} and vice versa
 *
 * @author Dan66ika77 (<a href="https://github.com/dan66ika77">GitHub Page</a>)
 */
public class ComponentUtil {
  // this is the serializer/deserializer for the utility class
  private static final LegacyComponentSerializer SERIALIZER = LegacyComponentSerializer.builder()
    .character('&')
    .useUnusualXRepeatedCharacterHexFormat()
    .hexColors()
    .build();

  /**
   * Format a String so that every type of message can be used
   * to send it to chat
   *
   * @param message the message to format
   * @return the formatted message as a String (can be converted to a {@link Component})
   */
  @NotNull
  public static String formatToString(@NotNull String message) {
    message = message.replace('§', '&');
    message = serialize(MiniMessage.miniMessage().deserialize(message));
    return message;
  }

  /**
   * Format a String so that every type of message can be used
   * to send it to chat in a Component form
   *
   * @param message the message to format
   * @return the formatted message as a Component
   */
  @NotNull
  public static Component formatToComponent(@NotNull String message) {
    message = message.replace('§', '&');
    message = serialize(MiniMessage.miniMessage().deserialize(message));
    return deserialize(message);
  }

  /**
   * Deserialize a String to a {@link Component}
   *
   * @param message the message to deserialize
   * @return the deserialized message as a {@link Component}
   */
  @NotNull
  public static Component deserialize(@NotNull String message) {
    return SERIALIZER.deserialize(message);
  }

  /**
   * Serialize a {@link Component} to a String
   *
   * @param message the message to serialize
   * @return the serialized message as a String
   */
  @NotNull
  public static String serialize(@NotNull Component message) {
    return SERIALIZER.serialize(message);
  }

  /**
   * Process a list of Strings to a list of formatted Strings
   *
   * @param list the list to process
   * @return the processed list
   */
  @NotNull
  public static List<String> processStringList(@NotNull List<String> list) {
    return list.stream()
      .map(ComponentUtil::formatToString)
      .collect(Collectors.toCollection(() -> new ArrayList<>(list.size())));
  }

  /**
   * Process a list of formatted Strings to a list of {@link Component}s
   *
   * @param list the list to process
   * @return the processed list
   */
  @NotNull
  public static List<Component> processComponentList(@NotNull List<String> list) {
    return list.stream()
      .map(line -> deserialize(formatToString(line)))
      .collect(Collectors.toCollection(() -> new ArrayList<>(list.size())));
  }

  /**
   * Serializes list of {@link Component}s to a list of formatted {@link String}s
   *
   * @param list the list to process
   * @return the processed list
   */
  @NotNull
  public static List<String> serializeComponentList(@NotNull List<Component> list) {
    return list.stream()
      .map(ComponentUtil::serialize)
      .collect(Collectors.toCollection(() -> new ArrayList<>(list.size())));
  }

  /**
   * Deserializes a list of {@link String}s to a list of {@link Component}s
   *
   * @param list the list to process
   * @return the processed list
   */
  @NotNull
  public static List<Component> deserializeStringList(@NotNull List<String> list) {
    return list.stream()
      .map(ComponentUtil::formatToComponent)
      .collect(Collectors.toCollection(() -> new ArrayList<>(list.size())));
  }
}
