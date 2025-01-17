package tech.alexnijjar.endermanoverhaul.client.renderer.items;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.registries.BuiltInRegistries;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;
import tech.alexnijjar.endermanoverhaul.common.items.tools.CorruptedShieldItem;
import tech.alexnijjar.endermanoverhaul.common.registry.ModItems;

public class CorruptedShieldRenderer extends GeoItemRenderer<CorruptedShieldItem> {
    public CorruptedShieldRenderer() {
        super(new DefaultedItemGeoModel<>(BuiltInRegistries.ITEM.getKey(ModItems.CORRUPTED_SHIELD.get())));
    }

    @Override
    public void actuallyRender(PoseStack poseStack, CorruptedShieldItem animatable, BakedGeoModel model, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int colour) {
        poseStack.pushPose();
        poseStack.translate(0.0, -0.5, 0.0);
        super.actuallyRender(poseStack, animatable, model, renderType, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, colour);
        poseStack.popPose();
    }
}
