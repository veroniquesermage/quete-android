package fr.wildcodeschool.xmlparser.wildView;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class WildEditTextBuilder implements WildViewBuilder {

    private static final String TAG = "WildEditText";
    private AppCompatEditText editText;

    public WildEditTextBuilder(Context ctx) {
       editText = new AppCompatEditText(ctx);
    }

    @Override
    public void setAttribute(String key, String value) {

        switch (key) {
            case "inputType":
                this.setInputType(value);
                break;
            case "ems":
                try {
                    editText.setEms(Integer.parseInt(value));
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

    private void setInputType(String pInputType) {
        switch (pInputType) {
            case "textPersonName":
                editText.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);
                break;
            default:
                // Log it
                break;
        }
    }

    @Override
    public View getBuildView() {
        return editText;
    }
}
