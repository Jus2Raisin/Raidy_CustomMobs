package fr.raidy.commands;

import fr.raidy.RaidyPlugin;
import fr.raidy.enums.CustomMobs;
import fr.raidy.listeners.EntitySpawnListener;
import fr.raidy.utils.CustomMobsUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wolf;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class CMCommands implements CommandExecutor {

    private RaidyPlugin raidyPlugin;

    public CMCommands(RaidyPlugin raidyPlugin) { this.raidyPlugin = raidyPlugin;}

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        final Player player = (Player)commandSender;

        if(strings.length == 0)
        {
            player.sendMessage("§7[§6§lCustomMobs§7] §cMauvais syntaxe, §6'/customMobs help' §cpour plus d'aides.");
            return false;
        }

        else if(strings.length == 1)
        {
            if(strings[0].equalsIgnoreCase("help"))
            {
                player.sendMessage("§7§m-------------------------§r");
                player.sendMessage("§7Plugin created by §dJus2§5Raisin §7version §a1.0.0");
                player.sendMessage(" ");
                player.sendMessage("§6§l> §e/custommobs spawn <voleur/skeleton/wolf>");
                player.sendMessage("§f- §7Apparition d'un nouveau mob.");
                player.sendMessage(" ");
                player.sendMessage("§6§l> §e/custommobs despawn");
                player.sendMessage("§f- §7Disparition de toutes les créatures modifiées.");
                player.sendMessage("§7§m-------------------------§r");
                return true;
            }

            else if(strings[0].equalsIgnoreCase("despawn"))
            {
                player.sendMessage("§7[§6§lCustomMobs§7] §cVous avez tuée toutes les créatures modifiées.");


                Bukkit.broadcastMessage(CustomMobs.LoupGarou.getName());

                for(Entity entities : player.getWorld().getEntities())
                {
                    if(entities.getCustomName() != null)
                    {
                        if(entities.getCustomName().equalsIgnoreCase(CustomMobs.LoupGarou.getName()) || (entities.getCustomName().equalsIgnoreCase(CustomMobs.ZombieVoleur.getName())) || (entities.getCustomName().equalsIgnoreCase(CustomMobs.Squelette.getName())))
                        {
                            entities.remove();
                        }
                    }
                }

                return true;

            }

            else
            {
                player.sendMessage("§7[§6§lCustomMobs§7] §cMauvais syntaxe, §6'/customMobs help' §cpour plus d'aides.");
                return false;
            }
        }


        else if(strings.length == 2)
        {
            if(strings[0].equalsIgnoreCase("spawn"))
            {
                if(strings[1].equalsIgnoreCase("wolf"))
                {
                    player.sendMessage("§7[§6§lCustomMobs§7] §7Vous avez fait §aapparaître §7une créature modifiée.");
                    RaidyPlugin.customMobsUtils.spawnCustomMobs("wolf", player.getLocation());
                    return true;
                }

                else if(strings[1].equalsIgnoreCase("voleur"))
                {
                    player.sendMessage("§7[§6§lCustomMobs§7] §7Vous avez fait §aapparaître §7une créature modifiée.");
                    RaidyPlugin.customMobsUtils.spawnCustomMobs("voleur", player.getLocation());
                    return true;
                }
                else if(strings[1].equalsIgnoreCase("skeleton"))
                {
                    player.sendMessage("§7[§6§lCustomMobs§7] §7Vous avez fait §aapparaître §7une créature modifiée.");
                    RaidyPlugin.customMobsUtils.spawnCustomMobs("skeleton", player.getLocation());
                    return true;
                }
                else
                {
                    player.sendMessage("§7[§6§lCustomMobs§7] §cMauvais syntaxe, §6'/customMobs help' §cpour plus d'aides.");
                    return false;
                }

            }

            else
            {
                player.sendMessage("§7[§6§lCustomMobs§7] §cMauvais syntaxe, §6'/customMobs help' §cpour plus d'aides.");
                return false;
            }
        }

        return false;
    }
}
