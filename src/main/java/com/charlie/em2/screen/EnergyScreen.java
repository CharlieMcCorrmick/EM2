package com.charlie.em2.screen;

import com.charlie.em2.EM2;
import com.charlie.em2.container.EnergyContainer;
import com.charlie.em2.container.QuarryOneContainer;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class EnergyScreen extends ContainerScreen<EnergyContainer>
{
    private final ResourceLocation GUI = new ResourceLocation(EM2.MOD_ID,
            "textures/gui/quarry_one_gui.png");

    public EnergyScreen(EnergyContainer screenContainer, PlayerInventory inv, ITextComponent titleIn)
    {
        super(screenContainer, inv, titleIn);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(MatrixStack matrixStack, float partialTicks, int x, int y)
    {

    }
}
