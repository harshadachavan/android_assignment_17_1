package com.harshadachavan.boundservice;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

public class UnboundMyService extends Service {
    private static final String LOGCAT = null;
    MediaPlayer AudioPlayer;

    public void onCreate(){
        super.onCreate();
        Log.d(LOGCAT, "Service Started!");
        AudioPlayer = MediaPlayer.create(this,R.raw.song);
    }

    public int onStartCommand(Intent intent, int flags, int startId){
        AudioPlayer.start();
        Log.d(LOGCAT, "Media Player started!");
        if(AudioPlayer.isLooping() != true){
            Log.d(LOGCAT, "Error in Playing Audio");
        }
        return START_STICKY;
    }

    public void onStop(){
        AudioPlayer.stop();
        AudioPlayer.release();
    }

    public void onPause(){
        AudioPlayer.stop();
        AudioPlayer.release();
    }
    public void onDestroy(){
        AudioPlayer.stop();
        AudioPlayer.release();
    }
    @Override
    public IBinder onBind(Intent Audioindent) {
        return null;
    }
}
