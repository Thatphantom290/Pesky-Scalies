package com.barnacle.pesky_scalies.registry;

import com.barnacle.pesky_scalies.PeskyScalies;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;


public class PSItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PeskyScalies.MOD_ID);

    public static final DeferredItem<Item> GRIDSECT = ITEMS.register("gridsect",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
