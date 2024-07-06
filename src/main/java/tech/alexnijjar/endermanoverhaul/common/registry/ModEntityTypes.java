package tech.alexnijjar.endermanoverhaul.common.registry;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.SpawnPlacementRegisterEvent;
import tech.alexnijjar.endermanoverhaul.EndermanOverhaul;
import tech.alexnijjar.endermanoverhaul.common.entities.*;
import tech.alexnijjar.endermanoverhaul.common.entities.pets.AxolotlPetEnderman;
import tech.alexnijjar.endermanoverhaul.common.entities.pets.HammerheadPetEnderman;
import tech.alexnijjar.endermanoverhaul.common.entities.pets.PetEnderman;
import tech.alexnijjar.endermanoverhaul.common.entities.projectiles.*;
import tech.alexnijjar.endermanoverhaul.common.entities.summons.Scarab;
import tech.alexnijjar.endermanoverhaul.common.entities.summons.Spirit;

@EventBusSubscriber(modid = EndermanOverhaul.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ModEntityTypes {
    public static final ResourcefulRegistry<EntityType<?>> ENTITY_TYPES = ResourcefulRegistries.create(BuiltInRegistries.ENTITY_TYPE, EndermanOverhaul.MOD_ID);
    public static final ResourcefulRegistry<EntityType<?>> ENDERMEN = ResourcefulRegistries.create(ENTITY_TYPES);
    public static final ResourcefulRegistry<EntityType<?>> PEARLS = ResourcefulRegistries.create(ENTITY_TYPES);

    public static final RegistryEntry<EntityType<BadlandsEnderman>> BADLANDS_ENDERMAN = ENDERMEN.register("badlands_enderman", () ->
        EntityType.Builder.of(BadlandsEnderman::new, MobCategory.MONSTER)
            .sized(0.6f, 3.0f)
            .eyeHeight(2.74f)
            .build("badlands_enderman"));

    public static final RegistryEntry<EntityType<CaveEnderman>> CAVE_ENDERMAN = ENDERMEN.register("cave_enderman", () ->
        EntityType.Builder.of(CaveEnderman::new, MobCategory.MONSTER)
            .sized(0.6f, 2.6f)
            .eyeHeight(2.45f)
            .build("cave_enderman"));

    public static final RegistryEntry<EntityType<CrimsonForestEnderman>> CRIMSON_FOREST_ENDERMAN = ENDERMEN.register("crimson_forest_enderman", () ->
        EntityType.Builder.of(CrimsonForestEnderman::new, MobCategory.MONSTER)
            .sized(0.6f, 3.1f)
            .fireImmune()
            .eyeHeight(2.95f)
            .build("crimson_forest_enderman"));

    public static final RegistryEntry<EntityType<DarkOakEnderman>> DARK_OAK_ENDERMAN = ENDERMEN.register("dark_oak_enderman", () ->
        EntityType.Builder.of(DarkOakEnderman::new, MobCategory.MONSTER)
            .sized(0.7f, 3.5f)
            .eyeHeight(2.95f)
            .build("dark_oak_enderman"));

    public static final RegistryEntry<EntityType<DesertEnderman>> DESERT_ENDERMAN = ENDERMEN.register("desert_enderman", () ->
        EntityType.Builder.of(DesertEnderman::new, MobCategory.MONSTER)
            .sized(0.6f, 3.1f)
            .eyeHeight(2.95f)
            .build("desert_enderman"));

    public static final RegistryEntry<EntityType<EndEnderman>> END_ENDERMAN = ENDERMEN.register("end_enderman", () ->
        EntityType.Builder.of(EndEnderman::new, MobCategory.MONSTER)
            .sized(0.6f, 2.5f)
            .fireImmune()
            .eyeHeight(2.35f)
            .build("end_enderman"));

    public static final RegistryEntry<EntityType<EndIslandsEnderman>> END_ISLANDS_ENDERMAN = ENDERMEN.register("end_islands_enderman", () ->
        EntityType.Builder.of(EndIslandsEnderman::new, MobCategory.MONSTER)
            .sized(0.6f, 4.4f)
            .fireImmune()
            .eyeHeight(4.25f)
            .build("end_islands_enderman"));

    public static final RegistryEntry<EntityType<FlowerFieldsEnderman>> FLOWER_FIELDS_ENDERMAN = ENDERMEN.register("flower_fields_enderman", () ->
        EntityType.Builder.of(FlowerFieldsEnderman::new, MobCategory.CREATURE)
            .sized(0.5f, 1.5f)
            .eyeHeight(1.15f)
            .build("flower_fields_enderman"));

    public static final RegistryEntry<EntityType<IceSpikesEnderman>> ICE_SPIKES_ENDERMAN = ENDERMEN.register("ice_spikes_enderman", () ->
        EntityType.Builder.of(IceSpikesEnderman::new, MobCategory.MONSTER)
            .sized(0.6f, 3.9f)
            .eyeHeight(3.55f)
            .build("ice_spikes_enderman"));

    public static final RegistryEntry<EntityType<MushroomFieldsEnderman>> MUSHROOM_FIELDS_ENDERMAN = ENDERMEN.register("mushroom_fields_enderman", () ->
        EntityType.Builder.of(MushroomFieldsEnderman::new, MobCategory.CREATURE)
            .sized(0.6f, 2.6f)
            .eyeHeight(2.45f)
            .build("mushroom_fields_enderman"));

    public static final RegistryEntry<EntityType<NetherWastesEnderman>> NETHER_WASTES_ENDERMAN = ENDERMEN.register("nether_wastes_enderman", () ->
        EntityType.Builder.of(NetherWastesEnderman::new, MobCategory.MONSTER)
            .sized(0.6f, 2.9f)
            .fireImmune()
            .eyeHeight(2.55f)
            .build("nether_wastes_enderman"));

    public static final RegistryEntry<EntityType<CoralEnderman>> CORAL_ENDERMAN = ENDERMEN.register("coral_enderman", () ->
        EntityType.Builder.of(CoralEnderman::new, MobCategory.MONSTER)
            .sized(0.6f, 2.0f)
            .eyeHeight(1.65f)
            .build("coral_enderman"));

    public static final RegistryEntry<EntityType<SavannaEnderman>> SAVANNA_ENDERMAN = ENDERMEN.register("savanna_enderman", () ->
        EntityType.Builder.of(SavannaEnderman::new, MobCategory.MONSTER)
            .sized(0.6f, 2.8f)
            .eyeHeight(2.45f)
            .build("savanna_enderman"));

    public static final RegistryEntry<EntityType<SnowyEnderman>> SNOWY_ENDERMAN = ENDERMEN.register("snowy_enderman", () ->
        EntityType.Builder.of(SnowyEnderman::new, MobCategory.MONSTER)
            .sized(0.6f, 2.8f)
            .eyeHeight(2.45f)
            .build("snowy_enderman"));

    public static final RegistryEntry<EntityType<SoulsandValleyEnderman>> SOULSAND_VALLEY_ENDERMAN = ENDERMEN.register("soulsand_valley_enderman", () ->
        EntityType.Builder.of(SoulsandValleyEnderman::new, MobCategory.MONSTER)
            .sized(0.6f, 2.5f)
            .fireImmune()
            .eyeHeight(2.15f)
            .build("soulsand_valley_enderman"));

    public static final RegistryEntry<EntityType<SwampEnderman>> SWAMP_ENDERMAN = ENDERMEN.register("swamp_enderman", () ->
        EntityType.Builder.of(SwampEnderman::new, MobCategory.MONSTER)
            .sized(0.6f, 3.8f)
            .eyeHeight(3.45f)
            .build("swamp_enderman"));

    public static final RegistryEntry<EntityType<WarpedForestEnderman>> WARPED_FOREST_ENDERMAN = ENDERMEN.register("warped_forest_enderman", () ->
        EntityType.Builder.of(WarpedForestEnderman::new, MobCategory.MONSTER)
            .sized(0.8f, 2.4f)
            .fireImmune()
            .eyeHeight(2.05f)
            .build("warped_forest_enderman"));

    public static final RegistryEntry<EntityType<WindsweptHillsEnderman>> WINDSWEPT_HILLS_ENDERMAN = ENDERMEN.register("windswept_hills_enderman", () ->
        EntityType.Builder.of(WindsweptHillsEnderman::new, MobCategory.MONSTER)
            .sized(0.6f, 4.1f)
            .eyeHeight(3.75f)
            .build("windswept_hills_enderman"));

    // Pets
    public static final RegistryEntry<EntityType<PetEnderman>> PET_ENDERMAN = ENTITY_TYPES.register("pet_enderman", () ->
        EntityType.Builder.<PetEnderman>of(PetEnderman::new, MobCategory.CREATURE)
            .sized(0.8f, 2.8f)
            .eyeHeight(2.45f)
            .build("pet_enderman"));

    public static final RegistryEntry<EntityType<HammerheadPetEnderman>> HAMMERHEAD_PET_ENDERMAN = ENTITY_TYPES.register("hammerhead_pet_enderman", () ->
        EntityType.Builder.<HammerheadPetEnderman>of(HammerheadPetEnderman::new, MobCategory.CREATURE)
            .sized(1.0f, 2.6f)
            .eyeHeight(2.45f)
            .build("hammerhead_pet_enderman"));

    public static final RegistryEntry<EntityType<AxolotlPetEnderman>> AXOLOTL_PET_ENDERMAN = ENTITY_TYPES.register("axolotl_pet_enderman", () ->
        EntityType.Builder.<AxolotlPetEnderman>of(AxolotlPetEnderman::new, MobCategory.CREATURE)
            .sized(0.8f, 2.7f)
            .eyeHeight(2.35f)
            .build("axolotl_pet_enderman"));

    // Summons
    public static final RegistryEntry<EntityType<Scarab>> SCARAB = ENTITY_TYPES.register("scarab", () ->
        EntityType.Builder.of(Scarab::new, MobCategory.MONSTER)
            .sized(0.3f, 0.5f)
            .eyeHeight(0.13f)
            .passengerAttachments(0.2375f)
            .clientTrackingRange(8)
            .build("scarab"));

    public static final RegistryEntry<EntityType<Spirit>> SPIRIT = ENTITY_TYPES.register("spirit", () ->
        EntityType.Builder.of(Spirit::new, MobCategory.MONSTER)
            .sized(0.3f, 0.3f)
            .fireImmune()
            .eyeHeight(0.51875f)
            .passengerAttachments(0.7375f)
            .ridingOffset(0.04f)
            .clientTrackingRange(8)
            .build("spirit"));

    // Projectiles
    public static final RegistryEntry<EntityType<EnderBullet>> ENDER_BULLET = ENTITY_TYPES.register("ender_bullet", () ->
        EntityType.Builder.<EnderBullet>of(EnderBullet::new, MobCategory.MISC)
            .sized(0.3125f, 0.3125f)
            .clientTrackingRange(8)
            .build("ender_bullet"));

    public static final RegistryEntry<EntityType<ThrownCorruptedPearl>> CORRUPTED_PEARL = PEARLS.register("corrupted_pearl", () ->
        EntityType.Builder.<ThrownCorruptedPearl>of(ThrownCorruptedPearl::new, MobCategory.MISC)
            .sized(0.25f, 0.25f)
            .clientTrackingRange(4)
            .updateInterval(10)
            .build("corrupted_pearl"));

    public static final RegistryEntry<EntityType<ThrownSoulPearl>> SOUL_PEARL = PEARLS.register("soul_pearl", () ->
        EntityType.Builder.<ThrownSoulPearl>of(ThrownSoulPearl::new, MobCategory.MISC)
            .sized(0.25f, 0.25f)
            .clientTrackingRange(4)
            .updateInterval(10)
            .build("soul_pearl"));

    public static final RegistryEntry<EntityType<ThrownAncientPearl>> ANCIENT_PEARL = PEARLS.register("ancient_pearl", () ->
        EntityType.Builder.<ThrownAncientPearl>of(ThrownAncientPearl::new, MobCategory.MISC)
            .sized(0.25f, 0.25f)
            .clientTrackingRange(4)
            .updateInterval(10)
            .build("ancient_pearl"));

    public static final RegistryEntry<EntityType<ThrownBubblePearl>> BUBBLE_PEARL = PEARLS.register("bubble_pearl", () ->
        EntityType.Builder.<ThrownBubblePearl>of(ThrownBubblePearl::new, MobCategory.MISC)
            .sized(0.25f, 0.25f)
            .clientTrackingRange(4)
            .updateInterval(10)
            .build("bubble_pearl"));

    public static final RegistryEntry<EntityType<ThrownSummonerPearl>> SUMMONER_PEARL = PEARLS.register("summoner_pearl", () ->
        EntityType.Builder.<ThrownSummonerPearl>of(ThrownSummonerPearl::new, MobCategory.MISC)
            .sized(0.25f, 0.25f)
            .clientTrackingRange(4)
            .updateInterval(10)
            .build("summoner_pearl"));

    public static final RegistryEntry<EntityType<ThrownIcyPearl>> ICY_PEARL = PEARLS.register("icy_pearl", () ->
        EntityType.Builder.<ThrownIcyPearl>of(ThrownIcyPearl::new, MobCategory.MISC)
            .sized(0.25f, 0.25f)
            .clientTrackingRange(4)
            .updateInterval(10)
            .build("icy_pearl"));

    public static final RegistryEntry<EntityType<ThrownCrimsonPearl>> CRIMSON_PEARL = PEARLS.register("crimson_pearl", () ->
        EntityType.Builder.<ThrownCrimsonPearl>of(ThrownCrimsonPearl::new, MobCategory.MISC)
            .sized(0.25f, 0.25f)
            .clientTrackingRange(4)
            .updateInterval(10)
            .build("crimson_pearl"));

    public static final RegistryEntry<EntityType<ThrownWarpedPearl>> WARPED_PEARL = PEARLS.register("warped_pearl", () ->
        EntityType.Builder.<ThrownWarpedPearl>of(ThrownWarpedPearl::new, MobCategory.MISC)
            .sized(0.25f, 0.25f)
            .clientTrackingRange(4)
            .updateInterval(10)
            .build("warped_pearl"));

    @SubscribeEvent
    public static void onRegisterAttributes(EntityAttributeCreationEvent event) {
        event.put(BADLANDS_ENDERMAN.get(), BadlandsEnderman.createAttributes().build());
        event.put(CAVE_ENDERMAN.get(), CaveEnderman.createAttributes().build());
        event.put(CRIMSON_FOREST_ENDERMAN.get(), CrimsonForestEnderman.createAttributes().build());
        event.put(DARK_OAK_ENDERMAN.get(), DarkOakEnderman.createAttributes().build());
        event.put(DESERT_ENDERMAN.get(), DesertEnderman.createAttributes().build());
        event.put(END_ENDERMAN.get(), EndEnderman.createAttributes().build());
        event.put(END_ISLANDS_ENDERMAN.get(), EndIslandsEnderman.createAttributes().build());
        event.put(FLOWER_FIELDS_ENDERMAN.get(), FlowerFieldsEnderman.createAttributes().build());
        event.put(ICE_SPIKES_ENDERMAN.get(), IceSpikesEnderman.createAttributes().build());
        event.put(MUSHROOM_FIELDS_ENDERMAN.get(), MushroomFieldsEnderman.createAttributes().build());
        event.put(NETHER_WASTES_ENDERMAN.get(), NetherWastesEnderman.createAttributes().build());
        event.put(CORAL_ENDERMAN.get(), CoralEnderman.createAttributes().build());
        event.put(SAVANNA_ENDERMAN.get(), SavannaEnderman.createAttributes().build());
        event.put(SNOWY_ENDERMAN.get(), SnowyEnderman.createAttributes().build());
        event.put(SOULSAND_VALLEY_ENDERMAN.get(), SoulsandValleyEnderman.createAttributes().build());
        event.put(SWAMP_ENDERMAN.get(), SwampEnderman.createAttributes().build());
        event.put(WARPED_FOREST_ENDERMAN.get(), WarpedForestEnderman.createAttributes().build());
        event.put(WINDSWEPT_HILLS_ENDERMAN.get(), WindsweptHillsEnderman.createAttributes().build());

        // Pets
        event.put(PET_ENDERMAN.get(), PetEnderman.createAttributes().build());
        event.put(HAMMERHEAD_PET_ENDERMAN.get(), HammerheadPetEnderman.createAttributes().build());
        event.put(AXOLOTL_PET_ENDERMAN.get(), AxolotlPetEnderman.createAttributes().build());

        // Summons
        event.put(SCARAB.get(), Scarab.createAttributes().build());
        event.put(SPIRIT.get(), Spirit.createAttributes().build());
    }

    @SubscribeEvent
    public static void onRegisterSpawnPlacements(SpawnPlacementRegisterEvent event) {
        event.register(BADLANDS_ENDERMAN.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, BadlandsEnderman::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(CAVE_ENDERMAN.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, CaveEnderman::checkSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(CRIMSON_FOREST_ENDERMAN.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, CrimsonForestEnderman::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(DARK_OAK_ENDERMAN.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DarkOakEnderman::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(DESERT_ENDERMAN.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DesertEnderman::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(END_ENDERMAN.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, EndEnderman::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(END_ISLANDS_ENDERMAN.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, EndIslandsEnderman::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(FLOWER_FIELDS_ENDERMAN.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, FlowerFieldsEnderman::checkMobSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(ICE_SPIKES_ENDERMAN.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, IceSpikesEnderman::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(MUSHROOM_FIELDS_ENDERMAN.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, MushroomFieldsEnderman::checkMobSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(NETHER_WASTES_ENDERMAN.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, NetherWastesEnderman::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(CORAL_ENDERMAN.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, CoralEnderman::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(SAVANNA_ENDERMAN.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, SavannaEnderman::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(SNOWY_ENDERMAN.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, SnowyEnderman::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(SOULSAND_VALLEY_ENDERMAN.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, SoulsandValleyEnderman::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(SWAMP_ENDERMAN.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, SwampEnderman::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(WARPED_FOREST_ENDERMAN.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, WarpedForestEnderman::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(WINDSWEPT_HILLS_ENDERMAN.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, WindsweptHillsEnderman::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);

        // Summons
        event.register(SCARAB.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(SPIRIT.get(), SpawnPlacementTypes.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
    }
}