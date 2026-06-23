package com.barnacle.pesky_scalies.datagen;

import com.barnacle.pesky_scalies.registry.PSEntities;
import com.barnacle.pesky_scalies.registry.PSItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.EntityLootSubProvider;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.stream.Stream;

public class PSEntityLootTables extends EntityLootSubProvider {

    public PSEntityLootTables(HolderLookup.Provider provider) {
        super(FeatureFlags.REGISTRY.allFlags(), provider);
    }

    @Override
    public void generate() {
        this.add(PSEntities.GRIDSECT.get(), LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(PSItems.GRIDSECT)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 1.0F))))
                ));
    }

    @Override
    protected Stream<EntityType<?>> getKnownEntityTypes() {
        return PSEntities.ENTITY_TYPES.getEntries().stream().map(holder -> holder.value());
    }
}