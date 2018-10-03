package extendedfablib;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import extendedfab.thenotoriousrog.extendedfab.R;

/*
 * The extended fab itself.
 * Holds two views, an icon, and a textview.
 * Colors can be changed.
 */
public class ExtendedFAB extends RelativeLayout {

    private int deviceWidth;
    private ImageView icon;
    private TextView label;
    private View rootView;
    private LayoutInflater inflater;
    private RelativeLayout extendedLayout;
    private Context context;

    public ExtendedFAB(Context context) {
        this(context, null, 0);
    }

    public ExtendedFAB(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ExtendedFAB(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
        setVisibility(VISIBLE);
        setBackground(context.getDrawable(R.drawable.fab_background));
        this.context = context;
    }

    private void init(Context context) {
        final Display display = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        Point deviceDisplay = new Point();
        display.getSize(deviceDisplay);
        deviceWidth = deviceDisplay.x;

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        setClickable(true);
        setFocusable(true);
        rootView = inflater.inflate(R.layout.extendedfab, this, true);

    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        extendedLayout = rootView.findViewById(R.id.extendedLayout);
        extendedLayout.getLayoutTransition().setDuration(100);
        icon = rootView.findViewById(R.id.ExtendedFABIcon);
        label = rootView.findViewById(R.id.ExtendedFABLabel);

        final int childCount = ((RelativeLayout)rootView).getChildCount();
        if(childCount > 2) {
            throw new RuntimeException("You can only have two views in ExtendedFAB!");
        }
    }

    // shrink ExtendedFAB
    public void shrink() {
        label.setVisibility(GONE);
    }

    // extend fab
    public void extend() {
        label.setVisibility(VISIBLE);
    }

    public void setIcon(int imageResSrc) {
        this.icon.setImageResource(imageResSrc);
    }

    public void setLabel(String labelText) {
        this.label.setText(labelText);
    }

    public void changeLabelColor(int color) {
        label.setTextColor(ContextCompat.getColor(context, color));
    }

    public void changeBackgroundColor(int color) {
        getBackground().setColorFilter(ContextCompat.getColor(context, color), PorterDuff.Mode.MULTIPLY);
    }

}
