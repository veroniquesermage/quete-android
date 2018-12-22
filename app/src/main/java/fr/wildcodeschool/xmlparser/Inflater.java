package fr.wildcodeschool.xmlparser;

import android.content.Context;
import android.util.Xml;
import android.view.ViewGroup;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;

import fr.wildcodeschool.xmlparser.wildView.ViewBuilder;
import fr.wildcodeschool.xmlparser.wildView.WildButtonBuilder;
import fr.wildcodeschool.xmlparser.wildView.WildEditTextWilder;
import fr.wildcodeschool.xmlparser.wildView.WildLinearLayoutBuilder;

public class Inflater {
    // Activity context
    private Context ctx;

    // Constructor should only contains initialisation
    Inflater(Context ctx) {
        this.ctx = ctx;
    }

    /**
     * This method parse the xml layout to populate the activity screen
     *
     * @param pParent Parent layout
     * @throws IOException
     * @throws XmlPullParserException
     */
    public void inflate(ViewGroup pParent) throws IOException, XmlPullParserException {
        // Store the parent
        ViewGroup lParentView = pParent;

        // INFO WCS - Here is how to keep a file from the assets directory
        InputStream lXmlStream = this.ctx.getAssets().open("content_assets.xml");

        // XML parser initialization
        XmlPullParser parser = Xml.newPullParser();
        parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
        parser.setInput(lXmlStream, null);

        // Loop on XML nodes
        int eventType = parser.getEventType();
        while (eventType != XmlPullParser.END_DOCUMENT) {
            if (eventType == XmlPullParser.START_TAG) {
                ViewBuilder viewBuilder = null;
                switch (parser.getName()) {
                    case "LinearLayout":
                        viewBuilder = new WildLinearLayoutBuilder(ctx);
                        break;
                    case "EditText":
                        viewBuilder = new WildEditTextWilder(ctx);
                        break;
                    case "Button":
                        viewBuilder = new WildButtonBuilder(ctx);
                        break;
//          case "TextView":
//
//          case "CheckBox":
//
//          case "Space":
//
                    default:
                        break;
                }

                if (viewBuilder != null) {
                    viewBuilder.parseXmlNode(parser);
//              if(viewBuilder instanceof WildTextViewBuilder) {
//                  ((WildTextViewBuilder)viewBuilder).setPadding();
//              }
                    lParentView.addView(viewBuilder.getBuildView());
                    if (viewBuilder instanceof WildLinearLayoutBuilder) {
                        lParentView = ((WildLinearLayoutBuilder) viewBuilder).getLayout();
                    }
                } else if (eventType == XmlPullParser.END_TAG) {
                    switch (parser.getName()) {
                        case "LinearLayout":
                            lParentView = (ViewGroup) lParentView.getParent();
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
}
