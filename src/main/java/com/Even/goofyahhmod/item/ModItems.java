package com.Even.goofyahhmod.item;

import com.Even.goofyahhmod.GoofyAhhMod;
import com.Even.goofyahhmod.item.custom.Firestone;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems
{
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, GoofyAhhMod.MOD_ID);


    public static final RegistryObject<Item> AMETHYST = ITEMS.register("amethyst",
            () -> new Item(new Item.Properties().group(ModItemGroup.GOOFY_GROUP)));

    public static final RegistryObject<Item> TONNEROLIUM = ITEMS.register("tonnerolium_ingot",
            () -> new Item(new Item.Properties().group(ModItemGroup.GOOFY_GROUP)));

    public static final RegistryObject<Item> MACCERONIUM = ITEMS.register("macceronium_ingot",
            () -> new Item(new Item.Properties().group(ModItemGroup.GOOFY_GROUP)));

    public static final RegistryObject<Item> FIRESTONE = ITEMS.register("firestone",
            () -> new Firestone(new Item.Properties().group(ModItemGroup.GOOFY_GROUP).maxDamage(20)));

    public static final RegistryObject<Item> PROGRAMMER_SOCKS_BLUE = ITEMS.register("programmer_socks_blue",
            () -> new ArmorItem(ModArmorMaterial.FBMATERIALBLUE, EquipmentSlotType.FEET, new Item.Properties().group(ModItemGroup.GOOFY_GROUP)));

    public static final RegistryObject<Item> PROGRAMMER_SOCKS_BLACK = ITEMS.register("programmer_socks_black",
            () -> new ArmorItem(ModArmorMaterial.FBMATERIALBLACK, EquipmentSlotType.FEET, new Item.Properties().group(ModItemGroup.GOOFY_GROUP)));

    public static final RegistryObject<Item> TONNEROLIUM_BOOTS = ITEMS.register("tonnerolium_boots",
            () -> new ArmorItem(ModArmorMaterial.TONNEROLIUM, EquipmentSlotType.FEET, new Item.Properties().group(ModItemGroup.GOOFY_GROUP)));

    public static final RegistryObject<Item> TONNEROLIUM_LEGGINGS = ITEMS.register("tonnerolium_leggings",
            () -> new ArmorItem(ModArmorMaterial.TONNEROLIUM, EquipmentSlotType.LEGS, new Item.Properties().group(ModItemGroup.GOOFY_GROUP)));

    public static final RegistryObject<Item> TONNEROLIUM_CHESTPLATE = ITEMS.register("tonnerolium_chestplate",
            () -> new ArmorItem(ModArmorMaterial.TONNEROLIUM, EquipmentSlotType.CHEST, new Item.Properties().group(ModItemGroup.GOOFY_GROUP)));

    public static final RegistryObject<Item> TONNEROLIUM_HELMET = ITEMS.register("tonnerolium_helmet",
            () -> new ArmorItem(ModArmorMaterial.TONNEROLIUM, EquipmentSlotType.HEAD, new Item.Properties().group(ModItemGroup.GOOFY_GROUP)));




    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }

}
