/*
 * Copyright (c) Refrac
 * If you have any questions please email refracplaysmc@gmail.com or reach me on Discord
 */
package me.refrac.simplestaffchat.spigot.utilities.chat;

import me.refrac.simplestaffchat.spigot.utilities.Files;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Placeholders {

    public static String setPlaceholders(Player player, String placeholder) {
        placeholder = placeholder.replace("%prefix%", Files.getConfig().getString("messages.prefix"));
        placeholder = placeholder.replace("%player%", player.getName());
        placeholder = placeholder.replace("%displayname%", ChatColor.stripColor(player.getDisplayName()));

        return Color.translate(placeholder);
    }
}