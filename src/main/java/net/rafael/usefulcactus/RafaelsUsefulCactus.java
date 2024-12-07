package net.rafael.usefulcactus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.rafael.usefulcactus.block.ModBlocks;
import net.rafael.usefulcactus.effect.ModEffects;
import net.rafael.usefulcactus.item.ModItemGroups;
import net.rafael.usefulcactus.item.ModItems;
import net.rafael.usefulcactus.util.CactusHammerUsageEvent;

public class RafaelsUsefulCactus implements ModInitializer {
	public static final String MOD_ID = "rafaels-useful-cactus";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModEffects.registerEffects();
		ModItemGroups.registerItemGroups();


		PlayerBlockBreakEvents.BEFORE.register(new CactusHammerUsageEvent());

		LOGGER.info("Initializing " + MOD_ID);
	}
}