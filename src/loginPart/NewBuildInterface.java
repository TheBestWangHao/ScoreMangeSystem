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
		newBuildFrame=new BuildFrame("ע�����",570, 350,lay).getFrame();
		actLabel=new BuildLabel("�� ��",f).getLabel();
		mailLabel=new BuildLabel("�� ��",f).getLabel();
		pwLabel=new BuildLabel("�� ��",f).getLabel();
		blankLabel=new BuildLabel("                        ",f).getLabel();
		actTf=new BuildTextField("������20λ�������� ",30).getTextField();
		mailTf=new BuildTextField("����������QQ����", 30).getTextField();
		pwTf=new BuildPwTf("������20λ��������",27).getPasswordField();
		but=new BuildButton("ע��",100,55,new Font("",Font.PLAIN,35)).getButton();
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
					JOptionPane jop=new JOptionPane("�޸ĳɹ���");
					jop.showMessageDialog(null,"�޸ĳɹ�");
				}
				else
				{
					sql="insert into admain VALUES(?,?,?)";
					pstatement=con.prepareStatement(sql);
					pstatement.setString(1,actTf.getText());
					pstatement.setString(2,String.valueOf(pwTf.getPassword()));
					pstatement.setString(3, mailTf.getText());
					pstatement.executeUpdate();
					JOptionPane jop=new JOptionPane("�޸ĳɹ���");
					jop.showMessageDialog(null,"�޸ĳɹ�");
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
 