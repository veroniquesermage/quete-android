package fr.wildcodeschool.xmlparser;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import org.xmlpull.v1.XmlPullParserException;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
  // Used to store the application context
  //
  // INFO WCS - application context
  // Application context is different from the Activity context
  // https://possiblemobile.com/2013/06/context/
  private static Context appContext;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    appContext = getApplicationContext();
    this.getBaseContext();
    setContentView(R.layout.activity_main);

    // Parent Layout
    ViewGroup lParentView = this.findViewById(R.id.mainLayout);

    try {
      Inflater lXmlInflater = new Inflater(this);
      lXmlInflater.inflate(lParentView);
    } catch (IOException | XmlPullParserException  e) {
      Log.e("PARSER ERROR", e.getMessage());
    }
  }

  /**
   * The context should be accessible from everywhere in the application
   * @return The application context
   */
  public static Context getAppContext() {
    return appContext;
  }
}
