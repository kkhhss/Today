package gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class toDay_main_gui extends JFrame{
	public startP startP = null;
	public startP selectP = null;
	public void startframe() {
		getContentPane().add(startP);
	}

	public static void main(String[] args) {
		toDay_main_gui main = new toDay_main_gui();

		main.startP = new startP(main);
		main.startframe();

		main.add(main.startP);

		main.setResizable(false);
		main.setVisible(true);
		main.setPreferredSize(new Dimension(840,840/12*9));
		main.setSize(840,840/12*9);
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.setLocationRelativeTo(null);
		main.setTitle("오늘 뭐 먹지?");
	}

}

class startP extends JPanel{
	private JButton btnStart;
	private JButton  btnchange;

	private toDay_main_gui main;

	ImageIcon startbtn1 = new ImageIcon("./Button_Image/start_button_ver.1.png");
	ImageIcon startbtn1_1 = new ImageIcon("./Button_Image/start_button_check_ver.1.png");
	ImageIcon changebtn1 = new ImageIcon("./Button_Image/change_theme_ver.1.png");
	ImageIcon changebtn1_1 = new ImageIcon("./Button_Image/change_theme_check_ver.1.png");

	public startP(toDay_main_gui main) {
		this.main=main;
		setLayout(null);

		btnStart = new JButton(startbtn1);
		btnStart.setRolloverIcon(startbtn1_1);
		btnStart.setBorderPainted(false);
		btnStart.setSize(130, 57);
		btnStart.setLocation(350, 420);
		btnStart.setContentAreaFilled(false);
		add(btnStart);

		btnchange = new JButton(changebtn1);
		btnchange.setRolloverIcon(changebtn1_1);
		btnchange.setBorderPainted(false);
		btnchange.setSize(130, 57);
		btnchange.setLocation(670, 515);
		btnchange.setContentAreaFilled(false);
		add(btnchange);

		btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 추가: SelectP1 패널을 화면에 추가
            	setVisible(false);
                main.getContentPane().add(new selectP1(main));
                main.revalidate();
                main.repaint();
            }
        });
	}
}
class selectP1 extends JPanel {
    private toDay_main_gui main;
    private JButton korean;
    private JButton western;
    private JButton chinese;
    private JButton japanese;
     
     
    ImageIcon btn1_1 = new ImageIcon("./Button_Image/btn1_1.png");
    ImageIcon btn1_1_1 = new ImageIcon("./Button_Image/btn1_1_1.png");
    ImageIcon btn1_2 = new ImageIcon("./Button_Image/btn1_2.png");
    ImageIcon btn1_2_1 = new ImageIcon("./Button_Image/btn1_2_1.png");
    ImageIcon btn1_3 = new ImageIcon("./Button_Image/btn1_3.png");
    ImageIcon btn1_3_1 = new ImageIcon("./Button_Image/btn1_3_1.png");
    ImageIcon btn1_4 = new ImageIcon("./Button_Image/btn1_4.png");
    ImageIcon btn1_4_1 = new ImageIcon("./Button_Image/btn1_4_1.png");
     
    public selectP1(toDay_main_gui 	main) {
        this.main = main;
        setLayout(null);
         
        korean  = new JButton(btn1_1);
        korean.setRolloverIcon(btn1_1_1);
        korean.setBorderPainted(false);
        korean.setSize(130, 70);
        korean.setLocation(80, 240);
        korean.setContentAreaFilled(false);
        korean.setVisible(true);
        add(korean);
        
        western  = new JButton(btn1_2);
        western.setRolloverIcon(btn1_2_1);
        western.setBorderPainted(false);
        western.setSize(130, 70);
        western.setLocation(260, 240);
        western.setContentAreaFilled(false);
        western.setVisible(true);
        add(western);
        
        chinese  = new JButton(btn1_3);
        chinese.setRolloverIcon(btn1_3_1);
        chinese.setBorderPainted(false);
        chinese.setSize(130, 70);
        chinese.setLocation(440, 240);
        chinese.setContentAreaFilled(false);
        chinese.setVisible(true);
        add(chinese);
        
        japanese  = new JButton(btn1_4);
        japanese.setRolloverIcon(btn1_4_1);
        japanese.setBorderPainted(false);
        japanese.setSize(130, 70);
        japanese.setLocation(620, 240);
        japanese.setContentAreaFilled(false);
        japanese.setVisible(true);
        add(japanese);
        
        korean.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 추가: SelectP1 패널을 화면에 추가
            	setVisible(false);
                main.getContentPane().add(new selectP2(main));
                main.revalidate();
                main.repaint();
            }
        });
        western.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 추가: SelectP1 패널을 화면에 추가
            	setVisible(false);
                main.getContentPane().add(new selectP2(main));
                main.revalidate();
                main.repaint();
            }
        });
        chinese.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 추가: SelectP1 패널을 화면에 추가
            	setVisible(false);
                main.getContentPane().add(new selectP2(main));
                main.revalidate();
                main.repaint();
            }
        });
        japanese.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 추가: SelectP1 패널을 화면에 추가
            	setVisible(false);
                main.getContentPane().add(new selectP2(main));
                main.revalidate();
                main.repaint();
            }
        });
    }
}
 class selectP2 extends JPanel{
	 private toDay_main_gui main;
	 private JButton rice;
	 private JButton bread;
	 private JButton noodle;
	 
	 ImageIcon btn1_1 = new ImageIcon("./Button_Image/btn2_1.png");
	    ImageIcon btn1_1_1 = new ImageIcon("./Button_Image/btn2_1_1.png");
	    ImageIcon btn1_2 = new ImageIcon("./Button_Image/btn2_2.png");
	    ImageIcon btn1_2_1 = new ImageIcon("./Button_Image/btn2_2_1.png");
	    ImageIcon btn1_3 = new ImageIcon("./Button_Image/btn2_3.png");
	    ImageIcon btn1_3_1 = new ImageIcon("./Button_Image/btn2_3_1.png");
	 
	 public selectP2(toDay_main_gui main) {
	        this.main = main;
	        setLayout(null);
	         
	        rice  = new JButton(btn1_1);
	        rice.setRolloverIcon(btn1_1_1);
	        rice.setBorderPainted(false);
	        rice.setSize(130, 70);
	        rice.setLocation(80, 240);
	        rice.setContentAreaFilled(false);
	        rice.setVisible(true);
	        add(rice);
	        
	        bread  = new JButton(btn1_2);
	        bread.setRolloverIcon(btn1_2_1);
	        bread.setBorderPainted(false);
	        bread.setSize(130, 70);
	        bread.setLocation(260, 240);
	        bread.setContentAreaFilled(false);
	        bread.setVisible(true);
	        add(bread);
	        
	        noodle  = new JButton(btn1_3);
	        noodle.setRolloverIcon(btn1_3_1);
	        noodle.setBorderPainted(false);
	        noodle.setSize(130, 70);
	        noodle.setLocation(440, 240);
	        noodle.setContentAreaFilled(false);
	        noodle.setVisible(true);
	        add(noodle);
	        
	        rice.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // 추가: SelectP1 패널을 화면에 추가
	            	setVisible(false);
	                main.getContentPane().add(new selectP3(main));
	                main.revalidate();
	                main.repaint();
	            }
	        });
	        bread.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // 추가: SelectP1 패널을 화면에 추가
	            	setVisible(false);
	                main.getContentPane().add(new selectP3(main));
	                main.revalidate();
	                main.repaint();
	            }
	        });
	        noodle.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // 추가: SelectP1 패널을 화면에 추가
	            	setVisible(false);
	                main.getContentPane().add(new selectP3(main));
	                main.revalidate();
	                main.repaint();
	            }
	        });
	        
	    }
 }
 class selectP3 extends JPanel{
	 private toDay_main_gui main;
	 private JButton hot;
	 private JButton cold;	 
	 
	 ImageIcon btn1_1 = new ImageIcon("./Button_Image/btn3_1.png");
	    ImageIcon btn1_1_1 = new ImageIcon("./Button_Image/btn3_1_1.png");
	    ImageIcon btn1_2 = new ImageIcon("./Button_Image/btn3_2.png");
	    ImageIcon btn1_2_1 = new ImageIcon("./Button_Image/btn3_2_1.png");
	 
	 public selectP3(toDay_main_gui main) {
	        this.main = main;
	        setLayout(null);
	         
	        hot  = new JButton(btn1_1);
	        hot.setRolloverIcon(btn1_1_1);
	        hot.setBorderPainted(false);
	        hot.setSize(130, 70);
	        hot.setLocation(80, 240);
	        hot.setContentAreaFilled(false);
	        hot.setVisible(true);
	        add(hot);
	        
	        cold  = new JButton(btn1_2);
	        cold.setRolloverIcon(btn1_2_1);
	        cold.setBorderPainted(false);
	        cold.setSize(130, 70);
	        cold.setLocation(260, 240);
	        cold.setContentAreaFilled(false);
	        cold.setVisible(true);
	        add(cold);
	        
	        hot.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // 추가: SelectP1 패널을 화면에 추가
	            	setVisible(false);
	                main.getContentPane().add(new result(main));
	                main.revalidate();
	                main.repaint();
	            }
	        });
	        cold.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // 추가: SelectP1 패널을 화면에 추가
	            	setVisible(false);
	                main.getContentPane().add(new result(main));
	                main.revalidate();
	                main.repaint();
	            }
	        });
	        
	    }

 }
 class result extends JPanel{
	 private toDay_main_gui main;
	 private JButton add;
	 
	 public result(toDay_main_gui main) {
		 
	 }
}
 
 