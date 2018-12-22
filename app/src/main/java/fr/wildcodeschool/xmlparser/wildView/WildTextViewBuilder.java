package fr.wildcodeschool.xmlparser.wildView;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fr.wildcodeschool.xmlparser.MainActivity;
import fr.wildcodeschool.xmlparser.ViewBuilder;

import static android.util.TypedValue.COMPLEX_UNIT_SP;

public class WildTextViewBuilder implements ViewBuilder {

    private static final String TAG = "WildTextView";
    private TextView textView;
    int paddingH = 0;
    int paddingV = 0;

    public WildTextViewBuilder (Context ctx){
        textView = new TextView(ctx);
    }

    @Override
    public void setAttribute(String key, String value) {
        switch (key){
            case "text":
                textView.setText(value);
                break;
            case "id":
                break;
//            case "textSize":
//                //ne fonctionne pas
//                Pattern pattern1 = Pattern.compile("([0-9]*)([a-z]*)");
//                Matcher matcher1 = pattern1.matcher(value);
//                if (matcher1.find()) {
//                    textView.setTextSize(COMPLEX_UNIT_SP, Float.parseFloat(matcher1.group(2)));
//                }
//                break;
            case "background":
                textView.setBackgroundColor(Integer.parseInt(value));
                break;
            case "textColor":
                textView.setTextColor(Integer.parseInt(value));
                break;
//            case "paddingVertical":
//                Pattern pattern = Pattern.compile("\"([0-9]*)([a-z]*)\"");
//                Matcher matcher = pattern.matcher(value);
//                if (matcher.find())
//                {
//                    int px = convertToPixel(matcher.group(1), matcher.group(2));
//                    if (key.equals("padding_vertical")) {
//                        paddingV = px;
//                    } else {
//                        paddingH = px;
//                    }
//                }
//                textView.setPadding(paddingH,paddingV,paddingH,paddingV);
//                break;
//            case "paddingHorizontal":
//                Pattern pattern1 = Pattern.compile("\"([0-9]*)([a-z]*)\"");
//                Matcher matcher1 = pattern1.matcher(value);
//                if (matcher1.find())
//                {
//                    int px = convertToPixel(matcher1.group(1), matcher1.group(2));
//                    if (key.equals("padding_horizontal")) {
//                        paddingV = px;
//                    } else {
//                        paddingH = px;
//                    }
//                }
//                textView.setPadding(paddingH,paddingV,paddingH,paddingV);
//                break;
            default:
                Log.i(TAG, "Unknown Attribute ["+key+"]");
                break;
        }
    }

    @Override
    public View getBuildView() {
        return textView;
    }

//    static private int convertToPixel(String value, String unit) {
//        DisplayMetrics displayMetric = MainActivity.getAppContext().getResources().getDisplayMetrics();
//
//        int pixel = 0;
//        try {
//            int num = Integer.getInteger(value);
//            switch (unit) {
//                case "px":
//                    pixel = num;
//                    break;
//                case "dp":
//                    pixel = Math.round(num * (displayMetric.xdpi / DisplayMetrics.DENSITY_DEFAULT));
//                    break;
//                case "sp":
//                    pixel = (int)TypedValue.applyDimension(COMPLEX_UNIT_SP, num, displayMetric);
//                    break;
//                default:
//                    break;
//            }
//        } catch (NullPointerException e) {
//            Log.e(TAG, e.getMessage());
//        }
//
//        return pixel;
//    }
}
