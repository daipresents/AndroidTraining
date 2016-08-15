Practice Report for 2/8
------

実習のレポートを下記に記述してください

### Service

1. サンプルプロジェクト (ServiceSample) に、サービスのライフサイクルをログに出力する実装が格納されています。このプロジェクトをビルドし、ログがどのように表示されるかをレポートしてください。

08-14 20:25:14.476 16030-16030/jp.mixi.sample.service V/StartedService: onCreate
08-14 20:25:14.476 16030-16030/jp.mixi.sample.service V/StartedService: onStartCommand
08-14 20:25:18.343 16030-16030/jp.mixi.sample.service V/StartedService: onDestroy
08-14 20:25:20.444 16030-16030/jp.mixi.sample.service V/BoundService: onCreate
08-14 20:25:20.455 16030-16030/jp.mixi.sample.service V/MainActivity: onServiceConnected
08-14 20:25:22.668 16030-16030/jp.mixi.sample.service V/BoundService: onUnbind
08-14 20:25:22.668 16030-16030/jp.mixi.sample.service V/BoundService: onDestroy
08-14 20:25:24.358 16030-16030/jp.mixi.sample.service V/MyIntentService: onCreate
08-14 20:25:24.359 16030-16030/jp.mixi.sample.service V/MyIntentService: onStartCommand
08-14 20:25:24.359 16030-16440/jp.mixi.sample.service V/MyIntentService: onHandleIntent
08-14 20:25:24.366 16030-16030/jp.mixi.sample.service V/MyIntentService: onDestroy


### Loader

1. サンプルプロジェクト (LoaderSample) に、AsyncTaskLoader のライフサイクルをログに出力する実装が格納されています。このプロジェクトをビルドし、ログがどのように出力されているかをレポートしてください。

08-14 21:30:57.901 25506-25506/jp.mixi.sample.loader V/MainActivity: onCreateLoader
08-14 21:30:57.903 25506-25506/jp.mixi.sample.loader V/MyAsyncTaskLoader: onStartLoading
08-14 21:30:57.914 25506-25595/jp.mixi.sample.loader V/MyAsyncTaskLoader: loadInBackground
08-14 21:30:58.956 25506-25506/jp.mixi.sample.loader V/MyAsyncTaskLoader: deliverResult
08-14 21:30:58.957 25506-25506/jp.mixi.sample.loader V/MainActivity: onLoadFinished


### AsyncTask

1. `AsyncTask#doInBackground()` で、TextView の文字を変更するような、UI の処理を実行するとどうなるかを、理由を添えてレポートしてください。

UIスレッドで呼び出せと怒られる。実行するとエラー。

08-14 22:43:56.562 14635-14675/jp.mixi.sample.async.asynctask E/Surface: getSlotFromBufferLocked: unknown buffer: 0x7f1fe201aa20
08-14 22:43:58.565 14635-14675/jp.mixi.sample.async.asynctask E/Surface: getSlotFromBufferLocked: unknown buffer: 0x7f1fe201b120
08-14 22:44:00.566 14635-14675/jp.mixi.sample.async.asynctask E/Surface: getSlotFromBufferLocked: unknown buffer: 0x7f1fe201b190
08-14 22:44:02.569 14635-14675/jp.mixi.sample.async.asynctask E/Surface: getSlotFromBufferLocked: unknown buffer: 0x7f1fe201b270
08-14 22:44:04.571 14635-14675/jp.mixi.sample.async.asynctask E/Surface: getSlotFromBufferLocked: unknown buffer: 0x7f1fe201b120
08-14 22:44:04.767 14635-14674/jp.mixi.sample.async.asynctask E/AndroidRuntime: FATAL EXCEPTION: AsyncTask #1
                                                                                Process: jp.mixi.sample.async.asynctask, PID: 14635
                                                                                java.lang.RuntimeException: An error occurred while executing doInBackground()
                                                                                    at android.os.AsyncTask$3.done(AsyncTask.java:309)
                                                                                    at java.util.concurrent.FutureTask.finishCompletion(FutureTask.java:354)
                                                                                    at java.util.concurrent.FutureTask.setException(FutureTask.java:223)
                                                                                    at java.util.concurrent.FutureTask.run(FutureTask.java:242)
                                                                                    at android.os.AsyncTask$SerialExecutor$1.run(AsyncTask.java:234)
                                                                                    at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1113)
                                                                                    at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:588)
                                                                                    at java.lang.Thread.run(Thread.java:818)
                                                                                 Caused by: android.view.ViewRootImpl$CalledFromWrongThreadException: Only the original thread that created a view hierarchy can touch its views.
                                                                                    at android.view.ViewRootImpl.checkThread(ViewRootImpl.java:6556)
                                                                                    at android.view.ViewRootImpl.requestLayout(ViewRootImpl.java:907)
                                                                                    at android.view.View.requestLayout(View.java:18722)
                                                                                    at android.view.View.requestLayout(View.java:18722)
                                                                                    at android.view.View.requestLayout(View.java:18722)
                                                                                    at android.view.View.requestLayout(View.java:18722)
                                                                                    at android.widget.RelativeLayout.requestLayout(RelativeLayout.java:360)
                                                                                    at android.view.View.requestLayout(View.java:18722)
                                                                                    at android.widget.TextView.checkForRelayout(TextView.java:7172)
                                                                                    at android.widget.TextView.setText(TextView.java:4342)
                                                                                    at android.widget.TextView.setText(TextView.java:4199)
                                                                                    at android.widget.TextView.setText(TextView.java:4174)
                                                                                    at jp.mixi.sample.async.asynctask.MainActivity$MyAsyncTask.doInBackground(MainActivity.java:84)
                                                                                    at jp.mixi.sample.async.asynctask.MainActivity$MyAsyncTask.doInBackground(MainActivity.java:43)
                                                                                    at android.os.AsyncTask$2.call(AsyncTask.java:295)
                                                                                    at java.util.concurrent.FutureTask.run(FutureTask.java:237)
                                                                                    at android.os.AsyncTask$SerialExecutor$1.run(AsyncTask.java:234) 
                                                                                    at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1113) 
                                                                                    at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:588) 
                                                                                    at java.lang.Thread.run(Thread.java:818) 
