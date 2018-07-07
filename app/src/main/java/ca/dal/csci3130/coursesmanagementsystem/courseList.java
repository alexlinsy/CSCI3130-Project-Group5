package ca.dal.csci3130.coursesmanagementsystem;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * This class is defined to store course object to a courseList
 * and use this courseList to show all courses timetable and information
 */
public class courseList extends ArrayAdapter<course> {
    private Activity context;
    private List<course> courseList;

    public courseList(Activity context,List<course>courseList){
        super(context,R.layout.list_layout,courseList);
        this.context = context;
        this.courseList = courseList;

    }

    /**
     * This method is used to get the course information and show to the textView
     * @param position get the position you selected
     * @param convertView get the convertView
     * @param parent get the last activity
     * @return the item that you selected
     */
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.list_layout,null,true);
        TextView textView =(TextView)listViewItem.findViewById(R.id.name);
        TextView textView1 = (TextView)listViewItem.findViewById(R.id.intro);
        TextView textView2 = (TextView)listViewItem.findViewById(R.id.seat);
        course fac = courseList.get(position);
        textView.setText(fac.getUid());
        textView1.setText(fac.getProfessor());
        textView2.setText((""+ fac.getSeat()));

        return listViewItem;
    }
}
