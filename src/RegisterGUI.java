import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.Joke.util.Register;

public class RegisterGUI extends JFrame {

	private static final long serialVersionUID = 3250371445038102261L;
	private JPanel contentPane;
    private JTextField nametext;  //name输入框
    private JTextField IDtext;  //ID输入框
    private JTextField passwdtext;  //密码输入框

        /**
         * Launch the application.
         */
    public void registerGUI() {
    	EventQueue.invokeLater(new Runnable() {
    		public void run() {
    			try {
    				RegisterGUI frame = new RegisterGUI();
    				frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                    }
                }
            });
        }

        /**
         * Create the frame.
         */
    public RegisterGUI() {
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 650, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel namelabel = new JLabel("Please input user name"); //设置提示姓名输入标签
        namelabel.setBounds(102, 91, 151, 23);
        contentPane.add(namelabel);

        JLabel IDlabel = new JLabel("Please input user ID");//设置提示ID输入标签
        IDlabel.setBounds(102, 160, 151, 23);
        
        contentPane.add(IDlabel);


        JLabel passwdlaber = new JLabel("Please input user password");//设置提示密码输入标签
        passwdlaber.setBounds(102, 224, 163, 23);
        contentPane.add(passwdlaber);

        nametext = new JTextField();  //普通文本输入框
        nametext.setBounds(271, 92, 92, 21); //设置位置及大小
        contentPane.add(nametext);
        nametext.setColumns(10);  //设置长度

        //ID
        IDtext = new JTextField();
        IDtext.setBounds(271, 161, 92, 21);
        contentPane.add(IDtext);
        IDtext.setColumns(8);

            //密码
        passwdtext = new JTextField();
        passwdtext.setBounds(271, 225, 92, 21);
        contentPane.add(passwdtext);
        passwdtext.setColumns(10);

            //注册按钮
        JButton register = new JButton("Sign Up"); 
           //注册按钮鼠标点击事件
        register.addMouseListener(new MouseAdapter() {

        public void mouseClicked(MouseEvent e) {
        	String name = nametext.getText();//得到name
            String ID = IDtext.getText();//得到ID
            String passwd = passwdtext.getText();//得到密码
                    //如果检测ID返回为null
            if (Register.checkID(ID) == null) { 
                   //如果检测密码返回为null
            	if (Register.checkPasswd(passwd) == null) {
                    //注册信息，并且得到返回信息
            		String srt = Register.register(name, passwd, ID);


                  //提示框，注册成功
            		JOptionPane.showMessageDialog(contentPane,srt,"information", JOptionPane.PLAIN_MESSAGE);
                    //隐藏当前窗体
            		setVisible(false);
                    //返回首页
            		new IndexGUI().init();
                 } else {
                    //提示框，输出错误信息            
                    JOptionPane.showMessageDialog(contentPane,Register.checkPasswd(passwd), "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
             } else {
                    //提示框，输出错误信息              
            	 JOptionPane.showMessageDialog(contentPane,Register.checkID(ID), "ERROR",JOptionPane.ERROR_MESSAGE);
                            }
                    }  
                    });

            register.setBounds(321, 305, 93, 23);
            contentPane.add(register);

            JButton back = new JButton("BACK");  //返回按钮
            back.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    IndexGUI.init(); //创建首页
                    setVisible(false); //当前页面不可见
                }
            });
            back.setBounds(531, 305, 93, 23);
            contentPane.add(back);

            JLabel label = new JLabel("Welcome to use KnowYou"); //欢迎标题
            label.setFont(new Font("黑体", Font.BOLD | Font.ITALIC, 30));
            label.setBounds(143, 26, 374, 35);
            contentPane.add(label);

            JLabel lblNewLabel = new JLabel("(There are 1 to 8 numbers)");
            lblNewLabel.setBounds(373, 164, 163, 15);
            contentPane.add(lblNewLabel);

            JLabel lblNewLabel_1 = new JLabel("(There are 6 to 15 numbers)");
            lblNewLabel_1.setBounds(373, 228, 163, 15);
            contentPane.add(lblNewLabel_1);
        }
    }