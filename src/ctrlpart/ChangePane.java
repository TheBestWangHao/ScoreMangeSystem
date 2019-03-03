package ctrlpart;

import java.awt.Dialog;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import toolPart.BuildDialog;
import toolPart.BuildJLabel;
import toolPart.DataBaseConnect;

public class ChangePane extends LookPanel
{
	int column,row;
	JPanel p;
	JScrollPane jp;
	JTable jt;
	int endValue,gradeValue;
	String orgValues,endValues;
	JLabel remindLabel;
	JFrame f;
	public ChangePane(JFrame f)
	{
		super();
		jt=super.jt;
		changeAction();
		remindLabel=new BuildJLabel("想要修改某项单元格内容时，请先双击相应单元格，修改其内容即可",new Font("",Font.BOLD,30)).getLabel();
		jp=super.p;
		p=new JPanel();
		p.add(jp);
		p.add(remindLabel);
		p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
		p.setVisible(true);
		f=this.f;
		changeAction();
	}
	public void changeAction()
	{
		jt.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e)
			{
				column=jt.getSelectedColumn();
				row=jt.getSelectedRow();
				orgValues=jt.getValueAt(row, column).toString();
			}
		});
		jt.getModel().addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) 
				{
					String columnName = null;
					try
					{
						Connection con=new DataBaseConnect().getConnection();
						if(column==0)
						{
							PreparedStatement pstatement;
							String sql;
							ResultSet rs;
							endValues=jt.getValueAt(row, column).toString();
							sql="select *from score where grade = ?";
							pstatement=con.prepareStatement(sql);
							pstatement.setString(1,endValues);
							rs=pstatement.executeQuery();
							if(!rs.next())
							{
								sql="update score set grade = ? where grade = ?";
								pstatement=con.prepareStatement(sql);
								pstatement.setString(1,endValues);
								pstatement.setString(2,orgValues);
								pstatement.executeLargeUpdate();
							}
							else
							{
								JOptionPane jop=new JOptionPane("此年级已存在，修改失败");
								jop.showMessageDialog(null,"此年级已存在，修改失败");
								jt.setModel(dm);
							}
						}
						else if(column==-1)
						{
							System.out.println("此处无需注意，仅因为changePane中getColumnName方法出了个-1值！");
						}
						else
						{
							gradeValue=Integer.parseInt(jt.getValueAt(row, 0).toString());
							endValue=Integer.parseInt(jt.getValueAt(row, column).toString());
							switch(column)
							{
								case 0:columnName="grade";break;
								case 1:columnName="mathscore";break;
								case 2:columnName="englishscore";break;
								case 3:columnName="majorscore";break;
								case 4:columnName="physicalscore";break;
								case 5:columnName="musicscore";break;
								case 6:columnName="thinkscore";break;
							}
							String sql="update score set "+columnName+" = ? where grade= ?";
							PreparedStatement pstatement=con.prepareStatement(sql);
							pstatement.setInt(1,endValue);
							pstatement.setInt(2,gradeValue);
							pstatement.executeUpdate();
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
						catch (SQLException e1)
						{
							e1.printStackTrace();
						}
					}
				}
		});
	}
	public JPanel getJPane()
	{
		return p;
	}
}
