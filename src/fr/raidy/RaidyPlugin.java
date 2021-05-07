package fr.raidy;

import fr.raidy.managers.RaidyManager;
import fr.raidy.utils.CustomMobsUtils;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class RaidyPlugin extends JavaPlugin
{
    private static RaidyPlugin instance;
    private RaidyManager raidyManager;
    public static CustomMobsUtils customMobsUtils = new CustomMobsUtils();

    @Override
    public void onEnable()
    {
        this.sendLog("§aPlugin has enabled.");
        this.raidyManager = new RaidyManager(this);
    }

    @Override
    public void onDisable()
    {
        this.sendLog("§cPlugin has disabled.");
    }

    public void sendLog(String message) { Bukkit.getConsoleSender().sendMessage("§6§l"+this.getDescription().getName()+"§e "+message); }

    public static RaidyPlugin getInstance() { return instance; }

    public RaidyManager getRaidyManager() { return raidyManager; }
}
