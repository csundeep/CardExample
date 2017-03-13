package com.example.sandy.cardviewexample;

import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.astuetz.PagerSlidingTabStrip;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class CardActivity extends AppCompatActivity {
    private static final String TAG = "RecyclerViewExample";

    private List<FeedItem> feedsList;
    private RecyclerView mRecyclerView;
    private MyRecyclerViewAdapter adapter;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ArrayList<Fragment> fragments = new ArrayList<>();
        List<String> tabs = new ArrayList<>();
        tabs.add("one");
        tabs.add("Two");
        Fragment f1 = new CardFragment();
        Fragment f2 = new CardFragment();
        fragments.add(f1);
        fragments.add(f2);

        SimpleFragmentPagerAdapter adapter = new SimpleFragmentPagerAdapter(getSupportFragmentManager(), fragments, tabs);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        // Set the adapter onto the view pager
        if (viewPager != null) {
            viewPager.setAdapter(adapter);
            viewPager.setCurrentItem(viewPager.getAdapter().getCount());
        }

        PagerSlidingTabStrip tabsStrip = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        // Attach the view pager to the tab strip
        if (tabsStrip != null && viewPager != null)
            tabsStrip.setViewPager(viewPager);
    }


}