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
package me.refracdevelopment.simplestaffchat.bungee.commands;

import me.refracdevelopment.simplestaffchat.bungee.commands.admin.AdminToggleCommand;
import me.refracdevelopment.simplestaffchat.bungee.commands.dev.DevToggleCommand;
import me.refracdevelopment.simplestaffchat.bungee.utilities.chat.Color;
import me.refracdevelopment.simplestaffchat.bungee.config.Config;
import me.refracdevelopment.simplestaffchat.shared.Permissions;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ToggleCommand extends Command {
    public static List<UUID> insc = new ArrayList<>();

    public ToggleCommand() {
        super(Config.COMMANDS_TOGGLE_COMMAND.toString(), "", Config.COMMANDS_TOGGLE_ALIASES.toList().toArray(new String[0]));
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (!Config.COMMANDS_TOGGLE_ENABLED.toBoolean()) return;
        if (!(sender instanceof ProxiedPlayer)) return;

        ProxiedPlayer player = (ProxiedPlayer) sender;

        if (!player.hasPermission(Permissions.STAFFCHAT_TOGGLE)) {
            Color.sendMessage(player, Config.MESSAGES_NO_PERMISSION.toString(), true);
            return;
        }

        if (insc.contains(player.getUniqueId())) {
            insc.remove(player.getUniqueId());
            Color.sendMessage(player, Config.MESSAGES_TOGGLE_OFF.toString(), true);
        } else {
            if (AdminToggleCommand.inac.contains(player.getUniqueId()) || DevToggleCommand.indc.contains(player.getUniqueId())) {
                AdminToggleCommand.inac.remove(player.getUniqueId());
                DevToggleCommand.indc.remove(player.getUniqueId());
            }
            insc.add(player.getUniqueId());
            Color.sendMessage(player, Config.MESSAGES_TOGGLE_ON.toString(), true);
        }
    }
}