package toolPart;

import java.awt.Dimension;

import javax.swing.JMenu;
import javax.swing.JPopupMenu;

public class BuildJMenu 
{
	JMenu menu;
	public BuildJMenu(String text)
	{
		Dimension dim=new Dimension(150,80);
		menu=new JMenu(text);
		menu.setSize(125,70);
	}
	public JMenu getMenu()
	{
		return menu;
	}
}
