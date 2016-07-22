import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import com.Joke.util.Diary;
import javax.swing.filechooser.FileNameExtensionFilter;


public class UsersGUI extends JFrame {
	private JPanel contentPane;
    private JTextField textField;

        //�ļ�ѡ���齨�������û��Ķ��ռǺ�ɾ���ռ�ʱѡ���ļ���
    private JFileChooser chooser;

        /*ÿ��ע���û�����¼���ռǶ�λ���Լ����ļ����£�pathname���ڱ����û����ļ���·��*/
    private static String pathname; 

    public static void init(String path) { //��ʼ������
    	pathname = path;
        EventQueue.invokeLater(new Runnable() {
        	public void run() {
                    try {
                        UsersGUI frame = new UsersGUI();
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
    public UsersGUI() {
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setToolTipText("KonwYou");
        tabbedPane.setBounds(0, 0, 574, 67);
        contentPane.add(tabbedPane);

        final JPanel panel = new JPanel();
        tabbedPane.addTab("Management Journal", null, panel, null);

        chooser = new JFileChooser(".\\"+pathname);//��ʼ��JFileChooser��������Ĭ��Ŀ¼Ϊ�û�Ŀ¼
        FileNameExtensionFilter filter=new FileNameExtensionFilter("Allowed","ky");//�ļ�ѡ������ֻ����ѡ��.ky�ļ�
        chooser.setFileFilter(filter);//Ϊ�ļ�����ѡ����

        JButton readButton = new JButton("Read the diary");
        readButton.addMouseListener(new MouseAdapter() {
                @Override
	       //�Ķ���ť����¼������û����ʱ�����ᴴ��һ���µ��ڲ�����
	        public void mouseClicked(MouseEvent e) {
	
	            int value = chooser.showOpenDialog(panel);//�ж��û��Ƿ�ѡ�����ļ�
	
	        //�ڲ�����
	            JInternalFrame internalFrame_Read = new JInternalFrame("Read the diary",    false, true, false, false);
	            internalFrame_Read.setBounds(0, 77, 584, 275);
	            contentPane.add(internalFrame_Read);
	            internalFrame_Read.getContentPane().setLayout(null);
	            JTextPane txtDiary = new JTextPane();
	            txtDiary.setBounds(0, 0, 568, 246);
	            internalFrame_Read.getContentPane().add(txtDiary);
	
	    //JTextPaneû��append����������ʹ��Document�����ϲ����ı�
	            javax.swing.text.Document doc=txtDiary.getDocument();
	            txtDiary.setBackground(Color.GREEN);//������ɫΪ��ɫ
	            txtDiary.setEditable(false);//����Ϊ���ɱ༭
	
	
	
	      //��value��ֵ��JFileChooser.APPROVE_OPTION���ʱ��֤���û�ѡ�����ļ�
	            if (value == JFileChooser.APPROVE_OPTION) {
	
	        //�õ��û�ѡ����ļ�
	            	File file = chooser.getSelectedFile();
	
	            if(file.exists())    //����ļ�����
	                {
	                    //Diary.read()������ȡ�ռ�;
	                    //�÷����������Ժ�Ŀγ������
	            	Diary.read(file, doc);
	                internalFrame_Read.setVisible(true);
	                    }
	                }
	            }
        });
        panel.add(readButton);

        JButton addButton = new JButton("Create a diary");//�½���ť
        addButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {

                    //�����½��ռ��ڲ�����
                	final JInternalFrame internalFrame_Write = new JInternalFrame("Create a diary",false, true, false, false);


                	internalFrame_Write.setBounds(0, 77, 584, 275);   
                	contentPane.add(internalFrame_Write);
                	internalFrame_Write.getContentPane().setLayout(null);

                	textField = new JTextField();
                	textField.setBounds(76, 0, 492, 21);
                	internalFrame_Write.getContentPane().add(textField);
                	textField.setColumns(10);

                	JLabel label = new JLabel("Title");

                	label.setFont(new Font("����", Font.PLAIN, 12));
                	label.setBounds(46, 3, 52, 15);
                	internalFrame_Write.getContentPane().add(label);

                    //�ռǱ༭��
                	final JEditorPane editorPane = new JEditorPane();
                	editorPane.setBounds(0, 31, 568, 179);
                	internalFrame_Write.getContentPane().add(editorPane);

                	JButton save = new JButton("SAVE");//���水ť
                	save.setBounds(465, 213, 93, 23);
                	save.addMouseListener(new MouseAdapter() {
                	
                	public void mouseClicked(MouseEvent e) {
        //��ȡ����
                		String title = textField.getText();    
        //��ȡ����
                		String txt = editorPane.getText();
        //����Diary.addDiary()���������ռ�
        //�÷����������Ժ�Ŀγ������
                		Diary.addDiary(pathname, title, txt);

        //�ռǽ�����ɺ����ص�ǰ����
                		internalFrame_Write.setVisible(false);
                	}
                	});
                	internalFrame_Write.getContentPane().add(save);
                	internalFrame_Write.setVisible(true);

                }
         });


            panel.add(addButton);

            //ɾ����ť
            JButton delButton = new JButton("Delete");
            delButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    File file=null;
                    int value=chooser.showOpenDialog(panel);
                    if(value==JFileChooser.APPROVE_OPTION)
                    {
                        file=chooser.getSelectedFile();

                    //ɾ��ȷ�Ͽ�����ȷ���û��Ƿ�ȷ��ɾ��      
                        int x=JOptionPane.showConfirmDialog(panel,"Confirm delete?","Please confirm",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);

                        if(file.exists())
                        {
                //���û�ѡ����OKʱ������ɾ������
                        	if(x==JOptionPane.OK_OPTION)
                        	{
                        		file.delete();

                        //��ӡɾ���ɹ���ʾ��Ϣ
                        JOptionPane.showMessageDialog(panel, "Delete Success!","information", JOptionPane.PLAIN_MESSAGE);
                    }

            }

        }

            }
    });
            panel.add(delButton);

          //���ذ�ť
            JButton back = new JButton("BACK");
            back.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    IndexGUI.init();
                    setVisible(false);
                }
            });
            panel.add(back);
        }
    }