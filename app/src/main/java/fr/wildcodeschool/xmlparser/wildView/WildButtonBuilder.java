package fr.wildcodeschool.xmlparser.wildView;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import fr.wildcodeschool.xmlparser.ViewBuilder;

public class WildButtonBuilder implements ViewBuilder {

    private static final String TAG = "WildButton";
    private Button button;

    public WildButtonBuilder(Context ctx) {
        button = new Button(ctx);
    }

    @Override
    public void setAttribute(String key, String value) {
        switch (key) {
            case "text":
                button.setText(value);
                break;
            case "gravity":

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
        return button;
    }
}
