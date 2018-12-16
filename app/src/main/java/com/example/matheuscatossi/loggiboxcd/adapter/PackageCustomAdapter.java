package com.example.matheuscatossi.loggiboxcd.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.matheuscatossi.loggiboxcd.R;
import com.example.matheuscatossi.loggiboxcd.model.DeliveryMan;
import com.example.matheuscatossi.loggiboxcd.model.Package;

import java.util.List;

public class PackageCustomAdapter extends RecyclerView.Adapter<PackageCustomAdapter.MyViewHolder> {

    private Context mContext;
    private List<Package> packageList;

//    private String weight;
////    private String date;
////    private String address_delivery;
////    private String address_deliveryman;
////    private DeliveryMan deliveryman;
////    private String code;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_weight;
        TextView tv_date;
        TextView tv_address_delivery;
        TextView tv_address_deliveryman;
        TextView tv_code;
        TextView tv_document_deliveryman;
        TextView tv_name_deliveryman;


        LinearLayout ll_line;

        public MyViewHolder(View view) {
            super(view);
            tv_weight = (TextView) view.findViewById(R.id.tv_weight);
            tv_date = (TextView) view.findViewById(R.id.tv_date);
            tv_address_delivery = (TextView) view.findViewById(R.id.tv_address_delivery);
            tv_address_deliveryman = (TextView) view.findViewById(R.id.tv_address_deliveryman);
            tv_code = (TextView) view.findViewById(R.id.tv_code);
            tv_document_deliveryman = (TextView) view.findViewById(R.id.tv_document_deliveryman);
            tv_name_deliveryman = (TextView) view.findViewById(R.id.tv_name_deliveryman);

            ll_line = (LinearLayout) view.findViewById(R.id.ll_line);
        }
    }

    public PackageCustomAdapter(Context mContext, List<Package> packageList) {
        this.mContext = mContext;
        this.packageList = packageList;
    }

    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_item_package, parent, false);

        return new MyViewHolder(itemView);
    }

    public void onBindViewHolder(final MyViewHolder holder, int position) {

        final Package packageItem = packageList.get(position);
        holder.tv_weight.setText("" + packageItem.getWeight());
        holder.tv_date.setText("" + packageItem.getDeadline_days() + " dia(s)");
        holder.tv_address_delivery.setText("" + packageItem.getDelivery_address());
        holder.tv_address_deliveryman.setText("" + packageItem.getUser().getAddress());
        holder.tv_code.setText("");
        holder.tv_document_deliveryman.setText("" + packageItem.getUser().getCpf());
        holder.tv_name_deliveryman.setText("" + packageItem.getUser().getName());

    }

    @Override
    public int getItemCount() {
        return packageList.size();
    }
}