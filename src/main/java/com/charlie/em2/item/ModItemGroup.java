package com.charlie.em2.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup
{
    public static final ItemGroup EM2Group = new ItemGroup("em2Tab")
    {
        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(ModItems.TEST.get());
        }
    };
}
