package adapter;

import android.content.Context;
import android.graphics.Paint;
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

public class Product_adapter extends RecyclerView.Adapter<Product_adapter.MyViewHolder> {
    Context context;
    ArrayList<Modelclass> arrayList;
    Clickevent clickevent3;

    // Subcat_clickevent subcatcliclevent;
    public Product_adapter(Context context, ArrayList<Modelclass> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }


    @NonNull
    @Override
    public Product_adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_custom_product, null, false);
        Product_adapter.MyViewHolder myViewHolder = new Product_adapter.MyViewHolder(view);


        return myViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull Product_adapter.MyViewHolder holder, int position) {
        Modelclass model = arrayList.get(position);

        String originalPrice = "₹" + model.getOriginalprice();


        holder.tex2.setText(originalPrice);
        String discountPrice = "₹" + model.getDiscountprice();
        holder.tex3.setText(discountPrice);
        holder.tex3.setPaintFlags(holder.tex3.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        holder.tex4.setText(arrayList.get(position).getBrandname());

        String description = model.getDescription();
        if (description.length() > 10) {
            description = description.substring(0, 10) + "...";
        }
        holder.tex5.setText(description);
        holder.tex6.setText(arrayList.get(position).getDisoffer());

        Glide.with(context).load(arrayList.get(position).getSubcattext()).into(holder.image);
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                clickevent3.GetItemPos(holder.getAdapterPosition());

              /*  Intent ii =new Intent(context, Subcat.class);
                ii.putExtra("hlo",""+arrayList.get(position).getId());
                context.startActivity(ii);*/
            }
        });





    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView tex2, tex3, tex4, tex5,tex6;
        RelativeLayout relativeLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            relativeLayout = itemView.findViewById(R.id.productrelative);
            image = itemView.findViewById(R.id.productiamge);
            tex2 = itemView.findViewById(R.id.textprice1);
            tex3 = itemView.findViewById(R.id.textprice2);
            tex4 = itemView.findViewById(R.id.nameproduct);
            tex5 = itemView.findViewById(R.id.desproduct);
            tex6 = itemView.findViewById(R.id.discountoffer);


        }

    }

    public void setonItemClickForRec(Clickevent clickevent) {
        this.clickevent3 = clickevent;
    }


}