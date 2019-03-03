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
	/*构造出一般的，具有  指定内容  的  按钮*/
	public BuildJButton(String text)
	{
		but=new JButton(text);
		but.setFont(new Font("",Font.PLAIN,12));
		Dimension dim=new Dimension(60, 40);
		but.setPreferredSize(dim);
		but.setVisible(true);
	}
	/*构造出   特殊的  具有  指定大小   以及  内容  的按钮*/
	public BuildJButton(String text,int length,int height)
	{
		but=new JButton(text);
		but.setFont(new Font("",Font.PLAIN,12));
		Dimension dim=new Dimension(length, height);
		but.setPreferredSize(dim);
		but.setVisible(true);
	}
	/*构造出   特殊的  具有指定  大小，内容，字体   的按钮*/
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
