package tech.alexnijjar.endermanoverhaul.common.entities;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.EnderMan;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoReplacedEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.util.GeckoLibUtil;
import tech.alexnijjar.endermanoverhaul.common.constants.ConstantAnimations;

public class ReplacedEnderman implements GeoReplacedEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    @Override
    public EntityType<?> getReplacingEntityType() {
        return EntityType.ENDERMAN;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, 0, state -> {
            EnderMan enderman = getEndermanFromState(state);
            if (enderman == null) return PlayState.STOP;

            if (state.isMoving()) {
                state.getController().setAnimation(enderman.isCreepy() ?
                    ConstantAnimations.RUN :
                    ConstantAnimations.WALK);
                state.setControllerSpeed(2);
            } else {
                state.getController().setAnimation(ConstantAnimations.IDLE);
                state.setControllerSpeed(1);
            }
            return PlayState.CONTINUE;
        }));

        controllers.add(new AnimationController<>(this, "creepy_controller", 5, state -> {
            EnderMan enderman = getEndermanFromState(state);
            if (enderman == null) return PlayState.STOP;
            if (!enderman.isCreepy()) return PlayState.STOP;
            state.getController().setAnimation(ConstantAnimations.ANGRY);
            return PlayState.CONTINUE;
        }));

        controllers.add(new AnimationController<>(this, "hold_controller", 5, state -> {
            EnderMan enderman = getEndermanFromState(state);
            if (enderman == null) return PlayState.STOP;
            if (enderman.getCarriedBlock() == null) return PlayState.STOP;
            state.getController().setAnimation(ConstantAnimations.HOLDING);
            return PlayState.CONTINUE;
        }));

        controllers.add(new AnimationController<>(this, "attack_controller", 5, state -> {
            EnderMan enderman = getEndermanFromState(state);
            if (enderman == null) return PlayState.STOP;
            if (enderman.getAttackAnim(state.getPartialTick()) == 0) return PlayState.STOP;
            state.getController().setAnimation(ConstantAnimations.ATTACK);
            return PlayState.CONTINUE;
        }));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Nullable
    private EnderMan getEndermanFromState(AnimationState<ReplacedEnderman> state) {
        Entity entity = state.getData(DataTickets.ENTITY);
        if (!(entity instanceof EnderMan enderman)) return null;
        return enderman;
    }
}
