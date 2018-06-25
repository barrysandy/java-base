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
			System.out.println("服务器已经初始化，等待客户端连接....");
			while(true) {
				socket = ss.accept();
				count ++ ;
				System.out.println("第" + count + "次连接服务器");
				//=============拿到请求信息===============
				//拿到输入流，有相应的请求信息
//				InputStream is = socket.getInputStream();
//				//输入流每次读出来的信息放入buff
//				byte[] buff = new byte[1024];
//				int len = is.read(buff);
//				if(len > 0) {
//					String msg = new String(buff,0,len);
//					System.out.println("----" + msg + "----");
//				}else {
//					System.out.println("bad Requset!!");
//				}
				
				Request req = new Request(socket.getInputStream());
				
				//==============发送服务器返回信息================
				//拿到输出流
//				OutputStream os = socket.getOutputStream();
//				String html = ""+ctime+"服务器回复：你是第"+count+"访问服务器的用户。";
//				os.write(html.getBytes());
//				os.flush();
//				os.close();
				
				Response response = new Response(socket.getOutputStream());
				
				//=================业务逻辑======================
				String uri = req.getUri();
				//判断这个请求是不是静态资源 .html .css .js 等等
				if(isStatic(uri)) {
					try {
						response.writeFile(uri.substring(1));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}else {
					
				}
				//这里要关闭
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
	 * 判断这个是不是请求静态资源
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
