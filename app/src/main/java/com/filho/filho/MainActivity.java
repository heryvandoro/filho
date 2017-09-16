package com.filho.filho;

import android.content.Intent;
import android.os.StrictMode;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.filho.filho.helper.APIConstans;
import com.filho.filho.helper.JSONParser;
import com.filho.filho.helper.TmdbAPI;

import org.json.JSONObject;

import java.util.Vector;

public class MainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener,
        MenuItem.OnMenuItemClickListener,
        ViewPager.OnPageChangeListener{

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private PagerAdapter adapter;
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = (TabLayout) findViewById(R.id.tabDiscovery);
        viewPager = (ViewPager) findViewById(R.id.pagerDiscovery);

        adapter = new PagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(2);
        tabLayout.addOnTabSelectedListener(this);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Discovery");
        setSupportActionBar(toolbar);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open, R.string.navigation_drawer_close){
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };
        drawerLayout.addDrawerListener(actionBarDrawerToggle);

        actionBarDrawerToggle.syncState();

        managesMenu((NavigationView) findViewById(R.id.navigation_view));

        viewPager.addOnPageChangeListener(this);
    }

    public void managesMenu(NavigationView navigationView){
        Menu mainMenu = navigationView.getMenu();

        mainMenu.add(0,0,Menu.NONE,"About").setOnMenuItemClickListener(this);
        mainMenu.add(0,1,Menu.NONE,"Help").setOnMenuItemClickListener(this);

        Menu subMenu = mainMenu.addSubMenu("Categories");

        Vector<JSONObject> data = null;
        try {
            data = JSONParser.getArray(
                        new JSONObject(TmdbAPI.getRequest(APIConstans.CATEGORY)
                    ), "genres");

            for(JSONObject x : data){
                subMenu.add(1,Integer.parseInt(x.getString("id")),Menu.NONE, x.getString("name")).setOnMenuItemClickListener(this);
            }
        }catch (Exception e){};
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        drawerLayout.closeDrawers();
        Intent i = null;
        if(item.getGroupId()==0 && item.getItemId()==1){
            i = new Intent(this, HelpActivity.class);
        }else{
            i = new Intent(this, CategoryActivity.class);
            //Toast.makeText(this, item.getItemId()+"", Toast.LENGTH_SHORT).show();
            i.putExtra("category_id", item.getItemId());
            i.putExtra("category_name", item.getTitle());
        }
        startActivity(i);
        return false;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        tabLayout.setScrollPosition(position, positionOffset, true);
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
