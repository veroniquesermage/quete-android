package fr.wildcodeschool.xmlparser.wildView;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import fr.wildcodeschool.xmlparser.ViewBuilder;

public class WildLinearLayoutBuilder implements ViewBuilder {

    private static final String TAG = "WildLinearLayout";
    private LinearLayout linearLayout;

    public WildLinearLayoutBuilder(Context ctx){
        linearLayout =  new LinearLayout(ctx);
    }


    @Override
    public void setAttribute(String key, String value) {
        switch (key) {
            case "orientation":
                linearLayout.setOrientation( value.equals("horizontal") ?
                        LinearLayout.HORIZONTAL : LinearLayout.VERTICAL );
                break;
            case "weightSum":
                linearLayout.setWeightSum(Float.parseFloat(value));
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
        return linearLayout;
    }
}
