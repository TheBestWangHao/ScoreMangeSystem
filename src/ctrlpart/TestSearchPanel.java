package ctrlpart;

import javax.swing.JFrame;
import javax.swing.JPanel;

import toolPart.BuildJFrame;

public class TestSearchPanel 
{

	public static void main(String[] args)
	{
		JFrame jf;
		JPanel jp;
		jf=new BuildJFrame("",1000, 800).getFrame();
		jp=new SearchPane(jf).getJPane();
		jf.setContentPane(jp);
		jf.setVisible(true);
	}
}
