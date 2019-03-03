package toolPart;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.Font;

public class BuildButton
{
	Button but;
	/*构造出一般的，具有  指定内容  的  按钮*/
	public BuildButton(String text)
	{
		but=new Button(text);
		but.setFont(new Font("",Font.PLAIN,12));
		Dimension dim=new Dimension(65, 35);
		but.setPreferredSize(dim);
		but.setVisible(true);
	}
	/*构造出   特殊的  具有  指定大小   以及  内容  的按钮*/
	public BuildButton(String text,int length,int height)
	{
		but=new Button(text);
		but.setFont(new Font("",Font.PLAIN,12));
		Dimension dim=new Dimension(length, height);
		but.setPreferredSize(dim);
		but.setVisible(true);
	}
	/*构造出   特殊的  具有指定  大小，内容，字体   的按钮*/
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
