package com.example.quliang.myapplication.net;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * 
 * 图片上传下载工具类
 * 
 * @author hy DownAndUploadPic.java 2015-11-05
 */
public class DownAndUploadPic {


	public static boolean downloadFile(String uri,String dir,String fileName) throws Exception {
//		SSLContext sc = SSLContext.getInstance("TLS");
//		sc.init(null, new TrustManager[]{new MyTrustManager()}, new SecureRandom());
//		HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
//		HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
//			@Override
//			public boolean verify(String hostname, SSLSession session) {
//				return true;
//			}
////		});
		URL url = new URL(uri);
		// 打开链接
		// 指定一个下载的目标链接，然后构建一个URL对象，调用该 对象的openConnection方法来建立一个数据通路（连接）。
		URLConnection connection =  url.openConnection();
		// 设置长链接
		connection.setRequestProperty("Connection", "Kepp-Alive");
		// 设置连接超时
		connection.setConnectTimeout(60 * 1000);

		int contentLength = connection.getContentLength();
		// 输入流
		// 代码的最后一行使用
		// connection.getInputStream，拿到一个输入流对象，通过这个流对象我们就可以读取到这个文件的内容了。下面要做的，就是读取这个流，将流写入我
		// 们的本地文件
		InputStream is = connection.getInputStream();
		// 获取文件的长度

		// 保存文件目录
		// Environment.getExternalStorageDirectory()
		// 方法会返回一个字符串，指示了存储卡的路径。我们拼接字符串出一个准备存放下载文件的文件夹。并先判断文件夹是是否存在，如果不存在，则新建一个文件夹
		File   f   = new File(dir);
		if (!f.exists()) {
			f.mkdirs();
		}

		File file = new File(dir + fileName);
		if (file.exists()) {// 文件已存在,并且不重复下载进行删除
			// file.delete();
		} else {
			// 下载
			try {
				byte[]       bs = new byte[4 * 1024];
				int          len;
				OutputStream os = new FileOutputStream(dir + fileName);
				while ((len = is.read(bs)) != -1) {
					os.write(bs, 0, len);
				}
				os.close();
			} catch (Exception e) {
				e.printStackTrace();
			} catch (OutOfMemoryError err) {
				err.printStackTrace();
			}
		}

		is.close();
		return true;
	}
}
