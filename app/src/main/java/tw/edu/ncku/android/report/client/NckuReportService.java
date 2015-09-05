package tw.edu.ncku.android.report.client;

import java.util.List;
import rx.Observable;

import retrofit.Retrofit;
import retrofit.GsonConverterFactory;
import retrofit.http.GET;
import tw.edu.ncku.android.report.client.model.Category;

public class NckuReportService {

    private static final String API_URL = "http://tcf.ncku.edu.tw:8000";
    private final NckuReport mNckuReport;

    public NckuReportService() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mNckuReport = retrofit.create(NckuReport.class);
    }

    public interface NckuReport {

        @GET("/category")
        Observable<List<Category>> listCategories();
    }

    public Observable<List<Category>> fetchCategories() {
        return mNckuReport.listCategories();
    }
}