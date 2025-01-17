package tech.alexnijjar.endermanoverhaul.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import tech.alexnijjar.endermanoverhaul.EndermanOverhaul;
import tech.alexnijjar.endermanoverhaul.datagen.provider.client.ModItemModelProvider;
import tech.alexnijjar.endermanoverhaul.datagen.provider.client.ModLangProvider;
import tech.alexnijjar.endermanoverhaul.datagen.provider.server.ModBlockTagProvider;
import tech.alexnijjar.endermanoverhaul.datagen.provider.server.ModEntityTypeTagProvider;
import tech.alexnijjar.endermanoverhaul.datagen.provider.server.ModItemTagProvider;
import tech.alexnijjar.endermanoverhaul.datagen.provider.server.ModLootTableProvider;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = EndermanOverhaul.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public final class EndermanOverhaulDataGenerator {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        generator.addProvider(event.includeClient(), new ModLangProvider(packOutput));
        generator.addProvider(event.includeClient(), new ModItemModelProvider(packOutput, existingFileHelper));

        generator.addProvider(event.includeServer(), new ModLootTableProvider(packOutput, lookupProvider));

        ModBlockTagProvider blockTagProvider = new ModBlockTagProvider(packOutput, lookupProvider, existingFileHelper);
        generator.addProvider(event.includeServer(), blockTagProvider);
        generator.addProvider(event.includeServer(), new ModItemTagProvider(packOutput, lookupProvider, blockTagProvider.contentsGetter(), existingFileHelper));
        generator.addProvider(event.includeServer(), new ModEntityTypeTagProvider(packOutput, lookupProvider, existingFileHelper));
    }
}
