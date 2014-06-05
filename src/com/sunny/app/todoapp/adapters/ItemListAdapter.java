package com.sunny.app.todoapp.adapters;

import java.util.ArrayList;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.sunny.app.model.Item;

public class ItemListAdapter extends ArrayAdapter<Item>{
	
	public ItemListAdapter(Context context, ArrayList<Item> items) {
		super(context, 0, items);
	}
}
