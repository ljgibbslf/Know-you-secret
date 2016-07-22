package com.Joke.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.text.Document;

public class Diary {

	public static void addDiary(String pathname, String title, String txt) {
            // pathname�����û����������ļ���
    File dirfile = new File(pathname);
    BufferedWriter bufw = null;
            // �����ļ���
    dirfile.mkdirs();

            // �����ռ��ļ�����׺Ϊ.kz
    File file = new File(dirfile, title + ".ky");
//    ���ܳ���
    char[] ch=new char[80];
	ch=txt.toCharArray();
	for(int i=0;i<txt.length();i++){
		ch[i]=(char) (ch[i]^20);
	}
    
    try {
                //д���ļ�
    	bufw = new BufferedWriter(new FileWriter(file, true));
        bufw.write(String.valueOf(ch));
        } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
    } finally {

                if (bufw != null) {
                    try {
                        bufw.close();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        }

        public static void read(File file, Document doc) {

            // ������ȡ������ȡ�ļ����ݣ�����������������ӵ��ռ���ʾ��
            try (BufferedReader bufr = new BufferedReader(new FileReader(file));) {
                String txt = null;
                // ��ȡ���з�,��ΪLinux��Windows�µĻ��з��ǲ�һ���ġ�����������ǿ��ƽ̨��
                String line = System.getProperty("line.separator");
                while ((txt = bufr.readLine()) != null) {
//                  ���ܳ���
                    char[] ch=new char[80];
                	ch=txt.toCharArray();
                	for(int i=0;i<txt.length();i++){
                		ch[i]=(char) (ch[i]^20);
                	}
                    doc.insertString(doc.getLength(),String.valueOf(ch) + line, null);

                }

            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

        }

    }
