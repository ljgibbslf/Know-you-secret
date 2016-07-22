 import java.awt.EventQueue;
    import java.awt.Font;
    import java.awt.event.KeyAdapter;
    import java.awt.event.KeyEvent;
    import java.awt.event.MouseAdapter;
    import java.awt.event.MouseEvent;

    import javax.swing.JButton;
    import javax.swing.JFrame;
    import javax.swing.JLabel;
    import javax.swing.JOptionPane;
    import javax.swing.JPanel;
    import javax.swing.JPasswordField;
    import javax.swing.JTextField;
    import javax.swing.border.EmptyBorder;

    import com.Joke.util.JDOM;


public class LoginGUI extends JFrame {
	private static final long serialVersionUID = 4994949944841194839L;
    private JPanel contentPane;  //面板
    private JTextField IDtxt; //ID输入框
    private JLabel Passwdlabel;//密码标签
    private JPasswordField passwordField;//密码输入框
    private JButton login;//登陆按钮
    private JButton back;//返回按钮

        /**
         * Launch the application.
         * @return 
         */
    public void loginGUI() {
    	EventQueue.invokeLater(new Runnable() {
    		public void run() {
    			try {
    				LoginGUI frame = new LoginGUI();
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
    public LoginGUI() {
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 650, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel IDlabel = new JLabel("Please input ID");//ID标签
        IDlabel.setBounds(68, 170, 91, 39);
        contentPane.add(IDlabel);

        IDtxt = new JTextField();
        IDtxt.setBounds(206, 179, 126, 21);
        contentPane.add(IDtxt);
        IDtxt.setColumns(10);

        Passwdlabel = new JLabel("Please input password");
        Passwdlabel.setBounds(68, 219, 150, 50);
        contentPane.add(Passwdlabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(206, 234, 126, 21);
        contentPane.add(passwordField);

        login = new JButton("login");

         //鼠标事件
        login.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {

                    event_login();//登陆事件方法
                }
            });

            //键盘事件
        login.addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent e)
                {
                    if(e.getKeyCode()==KeyEvent.VK_ENTER)//当键盘按下enter时调用
                    {
                        event_login();//登陆事件方法
                    }
                }
            });
        login.setBounds(239, 310, 93, 23);
        contentPane.add(login);

            //返回按钮
        back = new JButton("BACK");
        back.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                     IndexGUI.init();//回到主界面 隐藏本页面
                     setVisible(false);
                }
            });
        back.setBounds(507, 310, 93, 23);
        contentPane.add(back);

            //标题
        JLabel label = new JLabel("Welcome to use KnowYou");
        label.setFont(new Font("黑体", Font.BOLD | Font.ITALIC, 30));
        label.setBounds(142, 54, 386, 35);
        contentPane.add(label);
        }

        //封装登陆事件
        private void event_login()
        {
            String id=IDtxt.getText(); 
            String passwd=new String(passwordField.getPassword());
            String flag=JDOM.read(id, passwd);
            if(flag.contains("Successful landing"))
            {
                //拆分信息
                String[] bufs=flag.split("/");
                String name=bufs[1];
                //提示框，打印登陆成功
                JOptionPane.showMessageDialog(contentPane, "Welcome："+name,"Welcome",JOptionPane.PLAIN_MESSAGE);
                UsersGUI.init(name);
                setVisible(false);
            }
           else
           {
         //提示框，错误信息               
        	   JOptionPane.showMessageDialog(contentPane,flag,"ERROR",JOptionPane.ERROR_MESSAGE);//flag 包含了错误信息
           }
         }
    }