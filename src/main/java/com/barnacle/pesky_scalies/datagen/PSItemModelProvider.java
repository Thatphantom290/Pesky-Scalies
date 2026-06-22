package com.barnacle.pesky_scalies.datagen;

import com.barnacle.pesky_scalies.PeskyScalies;
import com.barnacle.pesky_scalies.registry.PSItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class PSItemModelProvider extends ItemModelProvider {
    public PSItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, PeskyScalies.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(PSItems.GRIDSECT.get());
    }
}