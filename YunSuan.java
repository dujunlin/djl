import java.util.Scanner;
public class YunSuan {
    private static Scanner scanner;
    public static void main(String[] args) {
        int x,Max,i,leixing,answer,DaAn=0;
        int rigthN=0,wrongN=0;
        String g = null;
        String d = null;
        System.out.println("请选择式子类型：1、整数，2、分数");
        scanner=new Scanner(System.in);
        leixing=scanner.nextInt();
        if(leixing==1){             //整数运算
            System.out.println("请输入题目的数量:");
            scanner=new Scanner(System.in);
            x=scanner.nextInt();
            int rightanswer[]=new int [x];
            int answers[]=new int [x];
            System.out.println("请输入算术数值的最大范围:");
            Max=scanner.nextInt();
            for(i=0;i<x;i++){
                char A,B;
                int a=(int)(Math.random()*Max);//随机生成一个整数
                int b=(int)(Math.random()*Max);//随机生成一个整数
                int C=(int)(Math.random()*Max);//随机生成一个整数
                int D=(int)(Math.random()*3);//随机生成一个0-3的整数，分别代表加、减、乘、除
                int c=(int)(Math.random()*3);//随机生成一个0-3的整数，分别代表加、减、乘、除
                if((c==0 ||c==1) && (D==0 || D==1)){
                    if(c==0 && D==0){
                        DaAn=a+b+C;
                    System.out.print(a+"+"+b+"+"+C+"=?");
                    }else if(c==0 && D==1){
                        DaAn=a+b-C;
                        System.out.print(a+"+"+b+"-"+C+"=?");
                    }else if(c==1 && D==0){
                        DaAn=a-b+C;
                        System.out.print(a+"-"+b+"+"+C+"=?");
                    }else if(c==1 && D==1){
                        DaAn=a-b-C;
                        System.out.print(a+"-"+b+"-"+C+"=?");
                    }

                }else if((c==0 ||c==1) && (D==2 || D==3)){
                    if(c==0 && D==2){
                        int E=b*C;
                        DaAn=a+E;
                        System.out.print(a+"+"+b+"*"+C+"=?");
                    }else if(c==0 && D==3){
                        int E=b/C;
                        DaAn=a+E;
                        System.out.print(a+"+"+b+"/"+C+"=?");
                    }else if(c==1 && D==2){
                        int E=b*C;
                        DaAn=a-E;
                        System.out.print(a+"-"+b+"*"+C+"=?");
                    }else if(c==1 && D==3){
                        int E=b/C;
                        DaAn=a-E;
                        System.out.print(a+"-"+b+"/"+C+"=?");
                    }
                }else if((c==2 ||c==3) && (D==0 || D==1)){
                    if(c==2 && D==0){
                        int E=a*b;
                        DaAn=E+C;
                        System.out.print(a+"*"+b+"+"+C+"=?");
                    }else if(c==3 && D==0){
                        int E=a/b;
                        DaAn=E+C;
                        System.out.print(a+"/"+b+"+"+C+"=?");
                    }else if(c==2 && D==1){
                        int E=a*b;
                        DaAn=E-C;
                        System.out.print(a+"*"+b+"-"+C+"=?");
                    }else if(c==3 && D==1){
                        int E=a/b;
                        DaAn=E-a;
                        System.out.print(a+"/"+b+"-"+C+"=?");
                    }
                }else if((c==2 ||c==3) && (D==2 || D==3)){
                    if(c==2 && D==2){
                        DaAn=a*b*C;
                        System.out.print(a+"*"+b+"*"+C+"=?");
                    }else if(c==2 && D==3){
                        DaAn=a*b/C;
                        System.out.print(a+"*"+b+"/"+C+"=?");
                    }else if(c==3 && D==2){
                        DaAn=a/b*C;
                        System.out.print(a+"/"+b+"*"+C+"=?");
                    }else if(c==3 && D==3){
                        DaAn=a/b/C;
                        System.out.print(a+"/"+b+"/"+C+"=?");
                    }
                }


                System.out.println("请输入你的答案：");
                answer=scanner.nextInt();
                if(answer==DaAn){
                    rigthN++;
                    System.out.println("恭喜你答对了！");
                }else{
                    System.out.println("很遗憾你答错了！正确答案为："+DaAn);
                }

            }
            System.out.print("\n");


            System.out.print("共答对"+rigthN+"题");
        }

        if(leixing==2){        //分数运算
            int M,Z;
            int x1,x2,B,m1,m2;
            System.out.println("请输入题目的数量: ");
            scanner=new Scanner(System.in);
            x=scanner.nextInt();
            String rigthanswer[]=new String [x];  //正确答案数组
            String youranswer[]=new String [x];   //做答答案数组
            System.out.println("请输入分母数值的最大范围: ");
            B=scanner.nextInt();
            for(i=0;i<x;i++){
                m1=1+(int)(Math.random()*B);//随机生成一个分母
                x1=1+(int)(Math.random()*m1);//生成一个比分母小的分子
                m2=1+(int)(Math.random()*B);//随机生成一个分母
                x2=1+(int)(Math.random()*m2);//生成一个比分母小的分子
                int c=(int)(Math.random()*3);//随机生成一个0-3的整数生成运算符
                if(c==0){  //加法
                    Z=x1*m2+x2*m1;
                    M=m1*m2;
                    d=simplification(Z,M);
                    System.out.print(x1+"/"+m1+"+"+x2+"/"+m2+"=");
                }
                if(c==1){   //减法
                    Z=x1*m2-x2*m1;
                    M=m1*m2;
                    d=simplification(Z,M);
                    System.out.print(x1+"/"+m1+"-"+x2+"/"+m2+"=");
                }
                if(c==2){   //乘法
                    Z=x1*x2;
                    M=m1*m2;
                    d=simplification(Z,M);
                    System.out.print(x1+"/"+m1+"*"+x2+"/"+m2+"=");
                }
                if(c==3){   //除法
                    Z=m1*x2;
                    M=m2*x1;
                    d=simplification(Z,M);
                    System.out.print(x1+"/"+m1+"/"+x2+"/"+m2+"=");
                }
                System.out.println("请输入你的答案：");
                g=scanner.next();
                if(g==d){
                    rigthN++;
                    System.out.println("恭喜你答对了！");
                }else{
                    System.out.println("很遗憾你答错了！正确答案为："+d);
                }


                youranswer[i]=g;//输进自己的答案装到数组中
                rigthanswer[i]=d;//将正确答案装到数组中
            }
            System.out.print("\n");

            System.out.print("共答对"+rigthN+"题");
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
}