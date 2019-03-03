package loginPart;

import java.awt.Button;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ctrlpart.CtrlInterface;
import ctrlpart.StudentInf;
import toolPart.BuildButton;
import toolPart.BuildDialog;
import toolPart.BuildFrame;
import toolPart.BuildJLabel;
import toolPart.BuildJTextField;
import toolPart.BuildLabel;
import toolPart.BuildPwTf;
import toolPart.BuildTextField;
import toolPart.DataBaseConnect;

public class LoginInterface 
{
	Frame loginFrame;
	Label actLabel,pWLabel,headLabel,blankLabel1;
	JLabel changePasswordLabel,blankLabel;
	JTextField actTf;
	JPasswordField pWTf;
	Button loginBut,newBuildBut;
	Connection con;
	PreparedStatement pstatement;
	ResultSet rs;
	Dialog notfoundDialog;
	public LoginInterface() 
	{
		headLabel=new BuildLabel("                   个人成绩管理系统                                   ",new Font("",Font.BOLD,30)).getLabel();
		headLabel.setForeground(Color.GRAY);
		changePasswordLabel=new BuildJLabel("修改密码点此处").getLabel();
		changePasswordLabel.setFont(new Font("",Font.PLAIN,15));
		changePasswordLabel.setForeground(Color.RED);
		blankLabel=new JLabel("                                                             ");
		FlowLayout lay=new FlowLayout(FlowLayout.LEFT);
		lay.setHgap(25);
		lay.setVgap(25);
		loginFrame=new BuildFrame("登录界面",200,100,lay).getFrame();
		loginFrame.addWindowListener(new WindowAdapter() 
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		loginFrame.setSize(600,300);
		loginFrame.setLocation(500, 300);
		actLabel=new BuildLabel("账 号 :",new Font("楷体",Font.BOLD,20)).getLabel();
		pWLabel=new BuildLabel("密 码 :",new Font("楷体",Font.BOLD,20)).getLabel();
		pWTf=new  BuildPwTf(16).getPasswordField();
		actTf=new  BuildJTextField(" ",new Font("",Font.PLAIN,20),22).getTextField();
		loginBut=new BuildButton("登 录").getButton();
		newBuildBut=new BuildButton("注 册 账 号").getButton();
		loginFrame.add(headLabel);
		
		loginFrame.add(actLabel);
		loginFrame.add(actTf);
		loginFrame.add(newBuildBut);
		loginFrame.add(pWLabel);
		loginFrame.add(pWTf);
		loginFrame.add(loginBut);
		loginFrame.add(blankLabel);
		loginFrame.add(changePasswordLabel);
		loginFrame.setVisible(true); 
		action();
	}
	public void action()
	{
		loginBut.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				if(isRigth())
				{
					String sql="select *from student";
					con=new DataBaseConnect().getConnection();
					try
					{
						Statement statement=con.createStatement();
						ResultSet rs=statement.executeQuery(sql);
						if(!rs.next())
						{
							Dialog d=new BuildDialog(loginFrame, "您尚未录入基本信息，请在信息录入界面中输入相应信息！").getDialog();
							new StudentInf();
						}
						else
						new CtrlInterface();
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
						}
						catch(SQLException s)
						{
							s.printStackTrace();
						}
					}
				}
				else
				{
					JOptionPane pan=new JOptionPane("账号或密码错误，登录失败！");
					pan.showMessageDialog(null,"账号或密码错误，登录失败！");
				}
			}
		});
		changePasswordLabel.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e)
			{
				new ChangePassword();
			}
		});
		newBuildBut.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				new NewBuildInterface();
			}
		});
	}
	public boolean isRigth()
	{
		String sql;
		sql="select *from admain where account= ? and password=?";
		con=new DataBaseConnect().getConnection();
		try
		{
		pstatement=con.prepareStatement(sql);
		pstatement.setString(1, actTf.getText());
		pstatement.setString(2, String.valueOf(pWTf.getPassword()));
		rs=pstatement.executeQuery();
		if(rs.next())
			return true;
		else
			return false;
		}
		catch(SQLException s)
		{
			s.printStackTrace();
		}
		finally 
		{
			try 
			{
				pstatement.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			try 
			{
				con.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return false;
	}
}
