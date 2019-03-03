package toolPart;

import java.awt.Font;
import java.awt.Label;

public class BuildLabel 
{
	Label label;
	/*此构造方法生成有指定内容的常用字体的，可视的。label*/
	public BuildLabel(String include)
	{
		Font f=new Font("",Font.PLAIN,20);
		label=new Label(include);
		label.setFont(f);
		label.setVisible(true);
	}
	/*此构造方法生成具有指定内容的，指定字体的,可视的。label*/
	public BuildLabel(String include,Font f)
	{
		label=new Label(include);
		label.setFont(f);
		label.setVisible(true);
	}
	public Label getLabel()
	{
		return label;
	}
}
