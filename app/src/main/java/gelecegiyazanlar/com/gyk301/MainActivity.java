package gelecegiyazanlar.com.gyk301;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button openPhotoAndVideo;
    Button openVoice;
    Button openMap;
    Button openWeb;
    Button dialCall;
    Button sendSms;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openPhotoAndVideo = (Button) findViewById(R.id.open_photo_and_video);
        openPhotoAndVideo.setOnClickListener(this);
        openVoice = (Button) findViewById(R.id.open_voice);
        openVoice.setOnClickListener(this);
        openMap = (Button) findViewById(R.id.open_map);
        openMap.setOnClickListener(this);
        openWeb = (Button) findViewById(R.id.open_web);
        openWeb.setOnClickListener(this);
        dialCall = (Button) findViewById(R.id.dial_call);
        dialCall.setOnClickListener(this);
        sendSms = (Button) findViewById(R.id.send_sms);
        sendSms.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == openPhotoAndVideo){
            Intent photoAndVideoIntent = new Intent(MainActivity.this,CameraActivity.class);
            startActivity(photoAndVideoIntent);

        } else if(view == openVoice){
            Intent voiceIntent = new Intent(MainActivity.this,VoiceActivity.class);
            startActivity(voiceIntent);

        } else if(view == openMap){
            Intent mapIntent = new Intent(MainActivity.this,MapActivity.class);
            startActivity(mapIntent);

        } else if(view == openWeb){
            Intent webIntent = new Intent(MainActivity.this,WebActivity.class);
            startActivity(webIntent);

        } else if(view == dialCall){
            Intent callIntent = new Intent(MainActivity.this,CallActivity.class);
            startActivity(callIntent);
        } else if(view == sendSms) {
            Intent smsIntent = new Intent(MainActivity.this,SmsActivity.class);
            startActivity(smsIntent);
        }
    }
}
