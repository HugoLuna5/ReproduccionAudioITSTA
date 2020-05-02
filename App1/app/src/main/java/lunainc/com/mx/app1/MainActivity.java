package lunainc.com.mx.app1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    private SoundPool sp;
    private int sonido_de_Reproduccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         * Ojo:
         * Esta clase ya no esta siendo utilizada
         */
        sp = new SoundPool(1, AudioManager.STREAM_MUSIC, 1);
        sonido_de_Reproduccion = sp.load(this, R.raw.song_short, 1);
    }

    public void audioSoundPool(View view){
        sp.play(sonido_de_Reproduccion,1,1,1,0,0);
    }

    public void audioMediaPlayer(View view){
        MediaPlayer mp = MediaPlayer.create(this, R.raw.song_long);
        mp.start();
    }


}
