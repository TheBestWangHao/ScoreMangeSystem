package ctrlpart;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import toolPart.BuildJFrame;

public class TestAddPanel
{

	public static void main(String[] args)
	{
		JFrame f;
		JPanel p;
		f=new BuildJFrame("",1000, 800).getFrame();
		p=new ChangePane(f).getJPane();
		f.setContentPane(p);
		f.setVisible(true);
	}
}
