package toolPart;

import java.awt.Font;
import java.awt.TextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BuildTextField 
{
	TextField tf;
	int time=0;
	/*�����  һ��ģ�����ָ����ʼ�������Լ��������ı���*/
	public BuildTextField(String text,int columns)
	{
		Font f=new Font("",Font.PLAIN,20);
		tf=new TextField(" "+text+" ",columns);
		tf.setFont(f);
		action();
		tf.setVisible(true);
	}
	/*�����  �����,����ָ����ʼ�����ݣ�������������ı���*/
	public BuildTextField(String text,Font f,int columns)
	{
		tf=new TextField(" "+text+" ",columns);
		tf.setFont(f);
		action();
		tf.setVisible(true);
	}
	public void action()
	{
		tf.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e)
			{
				time++;
				if(time==1)
				tf.setText("");
			}
		});
	}
	public TextField getTextField()
	{
		return tf;
	}
}
