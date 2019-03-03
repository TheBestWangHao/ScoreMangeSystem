package ctrlpart;

import java.awt.Dimension;
import java.awt.ScrollPane;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import toolPart.DataBaseConnect;

public class LookPanel 
{
	Connection con;
	ResultSet rs;
	Statement statement;
	JScrollPane p;
	JPanel completePane;
	JTable jt;
	DefaultTableModel dm;
	String sql;
	public LookPanel()
	{
		completePane=new JPanel();
		Vector<String> name=new Vector<>();
		Vector<Vector<Object>> listVector=new Vector<>();
		con=new DataBaseConnect().getConnection();
		sql="select *from score order by grade ASC";
		try
		{
			statement=con.createStatement();
			rs=statement.executeQuery(sql);
			name.add("年级");
			name.add("数学成绩");
			name.add("英语成绩");
			name.add("专业成绩");
			name.add("体育成绩");
			name.add("音乐成绩");
			name.add("思修成绩");
			while(rs.next())
			{
				Vector<Object> data=new Vector<>();
				data.add(rs.getString(1));
				data.add(rs.getInt(2));
				data.add(rs.getInt(3));
				data.add(rs.getInt(4));
				data.add(rs.getInt(5));
				data.add(rs.getInt(6));
				data.add(rs.getInt(7));
				listVector.add(data);
			}
			dm=new DefaultTableModel(listVector,name);
			jt=new JTable(dm);
			p=new JScrollPane(jt);
			p.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			p.setPreferredSize(new Dimension(1200,750));
			p.setVisible(true);
			completePane.add(p);
			completePane.setVisible(true);
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
	}
	public DefaultTableModel getTableModel()
	{
		return dm;
	}
	public JPanel getPane()
	{
		return completePane;
	}

}
