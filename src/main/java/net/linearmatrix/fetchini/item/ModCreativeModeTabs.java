package net.linearmatrix.fetchini.item;

import net.linearmatrix.fetchini.Fetchini;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS=DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Fetchini.MODID);
    public static final RegistryObject<CreativeModeTab> ITEMS_TAB=CREATIVE_MODE_TABS.register("items_tab",()-> CreativeModeTab.builder().icon(()->new ItemStack(ModItems.SAPPHIRE.get()))
            .title(Component.translatable("creativetab.items_tab"))
            .displayItems((pParameters, pOutput) -> {
                pOutput.accept(ModItems.SAPPHIRE.get());
                pOutput.accept(ModItems.RAW_SAPPHIRE.get());
            })
            .build());
    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
