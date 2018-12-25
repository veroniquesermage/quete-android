package fr.wildcodeschool.xmlparser.wildView;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

public class WildLinearLayoutBuilder implements WildViewBuilder {

    // Log TAG definition
    private static final String TAG = "WildLinearLayout";

    private LinearLayout mLayout;

    /**
     * Constructor
     * @param ctx   Activity context
     */
    public WildLinearLayoutBuilder(Context ctx) {
        mLayout = new LinearLayout( ctx );
    }

    /**
     * Populate the view with the attribute value
     * @param key The key of xml attribute
     * @param value The value of xml attribute
     */
    @Override
    public void setAttribute(String key, String value) {
        switch (key) {
            case "orientation":
                mLayout.setOrientation( value.equals("horizontal") ?
                        LinearLayout.HORIZONTAL : LinearLayout.VERTICAL );
                break;
            case "weightSum":
                mLayout.setWeightSum(Float.parseFloat(value));
                break;
            case "id":
                /* Nothing to do */
                break;
            default:
                Log.i(TAG, "Unknown Attribute ["+key+"]");
                break;
        }
    }

    @Override
    public View getBuildView() {
        return mLayout;
    }

    public LinearLayout getLayout() {
        return mLayout;
    }
}