package com.example.barto.zajeciaandroidjeden;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {


    private List<BaseImageClass> baseImageClassList =new ArrayList<>();

    private android.content.Context context;
        private OnItemClickListener mListener;


    private RecyclerView recyclerView;



    public interface OnItemClickListener
    {
        void onDeleteClick(int position);
        void onItemClick(int position);

    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener=listener;
    }





    public MyAdapter(List<BaseImageClass> zbaseImageClassList, RecyclerView zrecyclerView)
    {

        baseImageClassList =zbaseImageClassList;
        recyclerView=zrecyclerView;

    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.single_row_layout,viewGroup,false);
        MyViewHolder vh=new MyViewHolder(v,mListener);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder,final int position) {

        BaseImageClass baseImageClass = baseImageClassList.get(position);

        holder.imageName.setText(baseImageClass.getImageName());
        holder.expirationDate.setText(baseImageClass.getExpirationDate());



       // ((MyViewHolder) holder).imageName.setText(baseImageClass.getImageName());
       // ((MyViewHolder) holder).expirationDate.setText(baseImageClass.getExpirationDate());

        //kolorowanie daty na czerwono jeszcze sie przemysli


    }

    //wyglad poszczegolnego paska i co bedzie w sobie zawierał pozdro


    @Override
    public int getItemCount() {

        return baseImageClassList.size();
    }




    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView imageName;
        private TextView expirationDate;
        private ImageButton delete;
        public MyViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);


            imageName =(TextView) itemView.findViewById(R.id.image_name);
            expirationDate=(TextView) itemView.findViewById(R.id.image_date);
            delete=(ImageButton) itemView.findViewById(R.id.deleteButton);

            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener!=null)
                    {
                        int position=getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION)
                        {
                            listener.onDeleteClick(position);
                        }
                    }
                }
            });


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener!=null)
                    {
                        int position=getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION)
                        {
                            listener.onItemClick(position);
                        }
                    }
                }
            });








        }
    }
}
