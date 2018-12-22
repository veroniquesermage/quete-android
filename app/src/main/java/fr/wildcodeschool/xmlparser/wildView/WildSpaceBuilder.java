package fr.wildcodeschool.xmlparser.wildView;

import android.content.Context;
import android.view.View;
import android.widget.Space;

import fr.wildcodeschool.xmlparser.ViewBuilder;

public class WildSpaceBuilder implements ViewBuilder {

    private static final String TAG = "Space";
    private Space space;

    public WildSpaceBuilder(Context ctx){
        space = new Space(ctx);
    }

    @Override
    public void setAttribute(String key, String value) {
        switch (key){
            case "id":
                break;
        }

    }

    @Override
    public View getBuildView() {
        return space;
    }
}
