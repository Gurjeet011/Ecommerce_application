package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ecommerceapplication.Modelclass;
import com.example.ecommerceapplication.R;

import java.util.ArrayList;

public class Subcat4 extends  RecyclerView.Adapter<Subcat4.MyViewHolder> {
    Context context;
    ArrayList<Modelclass> arrayList;
    //  Clickevent cliclevent;

    public Subcat4(Context context, ArrayList<Modelclass> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }



    @NonNull
    @Override
    public Subcat4.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.subcat4, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Glide.with(context).load(arrayList.get(position).getSliderimage()).into(holder.img45);

    }









    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView img45;
        //  TextView tttt;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img45 = itemView.findViewById(R.id.img6);
            //  tttt = itemView.findViewById(R.id.txt555);

        }
    }
}


