package com.example.ritik.implicitintent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void Process(View view)
    {
        Intent intent = null;
        Intent chooser = null;
        if(view.getId()==R.id.button)
        {
            intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("geo:19.076,72.8777"));
            chooser=Intent.createChooser(intent,"Launch Maps");
            //startActivity(intent);
            startActivity(chooser);

        }
        if(view.getId()==R.id.button2)
        {
            intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("market://details?id=com.zapak.littlesinghamrun"));
            // startActivity(intent);
            chooser = Intent.createChooser(intent,"Market");
            startActivity(chooser);

        }
        if(view.getId()==R.id.button3)
        {
            intent = new Intent(Intent.ACTION_SEND);
            intent.setData(Uri.parse("mailto:"));
            String[] to = {"ritikagarwal700@gamil.com","ritiktruelover030@gmail.com"};
            intent.putExtra(Intent.EXTRA_EMAIL, to);
            intent.putExtra(Intent.EXTRA_SUBJECT,"my app send this");
            intent.putExtra(Intent.EXTRA_TEXT,"hey i will have to crack it and will not give up");
            intent.setType("message/rfc822");//mime type
            chooser=Intent.createChooser(intent,"Email");
            startActivity(chooser);
        }
        if(view.getId()==R.id.button5)
        {


            Uri imageUri = Uri.parse("android.resource://com.example.ritik.implicitintent/drawable/"+R.drawable.home);
            intent = new Intent(Intent.ACTION_SEND);

            intent.setType("image/*");

            intent.putExtra(Intent.EXTRA_STREAM, imageUri);
            intent.putExtra(Intent.EXTRA_TEXT,"Attached Images");
           chooser=Intent.createChooser(intent,"Send Image");
           //chooser.get
            startActivity(chooser);
           // ImageView iv = findViewById(R.id.imageView);
           // iv.setImageResource(R.drawable.coer);

        }
    }
}


