package net.rafael.usefulcactus;

import net.fabricmc.api.ModInitializer;
import net.rafael.usefulcactus.block.ModBlocks;
import net.rafael.usefulcactus.effect.ModEffects;
import net.rafael.usefulcactus.item.ModItemGroups;
import net.rafael.usefulcactus.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RafaelsUsefulCactus implements ModInitializer {
	public static final String MOD_ID = "rafaels-useful-cactus";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModEffects.registerEffects();

		LOGGER.info("Initializing " + MOD_ID);
	}
}