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
            // pathname是以用户名命名的文件夹
    File dirfile = new File(pathname);
    BufferedWriter bufw = null;
            // 建立文件夹
    dirfile.mkdirs();

            // 建立日记文件，后缀为.kz
    File file = new File(dirfile, title + ".ky");
//    加密程序
    char[] ch=new char[80];
	ch=txt.toCharArray();
	for(int i=0;i<txt.length();i++){
		ch[i]=(char) (ch[i]^20);
	}
    
    try {
                //写入文件
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

            // 创建读取流，读取文件内容，并将读到的内容添加到日记显示区
            try (BufferedReader bufr = new BufferedReader(new FileReader(file));) {
                String txt = null;
                // 获取换行符,因为Linux和Windows下的换行符是不一样的。这样可以增强跨平台性
                String line = System.getProperty("line.separator");
                while ((txt = bufr.readLine()) != null) {
//                  解密程序
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
