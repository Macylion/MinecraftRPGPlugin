package pl.macylion.rpgplugin;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.world.ChunkLoadEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class PlayerLoad implements Listener{
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		this.loadData(e.getPlayer());
	}
	
	@EventHandler
	public void onPlayerRespawn(PlayerRespawnEvent e) {
		this.loadData(e.getPlayer());
	}
	
	@SuppressWarnings("deprecation")
	private void loadData(Player player) {
		JavaPlugin plugin = Main.getPlugin(Main.class);
		//Points
		if(plugin.getConfig().get(player.getUniqueId() + ".points") == null)
			plugin.getConfig().set(player.getUniqueId() + ".points", 0);
		//Max Health Points
		if(plugin.getConfig().get(player.getUniqueId() + ".hp") == null)
				plugin.getConfig().set(player.getUniqueId() + ".hp" ,
						(int) plugin.getConfig().get("defaultHP"));
		player.getPlayer().setMaxHealth((int) plugin.getConfig().get(player.getUniqueId() + ".hp"));
		
		plugin.saveConfig();
	}
}
