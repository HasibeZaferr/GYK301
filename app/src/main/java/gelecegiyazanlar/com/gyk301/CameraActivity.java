package gelecegiyazanlar.com.gyk301;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

public class CameraActivity extends AppCompatActivity {

    Button takePhoto;
    Button recordVideo;

    private static final int VIDEO_ACTION_CODE = 101;
    private static final int IMAGE_ACTION_CODE = 102;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        takePhoto = (Button) findViewById(R.id.take_photo);
        recordVideo = (Button) findViewById(R.id.record_video);


        takePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                takeNewPhoto();
            }
        });

        recordVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recordNewVideo();
            }
        });
    }



    private void takeNewPhoto() {
        Intent takePhotoIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(takePhotoIntent, IMAGE_ACTION_CODE);
    }

    private void recordNewVideo() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        startActivityForResult(takePictureIntent, VIDEO_ACTION_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode != RESULT_OK) return;

        switch (requestCode) {
            case VIDEO_ACTION_CODE :
                VideoView videoView = ((VideoView) findViewById(R.id.videoPreview));
                videoView.setVideoURI(data.getData());
                videoView.setMediaController(new MediaController(this));
                videoView.requestFocus();
                videoView.start();
                break;

            case IMAGE_ACTION_CODE :
                Bundle extras = data.getExtras();
                ((ImageView) findViewById(R.id.imagePreview)).setImageBitmap((Bitmap) extras.get("data"));
                break;
            default:
                break;
        }
    }
}
