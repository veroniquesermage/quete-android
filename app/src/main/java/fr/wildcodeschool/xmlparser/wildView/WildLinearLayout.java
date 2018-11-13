package fr.wildcodeschool.xmlparser.wildView;

import android.content.Context;
import android.util.Log;
import android.widget.LinearLayout;

import org.xmlpull.v1.XmlPullParser;

import java.util.HashMap;

import fr.wildcodeschool.xmlparser.LayoutManager;

public class WildLinearLayout extends LinearLayout {
  // Log TAG definition
  private static final String TAG = "WildLinearLayout";

  /**
   * Constructor
   * @param ctx   Activity context
   */
  public WildLinearLayout(Context ctx) {
    super(ctx);
  }

  /**
   * Parse the @param XML node
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
      case "orientation":
        this.setOrientation( value.equals("horizontal") ?
          LinearLayout.HORIZONTAL : LinearLayout.VERTICAL );
        break;
      case "weightSum":
        this.setWeightSum(Float.parseFloat(value));
        break;
      case "id":
        /* Nothing to do */
        break;
      default:
        Log.i(TAG, "Unknown Attribute ["+key+"]");
        break;
    }
  }
}
