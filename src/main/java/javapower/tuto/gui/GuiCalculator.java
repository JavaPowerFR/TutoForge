package javapower.tuto.gui;

import java.io.IOException;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

public class GuiCalculator extends GuiScreen
{
	GuiButton k0 = new GuiButton(0, 0, 0, 20, 20, "0");
	GuiButton k1 = new GuiButton(1, 20, 0, 20, 20, "1");
	GuiButton k2 = new GuiButton(2, 40, 0, 20, 20, "2");
	GuiButton k3 = new GuiButton(3, 0, 20, 20, 20, "3");
	GuiButton k4 = new GuiButton(4, 20, 20, 20, 20, "4");
	GuiButton k5 = new GuiButton(5, 40, 20, 20, 20, "5");
	GuiButton k6 = new GuiButton(6, 0, 40, 20, 20, "6");
	GuiButton k7 = new GuiButton(7, 20, 40, 20, 20, "7");
	GuiButton k8 = new GuiButton(8, 40, 40, 20, 20, "8");
	GuiButton k9 = new GuiButton(9, 0, 60, 20, 20, "9");
	
	GuiButton ka = new GuiButton(11, 70, 0, 20, 20, "+");
	GuiButton kb = new GuiButton(12, 70, 20, 20, 20, "-");
	GuiButton kc = new GuiButton(13, 70, 40, 20, 20, "/");
	GuiButton kd = new GuiButton(14, 70, 60, 20, 20, "*");
	GuiButton ke = new GuiButton(15, 70, 80, 20, 20, "=");
	GuiButton kf = new GuiButton(16, 70, 100, 20, 20, "C");
	
	int a, b, op, r;
	
	public GuiCalculator()
	{
		
	}
	
	@Override
	public void initGui()
	{
		buttonList.clear();
		buttonList.add(k0);
		buttonList.add(k1);
		buttonList.add(k2);
		buttonList.add(k3);
		buttonList.add(k4);
		buttonList.add(k5);
		buttonList.add(k6);
		buttonList.add(k7);
		buttonList.add(k8);
		buttonList.add(k9);
		buttonList.add(ka);
		buttonList.add(kb);
		buttonList.add(kc);
		buttonList.add(kd);
		buttonList.add(ke);
		buttonList.add(kf);
		
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks)
	{
		super.drawScreen(mouseX, mouseY, partialTicks);
		if(op == 0)
		{
			drawString(fontRenderer, ""+a, 100, 10, 0xffff00);
		}
		else
		{
			if(r == 0)
			{
				drawString(fontRenderer, ""+a+"+-/*".charAt(op-1)+b, width/2, height/2, 0xffff00);
			}
			else
			{
				drawString(fontRenderer, ""+a+"+-/*".charAt(op-1)+b+"="+r, 100, 10, 0xffff00);
			}
		}
	}
	
	@Override
	public void updateScreen()
	{
		super.updateScreen();
		k0.x = width/2;
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException
	{
		if(button.id == 16)
		{
			op = 0;
			a = 0;
			b = 0;
			r = 0;
			
		}
		else if(button.id >= 0 && button.id <= 10)
		{
			if(op == 0)
			{
				a = a*10 + button.id;
			}
			else
			{
				b = b*10 + button.id;
			}
		}
		else if(button.id >= 11 && button.id <= 14)
		{
			op = button.id - 10;
		}
		else if(button.id == 15)
		{
			if(op == 1)
				r = a + b;
			else if(op == 2)
				r = a - b;
			else if(op == 3)
				r = a / b;
			else if(op == 4)
				r = a * b;
			
		}
	}
	
	@Override
	public boolean doesGuiPauseGame()
	{
		return false;
	}
}
