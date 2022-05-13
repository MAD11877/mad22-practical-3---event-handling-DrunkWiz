package sg.edu.np.mad.week2pracmadnathan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewDebug;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class ListActivity extends AppCompatActivity {

    private String TAG = "Main Activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ImageView myImage = findViewById(R.id.imageView);
        myImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alert();
            }
        });
    }
    private String randomINT(){
        Random ran = new Random();
        //String value = String.valueOf(ran.nextInt(999999999));
        long val = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
        String value = String.valueOf(val);
        Log.v(TAG, "Random interger: " + value);
        Intent myIntent =  new Intent(ListActivity.this, MainActivity.class);
        myIntent.putExtra("MyRandomInt", value);
        startActivity(myIntent);
        return value;
    }
    private void alert(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Profile");
        builder.setMessage("MADness");
        builder.setCancelable(false);
        builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {randomINT();}
        });
        builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {finish(); }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}