package com.Joke.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;

public class JDOM {

        //ע���û���Ϣ
	public static String write(String n, String p, String id) {
            // TODO Auto-generated method stub

            //UserInfo.xml�ĵ���·��
    String path = "./UserInfo.xml";
            //��xml�ĵ���װ��file
    File file = new File(path);
            //ʹ��Ĭ�ϵ�sax������
    SAXBuilder saxBuilder = new SAXBuilder();
    Document doc; //����document�ĵ�
    try {
    	doc = saxBuilder.build(file);

                //Ԫ�ض�Ӧ��xml�ĵ��о��Ǳ�ǩ
        Element root = doc.getRootElement(); //�õ���Ԫ��
        Element user = new Element("User"); //����UserԪ��
        Element name = new Element("name");//����nameԪ��
        Element passwd = new Element("passwd");//����passwdԪ��

                /*���ȼ��xml�ĵ����Ƿ��Ѿ�������ID����ͬ���û�����������ڲſ��Լ���ע��*/
        if (checkID(id, root)) {
                    //��ID����Ϊuser������
        	user.setAttribute(new Attribute("id", id)); 
                    //��������������
            name.setText(n);
            passwd.setText(p);

                    //��name��passwdԪ����ӵ�userԪ����
            user.addContent(name);
            user.addContent(passwd);

                    //��userԪ����ӵ���Ԫ����
            root.addContent(user);

                    //���xml�ĵ�
            XMLOutputter out = new XMLOutputter();
            out.output(doc, new FileOutputStream(file));
            return "Successful registration";//����ע��ɹ�
            } else
                    //����ID������Ϣ����������ID
            	return "ID already exists, please input again";

            } catch (JDOMException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return "ERROR";//δ֪����

        }

        public static boolean checkID(String id, Element root) {
            // ���ID�Ƿ����
            boolean flag = true;
            @SuppressWarnings("unchecked")
            //�õ�User��ǩ��������Ԫ�أ������뵽map������
            List<Element> list = root.getChildren("User");
            //��������Ƿ����ID
            Iterator<Element> it = list.iterator();
            while (it.hasNext()) {
                Element e = (Element) it.next();
                if (e.getAttributeValue("id").equals(id)) {
                    flag = false;
                }
            }
            return flag;
                     
            
        }

        //��ȡxml�ĵ����ڵ�¼
        public static String read(String id, String passwd) {
            String path = "./UserInfo.xml";
            File file = new File(path);
            SAXBuilder saxBuilder = new SAXBuilder();

            try {
                Document doc = saxBuilder.build(file);
                Element root = doc.getRootElement();

                //ȡ���û����������
                String info = getPasswd(root).get(id);
                if (info == null) {
                    return "User does not exist!!";
                }
                String[] buf = info.split("/");

                if (buf[0].equals(passwd)) {
                    return "Successful landing/" + buf[1];
                }

            } catch (JDOMException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return "Wrong password!!";
        }

        @SuppressWarnings("unchecked")
        /*���û��������������ӵ�map������*/
          private static Map<String, String> getPasswd(Element root) {
            Map<String, String> map = new TreeMap<String, String>();//�����û���Ϣ
            List<Element> list = new ArrayList<Element>();
            //�õ�User��ǩ��������Ԫ����Ϣ
            list = root.getChildren("User");
            Iterator<Element> it = list.iterator();
            while (it.hasNext()) {
                Element e = it.next();
                String id = e.getAttributeValue("id");
                String passwd = e.getChildText("passwd");
                String name = e.getChildText("name");
                map.put(id, getInfo(passwd, name));
            }

            return map;

        }

        //�����û��������Ϣ
        private static String getInfo(String passwd, String name) {

            return passwd + "/" + name;

        }
    }