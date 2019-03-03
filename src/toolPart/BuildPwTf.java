package toolPart;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPasswordField;

public class BuildPwTf 
{
	JPasswordField pf;
	int time=0;
	public BuildPwTf(int column)
	{
		pf=new JPasswordField(column);
		pf.setText("");
		Font f=new Font("",Font.PLAIN,25);
		pf.setFont(f);
		pf.setVisible(true);
		action();
	}
	public BuildPwTf(String text,int column)
	{
		pf=new JPasswordField(text,column);
		pf.setEchoChar('\0');
		Font f=new Font("¿¬Ìå",Font.PLAIN,25);
		pf.setFont(f);
		pf.setVisible(true);
		action();
	}
	public void action()
	{
		pf.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e)
			{
				time++;
				if(time==1)
				{
					pf.setText("");
					pf.setEchoChar('*');
				}
			}
		});
	}
	public JPasswordField getPasswordField()
	{
		return pf;
	}
}
