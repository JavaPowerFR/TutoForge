package javapower.tuto.item;

import javapower.tuto.core.ModCore;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemCalculator extends Item
{
	public ItemCalculator()
	{
		setRegistryName("calculator");
		setUnlocalizedName("calculator");
		setMaxStackSize(1);
		setCreativeTab(ModCore.creativeTabs);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
	{
		playerIn.openGui(ModCore.MODID, 0, null, 0, 0, 0);
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}
}
