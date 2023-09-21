package io.github.thepoultryman.cookingwportals;

import io.github.thepoultryman.cookingwportals.registry.ItemRegistry;
import net.fabricmc.api.ModInitializer;

public class CookingWithPortals implements ModInitializer {
    public static final String MOD_ID = "cookingwportals";

    @java.lang.Override
    public void onInitialize() {
        ItemRegistry.registerItems();
    }
}
