package pl.macylion.rpgplugin;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.world.ChunkLoadEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

public class ChunkLoad implements Listener{
	@EventHandler
	public void onChunkLoad(ChunkLoadEvent e) {
		
		//Location loc = new Location(e.getWorld(), e.getChunk().getX(), 100, e.getChunk().getZ());
		//LivingEntity entity = (LivingEntity) e.getWorld().spawnEntity(loc, EntityType.SHEEP);
		//entity.setGlowing(true);
		//entity.setCustomName("dupa");
		//System.out.println(entity.getLocation().getX() + " : " + entity.getLocation().getY() + " : " + entity.getLocation().getZ());
	}
	
	@EventHandler
	public void onEntitySpawn(EntitySpawnEvent e) {
		if(e.getEntityType() == EntityType.ZOMBIE) {
			Zombie z = (Zombie) e.getEntity();
			e.getEntity().setCustomName("Knight");
			e.getEntity().setGlowing(true);
			z.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 6000, 4));
		}
	}
}
