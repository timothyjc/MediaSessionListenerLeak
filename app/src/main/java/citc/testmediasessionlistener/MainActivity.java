package citc.testmediasessionlistener;

import android.content.ComponentName;
import android.content.Context;
import android.media.session.MediaController;
import android.media.session.MediaSessionManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;

import java.util.List;


public class MainActivity extends ActionBarActivity {

    private static final String TAG = MainActivity.class.getName();

    private MediaSessionManager.OnActiveSessionsChangedListener mListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListener = new MediaSessionManager.OnActiveSessionsChangedListener() {
            @Override
            public void onActiveSessionsChanged(List<MediaController> controllers) {
                // should only be called once unless activity is being leaked
                Log.i(TAG, "active sessions changed " + this.hashCode());
            }
        };

    }


    public void register() {
        try {
            Log.i(TAG, "registering listener");
            MediaSessionManager mm = (MediaSessionManager) getSystemService(Context.MEDIA_SESSION_SERVICE);
            ComponentName componentName = new ComponentName(this, NotificationListener.class);
            mm.addOnActiveSessionsChangedListener(mListener, componentName);
        } catch (SecurityException e) {
            Log.i(TAG, "failed to register", e);
        }

    }

    public void unregister() {
        try {
            Log.i(TAG, "unregistering listener");
            MediaSessionManager mm = (MediaSessionManager) getSystemService(Context.MEDIA_SESSION_SERVICE);
            mm.removeOnActiveSessionsChangedListener(mListener);
        } catch (SecurityException e) {
            Log.i(TAG, "failed to unregister", e);
        }
    }


    @Override
    public void onStart() {
        super.onStart();
        register();
    }

    @Override
    public void onStop() {
        super.onStop();
        unregister();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "activity destroyed");
    }


}
