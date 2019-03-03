package toolPart;

import java.awt.Font;
import java.awt.Label;

import javax.swing.JLabel;

public class BuildJLabel
{
	JLabel label;
	/*此构造方法生成有指定内容的常用字体的，可视的。label*/
	public BuildJLabel(String include)
	{
		Font f=new Font("",Font.PLAIN,20);
		label=new JLabel(include);
		label.setFont(f);
		label.setVisible(true);
	}
	/*此构造方法生成具有指定内容的，指定字体的,可视的。label*/
	public BuildJLabel(String include,Font f)
	{
		label=new JLabel(include);
		label.setFont(f);
		label.setVisible(true);
	}
	public JLabel getLabel()
	{
		return label;
	}
}
