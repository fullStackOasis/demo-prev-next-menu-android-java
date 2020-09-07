package com.fullstackoasis.demopreviousnextmenubar;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private static String TAG = MainActivity.class.getCanonicalName();

    private static int[] imageIds = { R.drawable.darkest_flower,
        R.drawable.dark_flower, R.drawable.light_flower, R.drawable.lightest_flower };

    private int currentImageNumber = 0;

    private boolean menuDisabled =
            currentImageNumber == 0 || currentImageNumber == imageIds.length -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        setCurrentImage();
    }

    private void setCurrentImage() {
        Log.d(TAG, "setCurrentImage! " + currentImageNumber);
        ImageView imageView = findViewById(R.id.imageView);
        int imageId = imageIds[currentImageNumber];
        Log.d(TAG, "image id " + imageId);
        imageView.setImageDrawable(getDrawable(imageId));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        Log.d(TAG, "XXX " + id + ", " + R.id.action_prev + ", " + R.id.action_next);

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_next) {
            setNextImage();
            return true;
        } else if (id == R.id.action_prev) {
            setPrevImage();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setPrevImage() {
        currentImageNumber--;
        setCurrentImage();
        if (shouldDisablePrevMenuItem()) {
            supportInvalidateOptionsMenu();
        }
    }

    private void setNextImage() {
        currentImageNumber++;
        setCurrentImage();
        if (shouldDisableNextMenuItem()) {
            supportInvalidateOptionsMenu();
        }
    }

    private boolean shouldDisablePrevMenuItem() {
        return (currentImageNumber == 0);
    }

    private boolean shouldDisableNextMenuItem() {
        return (currentImageNumber == imageIds.length - 1);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem itemNext = menu.findItem(R.id.action_next);
        if (shouldDisableNextMenuItem()) {
            itemNext.setEnabled(false);
        } else {
            itemNext.setEnabled(true);
        }
        MenuItem itemPrev = menu.findItem(R.id.action_prev);
        if (shouldDisablePrevMenuItem()) {
            itemPrev.setEnabled(false);
        } else {
            itemNext.setEnabled(true);
        }
        return super.onPrepareOptionsMenu(menu);
    }

}
