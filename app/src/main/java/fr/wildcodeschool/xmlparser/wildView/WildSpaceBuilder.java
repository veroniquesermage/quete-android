package fr.wildcodeschool.xmlparser.wildView;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Space;

public class WildSpaceBuilder implements WildViewBuilder {
    private static final String TAG = "Space";
    private Space space;

    public WildSpaceBuilder (Context ctx){
        space = new Space(ctx);
    }

    @Override
    public void setAttribute(String key, String value) {
        switch (key){
            case "id":
                break;
            default:
                Log.i(TAG, "Unknown Attribute ["+key+"]");
                break;
        }
    }

    @Override
    public View getBuildView() {
        return space;
    }
}
