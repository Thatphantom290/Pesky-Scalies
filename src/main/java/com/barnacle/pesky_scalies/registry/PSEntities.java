package com.barnacle.pesky_scalies.registry;

/*
import net.barnacle.pesky_scales.entity.mob.release.Gridsect;
 */
import com.barnacle.pesky_scalies.PeskyScalies;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class PSEntities {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, PeskyScalies.MOD_ID);

    /*

    public static final Supplier<EntityType<GeckoEntity>> GRIDSECT =
            ENTITY_TYPES.register("gridsect", () -> EntityType.Builder.of(Gridsect::new, MobCategory.CREATURE)
                    .sized(0.5f, 0.4f).build("gridsect"));

     */


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
