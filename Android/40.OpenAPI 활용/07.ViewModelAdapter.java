package com.example.mynaveractivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;

//배열을 참조하는 Adapter클래스
//xml파일의 각 뷰들에게 parser클래스를 통해 반환된 BookModel정보를 전달하는 클래스
public class ViewModelAdapter extends ArrayAdapter<BookModel> {

    private Context context;
    private BookModel vo;
    private int resource;
    private ArrayList<BookModel> list;

    public ViewModelAdapter(Context context,int resource,ArrayList<BookModel> list){
        super(context,resource,list);
        this.list = list;
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(resource,null);

        vo = list.get(position);
        if(vo != null){
            TextView title = (TextView)convertView.findViewById(R.id.book_title);
            TextView author = (TextView)convertView.findViewById(R.id.book_author);
            TextView price = (TextView)convertView.findViewById(R.id.book_price);
            ImageView img = (ImageView) convertView.findViewById(R.id.book_img);
            //문자값 셋팅
            if(title != null){
                title.setText(vo.getB_title());
            }
            if(author != null){
                title.setText(vo.getB_author());
            }
            if(price != null){
                title.setText(vo.getB_price());
            }

            //이미지 로드...
            //이미지를 로드하는 Async생성과 실행을 제일 마지막에 해주면 된다.
        }
        return convertView;
    };
}
