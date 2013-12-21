package k.tp.executors;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;

public class BlackSmoke extends BaseCE {

	@Override
	void preTeleport(Player sp, Location strike1, Location strike2, boolean p2p) {
		sp.getWorld().playEffect(strike1, Effect.SMOKE, BlockFace.UP);
		sp.getWorld().playEffect(strike1, Effect.SMOKE, BlockFace.UP);
		sp.getWorld().playEffect(strike1, Effect.SMOKE, BlockFace.UP);
		sp.getWorld().playEffect(strike1, Effect.SMOKE, BlockFace.UP);
		sp.getWorld().playEffect(strike1, Effect.SMOKE, BlockFace.UP);
	}

	@Override
	void postTeleport(Player sp, String teleString, Location strike1,
			Location strike2, boolean p2p, boolean didTele) {
		if (didTele) {
			sp.getWorld().playEffect(strike2, Effect.SMOKE, BlockFace.UP);
			sp.getWorld().playEffect(strike1, Effect.SMOKE, BlockFace.UP);
			sp.getWorld().playEffect(strike1, Effect.SMOKE, BlockFace.UP);
			sp.getWorld().playEffect(strike1, Effect.SMOKE, BlockFace.UP);
			sp.getWorld().playEffect(strike1, Effect.SMOKE, BlockFace.UP);
			sp.sendMessage("Teleported you to " + teleString + " with smoke!");
		}
	}

}
