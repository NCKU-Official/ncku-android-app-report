package tw.edu.ncku.android.report;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.view.Menu;
import android.view.MenuItem;

import com.google.gson.Gson;

import java.util.List;

import tw.edu.ncku.android.report.client.model.Category;
import tw.edu.ncku.android.report.client.model.CategoryResponse;

public class NavMenuManager {

    public static void setupMenu(Context ctx, CategoryResponse categoryResponse, NavigationView nav) {

        // if app start-up first time
        if(categoryResponse == null) return;

        Gson gson = new Gson();
        Menu menu = nav.getMenu();
        menu.clear();

        List<Category> categories = categoryResponse.getData();

        for (Category category : categories) {
            // set menu item name
            MenuItem mi = menu.add(category.getName());

            // set intent
            Intent i = new Intent();
            i.setClass(ctx, MainActivity.class);
            i.setAction(Constants.INTENT_NAV_ITEM_SELECTED);
            i.putExtra(Constants.INTENT_EXTRA_CATEGORY, gson.toJson(category));
            mi.setIntent(i);
        }
    }
}
