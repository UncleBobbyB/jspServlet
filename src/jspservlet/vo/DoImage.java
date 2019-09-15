package jspservlet.vo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
 
import java.util.Base64;
import java.util.Base64.*;

public class DoImage {
	public static String imageToBase64(String path) {// ��ͼƬ�ļ�ת��Ϊ�ֽ������ַ��������������Base64���봦��
	    byte[] data = null;
	    // ��ȡͼƬ�ֽ�����
	    try {
	        InputStream in = new FileInputStream(path);
	        data = new byte[in.available()];
	        in.read(data);
	        in.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    // ���ֽ�����Base64����
	    Encoder encoder = Base64.getEncoder();
	    return encoder.encodeToString(data);// ����Base64��������ֽ������ַ���
	}
	public static boolean base64ToImage(String base64, String path) {// ���ֽ������ַ�������Base64���벢����ͼƬ
	    if (base64 == null){ // ͼ������Ϊ��
	        return false;
	    }
	    Decoder decoder = Base64.getDecoder();
	    try {
	        // Base64����
	        byte[] bytes = decoder.decode(base64);
	        for (int i = 0; i < bytes.length; ++i) {
	            if (bytes[i] < 0) {// �����쳣����
	                bytes[i] += 256;
	            }
	        }
	        // ����jpegͼƬ
	        OutputStream out = new FileOutputStream(path);
	        out.write(bytes);
	        out.flush();
	        out.close();
	        return true;
	    } catch (Exception e) {
	        return false;
	    }
	}
	public static void main(String[] str) throws Exception {//����
		
		String path = "D:\\1.jpg";
		String base64 = DoImage.imageToBase64(path);
	
		
		DoImage.base64ToImage(base64, "D:\\2.png");
		
		System.out.println(base64+"+++++++++++");
		
		
		
	}
}
