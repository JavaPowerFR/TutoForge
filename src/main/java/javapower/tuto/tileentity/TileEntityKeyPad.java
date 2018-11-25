package javapower.tuto.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityKeyPad extends TileEntity
{
	public int val = 0;
	
	public void eventButton(int id)
	{
		if(id == 10)
		{
			val = 0;
		}
		else if(id == 11)
		{
			val = val*10;
		}
		else 
		{
			val = val*10 + id;
		}
		
		if(!world.isRemote)
		{
			markDirty();
		}
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		val = compound.getInteger("val");
		super.readFromNBT(compound);
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound)
	{
		compound.setInteger("val", val);
		return super.writeToNBT(compound);
	}
}
