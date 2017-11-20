package org.apache.cordova.ooyala;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.media.MediaScannerConnection;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.wcn.fishingtv.R;

import android.database.Cursor;
import android.provider.CallLog;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.apache.cordova.ooyala.lists.ChromecastListActivity;
import org.apache.cordova.ooyala.players.ChromecastBarebonesPlayerActivity;
import org.apache.cordova.ooyala.utils.ChromecastPlayerSelectionOption;
import org.apache.cordova.ooyala.players.ChromecastPlayerActivity;
import com.wcn.fishingtv.R;

import com.google.android.libraries.cast.companionlibrary.widgets.MiniController;
import com.ooyala.android.castsdk.CastManager;
import com.ooyala.android.castsdk.CastOptions;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

public class Ooyala extends CordovaPlugin {
  /**
   * Constructor.
   */
  private final String NAMESPACE = "urn:x-cast:ooyala";
  private final String APP_ID = "4172C76F";
  private MiniController defaultMiniController;

  public Ooyala() {
  }

  /**
   * Sets the context of the Command. This can then be used to do things like
   * get file paths associated with the Activity.
   *
   * @param cordova The context of the main Activity.
   * @param webView The CordovaWebView Cordova is running in.
   */
  public void initialize(CordovaInterface cordova, CordovaWebView webView) {
    super.initialize(cordova, webView);

  }

  /**
   * Executes the request and returns PluginResult.
   *
   * @param action            The action to execute.
   * @param args              JSONArry of arguments for the plugin.
   * @param callbackContext   The callback id used when calling back into JavaScript.
   * @return                  True if the action was valid, false if not.
   */
  public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
    if (action.equals("createPlayer")) {


      String code = args.getString(0);
      String eCode = args.getString(1);
      String domain = args.getString(2);
      //String title1 = args.getString(3);

      Context context=this.webView.getContext();


      Intent intent = new Intent(context, ChromecastListActivity.class);
      this.cordova.getActivity().startActivity(intent);


      JSONObject r = new JSONObject();
      r.put("status","Ok");
      callbackContext.success(r);
    }
    else if(action.equals("initPlayer"))
    {



    }
    else {
      return false;
    }
    return true;
  }

}