package toolPart;

import java.awt.Font;
import java.awt.Label;

import javax.swing.JLabel;

public class BuildJLabel
{
	JLabel label;
	/*�˹��췽��������ָ�����ݵĳ�������ģ����ӵġ�label*/
	public BuildJLabel(String include)
	{
		Font f=new Font("",Font.PLAIN,20);
		label=new JLabel(include);
		label.setFont(f);
		label.setVisible(true);
	}
	/*�˹��췽�����ɾ���ָ�����ݵģ�ָ�������,���ӵġ�label*/
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
