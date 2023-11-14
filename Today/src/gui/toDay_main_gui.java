package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.OSMTileFactoryInfo;
import org.jxmapviewer.input.CenterMapListener;
import org.jxmapviewer.input.PanKeyListener;
import org.jxmapviewer.input.PanMouseInputListener;
import org.jxmapviewer.input.ZoomMouseWheelListenerCursor;
import org.jxmapviewer.viewer.DefaultTileFactory;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.TileFactoryInfo;

public class toDay_main_gui extends JFrame{
	public startP startP = null;
	public startP selectP = null;
    public int category = -1;
    public int menuType = -1;
    public int temperature = -1;
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
	
	ImageIcon backgroundImage = new ImageIcon("./back_Image/start_bak_ver.1.png");

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
		
		JLabel backgroundLabel = new JLabel();
        backgroundLabel.setIcon(backgroundImage);
        backgroundLabel.setSize(840,630);
        backgroundLabel.setLocation(0, 0);
        add(backgroundLabel);

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
    ImageIcon backgroundImage = new ImageIcon("./back_Image/select_bak_ver.1.png");
     
    
    public selectP1(toDay_main_gui main) {
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
        
        western = new JButton(btn1_2);
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
        
        JLabel backgroundLabel = new JLabel();
        backgroundLabel.setIcon(backgroundImage);
        backgroundLabel.setSize(840,630);
        backgroundLabel.setLocation(0, 0);
        add(backgroundLabel);
        
        korean.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 추가: SelectP2 패널을 화면에 추가
                setVisible(false);
                main.getContentPane().add(new selectP2(main, 0)); // 0은 한식 카테고리를 나타냅니다.
                main.revalidate();
                main.repaint();
            }
        });

        western.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 추가: SelectP2 패널을 화면에 추가
                setVisible(false);
                main.getContentPane().add(new selectP2(main, 1)); // 1은 양식 카테고리를 나타냅니다.
                main.revalidate();
                main.repaint();
            }
        });

        chinese.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 추가: SelectP2 패널을 화면에 추가
                setVisible(false);
                main.getContentPane().add(new selectP2(main, 2)); // 2은 중식 카테고리를 나타냅니다.
                main.revalidate();
                main.repaint();
            }
        });

        japanese.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 추가: SelectP2 패널을 화면에 추가
                setVisible(false);
                main.getContentPane().add(new selectP2(main, 3)); // 3은 일식 카테고리를 나타냅니다.
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
	    ImageIcon backgroundImage = new ImageIcon("./back_Image/select_bak_ver.1.png");
	 
	 public selectP2(toDay_main_gui main, int category) {
	        this.main = main;
	        setLayout(null);
	         
	        rice  = new JButton(btn1_1);
	        rice.setRolloverIcon(btn1_1_1);
	        rice.setBorderPainted(false);
	        rice.setSize(130, 70);
	        rice.setLocation(145, 240);
	        rice.setContentAreaFilled(false);
	        rice.setVisible(true);
	        add(rice);
	        
	        bread  = new JButton(btn1_2);
	        bread.setRolloverIcon(btn1_2_1);
	        bread.setBorderPainted(false);
	        bread.setSize(130, 70);
	        bread.setLocation(355, 240);
	        bread.setContentAreaFilled(false);
	        bread.setVisible(true);
	        add(bread);
	        
	        noodle  = new JButton(btn1_3);
	        noodle.setRolloverIcon(btn1_3_1);
	        noodle.setBorderPainted(false);
	        noodle.setSize(130, 70);
	        noodle.setLocation(565, 240);
	        noodle.setContentAreaFilled(false);
	        noodle.setVisible(true);
	        add(noodle);
	        
	        JLabel backgroundLabel = new JLabel();
	        backgroundLabel.setIcon(backgroundImage);
	        backgroundLabel.setSize(840,630);
	        backgroundLabel.setLocation(0, 0);
	        add(backgroundLabel);
	        
	        rice.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // 추가: SelectP3 패널을 화면에 추가
	                setVisible(false);
	                main.getContentPane().add(new selectP3(main, category, 0)); // 0은 밥 메뉴를 나타냅니다.
	                main.revalidate();
	                main.repaint();
	            }
	        });

	        bread.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // 추가: SelectP3 패널을 화면에 추가
	                setVisible(false);
	                main.getContentPane().add(new selectP3(main, category, 1)); // 1은 빵 메뉴를 나타냅니다.
	                main.revalidate();
	                main.repaint();
	            }
	        });

	        noodle.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // 추가: SelectP3 패널을 화면에 추가
	                setVisible(false);
	                main.getContentPane().add(new selectP3(main, category, 2)); // 2는 면 메뉴를 나타냅니다.
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
	    ImageIcon backgroundImage = new ImageIcon("./back_Image/select_bak_ver.1.png");
	 
	 public selectP3(toDay_main_gui main, int category, int menuType) {
	        this.main = main;
	        setLayout(null);
	         
	        hot  = new JButton(btn1_1);
	        hot.setRolloverIcon(btn1_1_1);
	        hot.setBorderPainted(false);
	        hot.setSize(130, 70);
	        hot.setLocation(210, 240);
	        hot.setContentAreaFilled(false);
	        hot.setVisible(true);
	        add(hot);
	        
	        cold  = new JButton(btn1_2);
	        cold.setRolloverIcon(btn1_2_1);
	        cold.setBorderPainted(false);
	        cold.setSize(130, 70);
	        cold.setLocation(500, 240);
	        cold.setContentAreaFilled(false);
	        cold.setVisible(true);
	        add(cold);
	        
	        JLabel backgroundLabel = new JLabel();
	        backgroundLabel.setIcon(backgroundImage);
	        backgroundLabel.setSize(840,630);
	        backgroundLabel.setLocation(0, 0);
	        add(backgroundLabel);
	        
	        hot.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // 추가: SelectP1 패널을 화면에 추가
	            	setVisible(false);
	                main.getContentPane().add(new result(main, category, menuType, 0));
	                main.revalidate();
	                main.repaint();
	            }
	        });
	        cold.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // 추가: SelectP1 패널을 화면에 추가
	            	setVisible(false);
	                main.getContentPane().add(new result(main, category, menuType, 1));
	                main.revalidate();
	                main.repaint();
	            }
	        });

	        
	    }

 }
 class result extends JPanel {
	    private toDay_main_gui main;
	    private JButton add;
	    private JLabel resultLabel;

	    public result(toDay_main_gui main, int category, int menuType, int temperature) {
	        this.main = main;
	        setLayout(null);


	        resultLabel = new JLabel("추천 메뉴: " + getRecommendedMenu(main, category, menuType, temperature));
	        resultLabel.setSize(1000, 50);
	        resultLabel.setLocation(350, 90);
	        add(resultLabel);
	        
	        ImageIcon backgroundImage = new ImageIcon("./back_Image/result_bak.png");
	        
	        JLabel backgroundLabel = new JLabel();
	        backgroundLabel.setIcon(backgroundImage);
	        backgroundLabel.setSize(840,630);
	        backgroundLabel.setLocation(0, -15);
	        add(backgroundLabel);
	    }
	    
	    private void initMap() {
	        JXMapViewer mapViewer = new JXMapViewer();

	        // TileFactoryInfo 설정
	        TileFactoryInfo info = new OSMTileFactoryInfo();
	        DefaultTileFactory tileFactory = new DefaultTileFactory(info);
	        mapViewer.setTileFactory(tileFactory);

	        // 초기 위치 설정
	        GeoPosition initPosition = new GeoPosition(37.5665, 126.9780); // 예시로 서울 시청 좌표 사용
	        mapViewer.setAddressLocation(initPosition);

	        // 이벤트 리스너 추가
	        mapViewer.addMouseListener(new CenterMapListener(mapViewer));
	        mapViewer.addMouseMotionListener(new PanMouseInputListener(mapViewer));
	        mapViewer.addMouseWheelListener(new ZoomMouseWheelListenerCursor(mapViewer));
	        mapViewer.addKeyListener(new PanKeyListener(mapViewer));

	        // 지도 크기 및 위치 설정
	        mapViewer.setSize(542, 332); // 크기 설정
	        mapViewer.setLocation(15, 247); // 위치 설정

	        this.add(mapViewer);
	    }
	    

	    private String getRecommendedMenu(toDay_main_gui main, int category, int menuType, int temperature) {
	        Random random = new Random();
	        String recommendedMenu = "국밥";
	        
	        
	        initMap(); // 지도 초기화 메서드 호출
	        
	        
	        String[] koreanRiceHotMenu = {"국밥", "김치찌개", "된장찌개"};
	        String[] koreanRiceCoolMenu = {"비빔밥", "찬물에 밥"};
	        String[] koreanBreadHotMenu = {"꽈배기", "찹쌀도넛", "찐빵", "떡볶이"};
	        String[] koreanBreadCoolMenu = {"호두파이"};
	        String[] koreanNoodleHotMenu = {"잔치국수", "칼국수"};
	        String[] koreanNoodleCoolMenu = {"물냉면", "비빔냉면"};
	        
	        String[] westernRiceHotMenu = {"리소토", "크림 스프"};
	        String[] westernRiceCoolMenu = {"리소토"};
	        String[] westernBreadHotMenu = {"피자", "햄버거"};
	        String[] westernBreadCoolMenu = {"파이", "햄버거"};
	        String[] westernNoodleHotMenu = {"스파게티", "라자냐"};
	        String[] westernNoodleCoolMenu = {"파스타 샐러드"};
	        
	        String[] ChineseRiceHotMenu = {"마파두부 덮밥", "짬뽕밥", "짜장밥", "마라탕"};
	        String[] ChineseRiceCoolMenu = {"볶음밥"};
	        String[] ChineseBreadHotMenu = {"만두", "꽃빵"};
	        String[] ChineseBreadCoolMenu = {"만두", "꽃빵"};
	        String[] ChineseNoodleHotMenu = {"짜장면", "짬뽕", "울면"};
	        String[] ChineseNoodleCoolMenu = {"중국 냉면", "냉짬뽕"};

	        String[] JapaneseRiceHotMenu = {"오야코동", "규동", "돈까스", "오므라이스"};
	        String[] JapaneseRiceCoolMenu = {"초밥"};
	        String[] JapaneseBreadHotMenu = {"타코야끼", "오코노미야끼"};
	        String[] JapaneseBreadCoolMenu = {"타코야끼", "당고", "만쥬"};
	        String[] JapaneseNoodleHotMenu = {"우동", "온소바", "라멘"};
	        String[] JapaneseNoodleCoolMenu = {"냉소바"};


	       if(category == 0) {
	                if (menuType == 0) {
	                	// 밥 메뉴
	                    if (temperature == 0) {
	                    	// 뜨거움
		                    recommendedMenu = koreanRiceHotMenu[random.nextInt(koreanRiceHotMenu.length)];
	                    }
	                    else if(temperature == 1) {
	                    	// 차가움
		                    recommendedMenu = koreanRiceCoolMenu[random.nextInt(koreanRiceCoolMenu.length)];
	                    }
	                } 
	                else if (menuType == 1) {
	                    // 빵 메뉴
	                    if ( temperature == 0) {
	                    	// 뜨거움
		                    recommendedMenu = koreanBreadHotMenu[random.nextInt(koreanBreadHotMenu.length)];
	                    }
	                    else if( temperature == 1) {
	                    	// 차가움
		                    recommendedMenu = koreanBreadCoolMenu[random.nextInt(koreanBreadCoolMenu.length)];
	                    }
	                }
	                else if ( menuType == 2) {
	                    // 면 메뉴
	                    if ( temperature == 0) {
	                    	// 뜨거움
		                    recommendedMenu = koreanNoodleHotMenu[random.nextInt(koreanNoodleHotMenu.length)];
	                    }
	                    else if( temperature == 1) {
	                    	// 차가움
		                    recommendedMenu = koreanNoodleCoolMenu[random.nextInt(koreanNoodleCoolMenu.length)];
	                    }
	                }
	       }
	       else if( category==1) {
	                if ( menuType == 0) {
	                    // 밥 메뉴
	                    if ( temperature == 0) {
	                    	// 뜨거움
		                    recommendedMenu = westernRiceHotMenu[random.nextInt(westernRiceHotMenu.length)];
	                    }
	                    else if( temperature == 1) {
	                    	// 차가움
		                    recommendedMenu = westernRiceCoolMenu[random.nextInt(westernRiceCoolMenu.length)];
	                    }
	                } 
	                else if ( menuType == 1) {
	                    // 빵 메뉴
	                    if ( temperature == 0) {
	                    	// 뜨거움
		                    recommendedMenu = westernBreadHotMenu[random.nextInt(westernBreadHotMenu.length)];
	                    }
	                    else if( temperature == 1) {
	                    	// 차가움
		                    recommendedMenu = westernBreadCoolMenu[random.nextInt(westernBreadCoolMenu.length)];
	                    }
	                }
	                else if ( menuType == 2) {
	                    // 면 메뉴
	                    if ( temperature == 0) {
	                    	// 뜨거움
		                    recommendedMenu = westernNoodleHotMenu[random.nextInt(westernNoodleHotMenu.length)];
	                    }
	                    else if( temperature == 1) {
	                    	// 차가움
		                    recommendedMenu = westernNoodleCoolMenu[random.nextInt(westernNoodleCoolMenu.length)];
	                    }
	                }
	       }
	       else if( category == 2) {
	            	if ( menuType == 0) {
	                    // 밥 메뉴
	                    if ( temperature == 0) {
	                    	// 뜨거움
		                    recommendedMenu = ChineseRiceHotMenu[random.nextInt(ChineseRiceHotMenu.length)];
	                    }
	                    else if( temperature == 1) {
	                    	// 차가움
		                    recommendedMenu = ChineseRiceCoolMenu[random.nextInt(ChineseRiceCoolMenu.length)];
	                    }
	                } 
	                else if ( menuType == 1) {
	                    // 빵 메뉴
	                    if ( temperature == 0) {
	                    	// 뜨거움
		                    recommendedMenu = ChineseBreadHotMenu[random.nextInt(ChineseBreadHotMenu.length)];
	                    }
	                    else if( temperature == 1) {
	                    	// 차가움
		                    recommendedMenu = ChineseBreadCoolMenu[random.nextInt(ChineseBreadCoolMenu.length)];
	                    }
	                }
	                else if ( menuType == 2) {
	                    // 면 메뉴
	                    if ( temperature == 0) {
	                    	// 뜨거움
		                    recommendedMenu = ChineseNoodleHotMenu[random.nextInt(ChineseNoodleHotMenu.length)];
	                    }
	                    else if( temperature == 1) {
	                    	// 차가움
		                    recommendedMenu = ChineseNoodleCoolMenu[random.nextInt(ChineseNoodleCoolMenu.length)];
	                    }
	                }
	       }
	       else if( category == 3) {
	                if ( menuType == 0) {
	                    // 밥 메뉴
	                    if ( temperature == 0) {
	                    	// 뜨거움
		                    recommendedMenu = JapaneseRiceHotMenu[random.nextInt(JapaneseRiceHotMenu.length)];
	                    }
	                    else if( temperature == 1) {
	                    	// 차가움
		                    recommendedMenu = JapaneseRiceCoolMenu[random.nextInt(JapaneseRiceCoolMenu.length)];
	                    }
	                } 
	                else if ( menuType == 1) {
	                    // 빵 메뉴
	                    if ( temperature == 0) {
	                    	// 뜨거움
		                    recommendedMenu = JapaneseBreadHotMenu[random.nextInt(JapaneseBreadHotMenu.length)];
	                    }
	                    else if( temperature == 1) {
	                    	// 차가움
		                    recommendedMenu = JapaneseBreadCoolMenu[random.nextInt(JapaneseBreadCoolMenu.length)];
	                    }
	                }
	                else if ( menuType == 2) {
	                    // 면 메뉴
	                    if ( temperature == 0) {
	                    	// 뜨거움
		                    recommendedMenu = JapaneseNoodleHotMenu[random.nextInt(JapaneseNoodleHotMenu.length)];
	                    }
	                    else if( temperature == 1) {
	                    	// 차가움
		                    recommendedMenu = JapaneseNoodleCoolMenu[random.nextInt(JapaneseNoodleCoolMenu.length)];
	                    }
	                } 
	       }

	        return recommendedMenu;
	    }
	}
 
 