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
        System.out.println("we in");
    }

    public void onDisable() {
        System.out.println("we out");
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
            p.sendMessage(ChatColor.RED + "I gotchu");
            return true;
        }

        if (cmd.getName().equalsIgnoreCase("feed")) {
            p.setFoodLevel(20);
            p.sendMessage(ChatColor.RED + "I gotchu");
            return true;
        }
        try {
            boolean launch = cmd.getName().equalsIgnoreCase("launch");
            if (launch) {
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
        } catch (Exception e) {
            p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "bruv, numbas only m8");
        }
        return false;
    }
}