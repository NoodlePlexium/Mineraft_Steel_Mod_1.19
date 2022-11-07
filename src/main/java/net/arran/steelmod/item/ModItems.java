package net.arran.steelmod.item;

import net.arran.steelmod.SteelMod;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SteelMod.MOD_ID);

    public static final RegistryObject<Item> STEEL_INGOT = ITEMS.register("steel_ingot",
            ()-> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));

    public static final RegistryObject<SwordItem> STEEL_SWORD = ITEMS.register("steel_sword",
            ()-> new SwordItem(Tiers.SteelTier,1,-2.4f,new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

    public static class Tiers {
        public static final Tier SteelTier = new ForgeTier(3,
                512,
                1f,
                5,
                350,
                null, ()-> Ingredient.of(ModItems.STEEL_INGOT.get()));
    }
}
