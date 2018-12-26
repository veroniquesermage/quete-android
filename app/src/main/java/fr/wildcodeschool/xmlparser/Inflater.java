package fr.wildcodeschool.xmlparser;

import android.content.Context;
import android.util.Xml;
import android.view.ViewGroup;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;

import fr.wildcodeschool.xmlparser.wildView.WildCheckboxBuilder;
import fr.wildcodeschool.xmlparser.wildView.WildSpaceBuilder;
import fr.wildcodeschool.xmlparser.wildView.WildTextViewBuilder;
import fr.wildcodeschool.xmlparser.wildView.WildViewBuilder;
import fr.wildcodeschool.xmlparser.wildView.WildButtonBuilder;
import fr.wildcodeschool.xmlparser.wildView.WildEditTextBuilder;
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
            if(eventType == XmlPullParser.START_TAG) {
                WildViewBuilder wildViewBuilder = null;
                switch (parser.getName()) {
                    case "LinearLayout":
                        wildViewBuilder = new WildLinearLayoutBuilder( ctx );
                        break;
                    case "EditText":
                        wildViewBuilder = new WildEditTextBuilder( ctx );
                        break;
                    case "Button":
                        wildViewBuilder = new WildButtonBuilder( ctx );
                        break;
                    case "TextView":
                        wildViewBuilder = new WildTextViewBuilder(ctx);
                        break;
                    case "CheckBox":
                        wildViewBuilder = new WildCheckboxBuilder(ctx);
                        break;
                    case "Space":
                        wildViewBuilder = new WildSpaceBuilder(ctx);
                    default:
                        break;
                }

                if(wildViewBuilder != null) {
                    wildViewBuilder.parseXmlNode( parser );
//                    if(viewBuilder instanceof WildTextViewBuilder) {
//                        ((WildTextViewBuilder)viewBuilder).setPadding();
//                    }
                    lParentView.addView( wildViewBuilder.getBuildView() );
                    if(wildViewBuilder instanceof WildLinearLayoutBuilder) {
                        lParentView = ((WildLinearLayoutBuilder)wildViewBuilder).getLayout();
                    }
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
