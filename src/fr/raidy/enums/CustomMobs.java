package fr.raidy.enums;

import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;
import java.util.*;

public enum CustomMobs
{
    LoupGarou(20, "§cLoup Enragé", true),
    Squelette(10, "§dSquelette Magique", true),
    ZombieVoleur(15, "§6Zombie Voleur", true);

    private int spawn;
    private String name;
    private boolean nightfire;

    CustomMobs(int spawn, String name, boolean nightfire)
    {
       this.spawn = spawn;
       this.name = name;
       this.nightfire = nightfire;
    }

    public int getSpawn() {
        return spawn;
    }

    public String getName() {
        return name;
    }

    public boolean isNightfire() {
        return nightfire;
    }


}
