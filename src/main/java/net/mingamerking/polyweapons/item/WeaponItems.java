package net.mingamerking.polyweapons.item;

import com.jamieswhiteshirt.reachentityattributes.ReachEntityAttributes;
import eu.pb4.polymer.core.api.item.PolymerItemGroupUtils;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.util.Identifier;
import net.mingamerking.polyweapons.polymer.PolymerTextures;

import java.util.ArrayList;
import java.util.List;

import static net.mingamerking.polyweapons.PolyWeapons.MOD_ID;
import static net.mingamerking.polyweapons.PolyWeapons.id;

public class WeaponItems {

    public static final TextColor BLACK = getTextColor("#ffffff");
    public static final List<Item> items = new ArrayList<>() {};
    public static final Item WOOD_SPEAR = registerItem("wooden_spear", new SpearItem(new Item.Settings(), 4, Items.WOODEN_SWORD));
    public static final Item STONE_SPEAR = registerItem("stone_spear", new SpearItem(new Item.Settings(), 5, Items.STONE_SWORD));
    public static final Item IRON_SPEAR = registerItem("iron_spear", new SpearItem(new Item.Settings(), 6, Items.IRON_SWORD));
    public static final Item GOLD_SPEAR = registerItem("golden_spear", new SpearItem(new Item.Settings(), 4, Items.GOLDEN_SWORD));
    public static final Item DIAMOND_SPEAR = registerItem("diamond_spear", new SpearItem(new Item.Settings(), 7, Items.DIAMOND_SWORD));
    public static final Item NETHERITE_SPEAR = registerItem("netherite_spear", new SpearItem(new Item.Settings(), 8, Items.NETHERITE_SWORD));
    public static final Item LIFESTEAL_SWORD = registerItem("lifesteal_sword", new LifeStealSword(new Item.Settings(), Items.DIAMOND_SWORD));
    public static final ItemGroup ITEM_GROUP = ItemGroup.create(null, -1)
            .displayName(Text.translatable("item.polyweapons.group_title"))
            .icon(IRON_SPEAR::getDefaultStack)

            .entries((context, entries) -> items.forEach(entries::add))
            .build();

    public static void register() {
        PolymerItemGroupUtils.registerPolymerItemGroup(id("item"), ITEM_GROUP);
    }

    private static <T extends Item> T registerItem(String path, T block) {
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, path), block);
        PolymerTextures.requestModel(new Identifier(MOD_ID, "item/" + path), block);
        items.add(block);
        return block;
    }

    private static TextColor getTextColor(String name) {
        return TextColor.parse(name);
    }
}
