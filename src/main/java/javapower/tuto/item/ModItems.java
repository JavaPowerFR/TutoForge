package javapower.tuto.item;

import javapower.tuto.core.ModCore;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems
{
	public static final Item item_stoneStick = new ItemStoneStick();
	public static final Item item_calculator = new ItemCalculator();
	
	public static void registerItems(IForgeRegistry<Item> register)
    {
    	register.register(item_stoneStick);
    	register.register(item_calculator);
    }
	
	@SideOnly(Side.CLIENT)
	public static void registerModels()
	{
		ModelLoader.setCustomModelResourceLocation(item_stoneStick, 0, new ModelResourceLocation(ModCore.MODID+":stonestick"));
		ModelLoader.setCustomModelResourceLocation(item_calculator, 0, new ModelResourceLocation(ModCore.MODID+":calculator"));
		
	}
}
