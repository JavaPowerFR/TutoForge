package javapower.tuto.item;

import javapower.tuto.core.ModCore;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemStoneStick extends Item
{
	public ItemStoneStick()
	{
		setRegistryName("stonestick");
		setUnlocalizedName("stonestick");
		setMaxStackSize(5);
		setCreativeTab(ModCore.creativeTabs);
	}
	
}
