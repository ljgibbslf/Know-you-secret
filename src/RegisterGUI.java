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
    private JTextField nametext;  //name�����
    private JTextField IDtext;  //ID�����
    private JTextField passwdtext;  //���������

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

        JLabel namelabel = new JLabel("Please input user name"); //������ʾ���������ǩ
        namelabel.setBounds(102, 91, 151, 23);
        contentPane.add(namelabel);

        JLabel IDlabel = new JLabel("Please input user ID");//������ʾID�����ǩ
        IDlabel.setBounds(102, 160, 151, 23);
        
        contentPane.add(IDlabel);


        JLabel passwdlaber = new JLabel("Please input user password");//������ʾ���������ǩ
        passwdlaber.setBounds(102, 224, 163, 23);
        contentPane.add(passwdlaber);

        nametext = new JTextField();  //��ͨ�ı������
        nametext.setBounds(271, 92, 92, 21); //����λ�ü���С
        contentPane.add(nametext);
        nametext.setColumns(10);  //���ó���

        //ID
        IDtext = new JTextField();
        IDtext.setBounds(271, 161, 92, 21);
        contentPane.add(IDtext);
        IDtext.setColumns(8);

            //����
        passwdtext = new JTextField();
        passwdtext.setBounds(271, 225, 92, 21);
        contentPane.add(passwdtext);
        passwdtext.setColumns(10);

            //ע�ᰴť
        JButton register = new JButton("Sign Up"); 
           //ע�ᰴť������¼�
        register.addMouseListener(new MouseAdapter() {

        public void mouseClicked(MouseEvent e) {
        	String name = nametext.getText();//�õ�name
            String ID = IDtext.getText();//�õ�ID
            String passwd = passwdtext.getText();//�õ�����
                    //������ID����Ϊnull
            if (Register.checkID(ID) == null) { 
                   //���������뷵��Ϊnull
            	if (Register.checkPasswd(passwd) == null) {
                    //ע����Ϣ�����ҵõ�������Ϣ
            		String srt = Register.register(name, passwd, ID);


                  //��ʾ��ע��ɹ�
            		JOptionPane.showMessageDialog(contentPane,srt,"information", JOptionPane.PLAIN_MESSAGE);
                    //���ص�ǰ����
            		setVisible(false);
                    //������ҳ
            		new IndexGUI().init();
                 } else {
                    //��ʾ�����������Ϣ            
                    JOptionPane.showMessageDialog(contentPane,Register.checkPasswd(passwd), "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
             } else {
                    //��ʾ�����������Ϣ              
            	 JOptionPane.showMessageDialog(contentPane,Register.checkID(ID), "ERROR",JOptionPane.ERROR_MESSAGE);
                            }
                    }  
                    });

            register.setBounds(321, 305, 93, 23);
            contentPane.add(register);

            JButton back = new JButton("BACK");  //���ذ�ť
            back.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    IndexGUI.init(); //������ҳ
                    setVisible(false); //��ǰҳ�治�ɼ�
                }
            });
            back.setBounds(531, 305, 93, 23);
            contentPane.add(back);

            JLabel label = new JLabel("Welcome to use KnowYou"); //��ӭ����
            label.setFont(new Font("����", Font.BOLD | Font.ITALIC, 30));
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