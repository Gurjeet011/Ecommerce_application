package adapter;

import static java.security.AccessController.getContext;

import android.app.FragmentManager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ecommerceapplication.Home_fragment;
import com.example.ecommerceapplication.Modelclass;
import com.example.ecommerceapplication.Product;
import com.example.ecommerceapplication.R;

import Clickevent.Clickevent;
import Clickevent.Subcat_clickevent;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class Sub_cat_adapter  extends RecyclerView.Adapter<Sub_cat_adapter.MyViewHolder> {
    Context context;
    ArrayList<Modelclass> arrayList;
   // Subcat_clickevent subcatcliclevent;
Clickevent clickevent2;

    public Sub_cat_adapter(Context context, ArrayList<Modelclass>arrayList){
        this.context=context;
        this.arrayList=arrayList;
    }


    @NonNull
    @Override
    public Sub_cat_adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_custom__sub_cat, null, false);
        Sub_cat_adapter.MyViewHolder myViewHolder = new Sub_cat_adapter.MyViewHolder(view);
        return myViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull Sub_cat_adapter.MyViewHolder holder, int position) {
        holder.text.setText(arrayList.get(position).getSubcatimages());
        Glide.with(context).load(arrayList.get(position).getSubcattext()).into(holder.image);
       holder.relativeLayoutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             //  clickevent2.GetItempos(holder.getAdapterPosition());
clickevent2.GetItemPos(holder.getAdapterPosition());
            }
        });
    /*  holder.imageView2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {


           }
       });*/

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public View relativeLayoutt;
        CircleImageView image,imageView2;
        TextView text;
      //  RelativeLayout relativeLayoutt;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.Sub_cat_image);
//
            text = itemView.findViewById(R.id.sub_cat_text);
           relativeLayoutt = itemView.findViewById(R.id.relativeSubcat);


        }
    }

      public void setonItemClickForRec(Clickevent clickevent){
        this.clickevent2=clickevent;
    }




}


