package k.tp.executors;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;

public class BlackSmoke extends BaseCE {

	@Override
	void preTeleport(Player sp, Location strike1, Location strike2, boolean p2p) {
		Location[] locs = randomize(strike1, 10);
		for (Location l : locs) {
			sp.getWorld().playEffect(l, Effect.SMOKE, BlockFace.UP);
		}
	}

	@Override
	void postTeleport(Player sp, String teleString, Location strike1,
			Location strike2, boolean p2p, boolean didTele) {
		if (didTele) {
			Location[] locs = randomize(strike2, 10);
			for (Location l : locs) {
				sp.getWorld().playEffect(l, Effect.SMOKE, BlockFace.UP);
			}
			sp.sendMessage("Teleported you to " + teleString + " with smoke!");
		}
	}

	private Location[] randomize(Location l, int times) {
		double[] orig = new double[] { l.getX(), l.getY(), l.getZ() };
		double[][] random = new double[times][3];
		Location[] out = new Location[times];
		for (int i = 0; i < random.length; i++) {
			for (int j = 0; j < random[0].length; j++) {
				random[i][j] = orig[j]
						+ (Math.random() > 0.5 ? -Math.random() : Math.random());
			}
			out[i] = new Location(l.getWorld(), random[i][0], random[i][1],
					random[i][2], l.getYaw(), l.getPitch());
		}
		return out;
	}
}
