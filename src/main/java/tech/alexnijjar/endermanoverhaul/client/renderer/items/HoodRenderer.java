package tech.alexnijjar.endermanoverhaul.client.renderer.items;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import tech.alexnijjar.endermanoverhaul.EndermanOverhaul;
import tech.alexnijjar.endermanoverhaul.common.items.HoodItem;

public class HoodRenderer extends GeoArmorRenderer<HoodItem> {
    public HoodRenderer(String name) {
        super(new DefaultedItemGeoModel<HoodItem>(ResourceLocation.fromNamespaceAndPath(EndermanOverhaul.MOD_ID, name))
            .withAltTexture(ResourceLocation.fromNamespaceAndPath(EndermanOverhaul.MOD_ID, "armor/" + name)));
    }

    @Override
    protected void applyBoneVisibilityBySlot(EquipmentSlot currentSlot) {
        setAllVisible(false);

        if (EquipmentSlot.CHEST == currentSlot) {
            setBoneVisible(this.getHeadBone(this.model), true);
            setBoneVisible(this.getBodyBone(this.model), true);
            setBoneVisible(this.getRightArmBone(this.model), true);
            setBoneVisible(this.getLeftArmBone(this.model), true);
        }
    }
}
