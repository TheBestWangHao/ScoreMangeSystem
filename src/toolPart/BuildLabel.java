package toolPart;

import java.awt.Font;
import java.awt.Label;

public class BuildLabel 
{
	Label label;
	/*�˹��췽��������ָ�����ݵĳ�������ģ����ӵġ�label*/
	public BuildLabel(String include)
	{
		Font f=new Font("",Font.PLAIN,20);
		label=new Label(include);
		label.setFont(f);
		label.setVisible(true);
	}
	/*�˹��췽�����ɾ���ָ�����ݵģ�ָ�������,���ӵġ�label*/
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
