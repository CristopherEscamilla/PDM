package com.example.pdm.java.activities.menus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;


import com.example.pdm.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

public class MainMenusActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menus_main);

        Toolbar toolbars = findViewById(R.id.toolbar);
        setSupportActionBar(toolbars);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Seemding mail", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                enviarCorreo("destinatario@example.com", "Asunto del correo", "Cuerpo del correo");
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbars, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        if (drawer != null) {
            drawer.addDrawerListener(toggle);
        }
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (navigationView != null) {
            navigationView.setNavigationItemSelectedListener(this);
        }

    }

    /**
     * Inflates the menu, and adds items to the action bar if it is present.
     *
     * @param menu Menu to inflate.
     * @return Returns true if the menu inflated.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menus_menu_main, menu);
        return true;
    }

    /**
     * Handles app bar item clicks.
     *
     * @param item Item clicked.
     * @return Returns true if one of the defined items was clicked.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_contact) {
            displayToast(getString(R.string.action_contact_message));
            return true;
        } else if (id == R.id.action_order) {
            displayToast(getString(R.string.action_order_message));
            return true;
        } else if (id == R.id.action_status) {
            displayToast(getString(R.string.action_status_message));
            return true;
        } else if (id == R.id.action_favorites) {
            displayToast(getString(R.string.action_favorites_message));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Shows a message that the donut image was clicked.
     */
    public void showDonutOrder(View view) {
        showFoodOrder(getString(R.string.donut_order_message));
    }

    /**
     * Shows a message that the ice cream sandwich image was clicked.
     */
    public void showIceCreamOrder(View view) {
        showFoodOrder(getString(R.string.ice_cream_order_message));
    }

    /**
     * Shows a message that the froyo image was clicked.
     */
    public void showFroyoOrder(View view) {
        showFoodOrder(getString(R.string.froyo_order_message));
    }

    /**
     * Displays a Toast message for the food order.
     *
     * @param message Message to display.
     */
    public void showFoodOrder(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, Menus_Activity_Order.class);
        startActivity(intent);
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }
    public void enviarCorreo(String destinatario, String asunto, String cuerpo) {
        // Crear un intent con la acción ACTION_SENDTO
        Intent intent = new Intent(Intent.ACTION_SENDTO);

        // Establecer el destinatario del correo electrónico
        intent.setData(Uri.parse("mailto:" + destinatario));

        // Establecer el asunto del correo electrónico
        intent.putExtra(Intent.EXTRA_SUBJECT, asunto);

        // Establecer el cuerpo del correo electrónico
        intent.putExtra(Intent.EXTRA_TEXT, cuerpo);


            startActivity(intent);
        }

    /**
     * Handles the Back button: closes the nav drawer.
     */
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer != null) {
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            } else {
                super.onBackPressed();
            }
        }
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        // Handle navigation view item clicks here.
        int itemId = menuItem.getItemId();
        if (itemId == R.id.nav_camera) {
            // Handle the camera import action (for now display a toast).
            drawer.closeDrawer(GravityCompat.START);
            displayToast(getString(R.string.chose_camera));
            return true;
        } else if (itemId == R.id.nav_gallery) {
            // Handle the gallery action (for now display a toast).
            drawer.closeDrawer(GravityCompat.START);
            displayToast(getString(R.string.chose_gallery));
            return true;
        } else if (itemId == R.id.nav_slideshow) {
            // Handle the slideshow action (for now display a toast).
            drawer.closeDrawer(GravityCompat.START);
            displayToast(getString(R.string.chose_slideshow));
            return true;
        } else if (itemId == R.id.nav_manage) {
            // Handle the tools action (for now display a toast).
            drawer.closeDrawer(GravityCompat.START);
            displayToast(getString(R.string.chose_tools));
            return true;
        } else if (itemId == R.id.nav_share) {
            // Handle the share action (for now display a toast).
            drawer.closeDrawer(GravityCompat.START);
            displayToast(getString(R.string.chose_share));
            return true;
        } else if (itemId == R.id.nav_send) {
            // Handle the send action (for now display a toast).
            drawer.closeDrawer(GravityCompat.START);
            displayToast(getString(R.string.chose_send));
            return true;
        }
        return false;
    }
}