package extendedfab.thenotoriousrog.extendedfabdemo;

import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerDemoPresenter {

    private ArrayList<String> list;

    public RecyclerDemoPresenter(ArrayList<String> list) {
        this.list = list;
    }

    public void onBindDemoViewAtPosition(int pos, DemoUpdater demoUpdater) {
        String str = list.get(pos);
        demoUpdater.setText(str);
    }

    public int getCount() {
        return list.size();
    }

    public interface DemoUpdater {
        void setText(String text);
    }

}
