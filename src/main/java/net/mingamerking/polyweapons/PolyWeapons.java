package net.mingamerking.polyweapons;

import eu.pb4.polymer.core.impl.PolymerMod;
import eu.pb4.polymer.resourcepack.api.PolymerModelData;
import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils;
import eu.pb4.polymer.resourcepack.api.ResourcePackBuilder;
import eu.pb4.polymer.resourcepack.impl.PolymerResourcePackMod;
import net.fabricmc.api.ModInitializer;

import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.mingamerking.polyweapons.item.WeaponItems;
import net.mingamerking.polyweapons.polymer.PolymerTextures;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils.addModAssets;

public class PolyWeapons implements ModInitializer {
	public static final String MOD_ID = "polyweapons";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static Identifier id(String path) {
		return new Identifier(MOD_ID, path);
	}

	@Override
	public void onInitialize() {
		WeaponItems.register();
		PolymerTextures.setup(MOD_ID);
	}
}