package org.apache.cordova.ooyala;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaScannerConnection;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.cordova.ooyala.R;

import org.apache.cordova.ooyala.BasicPlaybackVideoPlayerActivity;

import android.database.Cursor;
import android.provider.CallLog;

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
      String title = args.getString(3);

      Context context=this.cordova.getActivity().getApplicationContext();

      Intent intent = new Intent(context, BasicPlaybackVideoPlayerActivity.class);
      intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
      intent.putExtra("embed_code", eCode);
      intent.putExtra("pcode", code);
      intent.putExtra("domain", domain);
      intent.putExtra("selection_name", title);
      this.cordova.getActivity().startActivity(intent);


      JSONObject r = new JSONObject();
      r.put("status","Ok");
      callbackContext.success(r);
    }
    else {
      return false;
    }
    return true;
  }
}