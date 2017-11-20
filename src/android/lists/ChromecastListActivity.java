package org.apache.cordova.ooyala.lists;
import android.app.Activity;

import android.content.Intent;
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

import org.apache.cordova.ooyala.players.ChromecastBarebonesPlayerActivity;
import org.apache.cordova.ooyala.utils.ChromecastPlayerSelectionOption;
import org.apache.cordova.ooyala.players.ChromecastPlayerActivity;
import com.cordova.ooyala.R;

import com.google.android.libraries.cast.companionlibrary.widgets.MiniController;
import com.ooyala.android.castsdk.CastManager;

public class ChromecastListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
  private static final String TAG = "ChromecastListActivity";

  private MiniController defaultMiniController;
  ChromecastPlayerSelectionOption[] videoList;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    Log.d(TAG, "onCreate()");
    super.onCreate(savedInstanceState);


    setContentView(R.layout.start_view);

    CastManager.getCastManager().getVideoCastManager().setStopOnDisconnect(false);

    // create the array of videos
    videoList = getVideoList();

    //Create the adapter for the ListView data
    ArrayAdapter<String> selectionAdapter = new ArrayAdapter<String>(this, R.layout.list_activity_list_item);
    for(ChromecastPlayerSelectionOption video : videoList) {
      selectionAdapter.add(video.title);
    }
    selectionAdapter.notifyDataSetChanged();

    //Populate the listView
    ListView listView = (ListView) findViewById(R.id.listView);
    listView.setAdapter(selectionAdapter);
    listView.setOnItemClickListener(this);

    //Restyle the CCL-provided minicontroller to have dark text
    defaultMiniController = (MiniController) findViewById(R.id.miniController1);
    TextView title = (TextView)defaultMiniController.findViewById(R.id.title_view);
    title.setTextColor(Color.BLACK);
    TextView subtitle = (TextView)defaultMiniController.findViewById(R.id.subtitle_view);
    subtitle.setTextColor(Color.GRAY);

    //Add the minicontroller to the list of minicontrolers managed by CCL
    CastManager.getVideoCastManager().addMiniController(defaultMiniController);

// Uncomment it if you want to activate the customized sample app in our sample app
//    customizedMiniController = (OOMiniController) findViewById(R.id.miniController2);
  }

  @Override
  public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    final Intent intent = new Intent(this, videoList[position].activity);
    intent.putExtra("embedcode", videoList[position].embedCode);
    intent.putExtra("embedcode2", videoList[position].embedCode2);
    intent.putExtra("pcode", videoList[position].pcode);
    intent.putExtra("domain", videoList[position].domain);
    startActivity(intent);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    super.onCreateOptionsMenu(menu);
    getMenuInflater().inflate(R.menu.main, menu);
    CastManager.getVideoCastManager().addMediaRouterButton(menu, R.id.media_route_menu_item);
    return true;
  }

  @Override
  protected void onStart() {
    Log.d(TAG, "onStart()");
    super.onStart();
  }
  
  @Override
  protected void onDestroy() {
    Log.d(TAG, "onDestroy()");
    CastManager.getVideoCastManager().removeMiniController(defaultMiniController);
    super.onDestroy();
  }

  @Override
  public void onResume() {
    super.onResume();
    if (CastManager.getCastManager().isInCastMode()) {
      defaultMiniController.setVisibility(View.VISIBLE);
    }
// Uncomment it if you want to activate the customized sample app in our sample app
//      castManager.addMiniController(customizedMiniController);
//      this.customizedMiniController.show();
    //onPause and onResume, call CCL code to support Cast Notifications
    CastManager.getCastManager().onResume();
    Log.d(TAG, "onResume()");
  }
  
  @Override
  public void onPause() {
    Log.d(TAG, "onPause()");
    //onPause and onResume, call CCL code to support Cast Notifications
    CastManager.getCastManager().onPause();
    super.onPause();
  }

  /**
    Generate the list of all videos for the list
   */
  private ChromecastPlayerSelectionOption[] getVideoList() {
    return new ChromecastPlayerSelectionOption[] {
      new ChromecastPlayerSelectionOption("Firas", "12aXY5MTE6sGeOfdhAo_vEaqgajYwfRi", "wzaDkyOnVDlnaTV7ppH7GYvIBbXM", "http://www.ooyala.com", ChromecastPlayerActivity.class),
    };
  }
}
