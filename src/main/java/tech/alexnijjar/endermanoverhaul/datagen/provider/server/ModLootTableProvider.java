package tech.alexnijjar.endermanoverhaul.datagen.provider.server;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.EntityLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.EnchantedCountIncreaseFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceWithEnchantedBonusCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import tech.alexnijjar.endermanoverhaul.common.registry.ModEntityTypes;
import tech.alexnijjar.endermanoverhaul.common.registry.ModItems;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class ModLootTableProvider extends LootTableProvider {
    public ModLootTableProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, Set.of(), List.of(new SubProviderEntry(EntityLootTables::new, LootContextParamSets.ENTITY)), lookupProvider);
    }

    private static class EntityLootTables extends EntityLootSubProvider {

        public EntityLootTables(HolderLookup.Provider lookupProvider) {
            super(FeatureFlags.REGISTRY.allFlags(), lookupProvider);
        }

        @Override
        public void generate() {
            add(ModEntityTypes.BADLANDS_ENDERMAN.get(), getDefaultEndermanLootTable()
                .withPool(LootPool.lootPool()
                    .add(LootItem.lootTableItem(ModItems.TINY_SKULL.get())
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1)))
                        .apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0, 1))))
                    .when(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(this.registries, 0.1f, 0.025f)))
                .withPool(LootPool.lootPool()
                    .add(LootItem.lootTableItem(ModItems.BADLANDS_HOOD.get())
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1))))
                    .when(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(this.registries, 0.1f, 0.025f))
                )
            );

            add(ModEntityTypes.CAVE_ENDERMAN.get(), getDefaultEndermanLootTable()
                .withPool(LootPool.lootPool()
                    .add(LootItem.lootTableItem(Items.COAL)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 3)))
                        .apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0, 1)))))
                .withPool(LootPool.lootPool()
                    .add(LootItem.lootTableItem(Items.RAW_IRON)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 3)))
                        .apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0, 1)))))
                .withPool(LootPool.lootPool()
                    .add(LootItem.lootTableItem(Items.EMERALD)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 2)))
                        .apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0, 1))))
                    .when(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(this.registries, 0.1f, 0.025f))
                )
            );

            add(ModEntityTypes.CRIMSON_FOREST_ENDERMAN.get(), getEmptyLootTable(ModItems.CRIMSON_PEARL)
                .withPool(LootPool.lootPool()
                    .add(LootItem.lootTableItem(Items.CRIMSON_FUNGUS)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 3)))
                        .apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0, 1)))
                    )
                )
            );

            add(ModEntityTypes.DARK_OAK_ENDERMAN.get(), getDefaultEndermanLootTable());

            add(ModEntityTypes.DESERT_ENDERMAN.get(), getDefaultEndermanLootTable()
                .withPool(LootPool.lootPool()
                    .add(LootItem.lootTableItem(Items.EMERALD)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 2)))
                        .apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0, 1))))
                    .when(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(this.registries, 0.05f, 0.025f))
                )
            );

            add(ModEntityTypes.END_ENDERMAN.get(), getEmptyLootTable(ModItems.CORRUPTED_PEARL)
                .withPool(LootPool.lootPool()
                    .add(LootItem.lootTableItem(Items.CHORUS_FRUIT)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 2)))
                        .apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0, 1)))))
                .withPool(LootPool.lootPool()
                    .add(LootItem.lootTableItem(ModItems.ENDERMAN_TOOTH.get())
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 2)))
                        .apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0, 1))))
                    .when(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(this.registries, 0.04f, 0.025f))
                )
            );

            add(ModEntityTypes.END_ISLANDS_ENDERMAN.get(), getDefaultEndermanLootTable(ModItems.ANCIENT_PEARL));

            add(ModEntityTypes.FLOWER_FIELDS_ENDERMAN.get(), getDefaultEndermanLootTable());

            add(ModEntityTypes.ICE_SPIKES_ENDERMAN.get(), getDefaultEndermanLootTable(ModItems.ICY_PEARL)
                .withPool(LootPool.lootPool()
                    .add(LootItem.lootTableItem(Items.PACKED_ICE)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 3)))
                        .apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0, 1)))
                    )
                )
            );

            add(ModEntityTypes.MUSHROOM_FIELDS_ENDERMAN.get(), getDefaultEndermanLootTable()
                .withPool(LootPool.lootPool()
                    .add(LootItem.lootTableItem(Items.RED_MUSHROOM)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 3)))
                        .apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0, 1)))
                    )
                )
            );

            add(ModEntityTypes.NETHER_WASTES_ENDERMAN.get(), getDefaultEndermanLootTable()
                .withPool(LootPool.lootPool()
                    .add(LootItem.lootTableItem(Items.BONE)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 3)))
                        .apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0, 1)))
                    )
                )
            );

            add(ModEntityTypes.CORAL_ENDERMAN.get(), getEmptyLootTable(ModItems.BUBBLE_PEARL));

            add(ModEntityTypes.SAVANNA_ENDERMAN.get(), getDefaultEndermanLootTable()
                .withPool(LootPool.lootPool()
                    .add(LootItem.lootTableItem(Items.ACACIA_LOG)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 4)))
                        .apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0, 1)))))
                .withPool(LootPool.lootPool()
                    .add(LootItem.lootTableItem(ModItems.SAVANNAS_HOOD.get())
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1))))
                    .when(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(this.registries, 0.1f, 0.025f))
                )
            );

            add(ModEntityTypes.SNOWY_ENDERMAN.get(), getDefaultEndermanLootTable(ModItems.ICY_PEARL)
                .withPool(LootPool.lootPool()
                    .add(LootItem.lootTableItem(Items.SNOWBALL)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 3)))
                        .apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0, 1)))))
                .withPool(LootPool.lootPool()
                    .add(LootItem.lootTableItem(ModItems.SNOWY_HOOD.get())
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1))))
                    .when(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(this.registries, 0.1f, 0.025f))
                )
            );

            add(ModEntityTypes.SOULSAND_VALLEY_ENDERMAN.get(), getEmptyLootTable(ModItems.SOUL_PEARL)
                .withPool(LootPool.lootPool()
                    .add(LootItem.lootTableItem(Items.BONE)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 3)))
                        .apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0, 1)))
                    )
                )
            );

            add(ModEntityTypes.SWAMP_ENDERMAN.get(), getDefaultEndermanLootTable(ModItems.SUMMONER_PEARL));

            add(ModEntityTypes.WARPED_FOREST_ENDERMAN.get(), getEmptyLootTable(ModItems.WARPED_PEARL)
                .withPool(LootPool.lootPool()
                    .add(LootItem.lootTableItem(Items.WARPED_FUNGUS)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 3)))
                        .apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0, 1)))
                    )
                )
            );

            add(ModEntityTypes.WINDSWEPT_HILLS_ENDERMAN.get(), getDefaultEndermanLootTable(ModItems.SUMMONER_PEARL));
        }

        @Override
        protected Stream<EntityType<?>> getKnownEntityTypes() {
            return ModEntityTypes.ENDERMEN.stream().map(RegistryEntry::get);
        }

        @Override
        protected boolean canHaveLootTable(EntityType<?> type) {
            return true;
        }

        private LootTable.Builder getDefaultEndermanLootTable() {
            return LootTable.lootTable()
                .withPool(LootPool.lootPool()
                    .add(LootItem.lootTableItem(Items.ENDER_PEARL)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 1)))
                        .apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0, 1)))
                    )
                );
        }

        private LootTable.Builder getDefaultEndermanLootTable(Supplier<Item> additionalPearl) {
            return LootTable.lootTable()
                .withPool(LootPool.lootPool()
                    .add(LootItem.lootTableItem(Items.ENDER_PEARL)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 1)))
                        .apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0, 1))))
                    .add(LootItem.lootTableItem(additionalPearl.get())
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 1)))
                        .apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0, 1)))
                    )
                );
        }

        private LootTable.Builder getEmptyLootTable(Supplier<Item> additionalPearl) {
            return LootTable.lootTable()
                .withPool(LootPool.lootPool()
                    .add(LootItem.lootTableItem(additionalPearl.get())
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 1)))
                        .apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0, 1)))
                    )
                );
        }
    }
}
