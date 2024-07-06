package tech.alexnijjar.endermanoverhaul.datagen.provider.server;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import tech.alexnijjar.endermanoverhaul.EndermanOverhaul;
import tech.alexnijjar.endermanoverhaul.common.tags.ModBlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {

    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, EndermanOverhaul.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        tag(ModBlockTags.CAVE_ENDERMAN_HOLDEABLE).addTag(BlockTags.COAL_ORES);
        tag(ModBlockTags.CAVE_ENDERMAN_HOLDEABLE).addTag(BlockTags.IRON_ORES);
        tag(ModBlockTags.CAVE_ENDERMAN_HOLDEABLE).addTag(BlockTags.DIAMOND_ORES);
        tag(ModBlockTags.CAVE_ENDERMAN_HOLDEABLE).addTag(BlockTags.GOLD_ORES);
        tag(ModBlockTags.CAVE_ENDERMAN_HOLDEABLE).addTag(BlockTags.REDSTONE_ORES);
        tag(ModBlockTags.CAVE_ENDERMAN_HOLDEABLE).addTag(BlockTags.LAPIS_ORES);
        tag(ModBlockTags.CAVE_ENDERMAN_HOLDEABLE).addTag(BlockTags.EMERALD_ORES);
        tag(ModBlockTags.CAVE_ENDERMAN_HOLDEABLE).addTag(BlockTags.COPPER_ORES);
        tag(ModBlockTags.CAVE_ENDERMAN_HOLDEABLE).addTag(BlockTags.BASE_STONE_OVERWORLD);
    }
}
