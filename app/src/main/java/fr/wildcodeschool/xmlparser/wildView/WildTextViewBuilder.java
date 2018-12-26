package fr.wildcodeschool.xmlparser.wildView;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;
import android.view.View;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static android.util.TypedValue.COMPLEX_UNIT_SP;
import static fr.wildcodeschool.xmlparser.LayoutManager.convertToPixel;

public class WildTextViewBuilder implements WildViewBuilder {
    private static final String TAG = "TextView";
    private AppCompatTextView textView;
    private int paddingV = 0;
    private int paddingH = 0;

    public WildTextViewBuilder (Context ctx){
        textView = new AppCompatTextView(ctx);
    }

    @Override
    public void setAttribute(String key, String value) {
        switch (key){
            case "background":
                textView.setBackgroundColor(Color.parseColor(value));
                break;
            case "textColor":
                textView.setTextColor(Color.parseColor(value));
                break;
            case "textSize":
                this.setTextSizeBuild(value);
                break;
            case "text":
                textView.setText(value);
                break;
            case "paddingHorizontal":
            case "paddingVertical":
                Pattern pattern = Pattern.compile("([0-9]*)([a-z]*)");
                Matcher matcher = pattern.matcher(value);
                if (matcher.find()) {
                    int px = convertToPixel(matcher.group(1), matcher.group(2));
                    if (key.equals("paddingVertical")) {
                        paddingV = px;
                    } else {
                        paddingH = px;
                    }
                }
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
        return textView;
    }

    private void setTextSizeBuild(String pTextSize){
        switch (pTextSize){
            case "20sp":
                textView.setTextSize(COMPLEX_UNIT_SP, 20.00f);
                break;
            default :
                Log.i (TAG,"c'est pas la taille qui compte");
                break;
        }
    }
}
