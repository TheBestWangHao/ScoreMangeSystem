package ctrlpart;

import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import toolPart.BuildDialog;
import toolPart.BuildJButton;
import toolPart.BuildJLabel;
import toolPart.BuildJTextField;
import toolPart.DataBaseConnect;

public class AddPanel 
{
	JScrollPane jsp;
	JTextField mathTF,englishTF,majorTF,physicalTF,musicTF,thinkTF,gradeTF;
	JLabel mathLabel,englishLabel,majorLabel,physicalLabel,musicLabel,thinkLabel,gradeLabel,blankLabel1,blankLabel2,blankLabel3,blankLabel4,blankLabel5,blankLabel6;
	JButton finishBut;
	JTable jt;
	JPanel jp,lastP;
	JFrame f;
	public AddPanel(JFrame f) 
	{
		f=this.f;
		jt=new JTable(new LookPanel().getTableModel());
		jp=new JPanel();
		lastP=new JPanel();
		lastP.setLayout(new BoxLayout(lastP,BoxLayout.Y_AXIS));
		lastP.setVisible(true);
		blankLabel1=new BuildJLabel("                           ").getLabel();
		blankLabel2=new BuildJLabel("                   ").getLabel();
		blankLabel3=new BuildJLabel("                   ").getLabel();
		blankLabel4=new BuildJLabel("                   ").getLabel();
		blankLabel5=new BuildJLabel("                   ").getLabel();
		blankLabel6=new BuildJLabel("                   ").getLabel();
		mathLabel=new BuildJLabel("��ѧ����:").getLabel();
		englishLabel=new BuildJLabel("Ӣ�����:").getLabel();
		majorLabel=new BuildJLabel("רҵ����:").getLabel();
		physicalLabel=new BuildJLabel("��������:").getLabel();
		musicLabel=new BuildJLabel("���ַ���:").getLabel();
		thinkLabel=new BuildJLabel("˼�޷���:").getLabel();
		gradeLabel=new BuildJLabel("�꼶:").getLabel();
		mathTF=new BuildJTextField("������0-100������",12).getTextField();
		englishTF=new BuildJTextField("������0-100������",12).getTextField();
		majorTF=new BuildJTextField("������0-100������",12).getTextField();
		physicalTF=new BuildJTextField("������0-100������",12).getTextField();
		musicTF=new BuildJTextField("������0-100������",12).getTextField();
		thinkTF=new BuildJTextField("������0-100������",12).getTextField();
		gradeTF=new BuildJTextField("������1-4������",12).getTextField();
		finishBut=new BuildJButton("����").getButton();
		jp.add(gradeLabel);
		jp.add(gradeTF);
		jp.add(blankLabel1);
		jp.add(mathLabel);
		jp.add(mathTF);
		jp.add(blankLabel2);
		jp.add(englishLabel);
		jp.add(englishTF);
//		jp.add(blankLabel3);
		jp.add(majorLabel);
		jp.add(majorTF);
		jp.add(blankLabel4);
		jp.add(physicalLabel);
		jp.add(physicalTF);
		jp.add(blankLabel5);
		jp.add(musicLabel);
		jp.add(musicTF);
//		jp.add(blankLabel6);
		jp.add(thinkLabel);
		jp.add(thinkTF);
		jp.add(finishBut);
		jp.setLayout(new FlowLayout(FlowLayout.LEFT,20,20));
		jp.setPreferredSize(new Dimension(500,400));
		jsp=new JScrollPane(jt);
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jp.setPreferredSize(new Dimension(5,5));
		jsp.setPreferredSize(new Dimension(600,450));
		lastP.add(jp);
		lastP.add(jsp);
		butAction();
	}
	public void butAction()
	{
		finishBut.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				Connection con=null;
				PreparedStatement pstatement=null;
				try
				{
				ResultSet rs;
				String sql="select *from score where grade = ?";
				con=new DataBaseConnect().getConnection();
				pstatement=con.prepareStatement(sql);
				pstatement.setString(1,gradeTF.getText());
				rs=pstatement.executeQuery();
				if(rs.next())
				{
					JOptionPane jop=new JOptionPane("���꼶�Ѵ��ڣ��޸�ʧ�ܣ�");
					jop.showMessageDialog(null,"���꼶�Ѵ��ڣ��޸�ʧ��");
				}
				else
				{
					sql="INSERT INTO score VALUES(?,?,?,?,?,?,?)";
					pstatement=con.prepareStatement(sql);
					pstatement.setString(1,gradeTF.getText());
					pstatement.setInt(2, Integer.parseInt(mathTF.getText()));
					pstatement.setInt(3, Integer.parseInt(englishTF.getText()));
					pstatement.setInt(4, Integer.parseInt(majorTF.getText()));
					pstatement.setInt(5, Integer.parseInt(physicalTF.getText()));
					pstatement.setInt(6, Integer.parseInt(musicTF.getText()));
					pstatement.setInt(7, Integer.parseInt(thinkTF.getText()));
					pstatement.executeUpdate();
					jt.setModel(new LookPanel().getTableModel());
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
		});
	}
	public JScrollPane getJScrollPane()
	{
		return jsp;
	}
	public JPanel getJPanel()
	{
		return lastP;
	}
}
