package tools.tgb.AntiEndermanGrief;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class AntiEndermanGrief extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getLogger().info("Anti Enderman Grief Enabled!");
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        getLogger().info("Anti Enderman Grief Disabled!");
    }

    @EventHandler
    public void onEntityChangeBlock(EntityChangeBlockEvent event) {
        if(event.getEntityType() == EntityType.ENDERMAN) {
            event.setCancelled(true);
        }
    }

}
