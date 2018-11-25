package javapower.tuto.proxy;

import javapower.tuto.block.ModBlocks;
import javapower.tuto.core.ModCore;
import javapower.tuto.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLLoadEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class CommonProxy
{
	
    public void preInit(FMLPreInitializationEvent event)
    {
    	MinecraftForge.EVENT_BUS.register(this);
    	ModBlocks.registerTE();
    	NetworkRegistry.INSTANCE.registerGuiHandler(ModCore.INSTANCE, new GuiHandlerTuto());
    }
    
    public void init(FMLInitializationEvent event)
    {
    	
    }
    
    public void postInit(FMLPostInitializationEvent event)
    {
    	
    }
    
    public void load(FMLLoadEvent event)
    {
    	
    }
    
    @SubscribeEvent
    public void registerBlocks(RegistryEvent.Register<Block> event)
    {
    	ModBlocks.registerBlocks(event.getRegistry());
    }
    
    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> event)
    {
    	ModBlocks.registerItems(event.getRegistry());
    	ModItems.registerItems(event.getRegistry());
    }
}
