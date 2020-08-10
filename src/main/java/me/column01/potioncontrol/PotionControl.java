package me.column01.potioncontrol;

import com.google.inject.Inject;
import me.column01.potioncontrol.listeners.PotionEffectChangeListener;
import me.column01.potioncontrol.listeners.PotionEffectListener;
import ninja.leaping.configurate.commented.CommentedConfigurationNode;
import ninja.leaping.configurate.loader.ConfigurationLoader;
import ninja.leaping.configurate.objectmapping.ObjectMappingException;
import org.slf4j.Logger;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.config.DefaultConfig;
import org.spongepowered.api.event.EventListener;
import org.spongepowered.api.event.entity.ChangeEntityPotionEffectEvent;
import org.spongepowered.api.event.game.state.GamePreInitializationEvent;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.plugin.Plugin;

import java.io.IOException;

@Plugin(id="potioncontrol", name="PotionControl", description="Sponge plugin to disable potion effects", authors={"Column01"})
public class PotionControl {
    public static PotionControl instance;
//    @Inject
//    @DefaultConfig(sharedRoot = true)
//    private Path configPath;
//
//    @Inject
//    @DefaultConfig(sharedRoot = true)
//    private ConfigurationLoader<CommentedConfigurationNode> configLoader;
//
//    @Listener
//    public void preInit(GamePreInitializationEvent e) throws IOException, ObjectMappingException {
//        // setupConfig();
//    }
    @Inject
    private Logger logger;

    @Listener
    public void onServerStart(GameStartedServerEvent event) {
        logger.info("PotionControl is loading...");
        // Register the potion effect event handler
        Sponge.getEventManager().registerListeners(this, new PotionEffectListener());
        // Manual event listener
        EventListener<ChangeEntityPotionEffectEvent.Gain> listener = new PotionEffectChangeListener();
        Sponge.getEventManager().registerListener(this, ChangeEntityPotionEffectEvent.Gain.class, listener);
        logger.info("PotionControl loaded!");
    }

    public Logger getLogger() {
        return logger;
    }

//    private void setupConfig() throws IOException, ObjectMappingException {
////        if(Files.exists(this.configPath)) {
////            if(Sponge.getAssetManager().getAsset(this, "default.conf").isPresent()) {
////                Sponge.getAssetManager().getAsset(this, "default.conf").get().copyToFile(this.configPath);
////            }
////        }
////        ConfigurationNode rootNode = this.configLoader.load();
////
////    }
}
