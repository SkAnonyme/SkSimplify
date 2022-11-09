package main.java.fr.devanonyme.sksimplify.commands;

import ch.njol.skript.Skript;
import main.java.fr.devanonyme.sksimplify.SkSimplify;
import main.java.fr.devanonyme.sksimplify.messages.LangFR;
import main.java.fr.devanonyme.sksimplify.method.SkriptMethod;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class SkSimplifyCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)) {
            Bukkit.getConsoleSender().sendMessage(LangFR.console_msg.getM());
            return false;
        }

        Player player = (Player) sender;

        if(player.hasPermission("sksimplify.use")) {
            SkriptMethod skmethod = new SkriptMethod(player);

            if(args.length == 0) {
                String plName = SkSimplify.getInstance().getDescription().getName();
                String plVer = SkSimplify.getInstance().getDescription().getVersion();
                List<String> plAut = SkSimplify.getInstance().getDescription().getAuthors();

                player.sendMessage(" ");
                player.sendMessage("§a" + plName + "§f, §a" + plVer + "§f, §a" + plAut);
                player.sendMessage(LangFR.help_message.getM());
                player.sendMessage(" ");
                return false;
            }

            if(args.length >= 1) {
                if (args[0].equalsIgnoreCase("help")) {
                    player.sendMessage("");
                    player.sendMessage(LangFR.help_1.getM());
                    player.sendMessage(LangFR.help_2.getM());
                    player.sendMessage(LangFR.help_3.getM());
                    player.sendMessage("");
                    return false;
                }

                String skriptName = args[1];

                if (args[0].equalsIgnoreCase("add")) {
                    if (skriptName != null) {
                        skmethod.add(skriptName);
                        return false;
                    }
                }
                if (args[0].equalsIgnoreCase("remove")) {
                    if (skriptName != null) {
                        skmethod.remove(skriptName);
                        return false;
                    }
                }
                if (args[0].equalsIgnoreCase("book")) {
                    if (skriptName != null) {
                        skmethod.book(skriptName);
                        return false;
                    }
                }

                if ((!args[0].equalsIgnoreCase("help")) || (!args[0].equalsIgnoreCase("add")) || (!args[0].equalsIgnoreCase("remove")) || (!args[0].equalsIgnoreCase("book"))) {
                    player.sendMessage("");
                    player.sendMessage(LangFR.help_1.getM());
                    player.sendMessage(LangFR.help_2.getM());
                    player.sendMessage(LangFR.help_3.getM());
                    player.sendMessage("");
                    return false;
                }
            }
        } else {
            player.sendMessage(LangFR.no_permission.getM());
        }

        return false;
    }
}
