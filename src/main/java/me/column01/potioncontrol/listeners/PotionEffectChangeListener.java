package me.column01.potioncontrol.listeners;

import me.column01.potioncontrol.PotionControl;
import org.slf4j.Logger;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.event.EventListener;
import org.spongepowered.api.event.entity.ChangeEntityPotionEffectEvent;
import org.spongepowered.plugin.meta.util.NonnullByDefault;

public class PotionEffectChangeListener implements EventListener<ChangeEntityPotionEffectEvent.Gain> {
    @NonnullByDefault
    @Override
    public void handle(ChangeEntityPotionEffectEvent.Gain event) {
        Logger logger = PotionControl.instance.getLogger();
        Entity target = event.getTargetEntity();
        logger.info(target.toString() + " recieved a potion effect: " + event.getPotionEffect().getType().getName());
    }
}
