package tech.alexnijjar.endermanoverhaul.common.items;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.util.GeckoLibUtil;
import tech.alexnijjar.endermanoverhaul.client.renderer.items.HoodRenderer;
import tech.alexnijjar.endermanoverhaul.common.constants.ConstantComponents;
import tech.alexnijjar.endermanoverhaul.common.registry.ModArmorMaterials;
import tech.alexnijjar.endermanoverhaul.common.registry.ModItems;

import java.util.List;
import java.util.function.Consumer;

public class HoodItem extends ArmorItem implements GeoItem {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public HoodItem(Properties properties) {
        super(ModArmorMaterials.HOOD.holder(), Type.CHESTPLATE, properties);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {}

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag isAdvanced) {
        tooltipComponents.add(ConstantComponents.HOOD_TOOLTIP);
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            private GeoArmorRenderer<?> badlandsRenderer;
            private GeoArmorRenderer<?> savannaRenderer;
            private GeoArmorRenderer<?> snowyRenderer;

            @Override
            public @NotNull HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
                GeoArmorRenderer<?> renderer;

                if (itemStack.is(ModItems.BADLANDS_HOOD.get())) {
                    if (this.badlandsRenderer == null) {
                        this.badlandsRenderer = new HoodRenderer("badlands_hood");
                    }
                    renderer = this.badlandsRenderer;
                } else if (itemStack.is(ModItems.SAVANNAS_HOOD.get())) {
                    if (this.savannaRenderer == null) {
                        this.savannaRenderer = new HoodRenderer("savanna_hood");
                    }
                    renderer = this.savannaRenderer;
                } else if (itemStack.is(ModItems.SNOWY_HOOD.get())) {
                    if (this.snowyRenderer == null) {
                        this.snowyRenderer = new HoodRenderer("snowy_hood");
                    }
                    renderer = this.snowyRenderer;
                } else {
                    return original;
                }

                renderer.prepForRender(livingEntity, itemStack, equipmentSlot, original);
                return renderer;
            }
        });
    }
}
