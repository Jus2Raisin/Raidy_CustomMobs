package fr.raidy.managers;

import fr.raidy.RaidyPlugin;
import fr.raidy.commands.CMCommands;
import fr.raidy.listeners.EntityDamageListener;
import fr.raidy.listeners.EntityDeathListener;
import fr.raidy.listeners.EntitySpawnListener;
import fr.raidy.listeners.WorldListener;
import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;

import java.util.HashMap;
import java.util.UUID;

public class RaidyManager {

    public HashMap<UUID, ItemStack> zVoleur = new HashMap<>();

    public RaidyManager(RaidyPlugin raidyPlugin)
    {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new EntitySpawnListener(raidyPlugin), raidyPlugin);
        pm.registerEvents(new EntityDeathListener(raidyPlugin), raidyPlugin);
        pm.registerEvents(new EntityDamageListener(raidyPlugin), raidyPlugin);
        pm.registerEvents(new WorldListener(raidyPlugin), raidyPlugin);
        raidyPlugin.getCommand("customMobs").setExecutor(new CMCommands(raidyPlugin));

    }
}
