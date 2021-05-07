package fr.raidy.listeners;

import fr.raidy.RaidyPlugin;
import fr.raidy.enums.CustomMobs;
import fr.raidy.managers.RaidyManager;
import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import javax.swing.text.html.parser.Entity;
import java.util.Random;

public class EntityDeathListener implements Listener {

    private RaidyPlugin raidyPlugin;
    private RaidyManager raidyManager;

    public EntityDeathListener(RaidyPlugin raidyPlugin) { this.raidyPlugin = raidyPlugin; this.raidyManager = raidyPlugin.getRaidyManager(); }

    @EventHandler(priority = EventPriority.HIGH)
    public void onEntityDeath(EntityDeathEvent event)
    {
        LivingEntity entity = event.getEntity();
        String name = entity.getCustomName();
        Player attacker = (Player) event.getEntity().getKiller();
        Random random = new Random();

        if(name != null && (attacker != null))
        {
            if(name.equalsIgnoreCase(CustomMobs.LoupGarou.getName()))
            {
                event.getDrops().add(new ItemStack(Material.BONE, random.nextInt(2)));
                event.getDrops().add(new ItemStack(Material.ROTTEN_FLESH, random.nextInt(3)));
            }
            else if(name.equalsIgnoreCase(CustomMobs.ZombieVoleur.getName()))
            {
                if(raidyPlugin.getRaidyManager().zVoleur.containsKey(attacker.getUniqueId()))
                {
                    ((Zombie) entity).getEquipment().setItemInMainHand(new ItemStack(Material.LEAD));

                    attacker.getInventory().addItem(raidyPlugin.getRaidyManager().zVoleur.get(attacker.getUniqueId()));
                    raidyPlugin.getRaidyManager().zVoleur.remove(attacker.getUniqueId());
                }

            }

        }


    }


}
