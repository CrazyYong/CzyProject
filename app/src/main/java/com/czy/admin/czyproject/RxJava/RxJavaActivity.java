package com.czy.admin.czyproject.RxJava;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.czy.admin.czyproject.NetWork.HttpConnection.HttpResultInterface;
import com.czy.admin.czyproject.NetWork.HttpConnection.HttpUtil;
import com.czy.admin.czyproject.R;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by czy on 2017/3/1.
 * 用于测试RxJava类
 */

public class RxJavaActivity extends Activity implements View.OnClickListener,HttpResultInterface {
    private Button rxjava_scheduler_btn;
    private Button rxjava_error_btn;
    private Button rxjava_map_btn;

    private HttpUtil httpUtil =null;
    private String  httpData = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava);
        rxjava_scheduler_btn=(Button)findViewById(R.id.rxjava_scheduler_btn);
        rxjava_error_btn=(Button)findViewById(R.id.rxjava_error_btn);
        rxjava_map_btn=(Button)findViewById(R.id.rxjava_map_btn) ;
        rxjava_scheduler_btn.setOnClickListener(this);
        rxjava_error_btn.setOnClickListener(this);
        rxjava_map_btn.setOnClickListener(this);
        httpUtil = new HttpUtil(this);
        rxjava_map_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.rxjava_scheduler_btn:
                scheduleThread();
                break;
            case R.id.rxjava_error_btn:
                errorRxJava();
                break;
            case R.id.rxjava_map_btn:
                mapRxJava();
                break;
            default:
                break;

        }
    }

    public void returnData(String name){
        httpData=name;
    }



    /**
     * 切换线程
     */
    public void scheduleThread(){
        Flowable.create(new FlowableOnSubscribe<String>() {
            @Override
            public void subscribe(FlowableEmitter<String> e) throws Exception {
                e.onNext("将会在3秒后显示");
                Thread.sleep(3000);
                httpUtil.requestData();
                e.onNext(httpData);
                e.onComplete();

            }
        }, BackpressureStrategy.BUFFER)
                .subscribeOn(Schedulers.io()) //事件产生在io线程
                .observeOn(AndroidSchedulers.mainThread())//事件处理在mainThread线程
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        Toast.makeText(RxJavaActivity.this, s, Toast.LENGTH_SHORT).show();
                    }
                });
    }


    /**
     * 模拟报错情况d调用 onError()方法
     */
    public void errorRxJava(){
        Flowable.create(new FlowableOnSubscribe<String>() {
            @Override
            public void subscribe(FlowableEmitter<String> e) throws Exception {
            e.onNext("exception:"+(1/0));
                e.onComplete();
            }
        },BackpressureStrategy.BUFFER).subscribe(new Subscriber<String>() {
            @Override
            public void onSubscribe(Subscription s) {
             s.request(1);
            }

            @Override
            public void onNext(String s) {
            System.out.println(s);
            }


            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
                Toast.makeText(RxJavaActivity.this, "onError", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onComplete() {
                Toast.makeText(RxJavaActivity.this, "onComplete", Toast.LENGTH_SHORT).show();
            }
        });

    }


    /**
     * 简洁的RxJava写法
     */
    private void simpleRxJava(){
        Flowable.just("hello RxJava 2").subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
       Toast.makeText(RxJavaActivity.this,"拿到的值:"+s,Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * map操作符拼接
     */

    private void mapRxJava(){
        Flowable.just("map1").map(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) throws Exception {


                return s.hashCode();
            }
        }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer s) throws Exception {
                Toast.makeText(RxJavaActivity.this,"拿到的值:"+s,Toast.LENGTH_SHORT).show();
            }
        });

    }

    /**
     * 常规的RxJava 写法，回调函数完整版
     */
    private void routineRxJava(){

        Flowable<String> flowable = Flowable.create(new FlowableOnSubscribe<String>() {
            @Override
            public void subscribe(FlowableEmitter<String> e) throws Exception {
                e.onNext("hello RxJava 2");
                e.onComplete();
            }
        }, BackpressureStrategy.BUFFER);


        Subscriber subscriber = new Subscriber<String>() {
            @Override
            public void onSubscribe(Subscription s) {

                // request必须调用，否则 onNext不会被调用
                s.request(Long.MAX_VALUE); //背压作用

            }

            @Override
            public void onNext(String s) {
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {

            }
        };

        flowable.subscribe(subscriber);
    }


}
