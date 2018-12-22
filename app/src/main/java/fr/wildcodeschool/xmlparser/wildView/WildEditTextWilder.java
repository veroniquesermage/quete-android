package fr.wildcodeschool.xmlparser.wildView;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import fr.wildcodeschool.xmlparser.ViewBuilder;

public class WildEditTextWilder implements ViewBuilder {

    private static final String TAG = "WildEditText";
    private EditText editText;

    public WildEditTextWilder(Context ctx) {
       editText = new EditText(ctx);
    }

    public void setAttribute(String key, String value) {
        switch (key) {
            case "inputType":
                editText.setInputType(Integer.parseInt(value));
                break;
            case "ems":
                try {
                    editText.setEms(Integer.getInteger(value));
                } catch (NullPointerException e) {
                    Log.e(TAG, e.getMessage());
                }
                break;
            case "text":
                editText.setText(value);
                break;
            case "hint":
                editText.setHint(value);
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
        return editText;
    }
}
