package extendedfablib;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;

public class ExtendedFABScrollListener implements AbsListView.OnScrollListener {

    private extendedfablib.ExtendedFAB fab;
    private int scrollPos;

    public ExtendedFABScrollListener(extendedfablib.ExtendedFAB fab) {
        this.fab = fab;
    }

    @Override
    public void onScrollStateChanged(AbsListView absListView, int scrollState) { }

    @Override
    public void onScroll(AbsListView absListView, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

        if(scrollPos < firstVisibleItem) {
            fab.shrink();
        } else if(scrollPos > firstVisibleItem){
            fab.extend();
        }

        scrollPos = firstVisibleItem;

    }
}


