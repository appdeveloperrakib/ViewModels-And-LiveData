package com.appdeveloperrakib.viewmodelsandlivedata.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.appdeveloperrakib.viewmodelsandlivedata.R;
import com.appdeveloperrakib.viewmodelsandlivedata.ViewModel.MainActivityViewModel;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        btn = findViewById(R.id.button);

        //Create object for ViewModel
        MainActivityViewModel model = new ViewModelProvider(this).get(MainActivityViewModel.class);

        //Geting Number from LiveData and det it on textview
        MutableLiveData<String > number =  model.getMyRandomNumber();
        number.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                textView.setText(""+s);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.createRandomNumber();
            }
        });



    }
}