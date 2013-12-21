package k.tp;

import org.bukkit.command.CommandExecutor;

public enum TeleportType {
	LIGHTNING("tpl", k.tp.executors.Lightning.class, "Lightning Teleport"), EXPLOSION(
			"tpe", k.tp.executors.Explosion.class, "Explosion Teleport"), BLACKSMOKE(
			"tps", k.tp.executors.BlackSmoke.class, "Black Smoke Teleport");

	public String cmd = "tpdef", name = "Default Teleport";
	private Class<? extends CommandExecutor> exe = TPExtended.class;

	private TeleportType(String command,
			Class<? extends CommandExecutor> executor, String ufn) {
		cmd = command;
		name = ufn;
		exe = executor;
	}

	public CommandExecutor executor() {
		try {
			return exe.newInstance();
		} catch (Exception e) {
		}
		TPExtended.me.getLogger().warning(
				"Using plugin as command executor for TeleportType " + name);
		return TPExtended.me;
	}
}
