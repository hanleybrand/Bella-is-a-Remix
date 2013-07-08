/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DITextures;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.Configuration;

/**
 *
 * @author Home
 */
public class TextureInfo {

    public static final String TexLoc = "/DITextures/";
    public static final String frameName = TexLoc + "DIFrameSkin.png";
    public static final String typeIconsName = TexLoc + "DITypeIcons.png";
    public static final String damageName = TexLoc + "damage.png";
    public static final String healthName = TexLoc + "health.png";
    public static final String backgroundName = TexLoc + "background.png";
    public static final String NamePlateName = TexLoc + "NamePlate.png";
    public static final String leftPotionName = TexLoc + "leftPotions.png";
    public static final String rightPotionName = TexLoc + "rightPotions.png";
    public static final String centerPotionName = TexLoc + "centerPotions.png";
    public static int healthBarHeight;
    public static int healthBarX;
    public static int healthBarY;
    public static int healthBarWidth;
    public static int frameHeight;
    public static int frameX;
    public static int frameY;
    public static int frameWidth;
    public static int backgroundHeight;
    public static int backgroundX;
    public static int backgroundY;
    public static int backgroundWidth;
    public static int NamePlateHeight;
    public static int NamePlateX;
    public static int NamePlateY;
    public static int NamePlateWidth;
    public static int MobPreviewOffsetX;
    public static int MobPreviewOffsetY;
    public static int MobTypeOffsetX;
    public static int MobTypeOffsetY;
    public static int MobTypeSizeX;
    public static int MobTypeSizeY;
    public static int PotionBoxOffsetX;
    public static int PotionBoxOffsetY;
    public static int PotionBoxSidesWidth;
    public static int PotionBoxHeight;

    public static void load(Minecraft mc) {
        MinecraftForgeClient.preloadTexture(frameName);
        MinecraftForgeClient.preloadTexture(typeIconsName);
        MinecraftForgeClient.preloadTexture(damageName);
        MinecraftForgeClient.preloadTexture(healthName);
        MinecraftForgeClient.preloadTexture(backgroundName);
        MinecraftForgeClient.preloadTexture(NamePlateName);
        MinecraftForgeClient.preloadTexture(leftPotionName);
        MinecraftForgeClient.preloadTexture(rightPotionName);
        MinecraftForgeClient.preloadTexture(centerPotionName);
        InputStream cfg;
        File file = new File("skin.cfg");
        try {
            file.createNewFile();
            cfg = mc.texturePackList.getSelectedTexturePack().getResourceAsStream(TexLoc + "skin.cfg");
            FileOutputStream fos = new FileOutputStream(file);
            int bite = 0;
            while ((bite = cfg.read()) != -1) {
                fos.write(bite);
            }
            fos.flush();
            fos.close();
            cfg.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        Configuration config = new Configuration(file);
        config.load();
        config.addCustomCategoryComment("Skin config", "Skin configuration");
        TextureInfo.healthBarHeight = config.get("Skin config", "HealthBarHeight", 8).getInt(8);
        TextureInfo.healthBarWidth = config.get("Skin config", "HealthBarWidth", 89).getInt(89);
        TextureInfo.healthBarX = config.get("Skin config", "HealthBarXOffset", 49).getInt(49);
        TextureInfo.healthBarY = config.get("Skin config", "HealthBarYOffset", 27).getInt(27);
        TextureInfo.frameHeight = config.get("Skin config", "FrameHeight", 155).getInt(155);
        TextureInfo.frameWidth = config.get("Skin config", "FrameWidth", 75).getInt(75);
        TextureInfo.frameX = config.get("Skin config", "FrameXOffset", -15).getInt(-15);
        TextureInfo.frameY = config.get("Skin config", "FrameYOffset", -5).getInt(-5);
        TextureInfo.backgroundHeight = config.get("Skin config", "BackgroundHeight", 65).getInt(65);
        TextureInfo.backgroundWidth = config.get("Skin config", "BackgroundWidth", 48).getInt(48);
        TextureInfo.backgroundX = config.get("Skin config", "BackgroundXOffset", 1).getInt(1);
        TextureInfo.backgroundY = config.get("Skin config", "BackgroundYOffset", -5).getInt(-5);
        TextureInfo.NamePlateHeight = config.get("Skin config", "NamePlateHeight", 13).getInt(13);
        TextureInfo.NamePlateWidth = config.get("Skin config", "NamePlateWidth", 85).getInt(80);
        TextureInfo.NamePlateX = config.get("Skin config", "NamePlateXOffset", 52).getInt(52);
        TextureInfo.NamePlateY = config.get("Skin config", "NamePlateYOffset", 13).getInt(13);
        TextureInfo.MobPreviewOffsetX = config.get("Skin config", "MobPreviewOffsetX", 0).getInt(0);
        TextureInfo.MobPreviewOffsetY = config.get("Skin config", "MobPreviewOffsetY", 0).getInt(0);
        TextureInfo.MobTypeOffsetX = config.get("Skin config", "MobTypeOffsetX", 7).getInt(7);
        TextureInfo.MobTypeOffsetY = config.get("Skin config", "MobTypeOffsetY", 40).getInt(40);
        TextureInfo.MobTypeSizeX = config.get("Skin config", "MobTypeSizeX", 12).getInt(12);
        TextureInfo.MobTypeSizeY = config.get("Skin config", "MobTypeSizeY", 12).getInt(12);
        TextureInfo.PotionBoxOffsetX = config.get("Skin config", "PotionBoxOffsetX", 49).getInt(49);
        TextureInfo.PotionBoxOffsetY = config.get("Skin config", "PotionBoxOffsetY", 27).getInt(27);
        TextureInfo.PotionBoxSidesWidth = config.get("Skin config", "PotionBoxSidesWidth", 4).getInt(4);
        TextureInfo.PotionBoxHeight = config.get("Skin config", "PotionBoxHeight", 8).getInt(8);
        file.delete();
    }
}
