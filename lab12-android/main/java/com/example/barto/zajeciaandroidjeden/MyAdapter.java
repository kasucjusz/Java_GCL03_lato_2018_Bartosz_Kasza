package com.example.barto.zajeciaandroidjeden;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import android.widget.AdapterView.OnItemClickListener;
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {


    private List<Tasks> tasksList=new ArrayList<>();

    private android.content.Context context;
        private OnItemClickListener mListener;


    private RecyclerView recyclerView;



    public interface OnItemClickListener
    {
        void onDeleteClick(int position);

    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener=listener;
    }





    public MyAdapter(List<Tasks> ztasksList, RecyclerView zrecyclerView)
    {

        tasksList=ztasksList;
        recyclerView=zrecyclerView;

    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.single_task_layout,viewGroup,false);
        MyViewHolder vh=new MyViewHolder(v,mListener);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder,final int position) {

        Tasks tasks=tasksList.get(position);

        holder.taskName.setText(tasks.getTaskName());
        holder.expirationDate.setText(tasks.getExpirationDate());



       // ((MyViewHolder) holder).taskName.setText(tasks.getTaskName());
       // ((MyViewHolder) holder).expirationDate.setText(tasks.getExpirationDate());

        //kolorowanie daty na czerwono jeszcze sie przemysli


    }

    //wyglad poszczegolnego paska i co bedzie w sobie zawierał pozdro


    @Override
    public int getItemCount() {

        return tasksList.size();
    }




    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView taskName;
        private TextView expirationDate;
        private ImageButton delete;
        public MyViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);


            taskName=(TextView) itemView.findViewById(R.id.task_name);
            expirationDate=(TextView) itemView.findViewById(R.id.task_date);
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







        }
    }
}
