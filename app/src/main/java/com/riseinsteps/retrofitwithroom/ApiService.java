package com.riseinsteps.retrofitwithroom;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("api/users?page=1/")
    Call<Model> getData();

}
