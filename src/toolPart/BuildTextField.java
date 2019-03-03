package toolPart;

import java.awt.Font;
import java.awt.TextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BuildTextField 
{
	TextField tf;
	int time=0;
	/*构造出  一般的，具有指定初始化内容以及列数的文本框*/
	public BuildTextField(String text,int columns)
	{
		Font f=new Font("",Font.PLAIN,20);
		tf=new TextField(" "+text+" ",columns);
		tf.setFont(f);
		action();
		tf.setVisible(true);
	}
	/*构造出  特殊的,具有指定初始化内容，列数，字体的文本框*/
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
