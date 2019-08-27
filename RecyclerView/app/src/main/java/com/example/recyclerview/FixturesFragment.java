package com.example.recyclerview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
    private String textStr;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fixtures_fragment,container,false);
        textView = view.findViewById(R.id.textView);
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
                    textStr+="\n" + post.getWinner();
                    textStr+="\n\n";

                    textView.append(textStr);
                    textStr = "";
                }


            }

            @Override
            public void onFailure(@NonNull Call<List<DetailPost>> call,@NonNull Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
