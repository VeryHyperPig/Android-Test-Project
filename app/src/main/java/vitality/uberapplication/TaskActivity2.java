package vitality.uberapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class TaskActivity2 extends AppCompatActivity {

    List<ImageView> images = new ArrayList<>();
    private int counter = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task2);

        EditText editUrl = findViewById(R.id.editUrl);
        ImageButton icDownload = findViewById(R.id.icDownload);
        ImageView image1 = findViewById(R.id.image1);
        ImageView image2 = findViewById(R.id.image2);
        ImageView image3 = findViewById(R.id.image3);
        ImageView image4 = findViewById(R.id.image4);

        images.add(image1);
        images.add(image2);
        images.add(image3);
        images.add(image4);

        icDownload.setOnClickListener(v -> {
            String link = editUrl.getText().toString();
            if (editUrl.getText().length() == 0) {
                editUrl.setHint("Вы не вставили ссылку!");
            } else {
                editUrl.setHint("Вставьте ссылку");
//                Glide.with(this).load(link).into(image1);
                nextImage(link);
                editUrl.setText(null);
            }
        });
    }
    private void nextImage(String link) {
        int index = ++counter;

        if (index > images.size() - 1) {
            index = 0;
            counter = 0;
        }

        ImageView imageLoad = images.get(index);
        Glide.with(this).load(link).into(imageLoad);
    }
}