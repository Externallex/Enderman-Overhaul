package tech.alexnijjar.endermanoverhaul;

import com.teamresourceful.resourcefulconfig.api.loader.Configurator;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.common.NeoForge;
import tech.alexnijjar.endermanoverhaul.client.EndermanOverhaulClient;
import tech.alexnijjar.endermanoverhaul.common.config.EndermanOverhaulConfig;
import tech.alexnijjar.endermanoverhaul.common.network.NetworkHandler;
import tech.alexnijjar.endermanoverhaul.common.registry.*;

@Mod(EndermanOverhaul.MOD_ID)
public class EndermanOverhaul {

    public static final String MOD_ID = "endermanoverhaul";
    public static final Configurator CONFIGURATOR = new Configurator(MOD_ID);

    public EndermanOverhaul(IEventBus bus) {
        CONFIGURATOR.register(EndermanOverhaulConfig.class);

        NetworkHandler.init();
        ModDataComponents.DATA_COMPONENT_TYPES.init();
        ModBlocks.BLOCKS.init();
        ModArmorMaterials.ARMOR_MATERIALS.init();
        ModItems.ITEMS.init();
        ModItems.TABS.init();
        ModEntityTypes.ENTITY_TYPES.init();
        ModParticleTypes.PARTICLE_TYPES.init();
        ModSoundEvents.SOUND_EVENTS.init();
        if (FMLEnvironment.dist.isClient()) {
            NeoForge.EVENT_BUS.addListener(EndermanOverhaulClient::onRegisterClientHud);
        }
    }
}
