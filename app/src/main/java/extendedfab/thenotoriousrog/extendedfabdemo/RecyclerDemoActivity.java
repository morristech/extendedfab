package extendedfab.thenotoriousrog.extendedfabdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

import extendedfab.thenotoriousrog.extendedfab.ExtendedFABRecyclerScrollListener;

public class RecyclerDemoActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private extendedfablib.ExtendedFAB fab;
    private RecyclerDemoViewAdapter adapter;

    private void setupRecyclerView() {

        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < 100; i++) {
            String str = "Item " + (i+1);
            list.add(str);
        }

        adapter = new RecyclerDemoViewAdapter(new RecyclerDemoPresenter(list));
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.notifyDataSetChanged();

        recyclerView.addOnScrollListener(new ExtendedFABRecyclerScrollListener(fab));
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_demo_activity);

        recyclerView = findViewById(R.id.recyclerView);
        fab = findViewById(R.id.extendedFAB);
        fab.changeLabelColor(R.color.white);
        fab.changeBackgroundColor(R.color.colorAccent);
        fab.setLabel("Back");
        fab.setIcon(R.drawable.ic_arrow_back_white_24dp);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RecyclerDemoActivity.this.finish();
            }
        });

        setupRecyclerView();

        // todo: give fab a click listener

    }
}
