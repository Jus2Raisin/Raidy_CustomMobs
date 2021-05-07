package fr.raidy.listeners;

import fr.raidy.RaidyPlugin;
import fr.raidy.enums.CustomMobs;
import fr.raidy.managers.RaidyManager;
import fr.raidy.utils.CustomMobsUtils;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

public class EntityDamageListener implements Listener {

    private RaidyPlugin raidyPlugin;
    private RaidyManager raidyManager;


    public EntityDamageListener(RaidyPlugin raidyPlugin) { this.raidyPlugin = raidyPlugin; this.raidyManager = raidyPlugin.getRaidyManager(); }

    @EventHandler(priority = EventPriority.HIGH)
    public void onEntityDamage(EntityDamageByEntityEvent event)
    {
        Entity attacker = event.getDamager();
        Entity victim = event.getEntity();

        if(attacker instanceof Zombie && (victim instanceof Player))
        {
            victim = (Player) event.getEntity();
            attacker = (Zombie) event.getDamager();

            if(attacker.getCustomName().equalsIgnoreCase(CustomMobs.ZombieVoleur.getName()))
            {


                if(!(raidyPlugin.getRaidyManager().zVoleur.containsKey(victim.getUniqueId())) && (!(((Player) victim).getInventory().getItemInMainHand().equals(new ItemStack(Material.AIR)))))
                {

                        ItemStack item = RaidyPlugin.customMobsUtils.getRandomItem(((Player) victim).getInventory().getStorageContents());
                        if(!item.equals(CustomMobsUtils.itemss))
                        {
                            raidyPlugin.getRaidyManager().zVoleur.put(victim.getUniqueId(), item);
                            ((Player) victim).getInventory().removeItem(item);
                            ((Zombie) attacker).getEquipment().setItemInMainHand(item);
                            Timer chrono = new Timer();
                            Player finalVictim = (Player)victim;
                            Entity finalAttacker = attacker;
                            chrono.schedule(new TimerTask() {
                                int timer = 10;
                                @Override
                                public void run() {

                                    if( timer == 0 || (!raidyPlugin.getRaidyManager().zVoleur.containsKey(finalVictim.getUniqueId())))
                                    {
                                        this.cancel();
                                        ((Zombie) finalAttacker).getEquipment().setItemInMainHand(new ItemStack(Material.LEAD));
                                        if(raidyPlugin.getRaidyManager().zVoleur.containsKey(finalVictim.getUniqueId()))
                                        {
                                            raidyPlugin.getRaidyManager().zVoleur.remove(finalVictim.getUniqueId());
}
                                    }
                                    else if(timer > 0)
                                    {
                                        sendActionBar(finalVictim, "§6Temps Restant : §e"+timer+"seconde(s)");
                                        timer--;
                                    }

                                }
                            }, 0L, 1000L);
                        }




                }


            }

        }




    }

    public static void sendActionBar(Player finalVictim, String message)
    {
        finalVictim.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));
    }

}
