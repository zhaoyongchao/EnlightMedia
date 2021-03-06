package com.enlight.android.common.network;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 请求监听者
 * @author zyc
 *
 */
public interface RequestCallback {
	
	/**解析数据*/
	public Object parserData(JSONObject jsonObject) throws JSONException;
	
	/**联网解析结束，但还在异步线程中，这里可以放一些费时操作，如操作数据库，读写文件，不可以放UI相关代码*/
	public void requestParserFinishedOnAysncTask(Object o);

	/**处理状态码的方法,true处理，false不处理*/
	public boolean handleCode(int responseCode, String responseMessage);

	/**取消联网*/
	public void requestCancel();
	
	/**联网错误*/
	public boolean requestFailed(Exception e);

	/**联网解析完成，处理一些UI事件，严禁放入耗时操作，如联网，操作数据库，操作本地文件*/
	public void requestSuccess(Object o);
	
	/**文件上传或下载百分比*/
	public void uploadProgress(long totalSize, long currentSize);

}
