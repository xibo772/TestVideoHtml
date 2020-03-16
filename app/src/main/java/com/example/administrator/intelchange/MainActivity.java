package com.example.administrator.intelchange;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {
    private static final String TAG = "MainActivity";
    WebView wv_common_webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DisplayMetrics outMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(outMetrics);
        int widthPixels = outMetrics.widthPixels;
        int heightPixels = outMetrics.heightPixels;
        Log.i(TAG, "widthPixels = " + widthPixels + ",heightPixels = " + heightPixels);

        wv_common_webview = (WebView) findViewById(R.id.webview);
        String id = "wCgc7h67O4g";

        wv_common_webview.loadUrl("file:///android_asset/111.html?v=" + id + "&w=" + widthPixels * 0.75 + "&h=" + heightPixels * 0.75);
//        wv_common_webview.loadUrl("http://ott.bangtv.tv/yt/play.html?v="+id+"&w="+widthPixels*0.75+"&h="+heightPixels*0.75);
        //加上下面这段代码可以使网页中的链接不以浏览器的方式打开
        wv_common_webview.setWebViewClient(new WebViewClient());
        //得到webview设置
        WebSettings webSettings = wv_common_webview.getSettings();
        //允许使用javascript
        webSettings.setJavaScriptEnabled(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        //设置可自由缩放网页
//                wv_common_webview.getSettings().setSupportZoom(true);
        wv_common_webview.getSettings().setBuiltInZoomControls(true);
        wv_common_webview.getSettings().setUseWideViewPort(true);//关键点
        wv_common_webview.getSettings().setLoadWithOverviewMode(true);
        wv_common_webview.getSettings().setTextZoom(100);
        wv_common_webview.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);

        // 如果页面中链接，如果希望点击链接继续在当前browser中响应，
        // 而不是新开Android的系统browser中响应该链接，必须覆盖webview的WebViewClient对象
        wv_common_webview.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //  重写此方法表明点击网页里面的链接还是在当前的webview里跳转，不跳到浏览器那边
                view.loadUrl(url);
                return true;
            }
//                });

//            }
        });


    }

    @SuppressLint("SetJavaScriptEnabled")
    public void testJS(int keycode, String key) {
        if (keycode == KeyEvent.KEYCODE_DPAD_LEFT) {
            wv_common_webview.loadUrl("javascript:operation( " + KeyEvent.KEYCODE_DPAD_LEFT + "," + key + ")");
        } else if (keycode == KeyEvent.KEYCODE_DPAD_RIGHT) {
            wv_common_webview.loadUrl("javascript:operation( " + KeyEvent.KEYCODE_DPAD_RIGHT + "," + key + ")");
        } else if (keycode == KeyEvent.KEYCODE_DPAD_UP) {
            wv_common_webview.loadUrl("javascript:operation( " + KeyEvent.KEYCODE_DPAD_UP + "," + key + ")");
        } else if (keycode == KeyEvent.KEYCODE_DPAD_DOWN) {
            wv_common_webview.loadUrl("javascript:operation( " + KeyEvent.KEYCODE_DPAD_DOWN + "," + key + ")");
        } else if (keycode == KeyEvent.KEYCODE_DPAD_CENTER) {
            wv_common_webview.loadUrl("javascript:operation( " + KeyEvent.KEYCODE_DPAD_CENTER + "," + key + ")");
        }


    }

//

    /**
     * 监听遥控器按键事件
     */
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        // TODO Auto-generated method stub
//        if (event.getKeyCode() == KeyEvent.KEYCODE_DPAD_LEFT
//                || event.getKeyCode() == KeyEvent.KEYCODE_DPAD_UP
//                || event.getKeyCode() == KeyEvent.KEYCODE_DPAD_RIGHT
//                || event.getKeyCode() == KeyEvent.KEYCODE_DPAD_DOWN||
//                event.getKeyCode()   == KeyEvent.KEYCODE_DPAD_CENTER&& event.getAction() == KeyEvent.ACTION_DOWN) {
//            testJS(event.getKeyCode(),"0");
//
//        }
//        if (event.getKeyCode() == KeyEvent.KEYCODE_DPAD_LEFT
//                || event.getKeyCode() == KeyEvent.KEYCODE_DPAD_UP
//                || event.getKeyCode() == KeyEvent.KEYCODE_DPAD_RIGHT
//                || event.getKeyCode() == KeyEvent.KEYCODE_DPAD_DOWN&&event.getAction() == KeyEvent.ACTION_UP) {
//            testJS(event.getKeyCode(),"1");
//
//        }
        if (event.getKeyCode() == KeyEvent.KEYCODE_DPAD_LEFT && event.getAction() == KeyEvent.ACTION_DOWN) {
            testJS(event.getKeyCode(), "0");
//            Toast.makeText(this,"点击了左键",0.LENGTH_SHORT).show();
        }
        if (event.getKeyCode() == KeyEvent.KEYCODE_DPAD_LEFT && event.getAction() == KeyEvent.ACTION_UP) {
            testJS(event.getKeyCode(), "1");
//            Toast.makeText(this,"点击了左键",Toast.LENGTH_SHORT).show();
        }
        if (event.getKeyCode() == KeyEvent.KEYCODE_DPAD_RIGHT && event.getAction() == KeyEvent.ACTION_DOWN) {
//            Toast.makeText(this,"点击了右键",Toast.LENGTH_SHORT).show();
            testJS(event.getKeyCode(), "0");
        }
        if (event.getKeyCode() == KeyEvent.KEYCODE_DPAD_RIGHT && event.getAction() == KeyEvent.ACTION_UP) {
//            Toast.makeText(this,"点击了右键",Toast.LENGTH_SHORT).show();
            testJS(event.getKeyCode(), "1");
        }
        if (event.getKeyCode() == KeyEvent.KEYCODE_DPAD_UP && event.getAction() == KeyEvent.ACTION_DOWN) {
//            Toast.makeText(this,"点击了上键",Toast.LENGTH_SHORT).show();
            testJS(event.getKeyCode(), "0");
        }
        if (event.getKeyCode() == KeyEvent.KEYCODE_DPAD_UP && event.getAction() == KeyEvent.ACTION_UP) {
//            Toast.makeText(this,"点击了上键",Toast.LENGTH_SHORT).show();
            testJS(event.getKeyCode(), "1");
        }
        if (event.getKeyCode() == KeyEvent.KEYCODE_DPAD_DOWN && event.getAction() == KeyEvent.ACTION_DOWN) {
//            Toast.makeText(this,"点击了下键",Toast.LENGTH_SHORT).show();
            testJS(event.getKeyCode(), "0");
        }
        if (event.getKeyCode() == KeyEvent.KEYCODE_DPAD_DOWN && event.getAction() == KeyEvent.ACTION_UP) {
//            Toast.makeText(this,"点击了下键",Toast.LENGTH_SHORT).show();
            testJS(event.getKeyCode(), "1");
        }
        if (event.getKeyCode() == KeyEvent.KEYCODE_DPAD_CENTER && event.getAction() != KeyEvent.ACTION_UP) {
            testJS(event.getKeyCode(), "0");
//            Toast.makeText(this,"点击了确定键",Toast.LENGTH_SHORT).show();
        }
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            this.finish();
        }

        return true;
    }

}
