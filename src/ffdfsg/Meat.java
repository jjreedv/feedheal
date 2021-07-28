package ffdfsg;

import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.craftbukkit.Main;
import org.bukkit.entity.Player;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.EventHandler;


public class Meat extends JavaPlugin implements CommandExecutor {

    public void onEnable() {

    }

    public void onDisable() {

    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Players only BOSSMAN");
            return true;
        }
        Player p = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("heal")) {
            double maxHealth = p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getDefaultValue();
            p.setHealth(maxHealth);
            return true;
        }

        if (cmd.getName().equalsIgnoreCase("feed")) {
            p.setFoodLevel(20);
            return true;
        }
        if (cmd.getName().equalsIgnoreCase("launch")) {
            //  is /launch
            if (args.length == 0) {
                p.sendMessage(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "ZOOOOOOOM!");
                p.setVelocity(p.getLocation().getDirection().multiply(2).setY(2));
                return true;
            }

            //  is /launch <number>
            p.sendMessage(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "ZOOOOOOOM!");
            p.setVelocity(p.getLocation().getDirection().multiply(Integer.parseInt(args[0])).setY(2));
            return true;
        }
        return false;
    }
}