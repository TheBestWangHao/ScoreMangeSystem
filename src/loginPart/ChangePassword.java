package loginPart;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import toolPart.BuildDialog;
import toolPart.BuildJButton;
import toolPart.BuildJLabel;
import toolPart.BuildJTextField;
import toolPart.BuildPwTf;
import toolPart.DataBaseConnect;

public class ChangePassword extends JFrame
{
	JPanel p=new JPanel();
	JLabel accountLabel,passwordLabel,newpassWordLabel;
	JTextField accountTF;
	JPasswordField passwordF,newpassWordF;
	JButton but;
	JFrame jf;
	public ChangePassword()
	{
		jf=this;
		this.setTitle("�޸�����");
		p.setLayout(new FlowLayout());
		accountLabel=new BuildJLabel("Ҫ�޸ĵ��˺�").getLabel();
		passwordLabel=new BuildJLabel("���˺ž�����").getLabel();
		newpassWordLabel=new BuildJLabel("���˺�������").getLabel();
		accountTF=new BuildJTextField("������15λ��������",new Font("",Font.PLAIN,20),22).getTextField();
		passwordF=new  BuildPwTf(16).getPasswordField();
		newpassWordF=new  BuildPwTf(16).getPasswordField();
		p.add(accountLabel);
		p.add(accountTF);
		p.add(passwordLabel);
		p.add(passwordF);
		p.add(newpassWordLabel);
		p.add(newpassWordF);
		but=new BuildJButton("ȷ ��").getButton();
		but.setPreferredSize(new Dimension(80, 40));
		p.add(but);
		this.setContentPane(p);
		this.setVisible(true);
		this.setSize(550,210);
		this.setLocation(500,300);
		checkPart();
	}
	public void checkPart()
	{
		but.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e)
			{
				if(isRigth())
				{
					String sql;
					java.sql.Connection con=new DataBaseConnect().getConnection();
					java.sql.PreparedStatement pstatement=null;
					sql="update admain set password = ? where account = ?";
					try
					{
						pstatement=con.prepareStatement(sql);
						pstatement.setString(1, String.valueOf(newpassWordF.getPassword()));
						pstatement.setString(2, accountTF.getText());
						pstatement.executeUpdate();
						JOptionPane jop=new JOptionPane("�޸ĳɹ���");
						jop.showMessageDialog(null,"�޸ĳɹ�");
						jf.setVisible(false);
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
						catch (SQLException a) 
						{
							a.printStackTrace();
						}
						try 
						{
							con.close();
						} 
						catch (SQLException a) 
						{
							a.printStackTrace();
						}
					}
				}
				else
				{
					JOptionPane jop=new JOptionPane("�˺Ż���������޸�ʧ�ܣ�");
					jop.showMessageDialog(null,"�˺Ż���������޸�ʧ�ܣ�");
				}
			}
		});
	}
	public boolean isRigth()
	{
		String sql;
		sql="select *from admain where account=? and password=?";
		java.sql.Connection con=new DataBaseConnect().getConnection();
		java.sql.PreparedStatement pstatement=null;
		try
		{
		pstatement=con.prepareStatement(sql);
		pstatement.setString(1, accountTF.getText());
		pstatement.setString(2, String.valueOf(passwordF.getPassword()));
		ResultSet rs=pstatement.executeQuery();
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
