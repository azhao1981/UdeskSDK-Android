package udesk.udesksdk;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import cn.udesk.activity.UdeskChatActivity;


/**
 * 状态栏通知显示的样例
 */
public class NotificationUtils {
	private NotificationUtils(){
	}

	private static NotificationUtils instance = null;
	
	public static NotificationUtils getInstance(){
		
		if (instance==null) {
			instance = new NotificationUtils();
		}
		return instance;
	}

	/**
	 *
	 * @param context
	 * @param message  状态栏显示的内容
     */
	public void notifyMsg(Context context,String message){

			String notify_serivice = Context.NOTIFICATION_SERVICE;
			NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(notify_serivice);
			int icon = R.mipmap.ic_launcher;
			CharSequence tickerText = "你有一条新消息！";
			long when = System.currentTimeMillis();
			Notification notification = new Notification(icon, tickerText, when);
			notification.flags = Notification.FLAG_AUTO_CANCEL;
			notification.defaults |= Notification.DEFAULT_VIBRATE;
			notification.defaults |= Notification.DEFAULT_LIGHTS;
			notification.defaults = Notification.DEFAULT_SOUND;
			CharSequence contentTitle = "新消息";
     		CharSequence contentText = message;
     		Intent notificationIntent = null;
			notificationIntent = new Intent(context, UdeskChatActivity.class);
			notificationIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			PendingIntent contentIntent = PendingIntent.getActivity(context, 0,
					notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
			notification.setLatestEventInfo(context, contentTitle, contentText,
					contentIntent);
			mNotificationManager.notify(1, notification);
		}


}
