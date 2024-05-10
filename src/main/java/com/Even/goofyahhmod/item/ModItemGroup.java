package com.Even.goofyahhmod.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup
{
    public static final ItemGroup GOOFY_GROUP = new ItemGroup("GoofyAhhTab")
    {

        @Override
        public ItemStack createIcon()
        {

            return new ItemStack(ModItems.TONNEROLIUM.get());
        }

    };
}
