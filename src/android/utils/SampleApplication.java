package org.apache.cordova.ooyala.utils;

import android.app.Application;
import android.content.pm.ApplicationInfo;

import com.ooyala.android.castsdk.CastManager;
import com.ooyala.android.castsdk.CastOptions;

import org.apache.cordova.ooyala.players.ChromecastPlayerActivity;

/**
 * This application is made to initialize the CastManager right at the start of the app load
 *
 * This step does not necessarily have to happen in the Application class, but is a reccomended option
 */
public class SampleApplication extends Application {
  private final String NAMESPACE = "urn:x-cast:ooyala";
  private final String APP_ID = "4172C76F";

  @Override
  public void onCreate() {
    super.onCreate();
    try {
      boolean isDebuggable =  ( 0 != ( getApplicationInfo().flags & ApplicationInfo.FLAG_DEBUGGABLE ) );
      CastOptions options = new CastOptions.Builder(APP_ID, NAMESPACE).setEnableCastDebug(isDebuggable).setTargetActivity(ChromecastPlayerActivity.class).build();
      CastManager.initialize(this, options);
    } catch (CastManager.CastManagerInitializationException e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }
}
