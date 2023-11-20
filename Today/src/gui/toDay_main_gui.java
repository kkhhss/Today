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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
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
	public toDay_main_gui() {
        result.loadMenuData(); // 메뉴 데이터 불러오기
        // 나머지 생성자 코드 ...
    }
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
	    
	 
	 // 카테고리별 메뉴 리스트
	    private static ArrayList<String> koreanRiceHotMenu = new ArrayList<>();
	    private static ArrayList<String> koreanRiceCoolMenu = new ArrayList<>();
        private static ArrayList<String> koreanBreadHotMenu = new ArrayList<>();
        private static ArrayList<String> koreanBreadCoolMenu = new ArrayList<>();
        private static ArrayList<String> koreanNoodleHotMenu = new ArrayList<>();
        private static ArrayList<String> koreanNoodleCoolMenu = new ArrayList<>();

        private static ArrayList<String> westernRiceHotMenu = new ArrayList<>();
        private static ArrayList<String> westernRiceCoolMenu = new ArrayList<>();
        private static ArrayList<String> westernBreadHotMenu = new ArrayList<>();
        private static ArrayList<String> westernBreadCoolMenu = new ArrayList<>();
        private static ArrayList<String> westernNoodleHotMenu = new ArrayList<>();
        private static ArrayList<String> westernNoodleCoolMenu = new ArrayList<>();

        private static ArrayList<String> ChineseRiceHotMenu = new ArrayList<>();
        private static ArrayList<String> ChineseRiceCoolMenu = new ArrayList<>();
        private static ArrayList<String> ChineseBreadHotMenu = new ArrayList<>();
        private static ArrayList<String> ChineseBreadCoolMenu = new ArrayList<>();
        private static ArrayList<String> ChineseNoodleHotMenu = new ArrayList<>();
        private static ArrayList<String> ChineseNoodleCoolMenu = new ArrayList<>();

        private static ArrayList<String> JapaneseRiceHotMenu = new ArrayList<>();
        private static ArrayList<String> JapaneseRiceCoolMenu = new ArrayList<>();
        private static ArrayList<String> JapaneseBreadHotMenu = new ArrayList<>();
        private static ArrayList<String> JapaneseBreadCoolMenu = new ArrayList<>();
        private static ArrayList<String> JapaneseNoodleHotMenu = new ArrayList<>();
        private static ArrayList<String> JapaneseNoodleCoolMenu = new ArrayList<>();
	    
	    
	    
	    
	    public result(toDay_main_gui main, int category, int menuType, int temperature) {
	        this.main = main;
	        setLayout(null);

	        ImageIcon btn1_1 = new ImageIcon("./Button_Image/add.png");
	        add  = new JButton(btn1_1);
		    add.setBorderPainted(false);
		    add.setSize(130, 50);
		    add.setLocation(670, 540);
		    add.setContentAreaFilled(false);
		    add.setVisible(true);
	        add(add);
	        
	        // 한식 텍스트 파일
		    File file1 = new File("./menuText/한식밥뜨거운.txt");
		    try (BufferedReader br = new BufferedReader(new FileReader(file1))) {
		        String line;
		        while ((line = br.readLine()) != null) {
		            koreanRiceHotMenu.add(line);
		        }
		    } catch (IOException e) {
		        e.printStackTrace();
		        // 오류 처리
		    }
		    File file2 = new File("./menuText/한식밥차가운.txt");
		    try (BufferedReader br = new BufferedReader(new FileReader(file2))) {
		        String line;
		        while ((line = br.readLine()) != null) {
		            koreanRiceCoolMenu.add(line);
		        }
		    } catch (IOException e) {
		        e.printStackTrace();
		        // 오류 처리
		    }
		    File file3 = new File("./menuText/한식빵뜨거운.txt");
		    try (BufferedReader br = new BufferedReader(new FileReader(file3))) {
		        String line;
		        while ((line = br.readLine()) != null) {
		            koreanBreadHotMenu.add(line);
		        }
		    } catch (IOException e) {
		        e.printStackTrace();
		        // 오류 처리
		    }
		    File file4 = new File("./menuText/한식빵차가운.txt");
		    try (BufferedReader br = new BufferedReader(new FileReader(file4))) {
		        String line;
		        while ((line = br.readLine()) != null) {
		            koreanBreadCoolMenu.add(line);
		        }
		    } catch (IOException e) {
		        e.printStackTrace();
		        // 오류 처리
		    }
		    File file5 = new File("./menuText/한식면뜨거운.txt");
		    try (BufferedReader br = new BufferedReader(new FileReader(file5))) {
		        String line;
		        while ((line = br.readLine()) != null) {
		            koreanNoodleHotMenu.add(line);
		        }
		    } catch (IOException e) {
		        e.printStackTrace();
		        // 오류 처리
		    }
		    File file6 = new File("./menuText/한식면차가운.txt");
		    try (BufferedReader br = new BufferedReader(new FileReader(file6))) {
		        String line;
		        while ((line = br.readLine()) != null) {
		            koreanNoodleCoolMenu.add(line);
		        }
		    } catch (IOException e) {
		        e.printStackTrace();
		        // 오류 처리
		    }
		    
		    // 양식 텍스트 파일
		    File file7 = new File("./menuText/양식밥뜨거운.txt");
		    try (BufferedReader br = new BufferedReader(new FileReader(file7))) {
		        String line;
		        while ((line = br.readLine()) != null) {
		            westernRiceHotMenu.add(line);
		        }
		    } catch (IOException e) {
		        e.printStackTrace();
		        // 오류 처리
		    }
		    File file8 = new File("./menuText/양식밥차가운.txt");
		    try (BufferedReader br = new BufferedReader(new FileReader(file8))) {
		        String line;
		        while ((line = br.readLine()) != null) {
		            westernRiceCoolMenu.add(line);
		        }
		    } catch (IOException e) {
		        e.printStackTrace();
		        // 오류 처리
		    }
		    File file9 = new File("./menuText/양식빵뜨거운.txt");
		    try (BufferedReader br = new BufferedReader(new FileReader(file9))) {
		        String line;
		        while ((line = br.readLine()) != null) {
		            westernBreadHotMenu.add(line);
		        }
		    } catch (IOException e) {
		        e.printStackTrace();
		        // 오류 처리
		    }
		    File file10 = new File("./menuText/양식빵차가운.txt");
		    try (BufferedReader br = new BufferedReader(new FileReader(file10))) {
		        String line;
		        while ((line = br.readLine()) != null) {
		            westernBreadCoolMenu.add(line);
		        }
		    } catch (IOException e) {
		        e.printStackTrace();
		        // 오류 처리
		    }
		    File file11 = new File("./menuText/양식면뜨거운.txt");
		    try (BufferedReader br = new BufferedReader(new FileReader(file11))) {
		        String line;
		        while ((line = br.readLine()) != null) {
		            westernNoodleHotMenu.add(line);
		        }
		    } catch (IOException e) {
		        e.printStackTrace();
		        // 오류 처리
		    }
		    File file12 = new File("./menuText/양식면차가운.txt");
		    try (BufferedReader br = new BufferedReader(new FileReader(file12))) {
		        String line;
		        while ((line = br.readLine()) != null) {
		            westernNoodleCoolMenu.add(line);
		        }
		    } catch (IOException e) {
		        e.printStackTrace();
		        // 오류 처리
		    }
		    
		    // 중식 텍스트 파일
		    File file13 = new File("./menuText/중식밥뜨거운.txt");
		    try (BufferedReader br = new BufferedReader(new FileReader(file13))) {
		        String line;
		        while ((line = br.readLine()) != null) {
		            ChineseRiceHotMenu.add(line);
		        }
		    } catch (IOException e) {
		        e.printStackTrace();
		        // 오류 처리
		    }
		    File file14 = new File("./menuText/중식밥차가운.txt");
		    try (BufferedReader br = new BufferedReader(new FileReader(file14))) {
		        String line;
		        while ((line = br.readLine()) != null) {
		            ChineseRiceCoolMenu.add(line);
		        }
		    } catch (IOException e) {
		        e.printStackTrace();
		        // 오류 처리
		    }
		    File file15 = new File("./menuText/중식빵뜨거운.txt");
		    try (BufferedReader br = new BufferedReader(new FileReader(file15))) {
		        String line;
		        while ((line = br.readLine()) != null) {
		            ChineseBreadHotMenu.add(line);
		        }
		    } catch (IOException e) {
		        e.printStackTrace();
		        // 오류 처리
		    }
		    File file16 = new File("./menuText/중식빵차가운.txt");
		    try (BufferedReader br = new BufferedReader(new FileReader(file16))) {
		        String line;
		        while ((line = br.readLine()) != null) {
		            ChineseBreadCoolMenu.add(line);
		        }
		    } catch (IOException e) {
		        e.printStackTrace();
		        // 오류 처리
		    }
		    File file17 = new File("./menuText/중식면뜨거운.txt");
		    try (BufferedReader br = new BufferedReader(new FileReader(file17))) {
		        String line;
		        while ((line = br.readLine()) != null) {
		            ChineseNoodleHotMenu.add(line);
		        }
		    } catch (IOException e) {
		        e.printStackTrace();
		        // 오류 처리
		    }
		    File file18 = new File("./menuText/중식면차가운.txt");
		    try (BufferedReader br = new BufferedReader(new FileReader(file18))) {
		        String line;
		        while ((line = br.readLine()) != null) {
		            ChineseNoodleCoolMenu.add(line);
		        }
		    } catch (IOException e) {
		        e.printStackTrace();
		        // 오류 처리
		    }
		    

		    // 일식 텍스트 파일
		    File file19 = new File("./menuText/일식밥뜨거운.txt");
		    try (BufferedReader br = new BufferedReader(new FileReader(file19))) {
		        String line;
		        while ((line = br.readLine()) != null) {
		            JapaneseRiceHotMenu.add(line);
		        }
		    } catch (IOException e) {
		        e.printStackTrace();
		        // 오류 처리
		    }
		    File file20 = new File("./menuText/일식밥차가운.txt");
		    try (BufferedReader br = new BufferedReader(new FileReader(file20))) {
		        String line;
		        while ((line = br.readLine()) != null) {
		            JapaneseRiceCoolMenu.add(line);
		        }
		    } catch (IOException e) {
		        e.printStackTrace();
		        // 오류 처리
		    }
		    File file21 = new File("./menuText/일식빵뜨거운.txt");
		    try (BufferedReader br = new BufferedReader(new FileReader(file21))) {
		        String line;
		        while ((line = br.readLine()) != null) {
		            JapaneseBreadHotMenu.add(line);
		        }
		    } catch (IOException e) {
		        e.printStackTrace();
		        // 오류 처리
		    }
		    File file22 = new File("./menuText/일식빵차가운.txt");
		    try (BufferedReader br = new BufferedReader(new FileReader(file22))) {
		        String line;
		        while ((line = br.readLine()) != null) {
		            JapaneseBreadCoolMenu.add(line);
		        }
		    } catch (IOException e) {
		        e.printStackTrace();
		        // 오류 처리
		    }
		    File file23 = new File("./menuText/일식면뜨거운.txt");
		    try (BufferedReader br = new BufferedReader(new FileReader(file23))) {
		        String line;
		        while ((line = br.readLine()) != null) {
		            JapaneseNoodleHotMenu.add(line);
		        }
		    } catch (IOException e) {
		        e.printStackTrace();
		        // 오류 처리
		    }
		    File file24 = new File("./menuText/일식면차가운.txt");
		    try (BufferedReader br = new BufferedReader(new FileReader(file24))) {
		        String line;
		        while ((line = br.readLine()) != null) {
		            JapaneseNoodleCoolMenu.add(line);
		        }
		    } catch (IOException e) {
		        e.printStackTrace();
		        // 오류 처리
		    }
		    
		    
	        add.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	setVisible(false);
	            	main.getContentPane().add(new add(main, category, 2));
	                main.revalidate();
	                main.repaint();
	            }
	        });
	        
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
	        menuImages.put("크림 스프", "./foodImage/creamsoup.jpg");
	        menuImages.put("피자", "./foodImage/pizza.jpg");
	        menuImages.put("햄버거", "./foodImage/hamburger.jpg");
	        menuImages.put("파이", "./foodImage/pie.jpg");
	        menuImages.put("스파게티", "./foodImage/spagetti.jpg");
	        menuImages.put("라자냐", "./foodImage/lazanya.jpg");
	        menuImages.put("파스타 샐러드", "./foodImage/pasta salad.jpg");
	        
	        menuImages.put("마파두부 덮밥", "./foodImage/mapatofu.jpg");
	        menuImages.put("짬뽕밥", "./foodImage/jjambbongbab.jpg");
	        menuImages.put("짜장밥", "./foodImage/jjajangbab.jpg");
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
	        menuImages.put("냉소바", "./foodImage/coolsoba.jpg");

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
	        menuLocations.put("크림 스프", new GeoPosition(37.469931, 126.934271));
	        menuLocations.put("피자", new GeoPosition(37.470159, 126.933438));
	        menuLocations.put("햄버거", new GeoPosition(37.470731, 126.933681));
	        menuLocations.put("파이", new GeoPosition(37.470859, 126.933769));
	        menuLocations.put("스파게티", new GeoPosition(37.470299, 126.934739));
	        menuLocations.put("라자냐", new GeoPosition(37.48137, 126.928521));
	        menuLocations.put("파스타 샐러드", new GeoPosition(37.5665, 126.9780));
	        
	        menuLocations.put("마파두부 덮밥", new GeoPosition(37.46880, 126.93444));
	        menuLocations.put("짬뽕밥", new GeoPosition(37.46880, 126.93444));
	        menuLocations.put("짜장밥", new GeoPosition(37.46880, 126.93444));
	        menuLocations.put("볶음밥", new GeoPosition(37.46880, 126.93444));
	        menuLocations.put("만두", new GeoPosition(37.46880, 126.93444));
	        menuLocations.put("꽃빵", new GeoPosition(37.46880, 126.93444));
	        menuLocations.put("짜장면", new GeoPosition(37.46880, 126.93444));
	        menuLocations.put("짬뽕", new GeoPosition(37.46880, 126.93444));
	        menuLocations.put("울면", new GeoPosition(37.46880, 126.93444));
	        menuLocations.put("중국 냉면", new GeoPosition(37.46880, 126.93444));
	        menuLocations.put("냉짬뽕", new GeoPosition(37.46880, 126.93444));

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
	    
	    // 메뉴 데이터 불러오기 메소드
	    static void loadMenuData() {
	        String[] categories = {"한식", "양식", "중식", "일식"};
	        String[] Types = {"밥", "빵", "면"};
	        String[] Temperatures = {"뜨거운", "차가운"};
	        for (String category : categories) {
	        	for (String type : Types) {
	        		for(String tem : Temperatures) {
	        			File file = new File("./menuText/" + category + type + tem + ".txt");
	        			try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	        				String line;
	        				while ((line = br.readLine()) != null) {
	        					if (category.equals("한식")) {
	        				        if (type.equals("밥") && tem.equals("뜨거운")) {
	        				            koreanRiceHotMenu.add(line);
	        				        } else if (type.equals("밥") && tem.equals("차가운")) {
	        				            koreanRiceCoolMenu.add(line);
	        				        }
	        				        if (type.equals("빵") && tem.equals("뜨거운")) {
	        				            koreanBreadHotMenu.add(line);
	        				        } else if (type.equals("빵") && tem.equals("차가운")) {
	        				            koreanBreadCoolMenu.add(line);
	        				        }
	        				        if (type.equals("면") && tem.equals("뜨거운")) {
	        				            koreanNoodleHotMenu.add(line);
	        				        } else if (type.equals("면") && tem.equals("차가운")) {
	        				            koreanNoodleCoolMenu.add(line);
	        				        }
	        				    } else if (category.equals("양식")) {
	        				        if (type.equals("밥") && tem.equals("뜨거운")) {
	        				            westernRiceHotMenu.add(line);
	        				        } else if (type.equals("밥") && tem.equals("차가운")) {
	        				            westernRiceCoolMenu.add(line);
	        				        }
	        				        if (type.equals("빵") && tem.equals("뜨거운")) {
	        				            westernBreadHotMenu.add(line);
	        				        } else if (type.equals("빵") && tem.equals("차가운")) {
	        				            westernBreadCoolMenu.add(line);
	        				        }
	        				        if (type.equals("면") && tem.equals("뜨거운")) {
	        				            westernNoodleHotMenu.add(line);
	        				        } else if (type.equals("면") && tem.equals("차가운")) {
	        				            westernNoodleCoolMenu.add(line);
	        				        }
	        				    } else if (category.equals("중식")) {
	        				        if (type.equals("밥") && tem.equals("뜨거운")) {
	        				            ChineseRiceHotMenu.add(line);
	        				        } else if (type.equals("밥") && tem.equals("차가운")) {
	        				            ChineseRiceCoolMenu.add(line);
	        				        }
	        				        if (type.equals("빵") && tem.equals("뜨거운")) {
	        				            ChineseBreadHotMenu.add(line);
	        				        } else if (type.equals("빵") && tem.equals("차가운")) {
	        				            ChineseBreadCoolMenu.add(line);
	        				        }
	        				        if (type.equals("면") && tem.equals("뜨거운")) {
	        				            ChineseNoodleHotMenu.add(line);
	        				        } else if (type.equals("면") && tem.equals("차가운")) {
	        				            ChineseNoodleCoolMenu.add(line);
	        				        }
	        				    } else if (category.equals("일식")) {
	        				        if (type.equals("밥") && tem.equals("뜨거운")) {
	        				            JapaneseRiceHotMenu.add(line);
	        				        } else if (type.equals("밥") && tem.equals("차가운")) {
	        				            JapaneseRiceCoolMenu.add(line);
	        				        }
	        				        if (type.equals("빵") && tem.equals("뜨거운")) {
	        				            JapaneseBreadHotMenu.add(line);
	        				        } else if (type.equals("빵") && tem.equals("차가운")) {
	        				            JapaneseBreadCoolMenu.add(line);
	        				        }
	        				        if (type.equals("면") && tem.equals("뜨거운")) {
	        				            JapaneseNoodleHotMenu.add(line);
	        				        } else if (type.equals("면") && tem.equals("차가운")) {
	        				            JapaneseNoodleCoolMenu.add(line);
	        				        }
	        				    }
	        				}
	        			} catch (IOException e) {
	        				e.printStackTrace();
	        			}
	        		}
	        	}
	        }
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
	        
	        ArrayList<String> targetList = null;

	        if (category == 0) { // 한식
	            if (menuType == 0) { // 밥
	                targetList = (temperature == 0) ? koreanRiceHotMenu : koreanRiceCoolMenu;
	            } else if (menuType == 1) { // 빵
	                targetList = (temperature == 0) ? koreanBreadHotMenu : koreanBreadCoolMenu;
	            } else if (menuType == 2) { // 면
	                targetList = (temperature == 0) ? koreanNoodleHotMenu : koreanNoodleCoolMenu;
	            }
	        } else if (category == 1) { // 양식
	        	if (menuType == 0) { // 밥
	                targetList = (temperature == 0) ? westernRiceHotMenu : westernRiceCoolMenu;
	            } else if (menuType == 1) { // 빵
	                targetList = (temperature == 0) ? westernBreadHotMenu : westernBreadCoolMenu;
	            } else if (menuType == 2) { // 면
	                targetList = (temperature == 0) ? westernNoodleHotMenu : westernNoodleCoolMenu;
	            }
	        } else if (category == 2) { // 양식
	        	if (menuType == 0) { // 밥
	                targetList = (temperature == 0) ? ChineseRiceHotMenu : ChineseRiceCoolMenu;
	            } else if (menuType == 1) { // 빵
	                targetList = (temperature == 0) ? ChineseBreadHotMenu : ChineseBreadCoolMenu;
	            } else if (menuType == 2) { // 면
	                targetList = (temperature == 0) ? ChineseNoodleHotMenu : ChineseNoodleCoolMenu;
	            }
	        } else if (category == 3) { // 양식
	        	if (menuType == 0) { // 밥
	                targetList = (temperature == 0) ? JapaneseRiceHotMenu : JapaneseRiceCoolMenu;
	            } else if (menuType == 1) { // 빵
	                targetList = (temperature == 0) ? JapaneseBreadHotMenu : JapaneseBreadCoolMenu;
	            } else if (menuType == 2) { // 면
	                targetList = (temperature == 0) ? JapaneseNoodleHotMenu : JapaneseNoodleCoolMenu;
	            }
	        }
	       
	       // ArrayList에서 무작위 메뉴 선택
	       if (targetList != null && !targetList.isEmpty()) {
	           int randomIndex = random.nextInt(targetList.size());
	           recommendedMenu = targetList.get(randomIndex);
	       }

	       return recommendedMenu;
	    }
	    
	 // 메뉴 추가 메서드
	    public static void addMenu(String menuName, String category, String menuType, String temperature) {
	        
	        // 파일에 메뉴 추가 로직
	        try (FileWriter fw = new FileWriter("./menuText/" + category + menuType + temperature + ".txt", true);
	             BufferedWriter bw = new BufferedWriter(fw);
	             PrintWriter out = new PrintWriter(bw)) {
	            out.println(menuName);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}

 
 class add extends JPanel{
	 private toDay_main_gui main;
	 
	 ImageIcon backgroundImage = new ImageIcon("./back_Image/add_bak.png");
	 
	 public add(toDay_main_gui main, int category, int menuType) {
	        this.main = main;
	        setLayout(null);
	        
	        JLabel QLabel = new JLabel();
	        QLabel.setSize(1000, 50);
	        QLabel.setLocation(325, 80);
	        add(QLabel);
	        
	        QLabel.setText("어떤 메뉴를 추가하고 싶으신가요?");
	        
	     // 라디오버튼 생성
	        JRadioButton koreanButton = new JRadioButton("한식");
	        JRadioButton westernButton = new JRadioButton("양식");
	        JRadioButton chineseButton = new JRadioButton("중식");
	        JRadioButton japaneseButton = new JRadioButton("일식");
	        JRadioButton riceButton = new JRadioButton("밥");
	        JRadioButton breadButton = new JRadioButton("빵");
	        JRadioButton noodleButton = new JRadioButton("면");
	        JRadioButton hotButton = new JRadioButton("따뜻한");
	        JRadioButton coldButton = new JRadioButton("시원한");

	        // 라디오버튼 그룹 생성
	        ButtonGroup categoryGroup = new ButtonGroup();
	        categoryGroup.add(koreanButton);
	        categoryGroup.add(westernButton);
	        categoryGroup.add(chineseButton);
	        categoryGroup.add(japaneseButton);

	        ButtonGroup menuTypeGroup = new ButtonGroup();
	        menuTypeGroup.add(riceButton);
	        menuTypeGroup.add(breadButton);
	        menuTypeGroup.add(noodleButton);

	        ButtonGroup temperatureGroup = new ButtonGroup();
	        temperatureGroup.add(hotButton);
	        temperatureGroup.add(coldButton);

	        // 라디오버튼 위치 설정
	        koreanButton.setBounds(160, 220, 100, 30);
	        westernButton.setBounds(160,280, 100, 30);
	        chineseButton.setBounds(160,340, 100, 30);
	        japaneseButton.setBounds(160, 400, 100, 30);
	        riceButton.setBounds(360, 250, 100, 30);
	        breadButton.setBounds(360, 310, 100, 30);
	        noodleButton.setBounds(360, 370, 100, 30);
	        hotButton.setBounds(560, 280, 100, 30);
	        coldButton.setBounds(560, 340, 100, 30);

	        // 텍스트 필드 및 버튼 생성 및 위치 설정
	        JTextField menuNameField = new JTextField();
	        menuNameField.setBounds(280, 500, 200, 30);
	        JButton submitButton = new JButton("추가");
	        submitButton.setBounds(490, 500, 80, 30);
	        
	        submitButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                String menuName = menuNameField.getText();
	                String selectedCategory = "";
	                String selectedType = "";
	                String selectedTem = "";
	                
	                if (koreanButton.isSelected()) {
	                    selectedCategory = "한식";
	                } else if (westernButton.isSelected()) {
	                    selectedCategory = "양식";
	                } else if (chineseButton.isSelected()) {
	                    selectedCategory = "중식";
	                } else if (japaneseButton.isSelected()) {
	                    selectedCategory = "일식";
	                }
	                
	                if (riceButton.isSelected()) {
	                	selectedType="밥";
	                } else if (breadButton.isSelected()) {
	                	selectedType="빵";
	                } else if (noodleButton.isSelected()) {
	                	selectedType="면";
	                }
	                
	                if (hotButton.isSelected()) {
	                	selectedTem="뜨거운";
	                } else if (coldButton.isSelected()) {
	                	selectedTem="차가운";
	                }
	                
	                result.addMenu(menuName, selectedCategory, selectedType, selectedTem);
	                
	                
	                // 메뉴 추가 후 팝업 메시지 표시
	                JOptionPane.showMessageDialog(main, "메뉴가 추가되었습니다.");

	                // 프로그램 종료
	                System.exit(0);
	            }
	        });

	        // 컴포넌트 추가
	        add(koreanButton);
	        add(westernButton);
	        add(chineseButton);
	        add(japaneseButton);
	        add(riceButton);
	        add(breadButton);
	        add(noodleButton);
	        add(hotButton);
	        add(coldButton);
	        add(menuNameField);
	        add(submitButton);
	        
	        JLabel backgroundLabel = new JLabel();
	        backgroundLabel.setIcon(backgroundImage);
	        backgroundLabel.setSize(840,630);
	        backgroundLabel.setLocation(0, 0);
	        add(backgroundLabel);

	        
	    }

 }
 