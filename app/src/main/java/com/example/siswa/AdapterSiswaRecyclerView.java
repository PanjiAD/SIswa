package com.example.siswa;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.siswa.activites.lihatSiswa;
import com.example.siswa.activites.lihat_detail_siswa;
import com.example.siswa.activites.tambahSiswa;

import java.util.ArrayList;

public class AdapterSiswaRecyclerView extends RecyclerView.Adapter<AdapterSiswaRecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<Siswa> daftarSiswa;
    FirebaseDataListener listener;

    public AdapterSiswaRecyclerView(ArrayList<Siswa> siswas, Context ctx){
        /**
         * Inisiasi data dan variabel yang akan digunakan
         */
        daftarSiswa = siswas;
        context = ctx;
        listener = (lihatSiswa)ctx;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        /**
         * Inisiasi View
         * Di tutorial ini kita hanya menggunakan data String untuk tiap item
         * dan juga view nya hanyalah satu TextView
         */
        TextView tvTitle;
        TextView tvSub;
        CardView crdView;

        ViewHolder(View v) {
            super(v);
            tvTitle = (TextView) v.findViewById(R.id.namaSiswa);
            tvSub= (TextView) v.findViewById(R.id.nisnSiswa);
            crdView = (CardView) v.findViewById(R.id.card_view);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        /**
         *  Inisiasi ViewHolder
         */
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_siswa, parent, false);
        // mengeset ukuran view, margin, padding, dan parameter layout lainnya
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        /**
         *  Menampilkan data pada view
         */
        final String name = daftarSiswa.get(position).getNama();
        final String nisn = daftarSiswa.get(position).getNisn();
        System.out.println("Siswa Data one by one "+position+daftarSiswa.size());
        holder.crdView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**
                 *  Kodingan untuk tutorial <span data-mce-type="bookmark" style="display: inline-block; width: 0px; overflow: hidden; line-height: 0;" class="mce_SELRES_start"></span>Read detail data
                 */
                context.startActivity(lihat_detail_siswa.getActIntent((Activity) context).putExtra("dataSiswa", daftarSiswa.get(position)));
            }
        });
        holder.crdView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                /**
                 *  Kodingan untuk tutorial delete dan update data
                 */
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialog_view);
                dialog.setTitle("Pilih Aksi");
                dialog.show();

                Button editButton = (Button) dialog.findViewById(R.id.bt_edit_data);
                Button delButton = (Button) dialog.findViewById(R.id.bt_delete_data);

                //apabila tombol edit diklik
                editButton.setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                dialog.dismiss();
                                context.startActivity(tambahSiswa.getActIntent((Activity) context).putExtra("dataSiswa", daftarSiswa.get(position)));
                            }
                        }
                );

                //apabila tombol delete diklik
                delButton.setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                dialog.dismiss();
                                listener.onDeleteData(daftarSiswa.get(position), position);
                            }
                        }
                );
                return true;
            }
        });
        holder.tvTitle.setText(name);
        holder.tvSub.setText(nisn);
    }

    @Override
    public int getItemCount() {
        /**
         * Mengembalikan jumlah item pada Siswa
         */
        return daftarSiswa.size();
    }

    public interface FirebaseDataListener{
        void onDeleteData(Siswa barang, int position);
    }
}
