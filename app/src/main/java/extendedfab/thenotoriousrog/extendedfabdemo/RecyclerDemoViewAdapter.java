package extendedfab.thenotoriousrog.extendedfabdemo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

public class RecyclerDemoViewAdapter extends RecyclerView.Adapter<RecyclerDemoViewHolder> {

    private RecyclerDemoPresenter presenter;

    public RecyclerDemoViewAdapter(RecyclerDemoPresenter presenter) {
        this.presenter = presenter;
    }

    @NonNull
    @Override
    public RecyclerDemoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecyclerDemoViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerDemoViewHolder recyclerDemoViewHolder, int i) {
        presenter.onBindDemoViewAtPosition(i, recyclerDemoViewHolder);
    }

    @Override
    public int getItemCount() {
        return presenter.getCount();
    }

}
