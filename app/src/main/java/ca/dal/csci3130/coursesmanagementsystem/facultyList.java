package ca.dal.csci3130.coursesmanagementsystem;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class facultyList extends ArrayAdapter<faculty> {

    private Activity context;
    private List<faculty>facultyList;
    //TextView text = (TextView)facultyList;
    public facultyList(Activity context, List<faculty>facultyList) {
        super(context,R.layout.list_layout,facultyList);
        this.context = context;
        this.facultyList = facultyList;
    }




    @NonNull
    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.list_layout,null,true);

        //TextView textView = (TextView)listViewItem.findViewById(R.id.)


        TextView textView =(TextView)listViewItem.findViewById(R.id.name);
        TextView textView1 = (TextView)listViewItem.findViewById(R.id.intro);
        TextView textView2 = (TextView)listViewItem.findViewById(R.id.seat);

       // TextView textView3 = (TextView)listViewItem.findViewById(R.id.courseID);

        faculty fac = facultyList.get(position);
        textView.setText(fac.getUid());
        textView1.setText(fac.getCourseProfessor());
        textView2.setText((""+ fac.getSeat()));
        //TextView text = (TextView)
        //text.setText(fac.getCourseIntro());
       // textView3.setText(fac.getUid());

        return listViewItem;
    }
}
