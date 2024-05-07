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
    public static final List<Item> spears = new ArrayList<>() {};
    public static final Item STONE_SPEAR = registerItem("stone_spear", new SpearItem(new Item.Settings()
            .maxCount(1)
            .maxDamage(5)));
    public static final ItemGroup ITEM_GROUP = ItemGroup.create(null, -1)
            .displayName(Text.translatable("item.polyweapons.group_title"))
            .icon(Items.IRON_SWORD::getDefaultStack)

            .entries((context, entries) -> spears.forEach(entries::add))
            .build();

    public static void register() {
        PolymerItemGroupUtils.registerPolymerItemGroup(id("item"), ITEM_GROUP);
    }

    private static <T extends Item> T registerItem(String path, T block) {
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, path), block);
        PolymerTextures.requestModel(new Identifier(MOD_ID, "item/" + path), block);
        spears.add(block);
        return block;
    }

    private static TextColor getTextColor(String name) {
        return TextColor.parse(name);
    }
}
