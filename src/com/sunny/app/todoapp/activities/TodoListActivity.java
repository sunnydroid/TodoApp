package com.sunny.app.todoapp.activities;

import java.io.File;
import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.sunny.app.todoapp.R;

public class TodoListActivity extends Activity {
	
	ArrayList<String> items;
	ArrayAdapter<String> itemAdapter;
	ListView lvItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_list);
        
        lvItems = (ListView) findViewById(R.id.lvItems);
        items = new ArrayList<>();
        itemAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        
        lvItems.setAdapter(itemAdapter);
        
        addListItemsListener();
    }
    
    /**
     * Click listenter attached to Add button to add text from 
     * edit textbox to the addapter
     * @param view
     */
    public void addTodoItem(View view) {
    	EditText etNewItem = (EditText) findViewById(R.id.etNewItem);
    	itemAdapter.add(etNewItem.getText().toString());
    	etNewItem.setText("");
    }
    
    /**
     * Creates a item long listener and attaches it to each item created 
     * in the items list view. 
     */
    public void addListItemsListener() {
    	lvItems.setOnItemLongClickListener(new OnItemLongClickListener() {
    		
    		@Override
    		public boolean onItemLongClick(AdapterView<?> aView, View item, int pos, long id) {
    			items.remove(pos);
    			itemAdapter.notifyDataSetInvalidated();
    			return true;
    		}
		});
    }
    
//    private void saveItemsToFile() {
//    	File filesDir = getFilesDir();
//    	File toDoFile = new File(filesDir, "todoFile.txt");
//    	
//    	try {
//    		items = new ArrayList<>(FileUtils.readLines(toDoFile));
//    	}
//    }
}
