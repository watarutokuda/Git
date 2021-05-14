package to.msn.wings.janken;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.Objects;

public class ResultFragment extends Fragment {
    private boolean isTwoPane = false;
    ImageView outputComp;   // コンピュータの手画像表示ビュー
    ImageView outputYou;   // 人間の手画像表示ビュー
    TextView outputWinLose; // 勝敗表示ビュー
    int handYou = 0;        // 人間の手を表す変数を宣言、初期化

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Activity activity = Objects.requireNonNull(getActivity());
        if(activity.findViewById(
                R.id.resultFrame) != null) {
            isTwoPane = true;
        }
        jankenResult();
    }



    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.result_fragment, container, false);
        Bundle bundle;
        Activity activity = Objects.requireNonNull(getActivity());
        if(isTwoPane) {
            bundle = Objects.requireNonNull(getArguments());
        } else {
            Intent intent = activity.getIntent();
            bundle = Objects.requireNonNull(intent.getExtras());
        }
        outputComp = view.findViewById(R.id.ivComp);
        outputYou = view.findViewById(R.id.outputYou);
        outputWinLose = view.findViewById(R.id.tvWinLose);
        // 第1画面から渡されたデータ（人間の選択手）を取得
        handYou = bundle.getInt("handYou", 0);
        // 人間の手の画像のID配列を定義
        int[] handYouImageId = {R.drawable.gu, R.drawable.choki, R.drawable.pa};
        // 人間の手を画像表示
        outputYou.setImageResource(handYouImageId[handYou]);
        return view;
    }
    public void jankenResult() {
        // コンピュータの手を表す変数を定義、乱数で決定
        int handComp = (int) (Math.random() * 3.0);
        // コンピュータの手を表す画像id配列を定義
        int[] imgId = {R.drawable.com_gu, R.drawable.com_choki, R.drawable.com_pa};
        // コンピュータの手を画像表示
        outputComp.setImageResource(imgId[handComp]);
        // 勝敗を判定
        int result = (handComp - handYou + 3) % 3;
        // 勝敗を表すテキスト文字列配列を定義
        String[] resultStr = {"引き分け", "あなたの勝ち", "あなたの負け"};
        // 勝敗をテキスト表示
        outputWinLose.setText(resultStr[result] + "です");
    }
}
