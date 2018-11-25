package javapower.tuto.block;

import javapower.tuto.core.ModCore;
import javapower.tuto.tileentity.TileEntityKeyPad;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

public class ModBlocks
{
	public static final BlockBase block_compressedStone = new BlockCompressedStone();
	public static final BlockBaseContainer block_keypad = new BlockKeyPad();
	
	public static void registerBlocks(IForgeRegistry<Block> register)
    {
		register.register(block_compressedStone);
		register.register(block_keypad);
    }
	
	public static void registerItems(IForgeRegistry<Item> register)
    {
		register.register(block_compressedStone.getItem());
		register.register(block_keypad.getItem());
    }
	
	@SideOnly(Side.CLIENT)
	public static void registerModels()
	{
		ModelLoader.setCustomModelResourceLocation(block_compressedStone.getItem(), 0, new ModelResourceLocation(ModCore.MODID+":compressedstone", "normal"));
		ModelLoader.setCustomModelResourceLocation(block_keypad.getItem(), 0, new ModelResourceLocation(ModCore.MODID+":keypad", "normal"));
	}
	
	public static void registerTE()
	{
		GameRegistry.registerTileEntity(TileEntityKeyPad.class, "keypad");
	}
}
