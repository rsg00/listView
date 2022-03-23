package com.example.listview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity {

   EditText foodInput;
   Button submit;
   ListView theList;

    List<String> listItems; // = new ArrayList<>();
    String [] starterList = {"Apple", "Banana", "Cucumber"};
    ArrayAdapter ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        foodInput = findViewById(R.id.FoodInput);
        submit = findViewById(R.id.buttonSubmit);
        theList = findViewById(R.id.TheList);

        listItems = new ArrayList<>(Arrays.asList(starterList));
        ad = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listItems);
        theList.setAdapter(ad);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String wordInput = foodInput.getText().toString();
                listItems.add(wordInput);
                ad.notifyDataSetChanged();
            }
        });


        theList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              Toast.makeText(MainActivity.this, listItems.get(position)+"", Toast.LENGTH_LONG).show();
              listItems.remove(position);
              ad.notifyDataSetChanged();
            }
        });


    }
}