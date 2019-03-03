package toolPart;

import java.awt.Frame;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class BuildFrame
{
	Frame f;
	/*构造具有指定标题以及指定大小的不可视的Frame */
	public BuildFrame(String tittle,int length,int height,LayoutManager lay) 
	{
		f=new Frame(tittle);
		f.setLayout(lay);
		f.setBounds(((Toolkit.getDefaultToolkit().getScreenSize().width)/2)-480, ((Toolkit.getDefaultToolkit().getScreenSize().height)/2)-450,600,600);//Toolkit.getDefaultToolkit().getScreenSize().width是获取屏幕的宽度，Toolkit.getDefaultToolkit().getScreenSize().height是获取屏幕的高度
		f.setSize(length,height);
		f.setResizable(false);
		f.addWindowListener(new WindowAdapter() 
		{
			public void windowClosing(WindowEvent e)
			{
				f.setVisible(false);
			}
		});
	}
	public Frame getFrame()
	{
		return f;
	}
}
