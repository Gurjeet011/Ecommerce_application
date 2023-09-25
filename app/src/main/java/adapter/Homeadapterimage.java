package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ecommerceapplication.Modelclass;
import com.example.ecommerceapplication.R;

import java.util.ArrayList;

import Clickevent.Clickevent;
import de.hdodenhof.circleimageview.CircleImageView;

public class Homeadapterimage extends RecyclerView.Adapter<Homeadapterimage.MyViewHolder> {
    Context context;
    ArrayList<Modelclass> arrayList;
  //  Clickevent cliclevent;

    public Homeadapterimage(Context context, ArrayList<Modelclass> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }



    @NonNull
    @Override
    public Homeadapterimage.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.homepage_image, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Glide.with(context).load(arrayList.get(position).getImg()).into(holder.imagekk);

    }



    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imagekk;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imagekk = itemView.findViewById(R.id.homeimage);

        }
    }
}
