package io.github.thepoultryman.cookingwportals.registry;

import io.github.thepoultryman.cookingwportals.CookingWithPortals;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ItemRegistry {
    public static Item CAKE_PAN;
    private static final RegistryKey<ItemGroup> ITEM_GROUP = RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(CookingWithPortals.MOD_ID, "itemgroup.cookingwportals"));

    private static <T> T register(Item item, String name) {
        Registry.register(Registries.ITEM, new Identifier(CookingWithPortals.MOD_ID, name), item);
        ItemGroupEvents.modifyEntriesEvent(ITEM_GROUP).register(content -> content.addItem(item));
        return (T) item;
    }

    public static void registerItems() {
        Registry.register(Registries.ITEM_GROUP, ITEM_GROUP, FabricItemGroup.builder()
                .icon(() -> new ItemStack(CAKE_PAN))
                .name(Text.translatable("itemgroup.cookingwportals")).build());

        CAKE_PAN = register(new Item(new Item.Settings()), "cake_pan");
    }
}
