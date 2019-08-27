package com.example.recyclerview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FixturesFragment extends Fragment {
    private SportAPI sportAPI;
    private TextView textView;
    private LinearLayout linLayout;
    private String textStr;
    private CardView cardView;
    private TextView match1;
    private TextView match2;
    private TextView match3;
    private TextView match4;
    private TextView match5;
    private TextView match6;
    private int i=0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fixtures_fragment,container,false);
//        textView = view.findViewById(R.id.textView);
        linLayout = view.findViewById(R.id.linLayout);
        match1 = view.findViewById(R.id.match1);
        match2 = view.findViewById(R.id.match2);
        match3 = view.findViewById(R.id.match3);
        match4 = view.findViewById(R.id.match4);
        match5 = view.findViewById(R.id.match5);
        match6 = view.findViewById(R.id.match6);
        final Animation myAnim = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_in_right);
        linLayout.startAnimation(myAnim);
        cardView = (CardView) view.findViewById(R.id.card_view3);
        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(1000);
        anim.setStartOffset(20);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);
        cardView.startAnimation(anim);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://us-central1-sportsfete18v2.cloudfunctions.net/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        sportAPI = retrofit.create(SportAPI.class);

        getDetailPosts();
        return view;
    }

    private void getDetailPosts() {

        Call<List<DetailPost>> call = sportAPI.getDetailPosts();

        call.enqueue(new Callback<List<DetailPost>>() {
            @Override
            public void onResponse(@NonNull Call<List<DetailPost>> call,@NonNull Response<List<DetailPost>> response) {

                if (!response.isSuccessful()) {
                    Toast.makeText(getContext(), "Data Not Found!", Toast.LENGTH_LONG).show();
                    return;
                }
                textStr="";
                List<DetailPost> posts = response.body();

                for (DetailPost post : posts) {

                    textStr+=post.getDept1();
                    textStr+= " VS " + post.getDept2();
                    switch(i){
                        case 1:
                           match1.setText(textStr);
                           break;
                        case 2:
                            match2.setText(textStr);
                            break;
                        case 3:
                            match3.setText(textStr);
                            break;
                        case 4:
                            match4.setText(textStr);
                            break;
                        case 5:
                            match5.setText(textStr);
                            break;
                        case 6:
                            match6.setText(textStr);
                            break;
                        default:
                            break;
                    }
                    textStr = "";
                    i++;
                }


            }

            @Override
            public void onFailure(@NonNull Call<List<DetailPost>> call,@NonNull Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
