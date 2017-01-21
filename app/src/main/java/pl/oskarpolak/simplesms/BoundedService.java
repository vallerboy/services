package pl.oskarpolak.simplesms;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by OskarPraca on 2017-01-21.
 */

public class BoundedService extends Service {

    private final IBinder mBinder = new LocalBinder();
    private Handler handler = new Handler();
    public class LocalBinder extends Binder {
       public BoundedService getService() {
            return BoundedService.this;
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    // Metoda zapewniona
    public void generateToast() {
        Toast.makeText(BoundedService.this, "Jestem z serwisu", Toast.LENGTH_SHORT).show();
    }
}
