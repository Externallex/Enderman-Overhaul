package tech.alexnijjar.endermanoverhaul.common.items.tools;

import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;
import tech.alexnijjar.endermanoverhaul.client.renderer.items.CorruptedShieldRenderer;
import tech.alexnijjar.endermanoverhaul.common.constants.ConstantComponents;
import tech.alexnijjar.endermanoverhaul.common.registry.ModItems;

import java.util.List;
import java.util.function.Consumer;

public class CorruptedShieldItem extends ShieldItem implements GeoItem {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public CorruptedShieldItem(Properties properties) {
        super(properties);
    }

    public boolean isValidRepairItem(@NotNull ItemStack stack, ItemStack repairCandidate) {
        return repairCandidate.is(ModItems.ENDERMAN_TOOTH.get());
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {}

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag isAdvanced) {
        tooltipComponents.add(ConstantComponents.CORRUPTED_SHIELD_TOOLTIP);
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            private BlockEntityWithoutLevelRenderer renderer;

            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                return this.renderer == null ? renderer = new CorruptedShieldRenderer() : this.renderer;
            }
        });
    }
}
