package fr.raidy.listeners;

import fr.raidy.RaidyPlugin;
import fr.raidy.enums.CustomMobs;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.*;

import static org.bukkit.Bukkit.getServer;

public class WorldListener implements Listener {

    private RaidyPlugin raidyPlugin;

    public WorldListener(RaidyPlugin raidyPlugin) { this.raidyPlugin = raidyPlugin;
    }

    @EventHandler
    public void onEntity(EntityInteractEvent event)
    {
        if(day(event.getEntity().getWorld()))
        {
            for(Entity entities : event.getEntity().getWorld().getEntities())
            {
                if(entities.getCustomName() != null)
                {
                    if(entities.getCustomName().equalsIgnoreCase(CustomMobs.LoupGarou.getName()) || (entities.getCustomName().equalsIgnoreCase(CustomMobs.ZombieVoleur.getName())) || (entities.getCustomName().equalsIgnoreCase(CustomMobs.Squelette.getName())))
                    {
                        entities.setFireTicks(1000);
                    }
                }
            }
        }
    }

    @EventHandler
    public void onEntity1(EntitySpawnEvent event)
    {
        if(day(event.getEntity().getWorld()))
        {
            for(Entity entities : event.getEntity().getWorld().getEntities())
            {
                if(entities.getCustomName() != null)
                {
                    if(entities.getCustomName().equalsIgnoreCase(CustomMobs.LoupGarou.getName()) || (entities.getCustomName().equalsIgnoreCase(CustomMobs.ZombieVoleur.getName())) || (entities.getCustomName().equalsIgnoreCase(CustomMobs.Squelette.getName())))
                    {
                        entities.setFireTicks(1000);
                    }
                }
            }
        }
    }

    @EventHandler
    public void onEntity2(EntityDamageEvent event)
    {
        if(day(event.getEntity().getWorld()))
        {
            for(Entity entities : event.getEntity().getWorld().getEntities())
            {
                if(entities.getCustomName() != null)
                {
                    if(entities.getCustomName().equalsIgnoreCase(CustomMobs.LoupGarou.getName()) || (entities.getCustomName().equalsIgnoreCase(CustomMobs.ZombieVoleur.getName())) || (entities.getCustomName().equalsIgnoreCase(CustomMobs.Squelette.getName())))
                    {
                        entities.setFireTicks(1000);
                    }
                }
            }
        }

    }

    @EventHandler
    public void onEntity3(EntityDeathEvent event)
    {
        if(day(event.getEntity().getWorld()))
        {
            for(Entity entities : event.getEntity().getWorld().getEntities())
            {
                if(entities.getCustomName() != null)
                {
                    if(entities.getCustomName().equalsIgnoreCase(CustomMobs.LoupGarou.getName()) || (entities.getCustomName().equalsIgnoreCase(CustomMobs.ZombieVoleur.getName())) || (entities.getCustomName().equalsIgnoreCase(CustomMobs.Squelette.getName())))
                    {
                        entities.setFireTicks(1000);
                    }
                }
            }
        }

    }


    private boolean day(World world) {
        return world.getTime() < 12300 || world.getTime() > 23850;
    }

}
