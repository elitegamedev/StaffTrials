package com.officiallom.StaffTrials;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		getLogger().info("Developed by EliteGameDev");
		saveDefaultConfig();
	}
	
	@Override
	public void onDisable() {
		getLogger().info("Developed by EliteGameDev");
		saveDefaultConfig();
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		Player player = (Player) sender;
		if (sender instanceof Player) {
			if (player.hasPermission("st.use")) {
				if (label.equalsIgnoreCase("st")) {
					if (args.length == 0) {
						player.sendMessage(ChatColor.RED + "Usage: /st [list] <add <player> [rank]>");
					} else if(args.length == 1) {
						if (args[0].equalsIgnoreCase("list")) {
							List<String> st = getConfig().getStringList("stafftrials");
							List<String> str = getConfig().getStringList("stafftrialswithranks");
							player.sendMessage(ChatColor.RED + "" + st + str);
						}
						player.sendMessage(ChatColor.RED + "Usage: /st [list] <add <player> [rank]>");
					} else if(args.length == 2) {
						if (args[0].equalsIgnoreCase("add")) {
							List<String> st = getConfig().getStringList("stafftrials");
							st.add(args[1]);
							getConfig().set("stafftrials", st);
							saveConfig();
						} else {
							player.sendMessage(ChatColor.RED + "Usage: /st [list] <add <player> [rank]>");
						}
					} else if(args.length == 3) {
						if (args[0].equalsIgnoreCase("add")) {
							List<String> str = getConfig().getStringList("stafftrailswithranks");
							str.add(args[1] + args[2]);
							getConfig().set("stafftrialswithranks", str);
							saveConfig();
						} else {
							player.sendMessage(ChatColor.RED + "Usage: /st [list] <add <player> [rank]>");
						}
					} else {
						player.sendMessage(ChatColor.RED + "Usage: /st [list] <add <player> [rank]>");
					}
				}
			}
		}
		return true;
	}
	
}
