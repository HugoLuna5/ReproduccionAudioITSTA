package lunainc.com.mx.app2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageButton action;
    private Button newView;
    private MediaPlayer mp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        action = (ImageButton) findViewById(R.id.action);
        newView = (Button) findViewById(R.id.newView);
        mp = MediaPlayer.create(this, R.raw.song_long);
        action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mp.isPlaying()){
                    mp.pause();
                    action.setBackgroundResource(R.drawable.ic_play);
                    Toast.makeText(MainActivity.this, "Pausa", Toast.LENGTH_SHORT).show();
                }else {
                    mp.start();
                    action.setBackgroundResource(R.drawable.ic_pause);
                    Toast.makeText(MainActivity.this, "Play", Toast.LENGTH_SHORT).show();
                }

            }
        });

        newView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

    }
}
