package tw.edu.ncku.android.report.client;

import java.util.List;

import retrofit.RestAdapter;
import retrofit.http.GET;
import rx.Observable;
import tw.edu.ncku.android.report.client.model.Category;
import tw.edu.ncku.android.report.client.model.CategoryResponse;

public class NckuReportService {

    private static final String API_URL = "http://tcf.ncku.edu.tw:8000";
    private final NckuReport mNckuReport;

    public NckuReportService() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(API_URL)
                .build();
        mNckuReport = restAdapter.create(NckuReport.class);
    }

    public interface NckuReport {

        @GET("/category")
        Observable<CategoryResponse> listCategories();
    }

    public Observable<CategoryResponse> fetchCategories() {
        return mNckuReport.listCategories();
    }
}