package k.tp.executors;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Lightning extends BaseCE {

	@Override
	void preTeleport(Player sp, Location strike1, Location strike2, boolean p2p) {
		strike1.getWorld().strikeLightningEffect(strike1);
	}

	@Override
	void postTeleport(Player sp, String teleString, Location strike1,
			Location strike2, boolean p2p, boolean didTele) {
		if (didTele) {
			strike2.getWorld().strikeLightningEffect(strike2);
			sp.sendMessage("Teleported you to " + teleString
					+ " with lightning!");
		}
	}
}
