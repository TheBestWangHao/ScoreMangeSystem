package toolPart;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.Font;

public class BuildButton
{
	Button but;
	/*�����һ��ģ�����  ָ������  ��  ��ť*/
	public BuildButton(String text)
	{
		but=new Button(text);
		but.setFont(new Font("",Font.PLAIN,12));
		Dimension dim=new Dimension(65, 35);
		but.setPreferredSize(dim);
		but.setVisible(true);
	}
	/*�����   �����  ����  ָ����С   �Լ�  ����  �İ�ť*/
	public BuildButton(String text,int length,int height)
	{
		but=new Button(text);
		but.setFont(new Font("",Font.PLAIN,12));
		Dimension dim=new Dimension(length, height);
		but.setPreferredSize(dim);
		but.setVisible(true);
	}
	/*�����   �����  ����ָ��  ��С�����ݣ�����   �İ�ť*/
  	public BuildButton(String text,int length,int height,Font f)
	{		
		but=new Button(text);
		but.setFont(f);
		Dimension dim=new Dimension(length, height);
		but.setPreferredSize(dim);
		but.setVisible(true);
		
	}
	public Button getButton()
	{
		return but;
	}
}
