package adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ecommerceapplication.Modelclass;
import com.example.ecommerceapplication.R;

import java.util.ArrayList;

public class Subcat2 extends RecyclerView.Adapter<Subcat2.MyViewHolder> {
    Context context;
    ArrayList<Modelclass> arrayList;
    //  Clickevent cliclevent;

    public Subcat2(Context context, ArrayList<Modelclass> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }



    @NonNull
    @Override
    public Subcat2.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.subcatitem2, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

  /*  @Override
    public void onBindViewHolder(@NonNull Subcat2. MyViewHolder holder, int position) {
        holder.ttt.setText(arrayList.get(position).getSlidername());

        Glide.with(context).load(arrayList.get(position).getSliderimage()).into(holder.imggggg);

    }*/

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tttt.setText(arrayList.get(position).getSlidername());

        Glide.with(context).load(arrayList.get(position).getSliderimage()).into(holder.imggggg);
    }






    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imggggg;
        TextView tttt;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imggggg = itemView.findViewById(R.id.img7);
            tttt = itemView.findViewById(R.id.txt555);

        }
    }
}
