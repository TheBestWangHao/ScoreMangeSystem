package ctrlpart;

import java.awt.FlowLayout;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import loginPart.NewBuildInterface;
import toolPart.BuildDialog;
import toolPart.BuildJLabel;
import toolPart.DataBaseConnect;

public class LabelPanel
{
	Connection con;
	Statement statement;
	ResultSet rs;
	JLabel nameLabel,numberLabel,univerLabel,collegeLabel,majorLabel,classLabel;
	JLabel blank1Label1,blankLabel2,blankLabel3;
	JPanel panel;
	String sql;
	String name,number,university,college,major,classes;
	public LabelPanel()
	{
		FlowLayout flowLayout=new FlowLayout();
		flowLayout.setHgap(40);
		Font t=new Font("",Font.PLAIN,20);
		panel=new JPanel();
		panel.setLayout(flowLayout);
		sql="select name,number,university,college,major,class from student";
		con=new DataBaseConnect().getConnection();
		try
		{
		statement=con.createStatement();
		rs=statement.executeQuery(sql);
		if(rs.next())
		{
			name=rs.getString(1);
			number=rs.getString(2);
			university=rs.getString(3);
			college=rs.getString(4);
			major=rs.getString(5);
			classes=rs.getString(6);
		}
		else
		{
			throw new RuntimeException("������ֲ���Ԥ�ϵ��쳣�����ݿ�����Ϣδ�ܳɹ���ȡ��");
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
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			try 
			{
				statement.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		nameLabel=new BuildJLabel("�� ��: "+name,t).getLabel();
		numberLabel=new BuildJLabel("ѧ ��:  "+number,t).getLabel();
		univerLabel=new BuildJLabel("ѧ У: "+university,t).getLabel();
		collegeLabel=new BuildJLabel("ѧ Ժ: "+college,t).getLabel();
		majorLabel=new BuildJLabel("ר ҵ: "+major,t).getLabel();
		classLabel=new BuildJLabel("�� ��: "+classes,t).getLabel();
		panel.add(nameLabel);
		panel.add(numberLabel);
		panel.add(univerLabel);
		panel.add(collegeLabel);
		panel.add(majorLabel);
		panel.add(classLabel);
		panel.setVisible(true);
	}
	public JPanel getPanel()
	{
		return panel;
	}
}
