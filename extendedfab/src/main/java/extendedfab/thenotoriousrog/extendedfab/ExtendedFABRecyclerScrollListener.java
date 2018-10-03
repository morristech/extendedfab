package extendedfab.thenotoriousrog.extendedfab;

import android.support.v7.widget.RecyclerView;

public class ExtendedFABRecyclerScrollListener extends RecyclerView.OnScrollListener{

    private extendedfablib.ExtendedFAB fab;

    public ExtendedFABRecyclerScrollListener(extendedfablib.ExtendedFAB fab) {
        this.fab = fab;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        if(dy > 0 ) {
            fab.shrink();
        } else if(dy < 0) {
            fab.extend();
        }
    }

    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {

    }
}
