package corp.king.booksapp.presentation.views;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import corp.king.booksapp.R;

public class MainActivity extends AppCompatActivity {

    private LinearLayout llBottomSheet, llcontent;
    private BottomSheetBehavior bottomSheetBehavior;
    private View view;
    private TextView username, my_lib;
    private FloatingActionButton btn_action;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        llBottomSheet = findViewById(R.id.bottom_sheet);
        username=findViewById(R.id.name);
        llcontent=findViewById(R.id.llcontent);
        btn_action=findViewById(R.id.button_action);
        view =findViewById(R.id.line_view);


        BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from(llBottomSheet);
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        bottomSheetBehavior.setPeekHeight(156);


        bottomSheetBehavior.setHideable(false);



        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                if (newState == BottomSheetBehavior.STATE_COLLAPSED) {
                    llcontent.setVisibility(View.GONE);
                    username.setVisibility(View.INVISIBLE);
                } else if (newState == BottomSheetBehavior.STATE_EXPANDED){
                    llcontent.setVisibility(View.VISIBLE);
                    username.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
            }

        });

        btn_action.setOnClickListener(view -> {
            if(bottomSheetBehavior.getState() == BottomSheetBehavior.STATE_COLLAPSED){
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            } else if(bottomSheetBehavior.getState()==BottomSheetBehavior.STATE_EXPANDED){
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            }

        });
    }

}
