//Mason Young
//Date: January 18, 2019
//Purpose: To create a game using grade 12 content
package com.example.masonyng.youngtexttwister;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class win extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);
    }
    public void toFirst(View view){
        Intent i = new Intent(this,
                splash.class);
        startActivity(i);
    }
}
