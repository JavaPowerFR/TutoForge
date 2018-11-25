package javapower.tuto.block;

import javapower.tuto.core.ModCore;
import javapower.tuto.tileentity.TileEntityKeyPad;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class BlockKeyPad extends BlockBaseContainer
{

	public BlockKeyPad()
	{
		super(Material.IRON);
		setRegistryName("keypad");
		setUnlocalizedName("keypad");
		setCreativeTab(ModCore.creativeTabs);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta)
	{
		return new TileEntityKeyPad();
	}

	@Override
	public Item getItem()
	{
		if(thisItem == null)
		{
			thisItem = new ItemBlock(this);
			thisItem.setRegistryName("keypad");
		}
		return thisItem;
	}
	
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state)
	{
		return EnumBlockRenderType.MODEL;
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{
		TileEntity te = worldIn.getTileEntity(pos);
		
		if(worldIn.isRemote || !(te instanceof TileEntityKeyPad))
			return true;
		
		int x = (((int)(64 - hitX*64))-12)/14;
		
		if(x <= 2 && (64 - hitX*64) >= 12)
		{
			int y = (((int)(64 - hitY*64))-5)/14;
			
			if(y <= 3 && (64 - hitY*64) >= 5)
			{
				int num = (x+1)+(y*3);
				
				if(num == 12)
				{
					playerIn.sendMessage(new TextComponentString("value: "+((TileEntityKeyPad)te).val));
				}
				else
				{
					((TileEntityKeyPad)te).eventButton(num);
				}
			}
		}
		
		return true;
		
	}

}
