package to.msn.wings.janken;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int handYou = 0;        // 人間の手を表す変数を宣言、初期化

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
//
//    public void btClick(View view) {
//
//        // 人間の手のボタンID配列を定義
//        int[] handYouId = {R.id.btGoo, R.id.btCho, R.id.btPah};
//        // タップされた画面部品のidのR値に応じて人間の手を取得
//        for (int i = 0; i < handYouId.length; i++) {
//            if (view.getId() == handYouId[i])
//                handYou = i;
//        }
//
//        // インテントオブジェクトを生成。
//        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
//        // 第2画面に送るデータを格納。
//        intent.putExtra("handYou", handYou);
//        // 第2画面の起動。
//        startActivity(intent);
//    }
}