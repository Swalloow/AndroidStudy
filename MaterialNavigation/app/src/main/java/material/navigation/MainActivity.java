package material.navigation;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    String title[] = {"Home", "StopOver", "Restaurant", "Coffee"};
    int icon[] = {R.drawable.main, R.drawable.stopover, R.drawable.restaurant, R.drawable.coffee};
    String name = "이지은";
    String account = "dlwldms@naver.com";
    int profile = R.drawable.sulhyun;

    Fragment homeFragment;
    Fragment fragment;

    Toolbar toolbar;
    RecyclerView recyclerView;
    RecyclerView.Adapter recyclerAdapter;
    RecyclerView.LayoutManager recyclerManager;
    DrawerLayout drawer;
    ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.RecyclerView);
        recyclerView.setHasFixedSize(true);

        recyclerAdapter = new MyAdapter(title, icon, name, account, profile, this);
        recyclerView.setAdapter(recyclerAdapter);

        final GestureDetector gestureDetector = new GestureDetector(MainActivity.this,
                new GestureDetector.SimpleOnGestureListener() {
                    @Override
                    public boolean onSingleTapUp(MotionEvent e) {
                        return true;
                    }
                });

        // SlideMenu with RecyclerView
        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView _recyclerView, MotionEvent motionEvent) {
                View child = _recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
                int getTrue = 0;

                int menuNum = _recyclerView.getChildAdapterPosition(child);
                if (child != null && gestureDetector.onTouchEvent(motionEvent)) {
                    switch (menuNum) {
                        case 1:
                            fragment = new HomeFragment();
                            getTrue = 1;
                            break;
                        case 2:
                            fragment = new HomeFragment();
                            getTrue = 1;
                            break;
                        case 3:
                            fragment = new HomeFragment();
                            getTrue = 1;
                            break;
                        case 4:
                            fragment = new HomeFragment();
                            getTrue = 1;
                            break;
                        default:
                            break;
                    }

                    if (fragment != null) {
                        FragmentManager fragmentManager = getFragmentManager();
                        fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit();
                        drawer.closeDrawers();
                    }
                    if (getTrue == 1)
                        return true;
                }
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }

        });
        recyclerManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(recyclerManager);
        drawer = (DrawerLayout) findViewById(R.id.DrawerLayout);
        drawerToggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.openDrawer, R.string.closeDrawer) {

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };

        drawer.setDrawerListener(drawerToggle);
        drawerToggle.syncState();

        homeFragment = new HomeFragment();
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frame_container, homeFragment).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return super.onOptionsItemSelected(item);
    }
}