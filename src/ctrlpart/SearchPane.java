package ctrlpart;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.Action;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import toolPart.BuildDialog;
import toolPart.BuildJButton;
import toolPart.BuildJFrame;
import toolPart.BuildJLabel;
import toolPart.BuildJTextField;
import toolPart.DataBaseConnect;

public class SearchPane
{
	JTextField inPutTF1,inPutTF2;
	JLabel blankLabel1,inPutLabel1,inPutLabel2;
	JTable jt;
	JButton jBut,menuBut;			//��jButΪ������ť
	JPopupMenu menu;
	JMenuItem englishItem,mathItem,physicalItem,musicItem,majorItem,thinkItem,gradeItem;
	String target=null,name;					//target��sql�������Ӧ��������name��JTable����ʾ������
	String sql;
	JScrollPane p;
	JPanel tfPane,completePane;			//��tfPane��ӵ�������ģ��,completePane��ӵ���tfPane��p
	Connection con;
	ResultSet rs;
	PreparedStatement pstatement;
	JFrame f;
	public SearchPane(JFrame f)
	{
		f=this.f;
		jt=new JTable(new LookPanel().getTableModel());
		p=new JScrollPane(jt);
		p.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		inPutTF1=new BuildJTextField(5).getTextField();
		inPutTF2=new BuildJTextField(5).getTextField();
		inPutLabel1=new BuildJLabel("��  ���� ").getLabel();
		inPutLabel2=new BuildJLabel("��").getLabel();
		jBut=new BuildJButton("����",100,30).getButton();
		menuBut=new BuildJButton("��ѯ��ʽ",100,30).getButton();
		menu=new JPopupMenu("��ѯ��ʽ");
		menu.setPopupSize(200,200);
		englishItem=new JMenuItem("Ӣ��ɼ���ѯ");
		mathItem=new JMenuItem("��ѧ�ɼ���ѯ");
		physicalItem=new JMenuItem("�����ɼ���ѯ");
		musicItem=new JMenuItem("���ֳɼ���ѯ");
		majorItem=new JMenuItem("רҵ�ɼ���ѯ");
		thinkItem=new JMenuItem("˼�޳ɼ���ѯ");
		gradeItem=new JMenuItem("�꼶��ѯ");
		menu.add(mathItem);
		menu.add(englishItem);
		menu.add(majorItem);
		menu.add(thinkItem);
		menu.add(musicItem);
		menu.add(physicalItem);
		menu.add(gradeItem);
		tfPane=new JPanel(new FlowLayout(FlowLayout.CENTER));
		tfPane.add(inPutTF1);
		tfPane.add(inPutLabel1);
		tfPane.add(inPutTF2);
		tfPane.add(inPutLabel2);
		tfPane.add(menuBut);
		tfPane.add(jBut);
		tfPane.setVisible(true);
		tfPane.setPreferredSize(new Dimension(1000,10));
		p.setPreferredSize(new Dimension(1000, 650));
		p.setVisible(true);
		menuAction();
		buttonAction();
		completePane=new JPanel();
		completePane.setLayout(new BoxLayout(completePane,BoxLayout.Y_AXIS));
		completePane.add(tfPane);		
		completePane.add(p);
		completePane.setVisible(true);

	}
	public void menuAction()
	{
		mathItem.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				inPutLabel1.setText("��  ���� ");
				inPutLabel2.setText("��");
				name="��ѧ����";
				target="mathscore";
				menuBut.setText("��ѧ�ɼ���ѯ");
			}
		});
		englishItem.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				inPutLabel1.setText("��  ���� ");
				inPutLabel2.setText("��");
				System.out.println("meememe");
				name="Ӣ�����";
				target="englishscore";
				menuBut.setText("Ӣ��ɼ���ѯ");
			}
		});
		majorItem.addActionListener(new ActionListener() 
		{	
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				inPutLabel1.setText("��  ���� ");
				inPutLabel2.setText("��");
				name="רҵ����";
				target="majorscore";
				menuBut.setText("רҵ�ɼ���ѯ");
			}
		});
		musicItem.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				inPutLabel1.setText("��  ���� ");
				inPutLabel2.setText("��");
				name="���ַ���";
				target="musicscore";
				menuBut.setText("���ֳɼ���ѯ");
			}
		});
		physicalItem.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{			
				inPutLabel1.setText("��  ���� ");
				inPutLabel2.setText("��");
				name="��������";
				target="physicalscore";
				menuBut.setText("�����ɼ���ѯ");
			}
		});
		thinkItem.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				inPutLabel1.setText("��  ���� ");
				inPutLabel2.setText("��");
				name="˼�޷���";
				target="thinkscore";
				menuBut.setText("˼�޳ɼ���ѯ");
			}
		});
		gradeItem.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				inPutLabel1.setText("���  ���� ");
				inPutLabel2.setText("���");
				name="�꼶����";
				target="grade";
				menuBut.setText("�꼶��ѯ");
			}
		});
		menuBut.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				menu.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	public void buttonAction()
	{

		jBut.addMouseListener(new MouseAdapter() 
		{

			public void mouseClicked(MouseEvent e)
			{	
				if(inPutTF1.getText().equals("")||inPutTF2.getText().equals(""))
				{
					JOptionPane jop=new JOptionPane("���ķ�������δ��������");
					jop.showMessageDialog(null,"���ķ�������δ��������");
				}
				else if(target==null)
				{
					JOptionPane jop=new JOptionPane("��ѡ��Ҫ��ѯ�Ŀ�Ŀ");
					jop.showMessageDialog(null,"��ѡ��Ҫ��ѯ�Ŀ�Ŀ");
				}
				else
				{
					Vector<String> names=new Vector<>();
					Vector<Vector<Object>> listVector=new Vector<>();
					try
					{
					if(!target.equals("grade"))
					{
						DefaultTableModel dm;
						names.add("�꼶");
						names.add(name);
						sql="select grade,"+target+" from score where "+target+" between ? and ? order by grade ASC";
						con=new DataBaseConnect().getConnection();
						pstatement=con.prepareStatement(sql);
						System.out.println(inPutTF1.getText()+inPutTF2.getText());
						pstatement.setInt(1,Integer.parseInt(inPutTF1.getText()));
						pstatement.setInt(2,Integer.parseInt(inPutTF2.getText()));
						rs=pstatement.executeQuery();
						while(rs.next())
						{
							Vector<Object> data=new Vector<>();
							data.add(rs.getString(1));
							data.add(rs.getInt(2));
							listVector.add(data);
						}
						dm=new DefaultTableModel(listVector,names);
						jt.setModel(dm);
						jt.setVisible(true);
					}
					else
					{
						sql="select * from score where grade between ? and ? order by grade ASC";
						con=new DataBaseConnect().getConnection();
						pstatement=con.prepareStatement(sql);
						pstatement.setString(1,inPutTF1.getText());
						pstatement.setString(2, inPutTF2.getText());
						DefaultTableModel dm;
						dm=new LookPanel().getTableModel();
						jt=new JTable(dm);
						p.add(jt);
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
						try 
						{
							pstatement.close();
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
	public JPanel getJPane()
	{
		return completePane;
	}
}


