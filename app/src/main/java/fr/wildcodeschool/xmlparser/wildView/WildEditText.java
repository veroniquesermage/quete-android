package fr.wildcodeschool.xmlparser.wildView;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.text.InputType;
import android.util.Log;

import org.xmlpull.v1.XmlPullParser;

import java.util.HashMap;

import fr.wildcodeschool.xmlparser.LayoutManager;

public class WildEditText extends AppCompatEditText {
  // Log TAG definition
  private static final String TAG = "WildEditText";

  /**
   * Constructor
   * @param ctx Activity context
   */
  public WildEditText(Context ctx) {
    super(ctx);
  }

  /**
   *
   * @param pParser
   */
  public void parseXmlNode(XmlPullParser pParser) {
    HashMap<String, String> map;
    map = LayoutManager.setLayoutParams(this, pParser);
    for (HashMap.Entry<String, String> entry : map.entrySet()) {
      this.setAttribute(entry.getKey(), entry.getValue());
    }
  }

  /**
   *
   * @param key
   * @param value
   */
  private void setAttribute(String key, String value) {
    switch (key) {
      case "inputType":
        this.setInputType(value);
        break;
      case "ems":
        try {
          this.setEms(Integer.getInteger(value));
        } catch (NullPointerException e) {
          Log.e(TAG, e.getMessage());
        }
        break;
      case "text":
        this.setText(value);
        break;
      case "hint":
        this.setHint(value);
        break;
      case "id":
        /* Nothing to do */
        break;
      default:
        Log.i(TAG, "Unknown Attribute ["+key+"]");
        break;
    }
  }

  /**
   *
   * @param pInputType
   */
  private void setInputType(String pInputType) {
    switch (pInputType) {
      case "textPersonName":
        this.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);
        break;
      default:
        // Log it
        break;
    }
  }
}
