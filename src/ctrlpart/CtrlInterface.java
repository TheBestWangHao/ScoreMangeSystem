package ctrlpart;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import toolPart.BuildJButton;
import toolPart.BuildJFrame;

public class CtrlInterface 
{
	JFrame f;
	JPanel p,lookPanel,searchPanel,addPanel,changePanel,deletePanel,butPanel,frameP,labelPanel;
	JButton lookBut,searchBut,changeBut,deleteBut,addBut;
	JLabel timeLabel;
	CardLayout card;
	/*�������½����½�����߼���
	 * �� ɾ �� �� �ԣ��������ť����ӵ���butPanel��,���������ť����Ӧ�Ĺ��ܽ��棬����ӵ���p�ϣ���p�ǿ�Ƭʽ���֡�
	 * Ȼ��p����ӵ���frameP�ϣ�frameP��Y��ĺ�ʽ���֣�����������ΪJFrame����ֱ������setLayout����˶������frameP��ʵ��Ŀ��
	 * Jframe�Ĵ�С�����ҽ����ֶ��ڶ������õģ�BuildJframeδ�ܳɹ����á�
	 */
	public CtrlInterface() 
	{
		timeLabel=new JLabel();
		f=new BuildJFrame("�������", 1200, 900).getFrame();
		f.addWindowListener(new WindowAdapter() 
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		card=new CardLayout();
		p=new JPanel();
		frameP=new JPanel();
		butPanel=new JPanel();
		lookPanel=new LookPanel().getPane();
		lookPanel.setPreferredSize(new Dimension(1200, 1200));
		labelPanel=new LabelPanel().getPanel();
		searchPanel=new SearchPane(f).getJPane();
		addPanel=new AddPanel(f).getJPanel();
		changePanel=new ChangePane(f).getJPane();
		deletePanel=new DeletePanel(f).getJPanel();
		lookBut=new BuildJButton("��ʾ",80,40).getButton();
		searchBut=new BuildJButton("��ѯ",80,40).getButton();
		addBut=new BuildJButton("����",80,40).getButton();
		deleteBut=new BuildJButton("ɾ��",80,40).getButton();
		changeBut=new BuildJButton("�޸�",80,40).getButton();
		p.setLayout(card);
		butPanel.add(lookBut);
		butPanel.add(addBut);
		butPanel.add(deleteBut);
		butPanel.add(changeBut);
		butPanel.add(searchBut);
		Thread t=new Thread(new TimeSet());
		t.start();
		p.add(lookPanel,"��ʾ");	
		p.add(addPanel,"����");
		p.add(deletePanel,"ɾ��");
		p.add(changePanel,"�޸�");
		p.add(searchPanel,"��ѯ");
		frameP.setLayout(new BoxLayout(frameP,BoxLayout.Y_AXIS));
		frameP.add(butPanel);
		frameP.add(labelPanel);
		frameP.add(p);
		p.setSize(1000,600);
		p.setVisible(true);
		frameP.setVisible(true);
		f.setContentPane(frameP);
		f.setVisible(true);
		cardAction();
	}
	public void cardAction()
	{
		lookBut.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				lookPanel=new LookPanel().getPane();
				p.remove(lookPanel);
				p.add(lookPanel,"��ʾ");
				card.show(p,"��ʾ");
			}
		});
		searchBut.addActionListener(new ActionListener()
		{	
			@Override
			public void actionPerformed(ActionEvent e)
			{
				searchPanel=new SearchPane(f).getJPane();
				p.remove(searchPanel);
				p.add(searchPanel,"��ѯ");
				card.show(p,"��ѯ");
			}
		});
		addBut.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				addPanel=new AddPanel(f).getJPanel();
				p.remove(addPanel);
				p.add(addPanel,"����");
				card.show(p,"����");
			}
		});
		deleteBut.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				deletePanel=new DeletePanel(f).getJPanel();
				p.remove(deletePanel);
				p.add(deletePanel,"ɾ��");
				card.show(p,"ɾ��");
			}
		});
		changeBut.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				changePanel=new ChangePane(f).getJPane();
				p.remove(changePanel);
				p.add(changePanel,"�޸�");
				changePanel=new ChangePane(f).getJPane();
				card.show(p,"�޸�");
			}
		});
	}
	private class TimeSet implements Runnable
	{
		public void run()
		{
			for(int i=1;i>0;)
			{
				java.util.Date date=new java.util.Date();
				SimpleDateFormat smDate=new SimpleDateFormat("yyyy-MM-dd");
				String time=smDate.format(date);
				timeLabel.setText("                  ʱ��:      "+time);
				timeLabel.setVisible(true);
				butPanel.add(timeLabel);
			}
		}
	}
}

