package tech.alexnijjar.endermanoverhaul.common.entities.projectiles;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.neoforged.neoforge.common.Tags;
import org.jetbrains.annotations.NotNull;
import tech.alexnijjar.endermanoverhaul.common.entities.projectiles.base.BaseThrownPearl;
import tech.alexnijjar.endermanoverhaul.common.registry.ModEntityTypes;
import tech.alexnijjar.endermanoverhaul.common.registry.ModItems;
import tech.alexnijjar.endermanoverhaul.common.registry.ModSoundEvents;
import tech.alexnijjar.endermanoverhaul.common.utils.ModUtils;

import java.util.List;

public class ThrownSummonerPearl extends BaseThrownPearl {
    public ThrownSummonerPearl(EntityType<? extends ThrownSummonerPearl> type, Level level) {
        super(type, level);
    }

    public ThrownSummonerPearl(Level level, LivingEntity shooter) {
        super(ModEntityTypes.SUMMONER_PEARL.get(), shooter, level);
    }

    @Override
    protected @NotNull Item getDefaultItem() {
        return ModItems.SUMMONER_PEARL.get();
    }

    @Override
    protected void onHitEntity(@NotNull EntityHitResult result) {
        super.onHitEntity(result);
        result.getEntity().hurt(this.damageSources().thrown(this, this.getOwner()), 0.0f);
    }

    @Override
    protected void onHit(@NotNull HitResult result) {
        super.onHit(result);

        if (this.level().isClientSide() || this.isRemoved()) return;
        for (int i = 0; i < 32; ++i) {
            ModUtils.sendParticles((ServerLevel) level(), ParticleTypes.PORTAL, this.getX(), (this.getY() - 1) + this.random.nextDouble() * 2.0, this.getZ(), 1, 0.0, 0.0, 0.0, -1.3);
        }

        Entity entity = this.getOwner();
        if (entity instanceof ServerPlayer serverPlayer) {
            if (serverPlayer.connection.isAcceptingMessages() && serverPlayer.level() == this.level() && !serverPlayer.isSleeping()) {
                List<Entity> nearbyEntities = level().getEntities(this, getBoundingBox().inflate(12.0), e -> e instanceof LivingEntity).stream()
                    .limit(serverPlayer.server.getGameRules().getInt(GameRules.RULE_MAX_ENTITY_CRAMMING))
                    .toList();

                for (var target : nearbyEntities) {
                    if (target == serverPlayer) continue;
                    if (target.getType().is(Tags.EntityTypes.TELEPORTING_NOT_SUPPORTED)) continue;
                    target.teleportTo(getX(), getY(), getZ());
                }
            }
        }

        level().playSound(null, getX(), getY(), getZ(), ModSoundEvents.SUMMONER_PEARL_HIT.get(), getSoundSource(), 1.0f, random.nextFloat() * 0.4f + 0.8f);
        this.discard();
    }
}
