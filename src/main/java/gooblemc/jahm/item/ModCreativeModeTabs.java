package gooblemc.jahm.item;

import gooblemc.jahm.JAHM;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs
{
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, JAHM.MOD_ID);

    public static final RegistryObject<CreativeModeTab> JAHM_TAB = CREATIVE_MODE_TABS.register("jahm",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.IRON_HAMMER_3.get()))
                    .title(Component.translatable("creativetab.jahm"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.STONE_HAMMER_3.get());
                        pOutput.accept(ModItems.IRON_HAMMER_3.get());
                        pOutput.accept(ModItems.GOLD_HAMMER_3.get());
                        pOutput.accept(ModItems.DIAMOND_HAMMER_3.get());
                        pOutput.accept(ModItems.NETHERITE_HAMMER_3.get());

                        pOutput.accept(ModItems.STONE_HAMMER_5.get());
                        pOutput.accept(ModItems.IRON_HAMMER_5.get());
                        pOutput.accept(ModItems.GOLD_HAMMER_5.get());
                        pOutput.accept(ModItems.DIAMOND_HAMMER_5.get());
                        pOutput.accept(ModItems.NETHERITE_HAMMER_5.get());

                        pOutput.accept(ModItems.STONE_HAMMER_7.get());
                        pOutput.accept(ModItems.IRON_HAMMER_7.get());
                        pOutput.accept(ModItems.GOLD_HAMMER_7.get());
                        pOutput.accept(ModItems.DIAMOND_HAMMER_7.get());
                        pOutput.accept(ModItems.NETHERITE_HAMMER_7.get());

                        pOutput.accept(ModItems.IRON_EXCAVATOR_3.get());
                    })
                    .build());


    public static void register(IEventBus eventBus)
    {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
