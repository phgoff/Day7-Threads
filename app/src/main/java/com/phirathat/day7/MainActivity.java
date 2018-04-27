package com.phirathat.day7;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int count = 0;
    private TextView tvcount;
    private  Thread t;

    private final Handler handler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message msg) {
            // Do something here in UI Thread
//            tvcount.setText("Count: " +count);
            tvcount.setText("Count: " + msg.arg1 + msg.obj.toString());
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvcount = findViewById(R.id.tvcount);

//        Thread t = new Thread(){
//            public void run(){
//                while( ++count < 10)
//                    try {
//                        Thread.sleep(1000);
////                        System.out.println("Count " + count);
//                        handler.sendEmptyMessage(0);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//            }
//
//        };
// ---------------------------------------------------------------------
     //   Send through Object
        Thread t = new Thread(){
            public void run(){
                while( ++count < 10)
                    try {
                        Thread.sleep(1000);
//                        System.out.println("Count " + count);
                        Message mesg = new Message();
                        mesg.arg1 = count;
                        mesg.obj = "Hello";
                        handler.sendMessage(mesg);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }

        };
        t.start();
    // -- runOnUIThread-----------------------------------
//     t = new Thread(){
//            public void run(){
//                while( ++count < 10)
//                    try {
//                        Thread.sleep(1000);
////                        System.out.println("Count " + count);
//                        runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//                            tvcount.setText("Count: " +count);
//                            }
//                        }
//                        );
//                    }
//                    catch (InterruptedException e) {
//                        e.printStackTrace();
//                        return ;
//                    }
//            }
//
//     };
//     t.start();
    //-----------------------------------------------------------------------

    }

    // Stop after changes activity
    @Override
    protected void onDestroy() {
        super.onDestroy();
            t.interrupt();
    }
}
