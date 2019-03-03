package loginPart;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.InterfaceAddress;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import toolPart.BuildButton;
import toolPart.BuildDialog;
import toolPart.BuildFrame;
import toolPart.BuildLabel;
import toolPart.BuildPwTf;
import toolPart.BuildTextField;
import toolPart.DataBaseConnect;

public class NewBuildInterface 
{
	Frame newBuildFrame;
	Label actLabel,mailLabel,pwLabel,blankLabel;
	TextField actTf,mailTf;
	Button but;
	JPasswordField pwTf;
	Connection con;
	PreparedStatement pstatement;
	ResultSet rs;
	public NewBuildInterface()
	{
		Font f=new Font("",Font.BOLD ,20);
		FlowLayout lay=new FlowLayout(FlowLayout.LEFT);
		lay.setHgap(30);
		lay.setVgap(30);
		newBuildFrame=new BuildFrame("注册界面",570, 350,lay).getFrame();
		actLabel=new BuildLabel("帐 号",f).getLabel();
		mailLabel=new BuildLabel("邮 箱",f).getLabel();
		pwLabel=new BuildLabel("密 码",f).getLabel();
		blankLabel=new BuildLabel("                        ",f).getLabel();
		actTf=new BuildTextField("请输入20位以内数字 ",30).getTextField();
		mailTf=new BuildTextField("请输入您的QQ邮箱", 30).getTextField();
		pwTf=new BuildPwTf("请输入20位以内数字",27).getPasswordField();
		but=new BuildButton("注册",100,55,new Font("",Font.PLAIN,35)).getButton();
		newBuildFrame.add(actLabel);
		newBuildFrame.add(actTf);
		newBuildFrame.add(pwLabel);
		newBuildFrame.add(pwTf);
		newBuildFrame.add(mailLabel);
		newBuildFrame.add(mailTf);
		newBuildFrame.add(blankLabel);
		newBuildFrame.add(but);
		newBuildFrame.setVisible(true);
		action();
	}
	public void action()
	{
		but.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e)
			{
				String sql="select *from admain where account=?";
				con=new DataBaseConnect().getConnection();
				try
				{
				pstatement=con.prepareStatement(sql);
				pstatement.setString(1,actTf.getText());
				rs=pstatement.executeQuery();
				if(rs.next())
				{
					JOptionPane jop=new JOptionPane("修改成功！");
					jop.showMessageDialog(null,"修改成功");
				}
				else
				{
					sql="insert into admain VALUES(?,?,?)";
					pstatement=con.prepareStatement(sql);
					pstatement.setString(1,actTf.getText());
					pstatement.setString(2,String.valueOf(pwTf.getPassword()));
					pstatement.setString(3, mailTf.getText());
					pstatement.executeUpdate();
					JOptionPane jop=new JOptionPane("修改成功！");
					jop.showMessageDialog(null,"修改成功");
				}
				}
				catch(SQLException s)
				{
					s.printStackTrace();
				}
				finally
				{
					try
					{
						con.close();
					} catch (SQLException e1) 
					{
						e1.printStackTrace();
					}
					try 
					{
						pstatement.close();
					} catch (SQLException e1) 
					{
						e1.printStackTrace();
					}
				}
			}
		});
	}
}
 