package fr.wildcodeschool.xmlparser.wildView;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;

import org.xmlpull.v1.XmlPullParser;

import java.util.HashMap;

import fr.wildcodeschool.xmlparser.LayoutManager;

public class WildButton extends AppCompatButton {
  // Log TAG definition
  private static final String TAG = "WildButton";

  /**
   * Constructor
   * @param pCtx Activity context
   */
  public WildButton(Context pCtx) {
    super(pCtx);
  }

  /**
   * Parse the @param XML node
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
      case "text":
        this.setText(value);
        break;
      case "gravity":
        // TODO - Manage gravity
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