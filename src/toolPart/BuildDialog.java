package toolPart;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BoxLayout;
import javax.swing.JDialog;

public class BuildDialog 
{
	JDialog d;
	Label label;
	Button but;
	/*构造   具有label信息   的依附于Frame f的Dialog,此方法多用于构造出   一般   的      提示信息！*/
	public BuildDialog(Frame f,String text) 
	{
		d=new JDialog(f,false);
		d.setTitle("错误提示");
		d.setLayout(new FlowLayout(FlowLayout.CENTER,20,35));
		d.setSize(400,180);
		d.setVisible(true);
		label=new BuildLabel(text).getLabel();
		label.setVisible(true);
		but=new BuildButton("确 定").getButton();
		but.setVisible(true);
		d.add(label);
		d.add(but);
		d.setResizable(false);
		d.setVisible(true);
		closeAction();
		d.setLocation(((Toolkit.getDefaultToolkit().getScreenSize().width)/2)-200, ((Toolkit.getDefaultToolkit().getScreenSize().height)/2)-200);
	}
	/*构造具有   label信息  以及指定    大小   的依附于Frame f的Dialog,此方法多用于构造出       特殊      的         提示信息！*/
	public BuildDialog(Frame f,String text,int length,int height)
	{
		d=new JDialog(f,false);
		d.setTitle("错误提示");
		d.setLayout(new FlowLayout(FlowLayout.CENTER,20,35));
		d.setSize(length,height);
		label=new BuildLabel(text).getLabel();
		but=new BuildButton("确 定").getButton();
		d.add(label);
		d.add(but);
		d.setResizable(false);
		d.setVisible(true);
		d.setLocation(((Toolkit.getDefaultToolkit().getScreenSize().width)/2)-200, ((Toolkit.getDefaultToolkit().getScreenSize().height)/2)-200);
		closeAction();
	}
	public void closeAction()
	{
		but.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				d.setVisible(false);
			}
		});
		d.addWindowListener(new WindowAdapter() 
		{
			public void windowClosing(WindowEvent e)
			{
				d.setVisible(false);
			}
		});
	}
	public Dialog getDialog()
	{
		return d;
	}
}
