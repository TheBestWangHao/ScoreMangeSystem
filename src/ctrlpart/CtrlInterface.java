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
	/*我来大致讲述下界面的逻辑：
	 * 增 删 改 查 显，这五个按钮被添加到了butPanel上,而这五个按钮所对应的功能界面，被添加到了p上，而p是卡片式布局。
	 * 然后p被添加到了frameP上，frameP是Y轴的盒式布局，这样做是因为JFrame不能直接用来setLayout，因此额外添加frameP来实现目的
	 * Jframe的大小是由我进行手动第二次设置的，BuildJframe未能成功设置。
	 */
	public CtrlInterface() 
	{
		timeLabel=new JLabel();
		f=new BuildJFrame("管理界面", 1200, 900).getFrame();
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
		lookBut=new BuildJButton("显示",80,40).getButton();
		searchBut=new BuildJButton("查询",80,40).getButton();
		addBut=new BuildJButton("增加",80,40).getButton();
		deleteBut=new BuildJButton("删除",80,40).getButton();
		changeBut=new BuildJButton("修改",80,40).getButton();
		p.setLayout(card);
		butPanel.add(lookBut);
		butPanel.add(addBut);
		butPanel.add(deleteBut);
		butPanel.add(changeBut);
		butPanel.add(searchBut);
		Thread t=new Thread(new TimeSet());
		t.start();
		p.add(lookPanel,"显示");	
		p.add(addPanel,"增加");
		p.add(deletePanel,"删除");
		p.add(changePanel,"修改");
		p.add(searchPanel,"查询");
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
				p.add(lookPanel,"显示");
				card.show(p,"显示");
			}
		});
		searchBut.addActionListener(new ActionListener()
		{	
			@Override
			public void actionPerformed(ActionEvent e)
			{
				searchPanel=new SearchPane(f).getJPane();
				p.remove(searchPanel);
				p.add(searchPanel,"查询");
				card.show(p,"查询");
			}
		});
		addBut.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				addPanel=new AddPanel(f).getJPanel();
				p.remove(addPanel);
				p.add(addPanel,"增加");
				card.show(p,"增加");
			}
		});
		deleteBut.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				deletePanel=new DeletePanel(f).getJPanel();
				p.remove(deletePanel);
				p.add(deletePanel,"删除");
				card.show(p,"删除");
			}
		});
		changeBut.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				changePanel=new ChangePane(f).getJPane();
				p.remove(changePanel);
				p.add(changePanel,"修改");
				changePanel=new ChangePane(f).getJPane();
				card.show(p,"修改");
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
				timeLabel.setText("                  时间:      "+time);
				timeLabel.setVisible(true);
				butPanel.add(timeLabel);
			}
		}
	}
}

