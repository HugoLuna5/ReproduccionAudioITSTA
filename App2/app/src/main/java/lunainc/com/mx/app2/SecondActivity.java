package lunainc.com.mx.app2;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private ImageButton action_play;
    private ImageButton action_pause;
    private ImageButton action_stop;
    private MediaPlayer mp;
    private int pause;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        init();
        events();
    }
    private void init(){
        action_play = (ImageButton) findViewById(R.id.action_play);
        action_pause = (ImageButton) findViewById(R.id.action_pause);
        action_stop = (ImageButton) findViewById(R.id.action_stop);

    }

    private void events() {


        action_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mp == null){
                    mp = MediaPlayer.create(SecondActivity.this, R.raw.song_long);
                    mp.start();
                    Toast.makeText(SecondActivity.this, "Play", Toast.LENGTH_SHORT).show();
                }else if(!mp.isPlaying()){
                    mp.seekTo(pause);
                    mp.start();
                    Toast.makeText(SecondActivity.this, "Reanudando", Toast.LENGTH_SHORT).show();
                }
            }
        });

        action_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mp != null){
                    mp.pause();
                    pause = mp.getCurrentPosition();
                    Toast.makeText(SecondActivity.this, "Pausa", Toast.LENGTH_SHORT).show();
                }
            }
        });

        action_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mp != null){
                    mp.stop();
                    mp = null;
                    Toast.makeText(SecondActivity.this, "Stop", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


}
