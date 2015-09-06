package tw.edu.ncku.android.report;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ContentFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.content_fragment, container, false);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        String url = getArguments().getString(Constants.INTENT_EXTRA_CATEGORY_VIEW_URL);
        WebView webview = (WebView) view.findViewById(R.id.webView);
        WebSettings ws = webview.getSettings();
        ws.setJavaScriptEnabled(true);
        webview.requestFocus();
        webview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if ((url != null) && ((url.startsWith("http://")) || (url.startsWith("https://")))) {
                    return false;
                } else {
                    view.getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
                    return true;
                }
            }
        });
        webview.loadUrl(url);
    }

}
