package javapower.tuto.core;

import javapower.tuto.item.ModItems;
import javapower.tuto.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLLoadEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ModCore.MODID, name = ModCore.NAME, version = ModCore.VERSION)
public class ModCore
{
    public static final String MODID = "tuto";
    public static final String NAME = "Tuto";
    public static final String VERSION = "1.0";
    
    @Instance
	public static ModCore INSTANCE;
    
    @SidedProxy(clientSide = "javapower.tuto.proxy.ClientProxy", serverSide = "javapower.tuto.proxy.CommonProxy")
    public static CommonProxy proxy;
    
    public static CreativeTabs creativeTabs = new CreativeTabs(MODID+".tab1")
    {
		@Override
		public ItemStack getTabIconItem()
		{
			return new ItemStack(ModItems.item_stoneStick);
		}
	};

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	proxy.init(event);
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    	proxy.postInit(event);
    }
    
    @EventHandler
    public void load(FMLLoadEvent event)
    {
    	proxy.load(event);
    }
}
