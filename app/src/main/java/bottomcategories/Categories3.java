package bottomcategories;

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

public class Categories3 extends  RecyclerView.Adapter<Categories3.MyViewHolder> {
    Context context;
    ArrayList<Modelclass> arrayList;
    //  Clickevent cliclevent;

    public Categories3(Context context, ArrayList<Modelclass> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }



    @NonNull
    @Override
    public Categories3.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categoriesitem3, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.txt111.setText(arrayList.get(position).getSlidername());

        Glide.with(context).load(arrayList.get(position).getSliderimage()).into(holder.img0);

    }













    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView img0;
        TextView txt111;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img0 = itemView.findViewById(R.id.imgr);
            txt111 = itemView.findViewById(R.id.txt123);

        }
    }
}


