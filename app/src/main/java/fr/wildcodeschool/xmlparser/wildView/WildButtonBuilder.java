package fr.wildcodeschool.xmlparser.wildView;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.view.View;

public class WildButtonBuilder implements WildViewBuilder {

    // Log TAG definition
    private static final String TAG = "WildButton";

    private AppCompatButton button;

    /**
     * Constructor
     * @param ctx Activity context
     */
    public WildButtonBuilder(Context ctx) {
        button = new AppCompatButton( ctx );
    }

    /**
     * Populate the view with the attribute value
     * @param key The key of xml attribute
     * @param value The value of xml attribute
     */
    @Override
    public void setAttribute(String key, String value) {
        switch (key) {
            case "text":
                button.setText(value);
                break;
            case "gravity":
                button.setGravity( Integer.parseInt( value ) );
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
