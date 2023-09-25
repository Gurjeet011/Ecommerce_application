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

public class Homeadater3 extends RecyclerView.Adapter<Homeadater3.MyViewHolder> {
    Context context;
    ArrayList<Modelclass> arrayList;
    //  Clickevent cliclevent;

    public Homeadater3(Context context, ArrayList<Modelclass> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }



    @NonNull
    @Override
    public Homeadater3.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.homelayout, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Glide.with(context).load(arrayList.get(position).getImg4()).into(holder.imgggb);

    }





    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imgggb;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imgggb = itemView.findViewById(R.id.imgj);

        }
    }
}

