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
	/*构造出  一般的，具有指定初始化内容以及列数的文本框*/
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
	/*构造出  特殊的,具有指定初始化内容，列数，字体的文本框*/
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
