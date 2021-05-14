package to.msn.wings.janken;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import java.util.Objects;

public class MainFragment extends Fragment {
    int handYou = 0;
    private boolean isTwoPane = false;

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Activity activity = Objects.requireNonNull(getActivity());
        if (activity.findViewById(R.id.resultFrame) != null) {
            isTwoPane = true;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        Activity activity = Objects.requireNonNull(getActivity());
        View view = inflater.inflate(R.layout.main_fragment, container, false);
//ボタン押されたとき
        ImageButton btGoo = view.findViewById(R.id.btGoo);
        ImageButton btCho = view.findViewById(R.id.btCho);
        ImageButton btPah = view.findViewById(R.id.btPah);

        ButtonListener listener = new ButtonListener();
        btGoo.setOnClickListener(listener);
        btCho.setOnClickListener(listener);
        btPah.setOnClickListener(listener);
        return view;
    }


    private class ButtonListener implements View.OnClickListener {
        public void onClick(View view) {
            int[] handYouId = {R.id.btGoo, R.id.btCho, R.id.btPah};
// タップされた画面部品のidのR値に応じて人間の手を取得
            for (int i = 0; i < handYouId.length; i++) {
                if (view.getId() == handYouId[i])
                    handYou = i;
            }
            FragmentManager manager = Objects.requireNonNull(getFragmentManager());
            ResultFragment fragment = new ResultFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("handYou", handYou);
            if (isTwoPane) {
                fragment.setArguments(bundle);
                manager.beginTransaction()
                        .replace(R.id.resultFrame, fragment)
                        .commit();
            } else {
                Intent intent = new Intent(getActivity(), ResultActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        }
    }
}


//        {
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
//


