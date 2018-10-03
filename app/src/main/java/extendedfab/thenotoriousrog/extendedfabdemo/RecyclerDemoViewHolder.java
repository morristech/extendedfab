package extendedfab.thenotoriousrog.extendedfabdemo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class RecyclerDemoViewHolder extends RecyclerView.ViewHolder implements RecyclerDemoPresenter.DemoUpdater {

    private View view;
    private TextView textView;

    public RecyclerDemoViewHolder(View view) {
        super(view);
        this.view = view;
        textView = view.findViewById(R.id.textView);
    }

    @Override
    public void setText(String text) {
        textView.setText(text);
    }
}
