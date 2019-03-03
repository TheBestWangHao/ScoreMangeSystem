package toolPart;

import java.awt.Frame;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class BuildJFrame 
{
	JFrame f;
	/*构造具有指定标题以及指定大小的不可视的Frame */
	public BuildJFrame(String tittle,int length,int height) 
	{
		f=new JFrame(tittle);
		f.setBounds(((Toolkit.getDefaultToolkit().getScreenSize().width)/2)-480, ((Toolkit.getDefaultToolkit().getScreenSize().height)/2)-450,length,height);//Toolkit.getDefaultToolkit().getScreenSize().width是获取屏幕的宽度，Toolkit.getDefaultToolkit().getScreenSize().height是获取屏幕的高度
		f.setResizable(false);
		f.addWindowListener(new WindowAdapter() 
		{
			public void windowClosing(WindowEvent e)
			{
				f.setVisible(false);
			}
		});
	}
	public JFrame getFrame()
	{
		return f;
	}
}
