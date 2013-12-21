package k.tp.executors;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Explosion extends BaseCE {

	@Override
	void preTeleport(Player sp, Location strike1, Location strike2, boolean p2p) {
		GameMode prev = sp.getGameMode();
		sp.setGameMode(GameMode.CREATIVE);
		sp.getWorld().createExplosion(strike1.getX(), strike1.getY(),
				strike1.getZ(), 4F, false, false);
		sp.setGameMode(prev);
	}

	@Override
	void postTeleport(Player sp, String teleString, Location strike1,
			Location strike2, boolean p2p, boolean didTele) {
		if (!didTele) {
			return;
		}
		GameMode prev = sp.getGameMode();
		sp.setGameMode(GameMode.CREATIVE);
		sp.getWorld().createExplosion(strike2.getX(), strike2.getY(),
				strike2.getZ(), 4F, false, false);
		sp.setGameMode(prev);
		sp.sendMessage("Teleported you to " + teleString
				+ " with an explosion!");
	}

}
