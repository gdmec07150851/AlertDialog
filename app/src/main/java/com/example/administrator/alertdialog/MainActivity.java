package com.example.administrator.alertdialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv1;
    private AlertDialog.Builder builder;
    private AlertDialog ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = (TextView) this.findViewById(R.id.textView1);
        Button btn1= (Button) this.findViewById(R.id.button1);
        Button btn2= (Button) this.findViewById(R.id.button2);
        Button btn3= (Button) this.findViewById(R.id.button3);
        Button btn4= (Button) this.findViewById(R.id.button4);
        Button btn5= (Button) this.findViewById(R.id.button5);
        Button btn6= (Button) this.findViewById(R.id.button6);
        Button btn7= (Button) this.findViewById(R.id.button7);

        View.OnClickListener listener = new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                switch(v.getId()){
                    case R.id.button1:
                        dialog1();
                        break;
                    case R.id.button2:
                        dialog2();
                        break;
                    case R.id.button3:
                        dialog3();
                        break;
                    case R.id.button4:
                        dialog4();
                        break;
                    case R.id.button5:
                        dialog5();
                        break;
                    case R.id.button6:
                        dialog6();
                        break;
                    case R.id.button7:
                        dialog7();
                        break;
                }
            }
        };

        btn1.setOnClickListener(listener);
        btn2.setOnClickListener(listener);
        btn3.setOnClickListener(listener);
        btn4.setOnClickListener(listener);
        btn5.setOnClickListener(listener);
        btn6.setOnClickListener(listener);
        btn7.setOnClickListener(listener);

    }
    public void dialog1(){
        ad = new AlertDialog.Builder(this).create();
        ad.setTitle("提示");
        ad.setMessage("确认退出吗?");
        ad.setIcon(android.R.drawable.ic_dialog_alert);
        DialogInterface.OnClickListener list1 = new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(which == DialogInterface.BUTTON_POSITIVE){
                    ad.dismiss();
                    MainActivity.this.finish();
                }
            }
        };
        ad.setButton(DialogInterface.BUTTON_POSITIVE,"取消",list1);
        ad.setButton(DialogInterface.BUTTON_NEGATIVE,"退出",list1);
        ad.show();
    }
    public void dialog2(){
        ad = new AlertDialog.Builder(this).create();
        ad.setTitle("调查");
        ad.setMessage("你平时忙吗?");
        ad.setIcon(android.R.drawable.ic_dialog_dialer);

        DialogInterface.OnClickListener list2 = new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str="";
                switch(which){
                    case DialogInterface.BUTTON_POSITIVE:
                        str="贼忙的";
                        break;
                    case DialogInterface.BUTTON_NEUTRAL:
                        str="还好吧";
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        str="贼无聊";
                        break;
                }
                tv1.setText(str);
            }
        };
        ad.setButton(DialogInterface.BUTTON_POSITIVE,"贼忙",list2);
        ad.setButton(DialogInterface.BUTTON_NEUTRAL,"还好",list2);
        ad.setButton(DialogInterface.BUTTON_NEGATIVE,"无聊",list2);
        ad.show();
    }
    public void dialog3(){
        ad = new AlertDialog.Builder(this).create();
        ad.setTitle("请输入");
        ad.setMessage("你自我感觉怎样");
        ad.setIcon(android.R.drawable.ic_dialog_info);
        final EditText Etext = new EditText(this);
        ad.setView(Etext);
        DialogInterface.OnClickListener list3 = new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                tv1.setText("你输入的是"+Etext.getText().toString());
            }
        };
        ad.setButton(DialogInterface.BUTTON_POSITIVE,"确定",list3);
        ad.show();
    }
    public void dialog4(){
        final String item[] = new String []{"北京","上海","广州"};
        final boolean bselect[] = new boolean[item.length];
        DialogInterface.OnMultiChoiceClickListener mlist1 = new DialogInterface.OnMultiChoiceClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                bselect[which] = isChecked;
            }
        };
        builder = new AlertDialog.Builder(this);
        builder.setMultiChoiceItems(item,null,mlist1);
        ad = builder.create();
        ad.setTitle("复选框");
        DialogInterface.OnClickListener list4 = new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str="你选择了：";
                for(int i=0;i<bselect.length;i++){
                    if(bselect[i]){
                        str=str+"\n"+item[i];
                    }
                }
                tv1.setText(str);
            }
        };
        ad.setButton(DialogInterface.BUTTON_POSITIVE,"确定",list4);
        ad.show();
    }
    public void dialog5(){
        final String item[] = new String[]{"北京","上海","广州"};
        final boolean bselect[] = new boolean[item.length];
        DialogInterface.OnClickListener mlist2 = new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                bselect[which]=true;
            }
        };
        builder = new AlertDialog.Builder(this);
        builder.setSingleChoiceItems(item,-1,mlist2);
        ad = builder.create();
        ad.setTitle("单选框");
        DialogInterface.OnClickListener list5 = new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str="你选择了：";
                for(int i=0;i<bselect.length;i++){
                    if(bselect[i]){
                        str= str+"\n"+item[i];
                    }
                }
                tv1.setText(str);
            }
        };
        ad.setButton(DialogInterface.BUTTON_POSITIVE,"确定",list5);
        ad.show();
    }
    public void dialog6(){
        final String item[] = new String[]{"北京","上海","广州"};
        final boolean bselect[] = new boolean[item.length];
        DialogInterface.OnClickListener mlist3 = new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str = "你选择了："+item[which];
                tv1.setText(str);
            }
        };
        builder = new AlertDialog.Builder(this);
        builder.setItems(item,mlist3);
        ad = builder.create();
        ad.setTitle("列表框");
        DialogInterface.OnClickListener list6 = new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                ad.dismiss();
            }
        };
        ad.setButton(DialogInterface.BUTTON_NEGATIVE,"取消",list6);
        ad.show();
    }
    public void dialog7(){
        LayoutInflater layInf = getLayoutInflater();
        View layout = layInf.inflate(R.layout.diydialog,null);
        final EditText Etext = (EditText) layout.findViewById(R.id.editText);
        ad = new AlertDialog.Builder(this).create();
        ad.setTitle("自定义布局");
        ad.setView(layout);
        DialogInterface.OnClickListener list7 = new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                tv1.setText("输入的是："+Etext.getText().toString());
            }
        };
        ad.setButton(DialogInterface.BUTTON_POSITIVE,"确定",list7);
        ad.setButton(DialogInterface.BUTTON_NEGATIVE,"取消",list7);
        ad.show();
    }
}