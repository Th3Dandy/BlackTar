package com.dandy.blacktar;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.Item;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.io.File;
import java.nio.file.Paths;

public class CustomGiveScreen extends Screen {
    private final Item item;
    private final Identifier iconTexture;

    protected CustomGiveScreen(Item item) {
        super(Text.literal("Give Item with Icon"));
        this.item = item;
        this.iconTexture = getIconTexture(item);
    }

    private Identifier getIconTexture(Item item) {
        String itemName = item.getName().getString().replace(" ", "_").toLowerCase();
        String basePath = "assets/black-tar/textures/gui/icons/";
        File iconFile = Paths.get(basePath, itemName + ".png").toFile();

        if (itemName.equalsIgnoreCase("enchanted_book")) {
            return new Identifier("black-tar", "textures/gui/icons/Enchanted_Book.gif");
        }

        if (iconFile.exists()) {
            return new Identifier("black-tar", "textures/gui/icons/" + itemName + ".png");
        } else {
            return new Identifier("black-tar", "textures/gui/icons/default.png");
        }
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
        RenderSystem.setShaderTexture(0, iconTexture);
        context.drawTexture(this.width / 2 - 16, this.height / 2 - 16, 0, 0, 32, 32, 32, 32);
        context.drawText(this.textRenderer, item.getName().getString(), this.width / 2, this.height / 2 + 16, 0xFFFFFF);
    }
}
