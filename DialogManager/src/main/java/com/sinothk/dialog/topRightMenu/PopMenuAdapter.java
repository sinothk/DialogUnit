package com.sinothk.dialog.topRightMenu;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sinothk.dialog.R;

import java.util.ArrayList;

/**
 * Created by 梁玉涛 on 2017/12/24.
 */

public class PopMenuAdapter extends BaseAdapter {
    Activity mContext;
    ArrayList<PopMenuItem> menuItems;

    public PopMenuAdapter(Activity mContext, ArrayList<PopMenuItem> menuItems) {
        this.mContext = mContext;
        this.menuItems = menuItems;
    }

    @Override
    public int getCount() {
        return menuItems.size();
    }

    @Override
    public Object getItem(int position) {
        return menuItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        HoldView holdView;

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.top_diaolog_menu_list_item, parent, false);
            holdView = new HoldView(convertView);
            convertView.setTag(holdView);
        } else {
            holdView = (HoldView) convertView.getTag();
        }

        PopMenuItem popMenuItem = menuItems.get(position);
        holdView.itemIcon.setImageResource(popMenuItem.getItemIcon());
        holdView.itemName.setText(popMenuItem.getItemName());

        if (popMenuItem.getItemBg() > 0) {
            holdView.listItemLayout.setBackgroundResource(popMenuItem.getItemBg());
        } else {
            holdView.listItemLayout.setBackgroundResource(R.drawable.selector_list_item_bg);
        }


        return convertView;
    }

    private class HoldView {
        LinearLayout listItemLayout;
        TextView itemName;
        ImageView itemIcon;

        HoldView(View convertView) {
            listItemLayout = (LinearLayout) convertView.findViewById(R.id.listItemLayout);
            itemIcon = (ImageView) convertView.findViewById(R.id.itemIcon);
            itemName = (TextView) convertView.findViewById(R.id.itemName);
        }
    }
}
