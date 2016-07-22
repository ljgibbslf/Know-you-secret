import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class IndexGUI extends JFrame {
        //�Զ���IndexGUI�̳�JFrame��
	private JPanel contentPane;  //�������
        //����JFrame�����������
    private static IndexGUI frame;

    public static void main(String[] args) {
    	init();
    	}
    
    public static void init(){  //��ʼ������
        EventQueue.invokeLater(new Runnable() {
                
        	public void run() {
        		try {
        			frame = new IndexGUI(); //ʵ����frame
        			frame.setVisible(true); //���ô���ɼ���
        		} catch (Exception e) {
        			e.printStackTrace();
        		}
        	}
            });
        }
        
    public IndexGUI() {
        setTitle("KnowYou");  //���ô������
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //����Ĭ�Ϲرշ�ʽ���������رհ�ť�ɹرմ���
        setBounds(100, 100, 650, 400);
        JPanel contentPane = new JPanel(); //ʵ�������
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); //��������С��λ��
        setContentPane(contentPane); //frame������
        contentPane.setLayout(null);  //������ò���Ϊnull,����ʡ�ԡ�����ҳ�沼�ֽ������ҡ�

        JLabel lblNewLabel = new JLabel("Welcome to use KnowYou"); //����
        lblNewLabel.setBounds(132, 74, 386, 35);
        lblNewLabel.setFont(new Font("����", Font.BOLD | Font.ITALIC, 30));
        contentPane.add(lblNewLabel);

        JButton login = new JButton("Login"); //��½��ť
            //��½��ť����¼�������걻���ʱ����
        login.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                	event_Login(); //��½�¼�����
                }
            });


            //���Ӽ����¼�
        login.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    {
                        event_Login();//��½�¼�����
                    }
                }
            });
         login.setBounds(65, 263, 124, 45);
         contentPane.add(login);

         JButton register = new JButton("Sign Up"); //ע�ᰴť

            //ע������¼�
         register.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    event_register(); //ע���¼�����
                }
            });

            //ע�ᰴť�����¼�
         register.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    {
                        event_register();//ע���¼�����
                    }
                }
            });
         register.setBounds(489, 263, 109, 45);
         contentPane.add(register);

        }

        //�Ե�½��ע���¼�����˽�з�����װ
        private void event_Login()
        {
            setVisible(false);
            new LoginGUI().loginGUI();
        }

        private void event_register()
        {
            setVisible(false);
            new RegisterGUI().registerGUI();
        }
    }