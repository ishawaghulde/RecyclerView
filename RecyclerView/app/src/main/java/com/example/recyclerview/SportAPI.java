package com.example.recyclerview;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SportAPI {
    @GET("fixture?sport=FOOTBALL(BOYS)")
    Call<List<DetailPost>> getDetailPosts();
}
