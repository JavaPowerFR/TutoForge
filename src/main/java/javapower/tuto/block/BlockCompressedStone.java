package javapower.tuto.block;

import java.text.MessageFormat;

import io.netty.handler.codec.redis.SimpleStringRedisMessage;
import javapower.tuto.core.ModCore;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class BlockCompressedStone extends BlockBase
{

	public BlockCompressedStone()
	{
		super(Material.ROCK);
		setRegistryName("compressedstone");
		setUnlocalizedName("compressedstone");
		setCreativeTab(ModCore.creativeTabs);
		setHardness(2.0f);
		setResistance(12.0f);
		setLightLevel(1f);
	}

	@Override
	public Item getItem()
	{
		if(thisItem == null)
		{
			thisItem = new ItemBlock(this);
			thisItem.setRegistryName("compressedstone");
		}
		return thisItem;
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{
		if(!worldIn.isRemote)
		{
			playerIn.sendMessage(new TextComponentString("onBlockActivated"));
		}
		return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
	}
	
	@Override
	public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn)
	{
		if(!worldIn.isRemote)
		{
			entityIn.sendMessage(new TextComponentString("onEntityWalk"));
		}
		super.onEntityWalk(worldIn, pos, entityIn);
	}
	
	@Override
	public void onFallenUpon(World worldIn, BlockPos pos, Entity entityIn, float fallDistance)
	{
		if(!worldIn.isRemote)
		{
			entityIn.sendMessage(new TextComponentString("onFallen Upon "+fallDistance));
		}
		entityIn.fall(fallDistance, 10.0F);
	}
	
}
