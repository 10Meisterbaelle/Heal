package com.xmeisterbaelle.heal.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;

public class Heal implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length == 0) {
            if(sender instanceof Player) {
                Player player = (Player) sender;
                if(player.hasPermission("heal.self")) {
                    player.setHealth(20);
                    player.setFoodLevel(20);
                    player.sendMessage("§aYou were healed.");
                } else {
                    sender.sendMessage("§cYou don't have permission.");
                }
                return true;
            } else {
                sender.sendMessage("§cPlease specify a player.");
                return false;
            }
        } else if(args.length == 1) {
            if(sender.hasPermission("heal.others")) {
                Player target = Bukkit.getPlayer(args[0]);
                if(target != null) {
                    target.setHealth(20);
                    target.setFoodLevel(20);
                    sender.sendMessage("§a" + target.getName() + " §ahas been healed.");
                    target.sendMessage("§aYou were healed.");
                } else {
                    sender.sendMessage("§cThis player is not online or doesn't exist.");
                }
            } else {
                sender.sendMessage("§cYou don't have permission.");
            }
            return true;
        } else {
            sender.sendMessage("§cIncorrect usage!");
            return false;
        }
    }
}
