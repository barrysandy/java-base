package com.xgb.java.base.mytomcat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Server {
	
	private static int count = 0;
	
	public static void main(String[] args) {
		ServerSocket ss = null;
		Socket socket = null;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String ctime = format.format(new Date());
		try {
			ss = new ServerSocket(8000);
			System.out.println("�������Ѿ���ʼ�����ȴ��ͻ�������....");
			while(true) {
				socket = ss.accept();
				count ++ ;
				System.out.println("��" + count + "�����ӷ�����");
				//=============�õ�������Ϣ===============
				//�õ�������������Ӧ��������Ϣ
//				InputStream is = socket.getInputStream();
//				//������ÿ�ζ���������Ϣ����buff
//				byte[] buff = new byte[1024];
//				int len = is.read(buff);
//				if(len > 0) {
//					String msg = new String(buff,0,len);
//					System.out.println("----" + msg + "----");
//				}else {
//					System.out.println("bad Requset!!");
//				}
				
				Request req = new Request(socket.getInputStream());
				
				//==============���ͷ�����������Ϣ================
				//�õ������
//				OutputStream os = socket.getOutputStream();
//				String html = ""+ctime+"�������ظ������ǵ�"+count+"���ʷ��������û���";
//				os.write(html.getBytes());
//				os.flush();
//				os.close();
				
				Response response = new Response(socket.getOutputStream());
				
				//=================ҵ���߼�======================
				String uri = req.getUri();
				//�ж���������ǲ��Ǿ�̬��Դ .html .css .js �ȵ�
				if(isStatic(uri)) {
					try {
						response.writeFile(uri.substring(1));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}else {
					
				}
				//����Ҫ�ر�
				socket.close();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				ss.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	/**
	 * �ж�����ǲ�������̬��Դ
	 * @param uri
	 * @return
	 */
	public static boolean isStatic(String uri) {
		
		String[] suffixs = {"html","css","js","jpg","jpeg"};
		//
		boolean isStatic = false;
		for (String suffix : suffixs) {
			if(uri.endsWith("."+suffix)) {
				isStatic = true;
			}
		}
		return isStatic;
	}
}
