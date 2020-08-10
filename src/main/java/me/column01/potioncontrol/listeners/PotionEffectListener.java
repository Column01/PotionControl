package me.column01.potioncontrol.listeners;

import me.column01.potioncontrol.PotionControl;
import org.slf4j.Logger;
import org.spongepowered.api.effect.potion.PotionEffect;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.Order;
import org.spongepowered.api.event.entity.ChangeEntityPotionEffectEvent;
import org.spongepowered.api.text.Text;

public class PotionEffectListener  {
    @Listener(order = Order.EARLY)
    public void potionEffectChange(ChangeEntityPotionEffectEvent event) {
        Logger logger = PotionControl.instance.getLogger();
        logger.warn("RECEIVED EVENT");
        Entity target = event.getTargetEntity();
        logger.info("Potion effect event for: " + target.toString());
        if(target instanceof Player) {
            Player player = (Player) target;
            PotionEffect effect = event.getPotionEffect();
            logger.info("Effect Type: " + effect.getType());
            logger.info("toString: " + effect.toString());
            logger.info("Name and ID: " + effect.getType().getName() + ", " + effect.getType().getId());
            player.sendMessage(Text.builder("Effect received: " + effect.toString()).build());
        }
    }

    @Listener
    public void potionEffectGain(ChangeEntityPotionEffectEvent.Gain event) {
        Logger logger = PotionControl.instance.getLogger();
        Entity target = event.getTargetEntity();
        logger.info(target.toString() + " gained effect: " + event.getPotionEffect().getType());
    }
}

