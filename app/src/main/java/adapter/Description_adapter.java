package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

public class Description_adapter extends RecyclerView.Adapter<Description_adapter.MYViewHolder> {
    Context context;
    ArrayList<Modelclass> arrayList;
    Clickevent clickevent4;

    public Description_adapter(Context context, ArrayList<Modelclass> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public Description_adapter.MYViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_description, null, false);
        Description_adapter.MYViewHolder MYViewHolder = new Description_adapter.MYViewHolder(view);


        return MYViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Description_adapter.MYViewHolder holder, int position) {
        holder.t1.setText(arrayList.get(position).getDesname());
        //  holder.t2.setText(arrayList.get(position).getDesdes());
        holder.t3.setText(arrayList.get(position).getDespricedis());
        holder.t4.setText(arrayList.get(position).getDespriceori());

        Glide.with(context).load(arrayList.get(position).getDesimage()).into(holder.descriimage);
        holder.description.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                clickevent4.GetItemPos(holder.getAdapterPosition());

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

    public class MYViewHolder extends RecyclerView.ViewHolder {
        ImageView descriimage;
        TextView t1, t2, t3, t4;
        ConstraintLayout description;
        Button btn;


        public MYViewHolder(@NonNull View itemView) {
            super(itemView);
            description = itemView.findViewById(R.id.descriptionpage);

            descriimage = itemView.findViewById(R.id.desimage);
            btn = itemView.findViewById(R.id.addtocartbutton);

            t1 = itemView.findViewById(R.id.desname);
            //  t2 = itemView.findViewById(R.id.desdes);

            t3 = itemView.findViewById(R.id.disprice);

            t4 = itemView.findViewById(R.id.oriprice);

        }

    }

    public void setonItemClickForRec(Clickevent clickevent) {
        this.clickevent4 = clickevent;
    }

}
