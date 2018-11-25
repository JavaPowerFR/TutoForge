package javapower.tuto.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public abstract class BlockBaseContainer extends BlockContainer
{
	Item thisItem;
	
	public BlockBaseContainer(Material materialIn)
	{
		super(materialIn);
	}
	
	public abstract Item getItem();

}
