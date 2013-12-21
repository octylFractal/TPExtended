package k.tp;

import org.bukkit.plugin.java.JavaPlugin;

public class TPExtended extends JavaPlugin {
	private static String logString = "TPExtended vUnknown";
	public static TPExtended me = null;

	@Override
	public void onDisable() {
		getLogger().info(logString + " disabled.");
	}

	@Override
	public void onEnable() {
		logString = getName() + " v" + getDescription().getVersion();
		me = this;
		enableAllTeleporters();
		getLogger().info(logString + " enabled.");
	}

	private void enableAllTeleporters() {
		for (TeleportType tt : TeleportType.values()) {
			try {
				enableTeleporter(tt);
				getLogger().info("Added " + tt.name);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void enableTeleporter(TeleportType type) {
		try {
			getServer().getPluginCommand(type.cmd).setExecutor(type.executor());
		} catch (Exception e) {
			throw new RuntimeException("Error creating TeleportType "
					+ type.name, e);
		}
	}

}
