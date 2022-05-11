package com.example.tourguide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(getString(R.string.about_nigeria));

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState( );

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // Start the first Menu item in Navigation Drawer and highlight it
        onNavigationItemSelected(navigationView.getMenu( ).getItem(0).setChecked(true));
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed( );
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId( );

        switch (id) {
            case R.id.nav_to:
                /** When user clicks on NG option start {@link OverviewFragment} */
                getSupportFragmentManager( ).beginTransaction( )
                        .replace(R.id.content_body, new OverviewFragment( ))
                        .commit( );
                getSupportActionBar( ).setTitle(getString(R.string.about_nigeria));
                break;
            case R.id.nav_architecture:
                /** When user clicks on Architecture option start {@link ArchitectureFragment} */
                getSupportFragmentManager( ).beginTransaction( )
                        .replace(R.id.content_body, new ArchitectureFragment( ))
                        .commit( );
                getSupportActionBar( ).setTitle(getString(R.string.architecture_category));
                break;
            case R.id.nav_restaurant:
                /** When user clicks on Restaurant option start {@link RestaurantFragment} */
                getSupportFragmentManager( ).beginTransaction( )
                        .replace(R.id.content_body, new RestaurantFragment( ))
                        .commit( );
                getSupportActionBar( ).setTitle(getString(R.string.restaurant_category));
                break;
            case R.id.nav_shopping:
                /** When user clicks on Shopping option start {@link ShoppingFragment} */
                getSupportFragmentManager( ).beginTransaction( )
                        .replace(R.id.content_body, new ShoppingFragment( ))
                        .commit( );
                getSupportActionBar( ).setTitle(getString(R.string.shopping_category));
                break;
            case R.id.nav_nightlife:
                /** When user clicks on Music and Nightlife option start {@link NightLifeFragment} */
                getSupportFragmentManager( ).beginTransaction( )
                        .replace(R.id.content_body, new NightLifeFragment( ))
                        .commit( );
                getSupportActionBar( ).setTitle(getString(R.string.nightlife_category));
                break;
            default:
                getSupportFragmentManager( ).beginTransaction( )
                        .replace(R.id.content_body, new OverviewFragment( ))
                        .commit( );
                break;
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
