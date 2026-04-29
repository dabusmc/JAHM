package gooblemc.jahm.item;

import gooblemc.jahm.JAHM;
import gooblemc.jahm.item.hammers.ExcavatorItem;
import gooblemc.jahm.item.hammers.HammerItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems
{
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, JAHM.MOD_ID);

    public static final RegistryObject<Item> STONE_HAMMER_3 = ITEMS.register("stone_hammer_3",
            () -> new HammerItem(Tiers.STONE, 2, -3.2F, 1, new Item.Properties().durability(393)));
    public static final RegistryObject<Item> IRON_HAMMER_3 = ITEMS.register("iron_hammer_3",
            () -> new HammerItem(Tiers.IRON, 3, -3.2F, 1, new Item.Properties().durability(750)));
    public static final RegistryObject<Item> GOLD_HAMMER_3 = ITEMS.register("gold_hammer_3",
            () -> new HammerItem(Tiers.GOLD, 1, -3.0F, 1, new Item.Properties().durability(96)));
    public static final RegistryObject<Item> DIAMOND_HAMMER_3 = ITEMS.register("diamond_hammer_3",
            () -> new HammerItem(Tiers.DIAMOND, 4, -3.1F, 1, new Item.Properties().durability(4683)));
    public static final RegistryObject<Item> NETHERITE_HAMMER_3 = ITEMS.register("netherite_hammer_3",
            () -> new HammerItem(Tiers.NETHERITE, 5, -3.1F, 1, new Item.Properties().durability(6093)));

    public static final RegistryObject<Item> STONE_HAMMER_5 = ITEMS.register("stone_hammer_5",
            () -> new HammerItem(Tiers.STONE, 2, -3.2F, 2, new Item.Properties().durability(393)));
    public static final RegistryObject<Item> IRON_HAMMER_5 = ITEMS.register("iron_hammer_5",
            () -> new HammerItem(Tiers.IRON, 3, -3.2F, 2, new Item.Properties().durability(750)));
    public static final RegistryObject<Item> GOLD_HAMMER_5 = ITEMS.register("gold_hammer_5",
            () -> new HammerItem(Tiers.GOLD, 1, -3.0F, 2, new Item.Properties().durability(96)));
    public static final RegistryObject<Item> DIAMOND_HAMMER_5 = ITEMS.register("diamond_hammer_5",
            () -> new HammerItem(Tiers.DIAMOND, 4, -3.1F, 2, new Item.Properties().durability(4683)));
    public static final RegistryObject<Item> NETHERITE_HAMMER_5 = ITEMS.register("netherite_hammer_5",
            () -> new HammerItem(Tiers.NETHERITE, 5, -3.1F, 2, new Item.Properties().durability(6093)));

    public static final RegistryObject<Item> STONE_HAMMER_7 = ITEMS.register("stone_hammer_7",
            () -> new HammerItem(Tiers.STONE, 2, -3.2F, 3, new Item.Properties().durability(393)));
    public static final RegistryObject<Item> IRON_HAMMER_7 = ITEMS.register("iron_hammer_7",
            () -> new HammerItem(Tiers.IRON, 3, -3.2F, 3, new Item.Properties().durability(750)));
    public static final RegistryObject<Item> GOLD_HAMMER_7 = ITEMS.register("gold_hammer_7",
            () -> new HammerItem(Tiers.GOLD, 1, -3.0F, 3, new Item.Properties().durability(96)));
    public static final RegistryObject<Item> DIAMOND_HAMMER_7 = ITEMS.register("diamond_hammer_7",
            () -> new HammerItem(Tiers.DIAMOND, 4, -3.1F, 3, new Item.Properties().durability(4683)));
    public static final RegistryObject<Item> NETHERITE_HAMMER_7 = ITEMS.register("netherite_hammer_7",
            () -> new HammerItem(Tiers.NETHERITE, 5, -3.1F, 3, new Item.Properties().durability(6093)));

    public static final RegistryObject<Item> IRON_EXCAVATOR_3 = ITEMS.register("iron_excavator_3",
            () -> new ExcavatorItem(Tiers.IRON, 3, -3.2F, 1, new Item.Properties().durability(750)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
