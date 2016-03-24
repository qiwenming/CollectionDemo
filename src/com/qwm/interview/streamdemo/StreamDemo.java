package com.qwm.interview.streamdemo;

import com.sun.org.apache.xpath.internal.SourceTree;
import jdk.internal.util.xml.impl.Input;

import java.io.*;
import java.util.Date;
import java.util.concurrent.locks.ReadWriteLock;

/**
 * Created by qiwenming on 2016/3/24.
 * 流
 */
public class StreamDemo {

    //=====================================字节流测试======================================
    public void testStream(){
        //键盘输入
        InputStream inputStream = System.in;
        try {
            System.out.println(inputStream.read());
        } catch (IOException e) {
            e.printStackTrace();
        }

        //文件读取
    }

    /**
     * 测试2
     */
    public void testStream2(){
        try {
            //网文件中写入数据
            File file = new File("D:\\IdeaProjects\\CollectionDemo\\text.txt");
            if(!file.exists()){
                file.createNewFile();
            }
            OutputStream outputStream = new FileOutputStream(file,true);
            outputStream.write(("\r\n我是小明" + System.currentTimeMillis()).getBytes());
            outputStream.flush();
            outputStream.close();

            //读出数据
            InputStream inputStream = new FileInputStream(file);
            byte[] buffer = new byte[1024];
            StringBuffer sb = new StringBuffer();
            int lenght = 0;
            while ((lenght=inputStream.read(buffer))>0){
                sb.append(new String(buffer,0,lenght));
            }
            inputStream.close();
            System.out.println(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void testStream3(){
        try{
            File file = new File("D:\\IdeaProjects\\CollectionDemo\\text1.txt");
            if(!file.exists()){
                file.createNewFile();
            }
            //写数据
            OutputStream out = new FileOutputStream(file,true);
            BufferedOutputStream bos = new BufferedOutputStream(out);
            bos.write(("\r\n哈哈测试而已"+System.currentTimeMillis()).getBytes());
            bos.flush();
            out.close();
            bos.close();

            //读数据
            InputStream in = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(in);
            byte[] buffer = new byte[1024];
            StringBuffer sb = new StringBuffer();
            int length = 0;
            while((length=in.read(buffer))>0){
                sb.append(new String(buffer,0,length));
            }
            in.close();
            bis.close();
            System.out.println(sb.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //=====================================字符流测试======================================
    public void testReaderAndWriter(){
        try {
            Date date = new Date();
            //写入
            File file = new File("D:\\IdeaProjects\\CollectionDemo\\字符流测试.txt");
            Writer writer = new FileWriter(file,true);
            writer.write("\r\n我是小明啦----"+date.toString());
            writer.close();

            //输出
            Reader reader = new FileReader(file);
            int length = 0;
            char[] buffer = new char[1024];
            StringBuffer sb = new StringBuffer();
            while ((length=reader.read(buffer))>0){
                sb.append(new String(buffer,0,length));
            }
            System.out.println(sb.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void testReaderAndWriter2(){
        try {
            Date date = new Date();
            //写入
            File file = new File("D:\\IdeaProjects\\CollectionDemo\\字符流测试2.txt");
            Writer writer = new FileWriter(file,true);
            BufferedWriter bw = new BufferedWriter(writer);
            bw.newLine();
            bw.write("小明是我啦--------》"+date.toString());
            bw.close();
            writer.close();

            //输出
            Reader reader = new FileReader(file);
            BufferedReader br = new BufferedReader(reader);
            StringBuffer sb = new StringBuffer();
            String str = null;
            while((str=br.readLine())!=null){
                sb.append(str+"\r\n");
            }


            System.out.println(sb.toString());

        }catch (Exception e){
            e.printStackTrace();
        }
    }

 //========================================字节流转字符流==============================================================

    /**
     * 键盘读取数据写入到文件中
     */
    public void testStreamReaderWriter(){
        try {
            Date date = new Date();
            File file = new File("D:\\IdeaProjects\\CollectionDemo\\字节流和字符流转换.txt");
            System.out.println("请输入文字：");
            //读数据  键盘读入 转换成字符流
            InputStream in = System.in;
            InputStreamReader isr =  new InputStreamReader(in);
            BufferedReader br = new BufferedReader(isr);
            String msg = br.readLine();
            in.close();
            isr.close();
            br.close();

            //写数据  键盘的数据写入到文件中  这里我们使用转换流
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file,true)));
            bw.write(date.toString()+":\t"+msg+"\r\n");
            bw.close();

            //把文件中的数据读取出来
            System.out.println("字节流和字符流转换.txt==============");
            BufferedReader br2 = new BufferedReader(new FileReader(file));
            String str ="";
            while ((str=br2.readLine())!=null){
                System.out.println(str);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
