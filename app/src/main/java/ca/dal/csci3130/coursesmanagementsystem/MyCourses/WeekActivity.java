package ca.dal.csci3130.coursesmanagementsystem.MyCourses;

import android.content.Context;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import ca.dal.csci3130.coursesmanagementsystem.R;




public class WeekActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week);
        setupUIView();

        setupListView();
    }

    private void setupUIView(){
        toolbar = (Toolbar)findViewById(R.id.ToolbarWeek);
        listView = (ListView)findViewById(R.id.lvWeek);
    }



    private void setupListView(){
        String[]week = getResources().getStringArray(R.array.Week);
       // String [] color = getResources().getStringArray(R.array.colors);
        SimpleAdatper simpleAdatper = new SimpleAdatper(this, week);
        listView.setAdapter(simpleAdatper);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:break;
                    case 1:break;
                    case 2:break;
                    case 3:break;
                    case 4:break;
                    case 5:break;
                    case 6:break;
                    default:break;
                }
            }
        });

    }

    public class SimpleAdatper extends BaseAdapter {
        private Context mContext;
        private LayoutInflater layoutInflater;
        private TextView day;
        private String[] week;
        private String[] color;
        private ImageView imageView;

        public SimpleAdatper(Context context,String[]week){
            mContext = context;
            this.week = week;
            this.color = color;
            layoutInflater = LayoutInflater.from(context);
        }
        /**
         * How many items are in the data set represented by this Adapter.
         *
         * @return Count of items.
         */
        @Override
        public int getCount() {
            return week.length;
        }

        /**
         * Get the data item associated with the specified position in the data set.
         *
         * @param position Position of the item whose data we want within the adapter's
         *                 data set.
         * @return The data at the specified position.
         */
        @Override
        public Object getItem(int position) {
            return week[position];
        }

        /**
         * Get the row id associated with the specified position in the list.
         *
         * @param position The position of the item within the adapter's data set whose row id we want.
         * @return The id of the item at the specified position.
         */
        @Override
        public long getItemId(int position) {
            return position;
        }

        /**
         * Get a View that displays the data at the specified position in the data set. You can either
         * create a View manually or inflate it from an XML layout file. When the View is inflated, the
         * parent View (GridView, ListView...) will apply default layout parameters unless you use
         * {@link LayoutInflater#inflate(int, ViewGroup, boolean)}
         * to specify a root view and to prevent attachment to the root.
         *
         * @param position    The position of the item within the adapter's data set of the item whose view
         *                    we want.
         * @param convertView The old view to reuse, if possible. Note: You should check that this view
         *                    is non-null and of an appropriate type before using. If it is not possible to convert
         *                    this view to display the correct data, this method can create a new view.
         *                    Heterogeneous lists can specify their number of view types, so that this View is
         *                    always of the right type (see {@link #getViewTypeCount()} and
         *                    {@link #getItemViewType(int)}).
         * @param parent      The parent that this view will eventually be attached to
         * @return A View corresponding to the data at the specified position.
         */
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null){
                convertView = layoutInflater.inflate(R.layout.activity_week_single_item,null);
            }
            day = (TextView)convertView.findViewById(R.id.tvDay);
            //description = (TextView)convertView.findViewById(R.id.tvDescription);
            imageView = (ImageView)convertView.findViewById(R.id.ivLetter);

            day.setText(week[position]);
            //description.setText(descriptionArray[position]);

            if(week[position].equalsIgnoreCase("Monday")){
                //int id = getResources().getIdentifier(,null,null);
                //imageView.getDrawable();
                imageView.setImageResource(R.drawable.monday);

            }else if (week[position].equalsIgnoreCase("Tuesday")){
                imageView.setImageResource(R.drawable.tuesday);
                // imageView.setBackgroundColor(20000);
            }else if(week[position].equalsIgnoreCase("Wednesday")) {
                ///imageView.setImageResource(R.drawable.contact);
                imageView.setImageResource(R.drawable.wednesday);
            }else if(week[position].equalsIgnoreCase("Thursday")){
                //imageView.setImageResource(R.drawable.contact);
                imageView.setImageResource(R.drawable.thursday);
            }else if(week[position].equalsIgnoreCase("Friday")){
                //imageView.setImageResource(R.drawable.contact);
                imageView.setImageResource(R.drawable.friday);
            }else if(week[position].equalsIgnoreCase("Saturday")){
                //imageView.setImageResource(R.drawable.contact);
                imageView.setImageResource(R.drawable.saturday);
            }else if(week[position].equalsIgnoreCase("Sunday")){
                //imageView.setImageResource(R.drawable.settings);
                //imageView.setImageResource(R.drawable.tuesday);
            }
            return convertView;
        }

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case android.R.id.home:{
                onBackPressed();
            }
        }
        return super.onOptionsItemSelected(item);
    }

}