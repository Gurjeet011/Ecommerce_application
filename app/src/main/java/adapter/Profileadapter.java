package adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ecommerceapplication.Modelclass;
import com.example.ecommerceapplication.R;

import java.util.ArrayList;

import bottomcategories.Categories1;

public class Profileadapter extends  RecyclerView.Adapter<Profileadapter.MyViewHolder> {
    Context context;
    ArrayList<Modelclass> arrayList;
    //  Clickevent cliclevent;

    public Profileadapter(Context context, ArrayList<Modelclass> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }



    @NonNull
    @Override
    public Profileadapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.customprofile, null, false);
        Profileadapter.MyViewHolder myViewHolder = new Profileadapter.MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.txt112.setText(arrayList.get(position).getSlidername());

        Glide.with(context).load(arrayList.get(position).getSliderimage()).into(holder.img112);
    }











    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    public void setRecyclerViewDivider(RecyclerView recyclerView) {
        DividerItemDecoration itemDecoration = new DividerItemDecoration(context, DividerItemDecoration.VERTICAL);
        Drawable divider = ContextCompat.getDrawable(context, R.drawable.divider_horizontal); // Load your divider drawable
        itemDecoration.setDrawable(divider);
        recyclerView.addItemDecoration(itemDecoration);
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView img112;
        TextView txt112;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img112 = itemView.findViewById(R.id.accountimg);
            txt112 = itemView.findViewById(R.id.accounttext);

        }
    }
}

