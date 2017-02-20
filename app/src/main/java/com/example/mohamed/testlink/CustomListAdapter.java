package com.example.mohamed.testlink;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by taseneem 21 on 11/27/2016.
 */
public class CustomListAdapter extends BaseAdapter {

    private ArrayList<User> arrayList;
    private Context ctx;

    public CustomListAdapter(ArrayList<User> arrayList, Context ctx) {
        this.arrayList = arrayList;
        this.ctx = ctx;
    }

    public void addItem(User t)
    {
        arrayList.add(t);
        notifyDataSetChanged();
    }

    public void removeItem(int position)
    {
        arrayList.remove(position);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public User getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        convertView = layoutInflater.inflate(R.layout.child_list,parent,false);

        TextView nameText = (TextView) convertView.findViewById(R.id.Name);
        TextView descText = (TextView) convertView.findViewById(R.id.Data);

        TextView AddressText = (TextView) convertView.findViewById(R.id.address);
        TextView BloodText = (TextView) convertView.findViewById(R.id.blood);

        //TextView GroupIDText = (TextView) convertView.findViewById(R.id.Groupid);
        TextView PhoneText = (TextView) convertView.findViewById(R.id.Phone);

        TextView EmailText = (TextView) convertView.findViewById(R.id.email);
        TextView BirthText = (TextView) convertView.findViewById(R.id.Date);



        final User t = getItem(position);

        nameText.setText(t.getUsername());
        descText.setText(t.getUserPost());
        BirthText.setText(t.getUserDate());


        PhoneText.setText(t.getUserPhone());

        EmailText.setText(t.getEmail());


        BloodText.setText(t.getUserBloood());


        AddressText.setText(t.getUserAddress());



        return convertView;
    }
}
