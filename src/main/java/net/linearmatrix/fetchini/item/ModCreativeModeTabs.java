package net.linearmatrix.fetchini.item;

import net.linearmatrix.fetchini.Fetchini;
import net.linearmatrix.fetchini.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS=DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Fetchini.MODID);
    public static final RegistryObject<CreativeModeTab> FETCHINI_ITEMS_TAB=CREATIVE_MODE_TABS.register("fetchini_items_tab",()-> CreativeModeTab.builder().icon(()->new ItemStack(ModItems.SAPPHIRE.get()))
            .title(Component.translatable("creativetab.fetchini_items_tab"))
            .displayItems((pParameters, pOutput) -> {
                pOutput.accept(ModItems.RAW_SAPPHIRE.get());
                pOutput.accept(ModBlocks.RAW_SAPPHIRE_BLOCK.get());
                pOutput.accept(ModItems.SAPPHIRE.get());
                pOutput.accept(ModBlocks.SAPPHIRE_BLOCK.get());
            })
            .build());
    public static final RegistryObject<CreativeModeTab> FETCHINI_BLOCKS_TAB=CREATIVE_MODE_TABS.register("fetchini_blocks_tab",()-> CreativeModeTab.builder().icon(()->new ItemStack(ModBlocks.SAPPHIRE_BLOCK.get()))
            .title(Component.translatable("creativetab.fetchini_blocks_tab"))
            .displayItems((pParameters, pOutput) -> {

            })
            .build());
    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
