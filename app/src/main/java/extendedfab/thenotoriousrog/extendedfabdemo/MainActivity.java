package extendedfab.thenotoriousrog.extendedfabdemo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import extendedfablib.ExtendedFAB;
import extendedfablib.ExtendedFABScrollListener;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<String> list = new ArrayList<>();
    private ExtendedFAB fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);

        // simply populate the list with sample information.
        for(int i = 0; i < 100; i++) {
            String item = "List item " + (i+1);
            list.add(item);
        }

        // create a simple adapter and simply just create the adapter needed for this project to work.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, list);
        listView.setAdapter(adapter);

        fab = findViewById(R.id.extendedFAB);
        fab.setIcon(R.drawable.ic_swap_horiz_white_24dp);
        fab.setLabel("Switch");

        // change the colors of the fab itself.
        fab.changeLabelColor(R.color.white);
        fab.changeBackgroundColor(R.color.colorAccent);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent recyclerDemoActivity = new Intent(MainActivity.this, RecyclerDemoActivity.class);
                startActivity(recyclerDemoActivity);
            }
        });

        listView.setOnScrollListener(new ExtendedFABScrollListener(fab)); // use the ExtendedFABScrollListener to properly send events to the ExtendedFab that's passed in.


    }
}
