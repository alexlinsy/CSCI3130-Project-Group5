package ca.dal.csci3130.coursesmanagementsystem;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class courseList extends ArrayAdapter<course> {
    private Activity context;
    private List<course> courseList;

    public courseList(Activity context,List<course>courseList){
        super(context,R.layout.list_layout,courseList);
        this.context = context;
        this.courseList = courseList;

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.list_layout,null,true);

        //TextView textView = (TextView)listViewItem.findViewById(R.id.)


        TextView textView =(TextView)listViewItem.findViewById(R.id.name);
        TextView textView1 = (TextView)listViewItem.findViewById(R.id.intro);
        TextView textView2 = (TextView)listViewItem.findViewById(R.id.seat);

        // TextView textView3 = (TextView)listViewItem.findViewById(R.id.courseID);

        course fac = courseList.get(position);
        textView.setText(fac.getUid());
        textView1.setText(fac.getProfessor());
        textView2.setText((""+ fac.getSeat()));
        //TextView text = (TextView)
        //text.setText(fac.getCourseIntro());
        // textView3.setText(fac.getUid());

        return listViewItem;
    }
}
