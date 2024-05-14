package net.mingamerking.polyweapons;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.entity.event.v1.ServerEntityCombatEvents;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.mingamerking.polyweapons.item.LifeStealSword;
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