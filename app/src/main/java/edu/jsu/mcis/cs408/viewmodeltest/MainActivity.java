package edu.jsu.mcis.cs408.viewmodeltest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create and initialize shared ViewModel

        TestViewModel model = new ViewModelProvider(this).get(TestViewModel.class);
        model.init(getApplicationContext());

    }

}