package citc.testmediasessionlistener;


import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

public class MyApp extends Application {

    @Override
    public void onCreate() {

        super.onCreate();
        LeakCanary.install(this);

    }

}
