package fr.wildcodeschool.xmlparser;

import android.content.Context;
import android.util.Xml;
import android.view.ViewGroup;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;

import fr.wildcodeschool.xmlparser.wildView.WildButton;
import fr.wildcodeschool.xmlparser.wildView.WildEditText;
import fr.wildcodeschool.xmlparser.wildView.WildLinearLayout;

public class Inflater {
  // Activity context
  private Context ctx;

  //
  // INFO WCS - enum
  // https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html
  enum INFLATE_TYPE { ASSETS, RAW }

  // Constructor should only contains initialisation
  Inflater(Context ctx) {
    this.ctx = ctx;
  }

  /**
   * This method parse the xml layout to populate the activity screen
   * @param pParent Parent layout
   * @param pType Inflate type
   * @throws IOException
   * @throws XmlPullParserException
   */
  public void inflate(ViewGroup pParent, INFLATE_TYPE pType) throws IOException, XmlPullParserException {
    // INFO WCS - throw vs throws
    // https://beginnersbook.com/2013/04/difference-between-throw-and-throws-in-java/

    // Store the parent
    ViewGroup lParentView = pParent;

    InputStream lXmlStream;
    if (pType == INFLATE_TYPE.ASSETS) {
      // INFO WCS - Here is how to keep a file from the assets directory
      lXmlStream = this.ctx.getAssets().open("content_assets.xml");
    } else {
      // INFO WCS - Here is how to keep a file from the raw directory
      lXmlStream = this.ctx.getResources().openRawResource(R.raw.content_raw);
    }

    // INFO WCS - XML and XmlPullParser
    // XML - https://developer.android.com/reference/android/util/Xml
    // XmlPullParser - https://developer.android.com/reference/org/xmlpull/v1/XmlPullParser

    // XML parser initialization
    XmlPullParser parser = Xml.newPullParser();
    parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
    parser.setInput(lXmlStream, null);

    // Loop on XML nodes
    int eventType = parser.getEventType();
    while (eventType != XmlPullParser.END_DOCUMENT) {
      if(eventType == XmlPullParser.START_TAG) {
        switch (parser.getName()) {
          case "LinearLayout":
            WildLinearLayout lLayout = new WildLinearLayout(ctx);
            lLayout.parseXmlNode(parser);
            lParentView.addView(lLayout);
            lParentView = lLayout;
            break;
          case "EditText":
            WildEditText lEditText = new WildEditText(ctx);
            lEditText.parseXmlNode(parser);
            lParentView.addView(lEditText);
            break;
          case "Button":
            WildButton lButton = new WildButton(ctx);
            lButton.parseXmlNode(parser);
            lParentView.addView(lButton);
            break;
          case "TextView":
            // TODO - Add WildTextView
            break;
          case "CheckBox":
            // TODO - Add WildCheckBox
            break;
          case "Space":
            // TODO - Add WildSpace
            break;
          default:
            break;
        }
      }
      else if (eventType == XmlPullParser.END_TAG) {
        switch (parser.getName()) {
          case "LinearLayout":
            lParentView = (ViewGroup)lParentView.getParent();
            break;
          default:
            break;
        }
      }
      parser.next();
      eventType = parser.getEventType();
    }
  }
}
