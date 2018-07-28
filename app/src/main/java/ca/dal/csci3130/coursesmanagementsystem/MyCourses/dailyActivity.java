package ca.dal.csci3130.coursesmanagementsystem.MyCourses;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import ca.dal.csci3130.coursesmanagementsystem.CoursesRegister.registeredCourse;
import ca.dal.csci3130.coursesmanagementsystem.R;

public class dailyActivity extends AppCompatActivity {
    private ArrayList<registeredCourse>courses;
    private ListView view;
    private String[]courseName;
    private String[]courseTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily);
        //view = findViewById(R.id.registered);
        Intent intent = getIntent();
        courses = (ArrayList<registeredCourse>) intent.getExtras().getSerializable("sche");
        courseName  = new String[courses.size()];
        courseTime = new String[courses.size()];
        for(int i = 0; i< courses.size();i++){
            courseName[i] = courses.get(i).getCourseID();
            courseTime[i] = courses.get(i).getStartTime()+" - "+courses.get(i).getEndTime();
        }
        setuplistView();
        //String str ="";
    }

    public void setuplistView(){
        view = findViewById(R.id.registered);
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,courseName,courseTime);
        view.setAdapter(simpleAdapter);
        view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

    }

    public class SimpleAdapter extends BaseAdapter{

        private Context mContext;
        private LayoutInflater layoutInflater;
        private TextView courseId,courseTime;
        private String[] idArray;
        private String[] timeArray;

        public SimpleAdapter(Context context, String[]title, String[]description){
            mContext = context;
            idArray = title;
            timeArray = description;
            layoutInflater = LayoutInflater.from(context);
        }
        /**
         * How many items are in the data set represented by this Adapter.
         *
         * @return Count of items.
         */
        @Override
        public int getCount() {
            return idArray.length;
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
            return idArray[position];
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
                convertView = layoutInflater.inflate(R.layout.daily_single_item,null);
            }
            courseId = (TextView)convertView.findViewById(R.id.registeredName);
            courseTime = (TextView)convertView.findViewById(R.id.registeredTime);
            courseId.setText(idArray[position]);
            courseTime.setText(timeArray[position]);
            return convertView;

        }
    }




}