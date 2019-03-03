package ctrlpart;

import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import toolPart.BuildDialog;
import toolPart.BuildJButton;
import toolPart.BuildJFrame;
import toolPart.BuildJLabel;
import toolPart.BuildJTextField;
import toolPart.DataBaseConnect;

public class StudentInf 
{
	java.sql.Connection con;
	java.sql.PreparedStatement pState;
	JFrame stuFrame;
	JPanel stuPanel;
	JTextField name,number,school,college,major,classes;
	JLabel nameL,numberL,schoolL,collegeL,majorL,classesL,blankJLabel;
	JButton certainBut;
	public StudentInf()
	{
		stuFrame=new BuildJFrame("学生信息",370,300).getFrame();
		stuPanel=new JPanel(new FlowLayout(40));
		name=new BuildJTextField(20).getTextField();
		number=new BuildJTextField(20).getTextField();
		school=new BuildJTextField(20).getTextField();
		college=new BuildJTextField(20).getTextField();
		major=new BuildJTextField(20).getTextField();
		classes=new BuildJTextField(20).getTextField();
		nameL=new BuildJLabel("姓 名").getLabel();
		numberL=new BuildJLabel("学 号").getLabel();
		schoolL=new BuildJLabel("学 校").getLabel();
		collegeL=new BuildJLabel("学 院").getLabel();
		classesL=new BuildJLabel("班 级").getLabel();
		majorL=new BuildJLabel("专 业").getLabel();
		blankJLabel=new BuildJLabel("                     ").getLabel();
		certainBut=new BuildJButton("完 成",80,40).getButton();
		stuPanel.add(nameL);
		stuPanel.add(name);
		stuPanel.add(numberL);
		stuPanel.add(number);
		stuPanel.add(schoolL);
		stuPanel.add(school);
		stuPanel.add(collegeL);
		stuPanel.add(college);
		stuPanel.add(majorL);
		stuPanel.add(major);
		stuPanel.add(classesL);
		stuPanel.add(classes);
		stuPanel.add(blankJLabel);
		stuPanel.add(certainBut);
		stuFrame.setContentPane(stuPanel);
		stuFrame.setVisible(true);
		butAction();
	}
	public void butAction()
	{
		certainBut.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e)
			{
				String sql="INSERT INTO student VALUES(?,?,?,?,?,?,?)";
				con=new DataBaseConnect().getConnection();
				if((name.getText().length()>=20)||(name.getText().length()==0)||(number.getText().length()>=20)||(number.getText().length()==0)||(school.getText().length()>=20)||(school.getText().length()==0)||(college.getText().length()>=20)||(college.getText().length()==0)||(major.getText().length()>=20)||(major.getText().length()==0)||(classes.getText().length()>=20)||(classes.getText().length()==0))
				{
					Dialog errorDialog=new BuildDialog(stuFrame, "您输入的格式不对，请重新输入！").getDialog();
				}
				else
				{
					try
					{
						pState=con.prepareStatement(sql);
						pState.setString(1,name.getText());
						pState.setString(2, number.getText());
						pState.setString(3, school.getText());
						pState.setString(4, collegeL.getText());
						pState.setString(5, major.getText());
						pState.setString(6, classes.getText());
						pState.executeLargeUpdate();
						Dialog d=new BuildDialog(stuFrame, "信息录入成功").getDialog();
						stuFrame.setVisible(false);
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
							pState.close();
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
}
