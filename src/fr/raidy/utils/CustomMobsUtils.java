package fr.raidy.utils;

import fr.raidy.enums.CustomMobs;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.Random;

public class CustomMobsUtils
{

    private boolean wolf = false;
    public void spawnCustomMobs(String name, Location loc)
    {
        Random r = new Random();
        if(name.equalsIgnoreCase("wolf") && !wolf)
        {
            wolf = true;
            Wolf w = (Wolf) loc.getWorld().spawnEntity(loc, EntityType.WOLF);
            w.setAI(true);
            w.setAngry(true);
            w.setCustomNameVisible(false);
            w.setCustomName(CustomMobs.LoupGarou.getName());
            w.setHealth(w.getMaxHealth());
            w.setAdult();

            Wolf w1 = (Wolf) loc.getWorld().spawnEntity(loc, EntityType.WOLF);
            w1.setAI(true);
            w1.setAngry(true);
            w1.setCustomNameVisible(false);
            w1.setCustomName(CustomMobs.LoupGarou.getName());
            w1.setHealth(w.getMaxHealth());
            w1.setAdult();

            Wolf w2 = (Wolf) loc.getWorld().spawnEntity(loc, EntityType.WOLF);
            w2.setAI(true);
            w2.setAngry(true);
            w2.setCustomNameVisible(false);
            w2.setCustomName(CustomMobs.LoupGarou.getName());
            w2.setHealth(w.getMaxHealth());
            w2.setAdult();

            Wolf w3 = (Wolf) loc.getWorld().spawnEntity(loc, EntityType.WOLF);
            w3.setAI(true);
            w3.setAngry(true);
            w3.setCustomNameVisible(false);
            w3.setCustomName(CustomMobs.LoupGarou.getName());
            w3.setHealth(w.getMaxHealth());
            w3.setAdult();
            wolf = false;


        }
        else if(name.equalsIgnoreCase("voleur"))
        {
            Zombie z = (Zombie) loc.getWorld().spawnEntity(loc, EntityType.ZOMBIE);
            z.setCustomNameVisible(false);
            z.setCustomName(CustomMobs.ZombieVoleur.getName());
            z.setHealth(10.0);
            z.setAdult();
            z.setAI(true);
            z.getEquipment().setItemInMainHand(new ItemStack(Material.LEAD));
            z.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999, 1));
        }
        else if(name.equalsIgnoreCase("skeleton"))
        {
            Skeleton s = (Skeleton) loc.getWorld().spawnEntity(loc, EntityType.SKELETON);
            {
                s.setCustomNameVisible(false);
                s.setCustomName(CustomMobs.Squelette.getName());
                s.setAI(true);
                s.setHealth(s.getMaxHealth());
                s.getEquipment().setHelmet(new ItemStack(Material.GOLDEN_HELMET));
                s.getEquipment().setHelmetDropChance(1.0f);
                s.getEquipment().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
                s.getEquipment().setLeggingsDropChance(1.0f);
                s.getEquipment().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
                s.getEquipment().setChestplateDropChance(1.0f);
                s.getEquipment().setBoots(new ItemStack(Material.LEATHER_BOOTS));
                s.getEquipment().setBootsDropChance(1.0f);
                s.getEquipment().setItemInMainHand(new ItemBuilder(Material.BOW).addEnchant(Enchantment.ARROW_DAMAGE, 1).addEnchant(Enchantment.ARROW_KNOCKBACK, 1).build());
                s.getEquipment().setItemInMainHandDropChance(1.0f);
            }
        }

    }

    public static ItemStack itemss = new ItemStack(Material.AIR);


    public ItemStack getRandomItem(ItemStack[] content) {
        Random r = new Random();
        ArrayList<ItemStack> items = new ArrayList<ItemStack>();

        for (ItemStack item : content) {
            if (item != null)
                items.add(item);

        }
        if(items.size() == 0) { return itemss; }
        else {
            return items.get(r.nextInt(items.size()));
        }

    }



}
