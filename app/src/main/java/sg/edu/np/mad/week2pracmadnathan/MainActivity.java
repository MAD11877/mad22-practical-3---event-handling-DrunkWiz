package sg.edu.np.mad.week2pracmadnathan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String TAG = "Main Activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent receivingEnd = getIntent();
        String random = receivingEnd.getStringExtra("MyRandomInt");
        //Using getIntExtra returns default value and not the actual value attached to key
        TextView myTextView = findViewById(R.id.textView);
        String printable = String.format("MAD %s",random);
        myTextView.setText(printable);

        User myUser =  new User();
        myUser.setFollowed(false);
        long newLong =Long.parseLong(random);
        myUser.setId(newLong);

        Button myfollowbutton = findViewById(R.id.FollowButton);
        myfollowbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean bool = myUser.getFollowed();
                bool = !bool;
                myUser.setFollowed(bool);
                Log.v(TAG, "on Click....");
                if (myUser.getFollowed() == Boolean.FALSE){
                    myfollowbutton.setText("Follow");
                }
                else {
                    myfollowbutton.setText("Unfollow");
                    Toast.makeText(getApplicationContext(),"Followed",Toast.LENGTH_SHORT).show();
                }
                Log.v(TAG, "on Click....");
                }
        });

        Button myMessageButton  = findViewById(R.id.MessageButton);
        myMessageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent =  new Intent(MainActivity.this, MessageGroup.class);
                //myIntent.putExtra("MyRandomInt", value);
                startActivity(myIntent);
            }
        });

    }

}