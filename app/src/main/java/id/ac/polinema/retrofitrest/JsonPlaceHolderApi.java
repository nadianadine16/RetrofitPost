package id.ac.polinema.retrofitrest;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface JsonPlaceHolderApi {
    @GET("Siswa")
    Call<List<Post>> getPost();

    @POST("Siswa")
    Call<Post>createPost(@Body Post post);

    @PUT("Siswa")
    Call<Post>updatePost(@Body Post post);

//    @FormUrlEncoded
//    @PUT("Siswa")
//    Call<ResponseBody>updateDataMhs(
//            @Field("id_siswa") String id_siswa,
//            @Field("nama") String nama,
//            @Field("alamat") String alamat,
//            @Field("jenis_kelamin") String jenis_kelamin,
//            @Field("no_telp") String no_telp
//    );
}

//    @GET("Siswa")
//    Call<List<Post>> getPost(@Query("id_siswa")String id_siswa);
//}


