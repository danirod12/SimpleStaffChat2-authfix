/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2022 RefracDevelopment
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
 * PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE
 * FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package me.refracdevelopment.simplestaffchat.bungee.utilities.chat;

import me.refracdevelopment.simplestaffchat.bungee.BungeeStaffChat;
import me.refracdevelopment.simplestaffchat.bungee.utilities.LuckPermsUtil;
import me.refracdevelopment.simplestaffchat.bungee.config.Config;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class Placeholders {

    public static String setPlaceholders(CommandSender sender, String placeholder) {
        placeholder = placeholder.replace("%prefix%", Config.MESSAGES_PREFIX.toString());
        if (sender instanceof ProxiedPlayer) {
            ProxiedPlayer player = (ProxiedPlayer) sender;

            if (ProxyServer.getInstance().getPluginManager().getPlugin("LuckPerms") != null) {
                placeholder = placeholder.replace("%luckperms_prefix%", LuckPermsUtil.getPrefix(player));
                placeholder = placeholder.replace("%luckperms_suffix%", LuckPermsUtil.getSuffix(player));
            } else {
                placeholder = placeholder.replace("%luckperms_prefix%", "N/A");
                placeholder = placeholder.replace("%luckperms_suffix%", "N/A");
            }

            placeholder = placeholder.replace("%player%", player.getName());
            placeholder = placeholder.replace("%displayname%", player.getDisplayName());
        }
        placeholder = placeholder.replace("%arrow%", "\u00BB");
        placeholder = placeholder.replace("%arrow2%", "\u27A5");
        placeholder = placeholder.replace("%arrow_2%", "\u27A5");
        placeholder = placeholder.replace("%star%", "\u2726");
        placeholder = placeholder.replace("%circle%", "\u2219");
        placeholder = placeholder.replace("|", "\u2503");

        return placeholder;
    }
}