package k.tp.executors;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;

public class BaseCE implements CommandExecutor {

	@Override
	public final boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		int alen = args.length;
		Location strike1 = null;
		Location strike2 = null;
		boolean didTele = false;
		Player sp = null, sp2 = null;
		if (sender instanceof Player && alen == 1) {
			sp = (Player) sender;
			sp2 = getPlayer(args[0], sender);
			if (sp2 == null) {
				return true;
			}
		} else if (sender instanceof Player && alen == 3) {
			sp = (Player) sender;
			try {
				strike2 = new Location(sp.getWorld(),
						Integer.parseInt(args[0]), Integer.parseInt(args[1]),
						Integer.parseInt(args[2]));
			} catch (NumberFormatException e) {
				sp.sendMessage("You need to provide integers for coord teleports!");
				return false;
			}
		} else if (alen == 2) {
			sp = getPlayer(args[0], sender);
			if (sp == null) {
				return true;
			}
			sp2 = getPlayer(args[1], sender);
			if (sp2 == null) {
				return true;
			}
		} else if (alen == 4) {
			sp = getPlayer(args[0], sender);
			if (sp == null) {
				return true;
			}
			try {
				strike2 = new Location(sp.getWorld(),
						Integer.parseInt(args[0]), Integer.parseInt(args[1]),
						Integer.parseInt(args[2]));
			} catch (NumberFormatException e) {
				sp.sendMessage("You need to provide integers for coord teleports!");
				return false;
			}
		} else {
			return false;
		}
		if (sp2 == null && strike2 == null) {
			sender.sendMessage("You must provide a location or player!");
			return false;
		}
		if (sp2 != null && strike2 == null) {
			strike2 = sp2.getLocation();
		}
		if (sp != null && strike2 != null) {
			strike1 = sp.getLocation();
			preTeleport(sp, strike1, strike2, sp2 != null);
			didTele = sp.teleport(strike2, TeleportCause.COMMAND);
			postTeleport(
					sp,
					sp2 == null ? strike2.getBlockX() + " "
							+ strike2.getBlockY() + " " + strike2.getBlockZ()
							: sp2.getDisplayName(), strike1, strike2,
					sp2 != null, didTele);
			return true;
		}
		return false;
	}

	public static Player getPlayer(String string, CommandSender s) {
		Player sp = s.getServer().getPlayer(string);
		if (sp == null) {
			s.sendMessage("Couldn't find a player with the name '" + string
					+ "'");
		}
		return sp;
	}

	void preTeleport(Player sp, Location strike1, Location strike2, boolean p2p) {

	}

	void postTeleport(Player sp, String teleString, Location strike1,
			Location strike2, boolean p2p, boolean didTele) {

	}
}
