package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.HashMap;
import java.util.Random;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

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
	    private JLabel imageLabel;
	    private HashMap<String, String> menuImages;
	    private HashMap<String, GeoPosition> menuLocations;
	    
	    public result(toDay_main_gui main, int category, int menuType, int temperature) {
	        this.main = main;
	        setLayout(null);
	        
	        // 메뉴 이름과 이미지 파일 경로 매핑
	        menuImages = new HashMap<>();
	        menuImages.put("국밥", "./foodImage/kukbap.jpg");
	        menuImages.put("김치찌개", "./foodImage/kimchiguk.jpg");
	        menuImages.put("된장찌개", "./foodImage/doinjangguk.jpg");
	        menuImages.put("비빔밥", "./foodImage/bibimbap.jpg");
	        menuImages.put("찬물에 밥", "./foodImage/waterbap.jpg");
	        menuImages.put("꽈배기", "./foodImage/gguabagi.jpg");
	        menuImages.put("찹쌀도넛", "./foodImage/chapssaldonut.jpg");
	        menuImages.put("찐빵", "./foodImage/zzinbbang.jpg");
	        menuImages.put("떡볶이", "./foodImage/ddokboggi.jpg");
	        menuImages.put("호두파이", "./foodImage/hodupie.jpg");
	        menuImages.put("잔치국수", "./foodImage/janchiguksu.jpg");
	        menuImages.put("칼국수", "./foodImage/kalguksu.jpg");
	        menuImages.put("물냉면", "./foodImage/waternangmyun.jpg");
	        menuImages.put("비빔냉면", "./foodImage/bibimnangmyun.jpg");
	        
	        menuImages.put("리소토", "./foodImage/risoto.jpg");
	        menuImages.put("크림스프", "./foodImage/creamsoup.jpg");
	        menuImages.put("피자", "./foodImage/pizza.jpg");
	        menuImages.put("햄버거", "./foodImage/hamburger.jpg");
	        menuImages.put("파이", "./foodImage/pie.jpg");
	        menuImages.put("스파게티", "./foodImage/spagetti.jpg");
	        menuImages.put("라자냐", "./foodImage/lazanya.jpg");
	        menuImages.put("파스타 샐러드", "./foodImage/pasta salad.jpg");
	        
	        menuImages.put("마파두부 덮밥", "./foodImage/mapatofu.jpg");
	        menuImages.put("짬뽕밥", "./foodImage/jjambbongbab.jpg");
	        menuImages.put("짜장밥", "./foodImage/jjajangbab.jpg");
	        menuImages.put("마라탕", "./foodImage/maratang.jpg");
	        menuImages.put("볶음밥", "./foodImage/bocembab.jpg");
	        menuImages.put("만두", "./foodImage/mandu.jpg");
	        menuImages.put("꽃빵", "./foodImage/flowerbread.jpg");
	        menuImages.put("짜장면", "./foodImage/jjajangmyun.jpg");
	        menuImages.put("짬뽕", "./foodImage/jjambbong.jpg");
	        menuImages.put("울면", "./foodImage/woolmyun.jpg");
	        menuImages.put("중국 냉면", "./foodImage/chinesecoolnoodle.jpg");
	        menuImages.put("냉짬뽕", "./foodImage/cooljjambbong.jpg");

	        menuImages.put("오야코동", "./foodImage/oyakodong.jpg");
	        menuImages.put("규동", "./foodImage/gyudong.jpg");
	        menuImages.put("돈까스", "./foodImage/dongas.jpg");
	        menuImages.put("오므라이스", "./foodImage/omurice.jpg");
	        menuImages.put("초밥", "./foodImage/susi.jpg");
	        menuImages.put("타코야끼", "./foodImage/tacoyagi.jpg");
	        menuImages.put("오코노미야끼", "./foodImage/oconomeuyagi.jpg");
	        menuImages.put("당고", "./foodImage/dango.jpg");
	        menuImages.put("만쥬", "./foodImage/manjyu.jpg");
	        menuImages.put("우동", "./foodImage/woodong.jpg");
	        menuImages.put("온소바", "./foodImage/hotsoba.jpg");
	        menuImages.put("라멘", "./foodImage/ramen.jpg");
	        menuImages.put("냉소바", "./foodImaege/coolsoba.jpg");

	        // 메뉴 이름과 가게 좌표 매핑
	        menuLocations = new HashMap<>();
	        menuLocations.put("국밥", new GeoPosition(37.47084, 126.933449));
	        menuLocations.put("김치찌개", new GeoPosition(37.469621, 126.934532));
	        menuLocations.put("된장찌개", new GeoPosition(37.469621, 126.934532));
	        menuLocations.put("비빔밥", new GeoPosition(37.470161, 126.93344));
	        menuLocations.put("찬물에 밥", new GeoPosition(37.465969, 126.931406));
	        menuLocations.put("꽈배기", new GeoPosition(37.470871, 126.93411));
	        menuLocations.put("찹쌀도넛", new GeoPosition(37.470871, 126.93411));
	        menuLocations.put("찐빵", new GeoPosition(37.467769, 126.932142));
	        menuLocations.put("떡볶이", new GeoPosition(37.467071, 126.9314));
	        menuLocations.put("호두파이", new GeoPosition(37.470859, 126.933769));
	        menuLocations.put("잔치국수", new GeoPosition(37.47243, 126.93520));
	        menuLocations.put("칼국수", new GeoPosition(37.47243, 126.93520));
	        menuLocations.put("물냉면", new GeoPosition(37.470759, 126.935821));
	        menuLocations.put("비빔냉면", new GeoPosition(37.470759, 126.935821));
	        
	        menuLocations.put("리소토", new GeoPosition(37.470299, 126.934739));
	        menuLocations.put("크림스프", new GeoPosition(37.469931, 126.934271));
	        menuLocations.put("피자", new GeoPosition(37.470159, 126.933438));
	        menuLocations.put("햄버거", new GeoPosition(37.470731, 126.933681));
	        menuLocations.put("파이", new GeoPosition(37.470859, 126.933769));
	        menuLocations.put("스파게티", new GeoPosition(37.470299, 126.934739));
	        menuLocations.put("라자냐", new GeoPosition(37.48137, 126.928521));
	        menuLocations.put("파스타 샐러드", new GeoPosition(37.5665, 126.9780));
	        
	        menuLocations.put("마파두부 덮밥", new GeoPosition(37.468801, 126.93444));
	        menuLocations.put("짬뽕밥", new GeoPosition(37.468801, 126.93444));
	        menuLocations.put("짜장밥", new GeoPosition(37.468801, 126.93444));
	        menuLocations.put("마라탕", new GeoPosition(37.468801, 126.93444));
	        menuLocations.put("볶음밥", new GeoPosition(37.468801, 126.93444));
	        menuLocations.put("만두", new GeoPosition(37.468801, 126.93444));
	        menuLocations.put("꽃빵", new GeoPosition(37.468801, 126.93444));
	        menuLocations.put("짜장면", new GeoPosition(37.468801, 126.93444));
	        menuLocations.put("짬뽕", new GeoPosition(37.468801, 126.93444));
	        menuLocations.put("울면", new GeoPosition(37.468801, 126.93444));
	        menuLocations.put("중국 냉면", new GeoPosition(37.468801, 126.93444));
	        menuLocations.put("냉짬뽕", new GeoPosition(37.468801, 126.93444));

	        menuLocations.put("오야코동", new GeoPosition(37.48207, 126.89762));
	        menuLocations.put("규동", new GeoPosition(37.472109, 126.934981));
	        menuLocations.put("돈까스", new GeoPosition(37.46894, 126.934212));
	        menuLocations.put("오므라이스", new GeoPosition(37.468801, 126.93444));
	        menuLocations.put("초밥", new GeoPosition(37.470419, 126.940348));
	        menuLocations.put("타코야끼", new GeoPosition(37.480031, 126.927861));
	        menuLocations.put("오코노미야끼", new GeoPosition(37.46858, 126.937751));
	        menuLocations.put("당고", new GeoPosition(37.451848, 126.902003));
	        menuLocations.put("만쥬", new GeoPosition(37.476441, 126.868402));
	        menuLocations.put("우동", new GeoPosition(37.47014, 126.937561));
	        menuLocations.put("온소바", new GeoPosition(37.477649, 126.963799));
	        menuLocations.put("라멘", new GeoPosition(37.468631, 126.936809));
	        menuLocations.put("냉소바", new GeoPosition(37.477649, 126.963799));
	        
	        resultLabel = new JLabel();
	        resultLabel.setSize(1000, 50);
	        resultLabel.setLocation(350, 90);
	        add(resultLabel);
	        
	        // 이미지 레이블 크기 설정
	        int imageLabelWidth = 235;
	        int imageLabelHeight = 250;

	        imageLabel = new JLabel();
	        imageLabel.setSize(imageLabelWidth, imageLabelHeight);
	        // 이미지 레이블 위치 설정 (예: 패널 중앙에 위치시키기)
	        imageLabel.setLocation(574, 255); // 적절한 위치 설정
	        add(imageLabel);

	        // 추천 메뉴 결정
	        String recommendedMenu = getRecommendedMenu(main, category, menuType, temperature);
	        resultLabel.setText("추천 메뉴: " + recommendedMenu);
	        
	        // 메뉴에 따라 지도 위치 초기화
	        GeoPosition position = menuLocations.getOrDefault(recommendedMenu, new GeoPosition(37.5665, 126.9780));
	        initMap(position); // 여기서 위치 정보를 전달

	        // 메뉴에 맞는 이미지 파일 경로 설정
	        String imagePath = menuImages.getOrDefault(recommendedMenu, "./foodImage/example.jpg");
	        
	        // 이미지 중앙 부분을 잘라내어 표시
	        try {
	            BufferedImage originalImage = ImageIO.read(new File(imagePath));
	            BufferedImage croppedImage = cropImageCenter(originalImage, imageLabelWidth, imageLabelHeight);
	            imageLabel.setIcon(new ImageIcon(croppedImage));
	        } catch (IOException e) {
	            e.printStackTrace();
	            // 오류 처리
	        }
	        
	        ImageIcon backgroundImage = new ImageIcon("./back_Image/result_bak.png");
	        JLabel backgroundLabel = new JLabel();
	        backgroundLabel.setIcon(backgroundImage);
	        backgroundLabel.setSize(840,630);
	        backgroundLabel.setLocation(0, -15);
	        add(backgroundLabel);
	    }
	    
	    private void showLocationOnMap(String menu) {
	        GeoPosition position = menuLocations.getOrDefault(menu, new GeoPosition(37.5665, 126.9780)); // 기본 위치
	        initMap(position);
	    }
	    
	    private void initMap(GeoPosition position) {
	        JXMapViewer mapViewer = new JXMapViewer();

	        // TileFactoryInfo 설정
	        TileFactoryInfo info = new OSMTileFactoryInfo();
	        DefaultTileFactory tileFactory = new DefaultTileFactory(info);
	        mapViewer.setTileFactory(tileFactory); 	

	        // 초기 위치 설정
	        mapViewer.setAddressLocation(position);

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
	    
	    private BufferedImage cropImageCenter(BufferedImage originalImage, int targetWidth, int targetHeight) {
	        // 원본 이미지의 비율에 따라 목표 크기 조정
	        double originalRatio = (double) originalImage.getWidth() / originalImage.getHeight();
	        double targetRatio = (double) targetWidth / targetHeight;
	        int newWidth, newHeight;

	        if (originalRatio > targetRatio) {
	            // 너비 기준으로 조정
	            newHeight = targetHeight;
	            newWidth = (int) (originalImage.getWidth() / ((double) originalImage.getHeight() / targetHeight));
	        } else {
	            // 높이 기준으로 조정
	            newWidth = targetWidth;
	            newHeight = (int) (originalImage.getHeight() / ((double) originalImage.getWidth() / targetWidth));
	        }

	        // 이미지 재조정
	        BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
	        Graphics g = resizedImage.createGraphics();
	        g.drawImage(originalImage, 0, 0, newWidth, newHeight, null);
	        g.dispose();

	        // 중앙 부분 크롭
	        int x = (newWidth - targetWidth) / 2;
	        int y = (newHeight - targetHeight) / 2;

	        return resizedImage.getSubimage(x, y, targetWidth, targetHeight);
	    }
	    

	    private String getRecommendedMenu(toDay_main_gui main, int category, int menuType, int temperature) {
	        Random random = new Random();
	        String recommendedMenu = "국밥";
	        
	        
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
 
 