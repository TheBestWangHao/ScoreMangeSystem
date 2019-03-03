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
		headLabel=new BuildLabel("                   ���˳ɼ�����ϵͳ                                   ",new Font("",Font.BOLD,30)).getLabel();
		headLabel.setForeground(Color.GRAY);
		changePasswordLabel=new BuildJLabel("�޸������˴�").getLabel();
		changePasswordLabel.setFont(new Font("",Font.PLAIN,15));
		changePasswordLabel.setForeground(Color.RED);
		blankLabel=new JLabel("                                                             ");
		FlowLayout lay=new FlowLayout(FlowLayout.LEFT);
		lay.setHgap(25);
		lay.setVgap(25);
		loginFrame=new BuildFrame("��¼����",200,100,lay).getFrame();
		loginFrame.addWindowListener(new WindowAdapter() 
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		loginFrame.setSize(600,300);
		loginFrame.setLocation(500, 300);
		actLabel=new BuildLabel("�� �� :",new Font("����",Font.BOLD,20)).getLabel();
		pWLabel=new BuildLabel("�� �� :",new Font("����",Font.BOLD,20)).getLabel();
		pWTf=new  BuildPwTf(16).getPasswordField();
		actTf=new  BuildJTextField(" ",new Font("",Font.PLAIN,20),22).getTextField();
		loginBut=new BuildButton("�� ¼").getButton();
		newBuildBut=new BuildButton("ע �� �� ��").getButton();
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
							Dialog d=new BuildDialog(loginFrame, "����δ¼�������Ϣ��������Ϣ¼�������������Ӧ��Ϣ��").getDialog();
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
					JOptionPane pan=new JOptionPane("�˺Ż�������󣬵�¼ʧ�ܣ�");
					pan.showMessageDialog(null,"�˺Ż�������󣬵�¼ʧ�ܣ�");
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
