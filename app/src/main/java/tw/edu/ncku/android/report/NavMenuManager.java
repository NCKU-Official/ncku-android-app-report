package tw.edu.ncku.android.report;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.view.Menu;
import android.view.MenuItem;

import com.google.gson.Gson;

import java.util.List;

import tw.edu.ncku.android.report.client.model.Category;
import tw.edu.ncku.android.report.storage.NckuReportStorage;

public class NavMenuManager {

    public static void setupMenu(Context ctx, NckuReportStorage s, NavigationView nav) {

        Gson gson = new Gson();
        Menu menu = nav.getMenu();
        menu.clear();

        List<Category> categories = s.getCategory().getData();

        for (Category category : categories) {
            // set menu item name
            MenuItem mi = menu.add(category.getName());

            // set intent
            Intent i = new Intent();
            i.setClass(ctx, MainActivity.class);
            i.setAction(Constants.INTENT_ACTION_MENU_CLICK);
            i.putExtra(Constants.INTENT_EXTRA_CATEGORY, gson.toJson(category));
            mi.setIntent(i);
        }
    }
}
