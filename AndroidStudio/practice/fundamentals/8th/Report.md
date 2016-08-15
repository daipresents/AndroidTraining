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
