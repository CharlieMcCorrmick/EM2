package com.charlie.somegreekbullshit.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup
{
    public static final ItemGroup SGB_GROUP = new ItemGroup("someGreekBullshitTab")
    {
        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(ModItems.TEST.get());
        }
    };
}
