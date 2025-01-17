package com.okiyacode.styleapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GalleryActivity extends AppCompatActivity {

    private ImageView image;
    private Button next;
    private final int[] imagePic =  {R.drawable.c,
            R.drawable.d,
            R.drawable.e,
            R.drawable.d,
            R.drawable.f,
            R.drawable.g,
            R.drawable.k,
            R.drawable.x,
    };

    private int index = 0;
    private void setup() {
        image = findViewById(R.id.imageViewGallery);
        next = findViewById(R.id.btnNext);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_gallery);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setup();


        next.setOnClickListener(v -> {
            index++;
            if (index == imagePic.length) {
                index = 0;
            }
            image.setImageResource(imagePic[index]);
        });


    }
}