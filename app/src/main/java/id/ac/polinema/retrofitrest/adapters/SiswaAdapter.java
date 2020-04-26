package id.ac.polinema.retrofitrest.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import id.ac.polinema.retrofitrest.Post;
import id.ac.polinema.retrofitrest.R;
import id.ac.polinema.retrofitrest.UpdateActivity;

public class SiswaAdapter extends RecyclerView.Adapter<SiswaAdapter.ViewHolder> {

    private List<Post> dataSiswa;
    private Context context;

    public SiswaAdapter(List<Post> dataSiswa, Context context) {
        this.context= context;
        this.dataSiswa = dataSiswa;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View Siswaview = layoutInflater.inflate(R.layout.item_list, parent, false);

        ViewHolder viewHolder = new ViewHolder(Siswaview);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SiswaAdapter.ViewHolder holder, int position) {
        final Post ssw = dataSiswa.get(position);

        TextView textView = holder.IdsswTextView;
        TextView textView1 = holder.nameTextView;
        TextView textView2 = holder.alamatTextView;
        TextView textView3 = holder.jkTextView;
        TextView textView4 = holder.notelpTextView;

        textView.setText(ssw.getId_siswa());
        textView1.setText(ssw.getNama());
        textView2.setText(ssw.getAlamat());
        textView3.setText(ssw.getJenis_kelamin());
        textView4.setText(ssw.getNo_telp());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mengirim data berupa nim yaitu idsiswa, nama, alamat, jenis kelamin, dan no telp
                Bundle bundle = new Bundle();
                bundle.putString("Nim", ssw.getId_siswa());
                bundle.putString("Nama", ssw.getNama());
                bundle.putString("Alamat", ssw.getAlamat());
                bundle.putString("Jenis Kelamin", ssw.getJenis_kelamin());
                bundle.putString("No Telp", ssw.getNo_telp());
                Intent intent = new Intent(context, UpdateActivity.class);
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {

        return dataSiswa.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView IdsswTextView;
        public TextView nameTextView;
        public TextView alamatTextView;
        public TextView jkTextView;
        public TextView notelpTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            IdsswTextView = (TextView)itemView.findViewById(R.id.id_siswa);
            nameTextView = (TextView)itemView.findViewById(R.id.nama_siswa);
            alamatTextView = (TextView)itemView.findViewById(R.id.alamat_siswa);
            jkTextView = (TextView)itemView.findViewById(R.id.jeniskelamin_siswa);
            notelpTextView = (TextView)itemView.findViewById(R.id.notelp_siswa);
        }
    }
}
