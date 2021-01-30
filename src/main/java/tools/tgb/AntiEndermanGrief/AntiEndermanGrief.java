package tools.tgb.AntiEndermanGrief;

import org.bstats.bukkit.Metrics;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class AntiEndermanGrief extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {


        Logger logger = this.getLogger();

        new UpdateChecker(this, 81788).getVersion(version -> {
            if (!this.getDescription().getVersion().equalsIgnoreCase(version)) {
                logger.info("§a----------------------------------------");
                logger.info("§aNew Version of AntiEndermanGrief available");
                logger.info("§a----------------------------------------");
            }
        });

        int pluginId = 10183;
        Metrics metrics = new Metrics(this, pluginId);

        getServer().getPluginManager().registerEvents(this, this);

        getLogger().info("AntiEndermanGrief Enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("AntiEndermanGrief Disabled!");
    }

    @EventHandler
    public void onEntityChangeBlock(EntityChangeBlockEvent event) {
        if(event.getEntityType() == EntityType.ENDERMAN) {
            event.setCancelled(true);
        }
    }

}
