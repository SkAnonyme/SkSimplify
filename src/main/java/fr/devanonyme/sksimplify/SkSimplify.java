package main.java.fr.devanonyme.sksimplify;

import main.java.fr.devanonyme.sksimplify.commands.SkSimplifyCommand;
import main.java.fr.devanonyme.sksimplify.listener.PlayerListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class SkSimplify extends JavaPlugin {

    private static SkSimplify instance;

    @Override
    public void onEnable() {
        instance = this;

        getCommand("sksimplify").setExecutor(new SkSimplifyCommand());
        Bukkit.getPluginManager().registerEvents(new PlayerListener(), this);
    }

    @Override
    public void onDisable() {

    }

    public static SkSimplify getInstance() {
        return instance;
    }
}
