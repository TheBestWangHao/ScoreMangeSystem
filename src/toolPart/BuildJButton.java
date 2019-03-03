package toolPart;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class BuildJButton
{
	JButton but;
	/*�����һ��ģ�����  ָ������  ��  ��ť*/
	public BuildJButton(String text)
	{
		but=new JButton(text);
		but.setFont(new Font("",Font.PLAIN,12));
		Dimension dim=new Dimension(60, 40);
		but.setPreferredSize(dim);
		but.setVisible(true);
	}
	/*�����   �����  ����  ָ����С   �Լ�  ����  �İ�ť*/
	public BuildJButton(String text,int length,int height)
	{
		but=new JButton(text);
		but.setFont(new Font("",Font.PLAIN,12));
		Dimension dim=new Dimension(length, height);
		but.setPreferredSize(dim);
		but.setVisible(true);
	}
	/*�����   �����  ����ָ��  ��С�����ݣ�����   �İ�ť*/
  	public BuildJButton(String text,int length,int height,Font f)
	{		
		but=new JButton(text);
		but.setFont(f);
		Dimension dim=new Dimension(length, height);
		but.setPreferredSize(dim);
		but.setVisible(true);
	}
  	public void action()
  	{
  		but.addMouseListener(new MouseAdapter()
  		{
  			int time=0;
  			public void mouseClicked(MouseEvent e)
  			{
  				time++;
  				if(time==1)
  				but.setText("");
  			}
		});
  	}
	public JButton getButton()
	{
		return but;
	}
}
