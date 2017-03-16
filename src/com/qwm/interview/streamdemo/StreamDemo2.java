package com.qwm.interview.streamdemo;

import java.io.*;
import java.nio.Buffer;
import java.util.Date;

/**
 * Author: qiwenming<br>
 * Create Date: 2017/3/16
 * Description: 流测试
 */
public class StreamDemo2 {
    public static void main(String[] args) throws Exception {
//        byteArrayTest();
//        fileOutAndInTest();
//        bufferedInAndOutTest();
//        testReaderAndWriter();
//        testReaderAndWriterBuffered();
        inOutToReadWriter();
    }

    /**
     * ByteArrayInputStream和ByteArrayOutputStream测试
     * 1.键盘输入，输出到 ByteArrayOutputStream中
     * 2.打印输入的字符
     * 3.把输出的数据，输入到ByteArrayInputStream中
     * 4.使用ByteArrayInputStream读取数据
     */
    public static void byteArrayTest() throws Exception {
        //1.
        ByteArrayOutputStream baos = new ByteArrayOutputStream();//默认32
        while(baos.size()!=12){
            baos.write(System.in.read());
        }
        //2.
        byte[] buf = baos.toByteArray();
        for (int i = 0; i <buf.length ; i++) {
            System.out.print((char)buf[i]+"  ");
        }
        System.out.println("\n------");

        //3.
        ByteArrayInputStream bais = new ByteArrayInputStream(buf);
        //4
        int c ;
        while( ( c=bais.read() )!=-1 ){
            System.out.println((char)c);
        }
    }

    /**
     * 文件测试 FileOutputStream和FileInputStream
     */
    public static void fileOutAndInTest() throws Exception {
        String fileName = "./myfile/fileStreamTest.txt";
        //输入到文件中
        byte[] buf = "wo name is xiaoming ,do you konw?".getBytes();
        FileOutputStream fos = new FileOutputStream(fileName);
        for (int i = 0; i < buf.length ; i++) {
            fos.write(buf[i]);
        }
        fos.close();

        //从文件中读取
        FileInputStream fis = new FileInputStream(fileName);
        int size = fis.available();
        for (int i = 0; i <size; i++) {
            System.out.print((char)fis.read());
        }
        fis.close();
    }

    /**
     * BufferedOutputStream和BufferedInputStream测试
     * @throws Exception
     */
    public static void bufferedInAndOutTest() throws Exception {
        String fileName = "./myfile/bufferedTest.txt";
        //输入到文件中
        byte[] buf = "wo name is xiaoming ,bufferedTest bufferedTest".getBytes();
        OutputStream os = new FileOutputStream(fileName);
        BufferedOutputStream bos = new BufferedOutputStream(os);
        bos.write(buf);
        bos.flush();
        bos.close();

        //读取
        InputStream is = new FileInputStream(fileName);
        BufferedInputStream bis = new BufferedInputStream(is);
        int length = 0;
        byte[] buff = new byte[1024];
        StringBuilder sb = new StringBuilder();
        while ( ( length = bis.read(buff) ) >0 ){
            sb.append(new String(buff,0,length));
        }
        bis.close();
        is.close();
        System.out.println(sb.toString());
    }

    /**
     * 文件测试 FileWriter和FileReader
     */
    public static void testReaderAndWriter() throws Exception {
        String fileName = "./myfile/testReaderAndWriter.txt";
        //输出到文件
        FileWriter fw = new FileWriter(fileName);
        fw.write("wo de ci shi di er ge ce shi ni men dong de ,wo ye bu zhi dao ni men ye bu zhi dao !!!!");
        fw.close();

        //从文件中读入
        FileReader fr = new FileReader(fileName);
        int length = 0;
        char[] bufC = new char[1024];
        StringBuilder sb = new StringBuilder();
        while( ( length = fr.read(bufC) ) >0 ){
            sb.append(new String(bufC,0,length));
        }
        System.out.println(sb.toString());
    }


    public static void testReaderAndWriterBuffered() throws Exception{
        String fileName = "./myfile/testReaderAndWriterBuffered.txt";
        //输出到文件
        FileWriter fw = new FileWriter(fileName);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("我们需要的只是测试而已，没错对的");
        bw.newLine();
        bw.write("testReaderAndWriterBuffered--->testReaderAndWriterBuffered");
        bw.flush();
        bw.close();
        fw.close();

        //读取
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);
        StringBuilder sb = new StringBuilder();
        String buff=null;
        while( (buff=br.readLine())!=null ){
            sb.append(buff+"\n");
        }
        br.close();
        fr.close();
        System.out.println(sb.toString());
    }

    //========================================字节流转字符流==============================================================
    /**
     * 字节流转字符流  InputStreamReader 和 OutputStreamWriter
     * 1.键盘读取
     * 2.写入文件
     * 3.读取文件
     */
    public static void inOutToReadWriter() throws Exception{
        String fileName = "./myfile/inOutToReadWriter.txt";
        System.out.println("------------请输入 886 为结束------------");
        //初始化数据
        BufferedReader bufReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb1 = new StringBuilder();
        String bufStr = null;
        while ( (bufStr=bufReader.readLine())!=null && !bufStr.contains("886") ){
            sb1.append(bufStr+"\n");
        }

        //数据写入文件中
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName,true)));
        bw.write(sb1.toString()+"\n"+ (new Date()).toString() +"\n");
        bw.close();

        System.out.println("------------inOutToReadWriter.txt-------------->");

        //读取
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        String buff = null;
        while( (buff = br.readLine())!=null ){
            System.out.println(buff);
        }
    }
}
