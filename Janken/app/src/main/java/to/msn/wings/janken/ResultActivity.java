package to.msn.wings.janken;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    // フィールド変数
    ImageView outputComp;   // コンピュータの手画像表示ビュー
    ImageView outputYou;   // 人間の手画像表示ビュー
    TextView outputWinLose; // 勝敗表示ビュー
    int handYou = 0;        // 人間の手を表す変数を宣言、初期化

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_fragment);
//        // Viewオブジェクトを取得
//        outputComp = findViewById(R.id.ivComp);
//        outputYou = findViewById(R.id.outputYou);
//        outputWinLose = findViewById(R.id.tvWinLose);
//
//        // インテントオブジェクトを取得。
//        Intent intent = getIntent();
//        // 第1画面から渡されたデータ（人間の選択手）を取得
//        handYou = intent.getIntExtra("handYou", 0);
//        // 人間の手の画像のID配列を定義
//        int[] handYouImageId = {R.drawable.gu, R.drawable.choki, R.drawable.pa};
//        // 人間の手を画像表示
//        outputYou.setImageResource(handYouImageId[handYou]);
//        // じゃんけんの後半処理
//        jankenResult();
    }

//    // じゃんけんの後半処理
//    public void jankenResult() {
//        // コンピュータの手を表す変数を定義、乱数で決定
//        int handComp = (int) (Math.random() * 3.0);
//        // コンピュータの手を表す画像id配列を定義
//        int[] imgId = {R.drawable.com_gu, R.drawable.com_choki, R.drawable.com_pa};
//        // コンピュータの手を画像表示
//        outputComp.setImageResource(imgId[handComp]);
//        // 勝敗を判定
//        int result = (handComp - handYou + 3) % 3;
//        // 勝敗を表すテキスト文字列配列を定義
//        String[] resultStr = {"引き分け", "あなたの勝ち", "あなたの負け"};
//        // 勝敗をテキスト表示
//        outputWinLose.setText(resultStr[result] + "です");
//    }
//
//    // 戻るボタンクをタップした時の処理
//    public void onBackBtClick(View view) {
//        finish();
//    }
}