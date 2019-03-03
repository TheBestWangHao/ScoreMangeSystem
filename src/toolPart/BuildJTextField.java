package toolPart;

import java.awt.Font;
import java.awt.TextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;

public class BuildJTextField 
{
	JTextField tf;
	int time=0;
	/*�����  һ��ģ�����ָ����ʼ�������Լ��������ı���*/
	public BuildJTextField(int columns)
	{
		Font f=new Font("",Font.PLAIN,15);
		tf=new JTextField(columns);
		tf.setFont(f);
		action();
		tf.setVisible(true);
	}
	public BuildJTextField(String text,int columns)
	{
		Font f=new Font("",Font.PLAIN,15);
		tf=new JTextField(" "+text+" ",columns);
		tf.setFont(f);
		action();
		tf.setVisible(true);
	}
	/*�����  �����,����ָ����ʼ�����ݣ�������������ı���*/
	public BuildJTextField(String text,Font f,int columns)
	{
		tf=new JTextField(" "+text+" ",columns);
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
	public JTextField getTextField()
	{
		return tf;
	}
}
