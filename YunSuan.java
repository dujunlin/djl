
import java.awt.Container;
        import java.awt.Dimension;
        import java.awt.Font;
        import java.awt.GridLayout;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import java.awt.event.KeyAdapter;
        import java.awt.event.KeyEvent;
        import java.text.DecimalFormat;
        import java.text.ParseException;
        import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.JButton;
        import javax.swing.JFrame;
        import javax.swing.JLabel;
        import javax.swing.JOptionPane;
        import javax.swing.JPanel;
        import javax.swing.JTextField;

public class yunsuan {
    public static void main(String[] args) {
//登录，登录成功后运行答题系统
        login();
    }
    //定义全局的分数
    static int score=0;
    //定义全局的value结果0
    static float currValue;
    //定义全局运算式的字符串
    static String currString;
    //定义全局时间
    static int DaAn;
    static String currTime;
    //定义算术式子的类型
    static int ID;

    static int i;//题目的数量
    static int z=0;//已出的题数
    //定义全局答题数
    static int Right=0;//做对的题数
    static String d=null;//分数式子的答案
    static String T;//算术表达式
    static int currNums=0;
    /**1.在线答题界面**/
    public static void exercise(){
        Timu();
        JFrame f=new JFrame();
        f.setTitle("在线答题系统(保留一位小数)");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setVisible(true);

        //设置窗口的大小和位置
        f.setSize(600,500);
        f.setLocation(400,100);
        f.setLayout(null);
        JPanel pan1=new JPanel();
        JLabel name1=new JLabel("题目");
        pan1.add(name1);
        JTextField  nameTest7=new JTextField(15);
        nameTest7.setBounds(10, 10, 180, 100);
        nameTest7.setText(T);
        //	nameTest1.setPreferredSize(new Dimension(180,100));
        pan1.add(nameTest7);
        JLabel name2=new JLabel("请输入答案");
        pan1.add(name2);
        JTextField  nameTest1=new JTextField(15);
       // String Answer=nameTest1.getText();
        //int DaAn=Integer.parseInt(Answer);
        nameTest1.setBounds(10, 10, 180, 100);
        //	nameTest1.setPreferredSize(new Dimension(180,100));
        pan1.add(nameTest1);
        pan1.setBounds(10, 10, 200, 120);
        f.add(pan1);


        JPanel pan2=new JPanel();
        JLabel name7=new JLabel("正确答案为：");
        pan2.add(name7);
        JTextField nameTest2=new JTextField(15);

        nameTest2.setBounds(300, 10, 180, 100);
        //	nameTest2.setPreferredSize(new Dimension(180,100));
        pan2.add(nameTest2);
        pan2.setBounds( 300,10, 200, 120);
        f.add(pan2);

        JPanel pan3=new JPanel();
        pan3.setLayout(null);
        JTextField nameTest3=new JTextField(15);
        nameTest3.setBounds(10, 60, 480, 200);
        nameTest3.setPreferredSize(new Dimension(300,100));
        pan3.add(nameTest3);
        pan3.setBounds( 10,60, 500, 220);
        f.add(pan3);

        JPanel pan4 = new JPanel();
        JButton btnStart=new JButton("下一题");
        btnStart.setBounds(30, 300,30, 30);
        btnStart.setPreferredSize(new Dimension(100,80));
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int daan=0 ;
                String Answer=nameTest1.getText();
                if(Answer.equals("")){
                    nameTest3.setFont(new Font("宋体", Font.PLAIN, 20));
                    nameTest3.setText("     请先完成本题      ");
                }
                if(ID==2){
                    if(Answer.equals(d)){
                    nameTest2.setText(d);
                    Right++;
                    }else if(!Answer.equals(d) && !Answer.equals("")){
                       nameTest2.setText(d);
                   }
                }
                if(ID==1) {
                    daan = Integer.parseInt(Answer);
                    System.out.println(daan);
                    if (daan == DaAn) {
                        nameTest2.setText(String.valueOf(DaAn));
                        Right++;
                    } else {
                        nameTest2.setText(String.valueOf(DaAn));
                    }
                }
                int res=JOptionPane.showConfirmDialog(null,"是否结束本题","下一题",JOptionPane.YES_NO_OPTION);
                if(res==JOptionPane.YES_OPTION){
                    z++;
                    if(z<i) {
                        Timu();
                        nameTest7.setText(T);
                        nameTest1.setText("");
                        nameTest2.setText("");
                        pan1.add(nameTest7);
                        pan1.setBounds(10, 10, 200, 120);
                        f.add(pan1);
                    }else {
                        nameTest3.setFont(new Font("宋体", Font.PLAIN, 20));
                        nameTest3.setText("     已经是最后一题      ");
                    }
                } else {
                    nameTest3.setFont(new Font("宋体", Font.PLAIN, 20));
                    nameTest3.setText("     请继续做题      ");
                }

            }
        });
        pan4.add(btnStart);
        pan4.setBounds(40, 350, 110, 90);
        f.add(pan4);

        JPanel pan5 = new JPanel();
        JButton btnStart1=new JButton("提交");
        btnStart1.setBounds(30, 300,30, 30);
        btnStart1.setPreferredSize(new Dimension(100,80));
        btnStart1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int res=JOptionPane.showConfirmDialog(null,"是否提交","是否提交",JOptionPane.YES_NO_OPTION);
                if(res==JOptionPane.YES_OPTION){
                    nameTest3.setFont(new Font("宋体", Font.PLAIN, 20));
                    nameTest3.setText("     提交成功      ");
                }else {
                    nameTest3.setFont(new Font("宋体", Font.PLAIN, 20));
                    nameTest3.setText("     请继续做题      ");
                }
            }
        });
        pan5.add(btnStart1);
        pan5.setBounds(190, 350, 110, 90);
        f.add(pan5);


        JPanel pan6 = new JPanel();
//	pan4.setLayout(null);
        JButton btnStart2=new JButton("查看分数");
        btnStart2.setBounds(30, 300,30, 30);
        btnStart2.setPreferredSize(new Dimension(100,80));
        btnStart2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //计算用时

                    nameTest3.setFont(new Font("宋体", Font.PLAIN, 20));
                    nameTest3.setText(" 一共有"+i+"道题，共答对了："+Right+"题，得分为："+20*Right+"分");

            }
        });
        pan6.add(btnStart2);
        pan6.setBounds(340, 350, 110, 90);
        f.add(pan6);

    }
    /**2.生成四则运算**/
    public static void  Timu(){


            int Max=100;
           if(ID==1) {
               char A, B;
               int a = (int) (Math.random() * Max);//随机生成一个整数
               int b = (int) (Math.random() * Max);//随机生成一个整数
               int C = (int) (Math.random() * Max);//随机生成一个整数
               int D = (int) (Math.random() * 3);//随机生成一个0-3的整数，分别代表加、减、乘、除
               int c = (int) (Math.random() * 3);//随机生成一个0-3的整数，分别代表加、减、乘、除
               if ((c == 0 || c == 1) && (D == 0 || D == 1)) {
                   if (c == 0 && D == 0) {
                       DaAn = a + b + C;
                       T = a + "+" + b + "+" + C + "=?";
                   } else if (c == 0 && D == 1) {
                       DaAn = a + b - C;
                      T = a + "+" + b + "-" + C + "=?";
                   } else if (c == 1 && D == 0) {
                       DaAn = a - b + C;
                       T = a + "-" + b + "+" + C + "=?";
                   } else if (c == 1 && D == 1) {
                       DaAn = a - b - C;
                       T = a + "-" + b + "-" + C + "=?";
                   }

               } else if ((c == 0 || c == 1) && (D == 2 || D == 3)) {
                   if (c == 0 && D == 2) {
                       int E = b * C;
                       DaAn = a + E;
                       T = a + "+" + b + "*" + C + "=?";
                   } else if (c == 0 && D == 3) {
                       int E = b / C;
                       DaAn = a + E;
                       T= a + "+" + b + "/" + C + "=?";
                   } else if (c == 1 && D == 2) {
                       int E = b * C;
                       DaAn = a - E;
                       T = a + "-" + b + "*" + C + "=?";
                   } else if (c == 1 && D == 3) {
                       int E = b / C;
                       DaAn = a - E;
                       T = a + "-" + b + "/" + C + "=?";
                   }
               } else if ((c == 2 || c == 3) && (D == 0 || D == 1)) {
                   if (c == 2 && D == 0) {
                       int E = a * b;
                       DaAn = E + C;
                       T = a + "*" + b + "+" + C + "=?";
                   } else if (c == 3 && D == 0) {
                       int E = a / b;
                       DaAn = E + C;
                       T = a + "/" + b + "+" + C + "=?";
                   } else if (c == 2 && D == 1) {
                       int E = a * b;
                       DaAn = E - C;
                       T = a + "*" + b + "-" + C + "=?";
                   } else if (c == 3 && D == 1) {
                       int E = a / b;
                       DaAn = E - a;
                       T = a + "/" + b + "-" + C + "=?";
                   }
               } else if ((c == 2 || c == 3) && (D == 2 || D == 3)) {
                   if (c == 2 && D == 2) {
                       DaAn = a * b * C;
                       T = a + "*" + b + "*" + C + "=?";
                   } else if (c == 2 && D == 3) {
                       DaAn = a * b / C;
                       T = a + "*" + b + "/" + C + "=?";
                   } else if (c == 3 && D == 2) {
                       DaAn = a / b * C;
                       T = a + "/" + b + "*" + C + "=?";
                   } else if (c == 3 && D == 3) {
                       DaAn = a / b / C;
                       T = a + "/" + b + "/" + C + "=?";
                   }
               }


           }else if(ID==2){
               int M,Z;
               int x1,x2,B,m1,m2;

               String rigthanswer[]=new String [i];  //正确答案数组

                   m1=1+(int)(Math.random()*Max);//随机生成一个分母
                   x1=1+(int)(Math.random()*m1);//生成一个比分母小的分子
                   m2=1+(int)(Math.random()*Max);//随机生成一个分母
                   x2=1+(int)(Math.random()*m2);//生成一个比分母小的分子
                   int c=(int)(Math.random()*3);//随机生成一个0-3的整数生成运算符
                   if(c==0){  //加法
                       Z=x1*m2+x2*m1;
                       M=m1*m2;
                       d=simplification(Z,M);
                      T=x1+"/"+m1+"+"+x2+"/"+m2+"=?";
                   }
                   if(c==1){   //减法
                       Z=x1*m2-x2*m1;
                       M=m1*m2;
                       d=simplification(Z,M);
                       T=x1+"/"+m1+"-"+x2+"/"+m2+"=?";
                   }
                   if(c==2){   //乘法
                       Z=x1*x2;
                       M=m1*m2;
                       d=simplification(Z,M);
                       T=x1+"/"+m1+"*"+x2+"/"+m2+"=?";
                   }
                   if(c==3){   //除法
                       Z=m1*x2;
                       M=m2*x1;
                       d=simplification(Z,M);
                       T=x1+"/"+m1+"/"+x2+"/"+m2+"=?";
                   }


           }

    }
    public static String simplification(int a,int b){//把分数结果化简
        int y = 1;
        for(int i=a;i>=1;i--){
            if(a%i==0&&b%i==0){
                y = i;    //求得最小公约数
                break;
            }
        }
        int z = a/y;
        int m = b/y;
        if(z==0) {
            return "0";
        }
        if(z==m){//分子分母相同情况直接输出整数
            return ""+z;
        }
        return ""+z+"/"+m;//若分子分母不同，则输出分数形式
    }


    /**2.登录跳转方法**/
    public static  void login(){
        JFrame f=new JFrame();
        f.setTitle("系统界面");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setVisible(true);

        //设置窗口的大小和位置
        f.setSize(400,400);
        f.setLocation(420,120);

        Container con=f.getContentPane();//生成一个容器
        con.setLayout(new GridLayout(7,1));
        //生成一个新的版面
        JPanel pan1=new JPanel();
        JLabel title=new JLabel("欢迎使用四则运算系统");
        title.setFont(new Font("宋体",Font.BOLD, 20));
        pan1.add(title);
        con.add(pan1);

        JPanel pan2=new JPanel();
        JLabel name=new JLabel("请输入题目的数量（不超过5题）：");
        pan2.add(name);
        JTextField nameTest=new JTextField(12);


        //System.out.println(i);
        pan2.add(nameTest);
        con.add(pan2);

        JPanel pan3=new JPanel();
        JLabel max=new JLabel("请填写算式类型的序号（1.整数 2.分数）：");
        pan3.add(max);
        JTextField nameTest2=new JTextField(10);
        //String zuida=nameTest.getText();
        //Max= Integer.parseInt(zuida);
        //System.out.println(i);
        pan3.add(nameTest2);
        con.add(pan3);

        JPanel pan4 = new JPanel();
        JButton b_log=new JButton("开始");
        b_log.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                i=0;
                ID=0;
                String shu=nameTest.getText();
                i=Integer.parseInt(shu);
                String id=nameTest2.getText();
                ID=Integer.parseInt(id);
                System.out.println(ID);

                exercise();
            }
        });
        pan4.add(b_log);
        con.add(pan4);



    }
}

