package adapter;

import android.content.Context;
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

public class Displaycart extends  RecyclerView.Adapter<Displaycart.MyViewHolder> {
    Context context;
    ArrayList<Modelclass> arrayList;
    //  Clickevent cliclevent;

    public Displaycart(Context context, ArrayList<Modelclass> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }



    @NonNull
    @Override
    public Displaycart.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_addcart, null, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.t1.setText(arrayList.get(position).getDesname());
        //  holder.t2.setText(arrayList.get(position).getDesdes());
        holder.t3.setText(arrayList.get(position).getDespricedis());
        holder.t2.setText(arrayList.get(position).getDespriceori());

      //  Glide.with(context).load(arrayList.get(position).getImg()).into(holder.img5x);
        Glide.with(context)
                .load(arrayList.get(position).getImg())
                .placeholder(R.drawable.placeholder_image) // placeholder image set karein
                .error(R.drawable.img) // agar image load nahi ho paati, to error image set karein
                .into(holder.img5x);

    }







    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView img5x;
        TextView t1,t2,t3;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img5x = itemView.findViewById(R.id.cartimage);
            t1 = itemView.findViewById(R.id.cartname);
            t2 = itemView.findViewById(R.id.cartprice);
            t3= itemView.findViewById(R.id.cartprice2);

        }
    }
}

