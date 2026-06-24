package com.barnacle.pesky_scalies.entity.mob.release;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import com.barnacle.pesky_scalies.client.variants.ShameCrestVariant;
import com.barnacle.pesky_scalies.entity.ai.navigation.SmoothGroundNavigation;
import com.barnacle.pesky_scalies.registry.PSEntities;
import com.barnacle.pesky_scalies.registry.PSItems;
import net.minecraft.Util;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ShameCrest extends Animal {

    public final AnimationState idleAnimationState = new AnimationState();

    private static final EntityDataAccessor<Integer> VARIANT =
            SynchedEntityData.defineId(ShameCrest.class, EntityDataSerializers.INT);

    public ShameCrest(EntityType<? extends Animal> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));

        this.goalSelector.addGoal(1, new PanicGoal(this, 2.0));
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.25, stack -> stack.is(PSItems.GRIDSECT), false));

        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25));

        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 10d)
                .add(Attributes.MOVEMENT_SPEED, 0.25D)
                .add(Attributes.FOLLOW_RANGE, 24D);
    }

    @Override
    public boolean isFood(ItemStack stack) {
        return stack.is(PSItems.GRIDSECT.get());
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob otherParent) {
        ShameCrestVariant variant = Util.getRandom(ShameCrestVariant.values(), this.random);
        ShameCrest baby = PSEntities.SHAME_CREST.get().create(level);
        baby.setVariant(variant);
        return baby;
    }

    @Override
    protected @NotNull PathNavigation createNavigation(@NotNull Level level) {
        return new SmoothGroundNavigation(this, level);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.level().isClientSide) this.setupAnimationStates();
    }

    public void setupAnimationStates() {
        this.idleAnimationState.animateWhen(this.isAlive(), this.tickCount);
    }

    @Override
    public void calculateEntityAnimation(boolean flying) {
        float pos = (float) Mth.length(this.getX() - this.xo, this.getY() - this.yo, this.getZ() - this.zo);
        float speed = Math.min(pos * this.getWalkAnimationSpeed(), 1.0F);
        this.walkAnimation.update(speed, 0.4F);
    }

    public float getWalkAnimationSpeed() {
        return this.isBaby() ? 4.0F : 12.0F;
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(VARIANT, 0);
    }

    private int getTypeVariant() {
        return this.entityData.get(VARIANT);
    }

    public ShameCrestVariant getVariant() {
        return ShameCrestVariant.byId(this.getTypeVariant() & 255);
    }

    private void setVariant(ShameCrestVariant variant) {
        this.entityData.set(VARIANT, variant.getId() & 255);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("Variant", this.getTypeVariant());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.entityData.set(VARIANT, compound.getInt("Variant"));
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty,
                                        MobSpawnType spawnType, @Nullable SpawnGroupData spawnGroupData) {
        ShameCrestVariant variant = Util.getRandom(ShameCrestVariant.values(), this.random);
        this.setVariant(variant);
        return super.finalizeSpawn(level, difficulty, spawnType, spawnGroupData);
    }

    @Override
    public void playAmbientSound() {
        this.level().playSound(null, this.getX(), this.getY(), this.getZ(),
                SoundEvents.AXOLOTL_IDLE_AIR, this.getSoundSource(), 0.3F, 0.5F);

        this.level().playSound(null, this.getX(), this.getY(), this.getZ(),
                SoundEvents.ARMADILLO_AMBIENT, this.getSoundSource(), 0.1F, 0.1F);
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        this.level().playSound(null, this.getX(), this.getY(), this.getZ(),
                SoundEvents.AXOLOTL_HURT, this.getSoundSource(), 0.6F, 0.8F);
        return SoundEvents.ARMADILLO_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        this.level().playSound(null, this.getX(), this.getY(), this.getZ(),
                SoundEvents.AXOLOTL_DEATH, this.getSoundSource(), 0.3F, 0.3F);

        return SoundEvents.ARMADILLO_DEATH;
    }
}