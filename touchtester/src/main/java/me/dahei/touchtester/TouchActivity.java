package me.dahei.touchtester;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * created by yubosu
 * 2018年08月02日上午9:42
 */
public class TouchActivity extends AppCompatActivity {

    private final String TAG = "TouchActivity";

    private int index = 1;

    LogLinearLayout fatherLayout;
    LogLinearLayout child1;
    LogLinearLayout child2;

    private Boolean[][][]  booleans= {
        {
            {false, null, true},
            {false, null, true},
            {false, true, false}
        },
        {
            {false, false, false},
            {false, null, true},
            {false, false, false}
        },
        {
            {false, null, true},
            {false, null, true},
            {false, true, false}
        },
        {
            {null, null, null},
            {false, null, true},
            {false, null, false}
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch);
        init();
    }

    private void init() {
        fatherLayout = findViewById(R.id.layout_father);
        child1 = findViewById(R.id.layout_child1);
        child2 = findViewById(R.id.layout_child2);
        fatherLayout.setName("fatherLayout");
        child1.setName("layout_child1");
        child2.setName("layout_child2");
        Button button = findViewById(R.id.button);
        final TextView textView = findViewById(R.id.text);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "button click");
                index = (index + 1) % booleans.length;
                test(booleans[index]);
                textView.setText("test " + index);
            }
        });
    }

    private void test(Boolean[][] b1 ) {
        fatherLayout.setTouchOption(b1[0][0], b1[0][1], b1[0][2]);
        child1.setTouchOption(b1[1][0], b1[1][1], b1[1][2]);
        child2.setTouchOption(b1[2][0], b1[2][1], b1[2][2]);
    }
}
