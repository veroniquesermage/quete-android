package fr.wildcodeschool.xmlparser.wildView;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;

import fr.wildcodeschool.xmlparser.ViewBuilder;

public class WildCheckBoxBuilder implements ViewBuilder {

    private static final String TAG = "CheckBox";
    private CheckBox checkBox;

    public WildCheckBoxBuilder(Context ctx){
        checkBox = new CheckBox(ctx);
    }

    @Override
    public void setAttribute(String key, String value) {
        switch (key){
            case "id":
                break;
            case "text":
                checkBox.setText(value);
                break;
            default:
                Log.i(TAG, "Unknown Attribute ["+key+"]");
                break;
        }

    }

    @Override
    public View getBuildView() {
        return checkBox;
    }
}
