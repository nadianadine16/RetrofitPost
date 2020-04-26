package id.ac.polinema.retrofitrest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UpdateActivity extends AppCompatActivity {
    private TextView txtnim, txtnama, txtalamat, txtjk, txtnotelp;
    private EditText edtnim, edtnama, edtalamat, edtjk, edtnotelp;
    private Button btnupdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        txtnim = (TextView)findViewById(R.id.textid);
        txtnama = (TextView)findViewById(R.id.textnama);
        txtalamat = (TextView)findViewById(R.id.textalamat);
        txtjk = (TextView)findViewById(R.id.textjk);
        txtnotelp = (TextView)findViewById(R.id.texttelp);
        edtnim = (EditText)findViewById(R.id.editid);
        edtnama = (EditText)findViewById(R.id.editnama);
        edtalamat = (EditText)findViewById(R.id.editalamat);
        edtjk = (EditText)findViewById(R.id.editjk);
        edtnotelp = (EditText)findViewById(R.id.edittelp);
        btnupdate = (Button)findViewById(R.id.btnupdate);

        //mengambil data dari intent menggunakan bundle
        Bundle bundle = getIntent().getExtras();
        edtnim.setText(bundle.getString("Nim"));
        edtnama.setText(bundle.getString("Nama"));
        edtalamat.setText(bundle.getString("Alamat"));
        edtjk.setText(bundle.getString("Jenis Kelamin"));
        edtnotelp.setText(bundle.getString("No Telp"));

        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateData();
                Intent intent = new Intent(UpdateActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void updateData(){
        String id_siswa = edtnim.getText().toString();
        String nama = edtnama.getText().toString();
        String alamat = edtalamat.getText().toString();
        String jenis_kelamin = edtjk.getText().toString();
        String no_telp = edtnotelp.getText().toString();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.12/mahasiswa/Api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Post post = new Post(id_siswa,nama, alamat, jenis_kelamin, no_telp);

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        Call<Post> call = jsonPlaceHolderApi.updatePost(post);

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if(response.isSuccessful()){
                    Toast.makeText(UpdateActivity.this, "Data berhasil diupdate", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(UpdateActivity.this, MainActivity.class);
                    startActivity(i);
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Toast.makeText(UpdateActivity.this, "Gagal diupdate", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
