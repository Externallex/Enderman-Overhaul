package tech.alexnijjar.endermanoverhaul.mixins.common;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.Tags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import tech.alexnijjar.endermanoverhaul.common.registry.ModItems;
import tech.alexnijjar.endermanoverhaul.common.utils.ModUtils;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {

    @Shadow
    protected ItemStack useItem;

    public LivingEntityMixin(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    @Inject(
        method = "blockUsingShield",
        at = @At("TAIL")
    )
    private void endermanoverhaul$blockUsingShield(LivingEntity attacker, CallbackInfo ci) {
        if (!useItem.is(ModItems.CORRUPTED_SHIELD.get())) return;
        if (attacker.getType().is(Tags.EntityTypes.TELEPORTING_NOT_SUPPORTED)) return;

        if (attacker.level().random.nextInt(4) != 0) {
            ModUtils.teleportTarget(attacker.level(), attacker, 32);
            attacker.hurt(attacker.damageSources().fall(), 2.0f);
        }
    }
}
