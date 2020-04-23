package id.ac.polinema.retrofitrest.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import id.ac.polinema.retrofitrest.Post;
import id.ac.polinema.retrofitrest.R;

public class SiswaAdapter extends RecyclerView.Adapter<SiswaAdapter.ViewHolder> {

    private List<Post> items;


    public SiswaAdapter(List<Post> items) {

        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Post item = items.get(position);
        holder.txtidsiswa.setText(item.getId_siswa());
        holder.txtnama.setText(item.getNama());
        holder.txtalamat.setText(item.getAlamat());
        holder.txtjeniskelamin.setText(item.getJenis_kelamin());
        holder.txtnotelp.setText(item.getNo_telp());
    }

    @Override
    public int getItemCount() {
        return (items != null) ? items.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtidsiswa, txtnama, txtalamat, txtjeniskelamin, txtnotelp;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtidsiswa = (TextView) itemView.findViewById(R.id.id_siswa);
            txtnama = (TextView) itemView.findViewById(R.id.nama_siswa);
            txtalamat = (TextView) itemView.findViewById(R.id.alamat_siswa);
            txtjeniskelamin = (TextView) itemView.findViewById(R.id.jeniskelamin_siswa);
            txtnotelp = (TextView) itemView.findViewById(R.id.notelp_siswa);
        }
    }
}
