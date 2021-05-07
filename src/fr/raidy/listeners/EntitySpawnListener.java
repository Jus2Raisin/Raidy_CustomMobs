package fr.raidy.listeners;

import fr.raidy.RaidyPlugin;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;

import java.util.Random;

public class EntitySpawnListener implements Listener {

    private RaidyPlugin raidyPlugin;

    public EntitySpawnListener(RaidyPlugin raidyPlugin)
    {
        this.raidyPlugin = raidyPlugin;
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onEntitySpawn(EntitySpawnEvent event)
    {
        Entity entity = event.getEntity();
        Location loc = entity.getLocation();

        /*if(entity instanceof Wolf)
        {
            if(getChance(80))
            {
                event.setCancelled(true);
                RaidyPlugin.customMobsUtils.spawnCustomMobs("wolf", loc);

            }
        }*/
        if(entity instanceof Zombie)
        {
            if(getChance(80))
            {
                event.setCancelled(true);
                RaidyPlugin.customMobsUtils.spawnCustomMobs("voleur", loc);

            }
        }
        else if(entity instanceof Skeleton)
        {
            if(getChance(90))
            {
                event.setCancelled(true);
                RaidyPlugin.customMobsUtils.spawnCustomMobs("skeleton", loc);

            }
        }



    }

    @EventHandler
    public void onInteract(PlayerInteractAtEntityEvent event)
    {
        Entity entity = event.getRightClicked();
        Player player = event.getPlayer();

        if(entity instanceof Piglin && player.getWorld().equals(Bukkit.getWorld("world_nether")))
        {
          event.setCancelled(true);
        }

    }



    private boolean getChance(int minimalChance) {
        Random random = new Random();
        return random.nextInt(99) + 1 >= minimalChance;
    }



}
