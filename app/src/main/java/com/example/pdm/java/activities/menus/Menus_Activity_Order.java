package com.example.pdm.java.activities.menus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.pdm.R;

public class Menus_Activity_Order extends AppCompatActivity {
    private static final String TAG_ACTIVITY = Menus_Activity_Order.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menus_order);
    }
    /**
     * Displays the actual message in a toast message.
     *
     * @param message Message to display.
     */
    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    /**
     * Checks which radio button was clicked
     * and displays a toast message to show the choice.
     *
     * @param view The radio button view.
     */
    public void onRadioButtonClicked(View view) {
            // Is a button now checked?
            boolean checked = ((RadioButton) view).isChecked();
            // Check which radio button was clicked
            if (checked) {
                if (view.getId() == R.id.sameday) {
                    // Same day service
                    displayToast(getString(R.string.chosen) + getString(R.string.same_day_messenger_service));
                } else if (view.getId() == R.id.nextday) {
                    // Next day delivery
                    displayToast(getString(R.string.chosen) + getString(R.string.next_day_ground_delivery));
                } else if (view.getId() == R.id.pickup) {
                    // Pick up
                    displayToast(getString(R.string.chosen) + getString(R.string.pick_up));
                } else {
                    Log.d(TAG_ACTIVITY, getString(R.string.nothing_clicked));
                }
            }

    }
}