package id.ac.polinema.retrofitrest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import id.ac.polinema.retrofitrest.adapters.SiswaAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    TextView textViewResult;
    private SiswaAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        textViewResult = findViewById(R.id.text_view_result);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.12/mahasiswa/Api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderAPI = retrofit.create(JsonPlaceHolderApi.class);
        Call<List<Post>> call = jsonPlaceHolderAPI.getPost();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                generateDataList(response.body());
                //if (!response.isSuccessful()){
                //    textViewResult.setText("Code "+response.code());
                //    return;
                //}
                //List<Post> posts=response.body();
                //String content="";
                //for (Post post:posts){

                //   content+="ID Siswa :"+post.getId_siswa()+"\n";
                //   content+="Nama :"+post.getNama()+"\n";
                //   content+="Alamat :"+post.getAlamat()+"\n";
                //   content+="Jenis Kelamin :"+post.getJenis_kelamin()+"\n";
                //   content+="No Telp. :"+post.getNo_telp()+"\n\n";
                //}
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }

    public void tambah(View view) {
        Intent i = new Intent(MainActivity.this,Formadd.class);
        startActivity(i);
    }
    private void generateDataList(List<Post> dataList) {
        recyclerView = findViewById(R.id.text_view_result);
        //membuat adapter dan menampilkan list datanya
        adapter = new SiswaAdapter(dataList, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        //membuat recyclerview dengan layout default
        recyclerView.setLayoutManager(layoutManager);
        //menghubungkan adapter dengan recyclerview
        recyclerView.setAdapter(adapter);
    }
}
