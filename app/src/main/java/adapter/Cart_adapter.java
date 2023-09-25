package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ecommerceapplication.Modelclass;
import com.example.ecommerceapplication.R;

import java.util.ArrayList;

import Clickevent.Clickevent;

public class Cart_adapter extends RecyclerView.Adapter<Cart_adapter.MYViewHolder> {
    Context context;
    ArrayList<Modelclass> arrayList;
   // Clickevent clickevent4;

    public Cart_adapter(Context context, ArrayList<Modelclass> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public Cart_adapter.MYViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_addcart, null, false);
        Cart_adapter.MYViewHolder MYViewHolder = new Cart_adapter.MYViewHolder(view);


        return MYViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MYViewHolder holder, int position) {
        holder.t1.setText(arrayList.get(position).getCarttname());
        holder.t3.setText(arrayList.get(position).getCartprice1());
        holder.t4.setText(arrayList.get(position).getCartprice2());
        Glide.with(context).load(arrayList.get(position).getCarttimage()).into(holder.addtocartimage);

    }


       /* holder.description.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                clickevent4.GetItemPos(holder.getAdapterPosition());

              *//*  Intent ii =new Intent(context, Subcat.class);
                ii.putExtra("hlo",""+arrayList.get(position).getId());
                context.startActivity(ii);*//*
            }
        });*/
  //  }

    @Override
    public int getItemCount() {
        return arrayList.size();

    }

    public class MYViewHolder extends RecyclerView.ViewHolder {
        ImageView addtocartimage;
        TextView t1, t2, t3, t4;
       // ConstraintLayout description;

        public MYViewHolder(@NonNull View itemView) {
            super(itemView);
          //  description = itemView.findViewById(R.id.descriptionpage);

            addtocartimage = itemView.findViewById(R.id.cartimage);

            t1 = itemView.findViewById(R.id.cartname);
            //  t2 = itemView.findViewById(R.id.desdes);

            t3 = itemView.findViewById(R.id.cartprice);

            t4 = itemView.findViewById(R.id.cartprice2);

        }

    }

   // public void setonItemClickForRec(Clickevent clickevent) {
     //   this.clickevent4 = clickevent;
  //  }

}


