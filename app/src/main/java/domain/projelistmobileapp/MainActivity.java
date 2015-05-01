package domain.projelistmobileapp;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.ShareActionProvider;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity
{
    private Context activity;
    private ShareActionProvider mShareActionProvider;
    Button button;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        button = (Button) findViewById(R.id.MyButton);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent myIntent = new Intent(MainActivity.this, DisplayMessageActivity.class);
                startActivity(myIntent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main_activity_actions, menu);
        MenuItem shareItem = menu.findItem(R.id.action_share);
        mShareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(shareItem);
        //Log.w("NullPointerException", "Is mShareActionProvider null: " + (mShareActionProvider == null));
        mShareActionProvider.setShareIntent(getDefaultIntent());

        return super.onCreateOptionsMenu(menu);
    }

    private Intent getDefaultIntent()
    {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("image/*");
        return intent;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_search:
                openSearch();
                return true;
            case R.id.action_settings:
                openSettings();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void openSearch()
    {
        System.out.println("openSearch() içindesin");
        // TO DO
    }

    public void openSettings()
    {
        System.out.println("openSettings() içindesin");
        // TO DO
    }

    public Context getActivity()
    {
        return activity;
    }
}
