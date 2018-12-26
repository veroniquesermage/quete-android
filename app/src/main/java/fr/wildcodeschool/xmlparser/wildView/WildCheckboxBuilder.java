package fr.wildcodeschool.xmlparser.wildView;

import android.content.Context;
import android.support.v7.widget.AppCompatCheckBox;
import android.util.Log;
import android.view.View;

public class WildCheckboxBuilder implements WildViewBuilder {

    private AppCompatCheckBox checkBox;
    private static final String TAG = "Checkbox";

    public WildCheckboxBuilder (Context ctx){
        checkBox = new AppCompatCheckBox(ctx);
    }

    @Override
    public void setAttribute(String key, String value) {
        switch (key){
            case "id":
                break;
            case "text":
                checkBox.setText(value);
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
