package net.teamfruit.nubecraft;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JLabel;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkCheckHandler;
import cpw.mods.fml.relauncher.Side;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class NubeCraft {
	@Instance(Reference.MODID)
	public static NubeCraft instance;

	@NetworkCheckHandler
	public boolean checkModList(final Map<String, String> versions, final Side side) {
		return true;
	}

	private static int w;
	private static int h;
	private static int i;
	private static int l;

	@EventHandler
	public void preInit(final FMLPreInitializationEvent event) {
		final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		w = screenSize.width;
		h = screenSize.height;
		l = w/280;
		new Thread() {
			@Override
			public void run() {
				while (true) {
					final JFrame frame = new JFrame("ヌベヂョンですか？");
					final JLabel label = new JLabel("└(՞ةڼ◔)」");
					label.setFont(new Font("Serif", Font.PLAIN, 64));
					frame.add(label);
					if (w/280>i)
						i++;
					final int x = i+280<w-280 ? i+280 : 0;
					final int y = i+150<h-150 ? i+150 : i/l;
					frame.setBounds(new Rectangle(x, y, 280, 150));
					frame.setVisible(true);
					i++;
					try {
						sleep(10);
					} catch (final InterruptedException e) {
						throw new RuntimeException("ヌベヂョンヌゾジョンベルミッティスモゲロンボョｗｗｗｗ");
					}
				}
			}
		}.start();
	}

	@EventHandler
	public void init(final FMLInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(this);
	}

	@EventHandler
	public void postInit(final FMLPostInitializationEvent event) {

	}
}
