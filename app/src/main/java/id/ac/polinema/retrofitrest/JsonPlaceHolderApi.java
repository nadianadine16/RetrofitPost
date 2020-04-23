package id.ac.polinema.retrofitrest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface JsonPlaceHolderApi {
    @GET("Siswa")
    Call<List<Post>> getPost();

    @POST("Siswa")
    Call<Post>createPost(@Body Post post);
}

//    @GET("Siswa")
//    Call<List<Post>> getPost(@Query("id_siswa")String id_siswa);
//}


