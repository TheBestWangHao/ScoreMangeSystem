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
	/*����   ����label��Ϣ   ��������Frame f��Dialog,�˷��������ڹ����   һ��   ��      ��ʾ��Ϣ��*/
	public BuildDialog(Frame f,String text) 
	{
		d=new JDialog(f,false);
		d.setTitle("������ʾ");
		d.setLayout(new FlowLayout(FlowLayout.CENTER,20,35));
		d.setSize(400,180);
		d.setVisible(true);
		label=new BuildLabel(text).getLabel();
		label.setVisible(true);
		but=new BuildButton("ȷ ��").getButton();
		but.setVisible(true);
		d.add(label);
		d.add(but);
		d.setResizable(false);
		d.setVisible(true);
		closeAction();
		d.setLocation(((Toolkit.getDefaultToolkit().getScreenSize().width)/2)-200, ((Toolkit.getDefaultToolkit().getScreenSize().height)/2)-200);
	}
	/*�������   label��Ϣ  �Լ�ָ��    ��С   ��������Frame f��Dialog,�˷��������ڹ����       ����      ��         ��ʾ��Ϣ��*/
	public BuildDialog(Frame f,String text,int length,int height)
	{
		d=new JDialog(f,false);
		d.setTitle("������ʾ");
		d.setLayout(new FlowLayout(FlowLayout.CENTER,20,35));
		d.setSize(length,height);
		label=new BuildLabel(text).getLabel();
		but=new BuildButton("ȷ ��").getButton();
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
