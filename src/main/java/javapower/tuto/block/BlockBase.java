package javapower.tuto.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public abstract class BlockBase extends Block
{
	Item thisItem;
	
	public BlockBase(Material materialIn)
	{
		super(materialIn);
	}
	
	public abstract Item getItem();

}
