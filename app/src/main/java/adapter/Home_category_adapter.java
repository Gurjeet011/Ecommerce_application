package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import Clickevent.Clickevent;
import com.example.ecommerceapplication.Modelclass;
import com.example.ecommerceapplication.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class Home_category_adapter extends RecyclerView.Adapter<Home_category_adapter.MyViewHolder> {
    Context context;
    ArrayList<Modelclass>arrayList;
    Clickevent cliclevent;
   public Home_category_adapter(Context context, ArrayList<Modelclass>arrayList){
        this.context=context;
        this.arrayList=arrayList;
    }


    @NonNull
    @Override
    public Home_category_adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_custom_category, null, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull Home_category_adapter.MyViewHolder holder, int position) {
         holder.text.setText(arrayList.get(position).getCategoreyname());
        Glide.with(context).load(arrayList.get(position).getCategoreyimage()).into(holder.image);
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cliclevent.GetItemPos(holder.getAdapterPosition());
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
        CircleImageView image;
        TextView text;
        RelativeLayout relativeLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.category_image);
            text = itemView.findViewById(R.id.category_text);
            relativeLayout = itemView.findViewById(R.id.relative);
        }
        }

    public void setonItemClickForRec( Clickevent cliclevent){
       this.cliclevent=cliclevent;

    }
}
