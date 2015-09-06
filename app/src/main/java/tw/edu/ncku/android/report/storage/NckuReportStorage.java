package tw.edu.ncku.android.report.storage;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import tw.edu.ncku.android.report.client.model.CategoryResponse;

public class NckuReportStorage {

    private static NckuReportStorage mNckuReportStorage;
    private static Context c;
    private static Gson gson;

    private NckuReportStorage() {

    }

    public static NckuReportStorage getInstance(Context c) {

        if (mNckuReportStorage == null) {

            gson = new Gson();
            NckuReportStorage.c = c;
            mNckuReportStorage = new NckuReportStorage();
        }
        return mNckuReportStorage;
    }

    public CategoryResponse getCategory() {

        SharedPreferences sp = c.getSharedPreferences(StorageConstants.SP_API, 0);
        String categoryJson = sp.getString(StorageConstants.SP_CATEGORY, "");
        return gson.fromJson(categoryJson, CategoryResponse.class);
    }

    public void saveCategory(CategoryResponse category) {

        SharedPreferences sp = c.getSharedPreferences(StorageConstants.SP_API, 0);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("category", gson.toJson(category));
        editor.apply();
    }

}
