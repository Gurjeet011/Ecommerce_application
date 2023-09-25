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
import java.util.List;

public class ImageSliderAdapter extends RecyclerView.Adapter<ImageSliderAdapter.ImageViewHolder> {
    Context context;
    ArrayList<Modelclass> arrayList;
    //private List<Integer> imageList;

    public ImageSliderAdapter(Context context, ArrayList<Modelclass> arrayList) {
        //this.imageList = imageList;
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_custom_imageslider, parent, false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
      //  int imageRes = imageList.get(position);
       // holder.imageView.setImageResource(imageRes);

        Glide.with(context).load(arrayList.get(position).getImageslider()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }



    static class ImageViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view);
        }
    }
}