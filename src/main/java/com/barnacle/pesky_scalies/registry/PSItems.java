package com.barnacle.pesky_scalies.registry;

import com.barnacle.pesky_scalies.PeskyScalies;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class PSItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PeskyScalies.MOD_ID);

    public static final DeferredItem<Item> GRIDSECT = ITEMS.register("gridsect",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> ICON = ITEMS.register("icon",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> GRIDSECT_SPAWN_EGG = ITEMS.register("gridsect_spawn_egg",
            () -> new DeferredSpawnEggItem(PSEntities.GRIDSECT, 0x4f4f4f, 0x0e0e0e,
                    new Item.Properties()));

    public static final DeferredItem<Item> SHAME_CREST_SPAWN_EGG = ITEMS.register("shame_crest_spawn_egg",
            () -> new DeferredSpawnEggItem(PSEntities.SHAME_CREST, 0x501910, 0x8f7515,
                    new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
