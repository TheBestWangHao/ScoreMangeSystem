package ctrlpart;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import toolPart.BuildDialog;
import toolPart.BuildJButton;
import toolPart.BuildJLabel;
import toolPart.DataBaseConnect;

public class DeletePanel
{
	JScrollPane jsp;
	JPanel deletePanel,lastP;
	JLabel gradeLabel,courseLabel;
	JPopupMenu gradeMenu,courseMenu;
	JMenuItem gi1,gi2,gi3,gi4,allGrade,mathItem,englishItem,majorItem,physicalItem,musicItem,thinkItem,allCourse;
	JButton deleteBut,gradeBut,courseBut;
	String grade=null,course=null;
	JTable jt;
	JFrame f;
	public DeletePanel(JFrame f) 
	{	
		f=this.f;
		DefaultTableModel dm1;
		deletePanel=new JPanel();
		lastP=new JPanel();
		gradeLabel=new BuildJLabel("年纪 ：").getLabel();
		courseLabel=new BuildJLabel("科目 ：").getLabel();
		gi1=new JMenuItem("1年纪");
		gi2=new JMenuItem("2年纪");
		gi3=new JMenuItem("3年纪");
		gi4=new JMenuItem("4年级");
		allGrade=new JMenuItem("全部");
		mathItem=new JMenuItem("数学");
		englishItem=new JMenuItem("英语");
		majorItem=new JMenuItem("专业");
		physicalItem=new JMenuItem("体育");
		musicItem=new JMenuItem("音乐");
		thinkItem=new JMenuItem("思修");
		allCourse=new JMenuItem("全部");
		gradeMenu=new JPopupMenu();
		courseMenu=new JPopupMenu();
		gradeMenu.setPopupSize(100,100);
		courseMenu.setPopupSize(150,150);
		gradeBut=new BuildJButton("年 级",80,30).getButton();
		courseBut=new BuildJButton("科 目",80,30).getButton();
		deleteBut=new BuildJButton("删 除",80,30).getButton();
		gradeMenu.add(gi1);
		gradeMenu.add(gi2);
		gradeMenu.add(gi3);
		gradeMenu.add(gi4);
		gradeMenu.add(allGrade);
		courseMenu.add(mathItem);
		courseMenu.add(englishItem);
		courseMenu.add(majorItem);
		courseMenu.add(physicalItem);
		courseMenu.add(musicItem);
		courseMenu.add(thinkItem);
		courseMenu.add(allCourse);
		deletePanel.add(gradeLabel);
		deletePanel.add(gradeBut);
		deletePanel.add(courseLabel);
		deletePanel.add(courseBut);
		deletePanel.add(deleteBut);
		deletePanel.setPreferredSize(new Dimension(5,5));
		dm1=new LookPanel().getTableModel();
		jt=new JTable(dm1);
		jsp=new JScrollPane(jt);
		jsp.setPreferredSize(new Dimension(670,670));
		jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		lastP.setLayout(new BoxLayout(lastP,BoxLayout.Y_AXIS));
		lastP.add(deletePanel);
		lastP.add(jsp);
		lastP.setVisible(true);
		menuItemAction();
		butAction();
	}
	public void menuItemAction()
	{
		gi1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				grade="1";
				gradeBut.setText("1年纪");
			}
		});
		gi2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				grade="2";
				gradeBut.setText("2年纪");
			}
		});
		gi3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				grade="3";
				gradeBut.setText("3年纪");
			}
		});
		gi4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				grade="4";
				gradeBut.setText("4年纪");
			}
		});
		allGrade.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				grade="*";
				gradeBut.setText("全部");
			}
		});
		mathItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				course="mathscore";
				courseBut.setText("数学");
			}
		});
		englishItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				course="englishscore";
				courseBut.setText("英语");
			}
		});
		majorItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				course="majorscore";
				courseBut.setText("专业");
			}
		});
		physicalItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				course="physicalscore";
				courseBut.setText("体育");
			}
		});
		musicItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				course="musicscore";
				courseBut.setText("音乐");
			}
		});
		thinkItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				course="thinkscore";
				courseBut.setText("思修");
			}
		});
		allCourse.addActionListener(new ActionListener() 
		{	
			@Override
			public void actionPerformed(ActionEvent e)
			{
				course="*";
				courseBut.setText("全部");
			}
		});
	}
	public void butAction()
	{
		gradeBut.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e)
			{
				gradeMenu.show(e.getComponent(), e.getX(), e.getY());
			}
		});
		courseBut.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e)
			{
				courseMenu.show(e.getComponent(), e.getX(), e.getY());
			}
		});
		deleteBut.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				if(grade==null||course==null)
				{
					JOptionPane jop=new JOptionPane("请选择要删除的年级和科目");
					jop.showMessageDialog(null,"修改成功");
				}
				else
				{
					String sql;
					Connection con=new DataBaseConnect().getConnection();
					Statement statement = null;
					if(!grade.equals("*"))
					{
						if(!course.equals("*"))
						{
							sql="UPDATE SCORE SET "+course+" =null WHERE GRADE="+grade+"";
						}
						else
						{
							sql="DELETE FROM SCORE WHERE GRADE ="+grade+"";
						}
					}
					else
					{
						if(!course.equals("*"))
						{
							sql="UPDATE SCORE SET "+course+" =''";
						}
						else
						{
							sql="DELETE FROM SCORE";
						}
					}
					try
					{
						statement=con.createStatement();
						statement.executeUpdate(sql);
						DefaultTableModel dm2=new LookPanel().getTableModel();
						jt.setModel(dm2);
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
						try 
						{
							statement.close();
						} 
						catch (SQLException e1) 
						{
							e1.printStackTrace();
						}
					}
				}
			}
		});
	}
	public JPanel getJPanel()
	{
		return lastP;
	}
}
