package com.czy.admin.czyproject.Genericity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.czy.admin.czyproject.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenericityActivity extends Activity {
    private Button btn_generictiy_class;
    private TextView result_tv;
    private Button btn_generictiy_symbol;
    private Button btn_generictiy_method_arg;

    private StringBuilder stringBuilder = new StringBuilder();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genericity);
        btn_generictiy_class=(Button)findViewById(R.id.btn_generictiy_class);
        result_tv=(TextView)findViewById(R.id.result_tv);
        btn_generictiy_symbol=(Button)findViewById(R.id.btn_generictiy_symbol);
        btn_generictiy_method_arg=(Button)findViewById(R.id.btn_generictiy_method_arg);

        //泛型通配符
        btn_generictiy_symbol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Generic<Integer> gInteger = new Generic<Integer>(123);
                Generic<Number> gNumber = new Generic<Number>(456);

                showKeyValue(gNumber);
            }
        });


        //泛型类
        btn_generictiy_class.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //泛型的类型参数只能是类类型（包括自定义类），不能是简单类型
                //传入的实参类型需与泛型的类型参数类型相同，即为Integer.
                Generic<Integer> integerGeneric =new Generic<Integer>(12345);
                stringBuilder.append(integerGeneric.getKey()+"\n");

                //传入的实参类型需与泛型的类型参数类型相同，即为String.
                Generic<String> genericString = new Generic<String>("key_vlaue");
                stringBuilder.append(genericString.getKey()+"\n");

                /**
                 * 定义的泛型类，就一定要传入泛型类型实参么？并不是这样，在使用泛型的时候如果传入泛型实参，
                 * 则会根据传入的泛型实参做相应的限制，此时泛型才会起到本应起到的限制作用。
                 * 如果不传入泛型类型实参的话，在泛型类中使用泛型的方法或成员变量定义的类型可以为任何的类型。
                 */
                Generic generic = new Generic("111111");
                Generic generic1 = new Generic(4444);
                Generic generic2 = new Generic(55.55);
                Generic generic3 = new Generic(false);

                stringBuilder.append(generic.getKey()+"\n");
                stringBuilder.append(generic1.getKey()+"\n");
                stringBuilder.append(generic2.getKey()+"\n");
                stringBuilder.append(generic3.getKey()+"\n");

                result_tv.setText(stringBuilder.toString());
            }
        });

        //泛型方法
        btn_generictiy_method_arg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printMsg("111",222,"aaaa","2323.4",55.55);
                result_tv.setText(stringBuilder.toString());
            }
        });
    }

    /**
     * 1.
     * 特性
     * 泛型只在编译阶段有效。
     */
    private void one(){
        List<String> stringArrayList = new ArrayList<String>();
        List<Integer> integerArrayList = new ArrayList<Integer>();

        Class classStringArrayList = stringArrayList.getClass();
        Class classIntegerArrayList = integerArrayList.getClass();

        if(classStringArrayList.equals(classIntegerArrayList)){
            Log.d("泛型测试","类型相同");
        }
    }

    /**
     * 2.泛型类
     * 此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型
     * 在实例化泛型类时，必须指定T的具体类型
     * @param <T>
     */
    class Generic<T>{
        private T key;//key这个成员变量的类型为T,T的类型由外部指定

        public Generic(T key){//泛型构造方法形参key的类型也为T，T的类型由外部指定
            this.key=key;
        }

        public T getKey(){//泛型方法getKey的返回值类型为T，T的类型由外部指定

            return key;
        }
    }

    /**
     * 3
     * 泛型接口
     * 泛型接口与泛型类的定义及使用基本相同。泛型接口常被用在各种类的生产器中
     * @param <T>
     */
    public interface Generator<T>{
        public T next();
    }

    /**
     * 3.1
     * 未传入泛型实参时，与泛型类的定义相同，在声明类的时候，需将泛型的声明也一起加到类中
     * 即：class FruitGenerator<T> implements Generator<T>{
     * 如果不声明泛型，如：class FruitGenerator implements Generator<T>，编译器会报错："Unknown class"
     */
//    class FruitGenerator<T> implements Generator<T>{
//        @Override
//        public T next() {
//            return null;
//        }
//    }

    /**
     * 3.2
     * 传入泛型实参时：
     * 定义一个生产器实现这个接口,虽然我们只创建了一个泛型接口Generator<T>
     * 但是我们可以为T传入无数个实参，形成无数种类型的Generator接口。
     * 在实现类实现泛型接口时，如已将泛型类型传入实参类型，则所有使用泛型的地方都要替换成传入的实参类型
     * 即：Generator<T>，public T next();中的的T都要替换成传入的String类型。
     */
    class FruitGenerator implements Generator<String>{
        private String[] fruits = new String[]{"Apple", "Banana", "Pear"};
        @Override
        public String next() {
            Random rand = new Random();
            return fruits[rand.nextInt(3)];
        }
    }


    /**
     * 4
     * 泛型通配符
     * 回到上面的例子，如何解决上面的问题？总不能为了定义一个新的方法来处理Generic<Integer>类型的类，这显然与java中的多态理念相违背。
     * 因此我们需要一个在逻辑上可以表示同时是Generic<Integer>和Generic<Number>父类的引用类型。由此类型通配符应运而生。
     * 类型通配符一般是使用？代替具体的类型实参，注意了，此处’？’是类型实参，而不是类型形参 。重要说三遍！此处’？’是类型实参，而不是类型形参 ！ 此处’？’是类型实参，而不是类型形参 ！再直白点的意思就是，此处的？和Number、String、Integer一样都是一种实际的类型，
     * 可以把？看成所有类型的父类。是一种真实的类型。
     * @param obj
     */
    public void showKeyValue(Generic<?> obj){
        Log.d("泛型测试","key value is " + obj.getKey());
    }


    /**
     * 5.
     * 泛型方法的基本介绍
     * @param tClass 传入的泛型实参
     * @return T 返回值为T类型
     * 说明：
     *     1）public 与 返回值中间<T>非常重要，可以理解为声明此方法为泛型方法。
     *     2）只有声明了<T>的方法才是泛型方法，泛型类中的使用了泛型的成员方法并不是泛型方法。
     *     3）<T>表明该方法将使用泛型类型T，此时才可以在方法中使用泛型类型T。
     *     4）与泛型类的定义一样，此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型。
     */
    public <T> T genericMethod(Class<T> tClass)throws InstantiationException ,
            IllegalAccessException{
        T instance = tClass.newInstance();
        return instance;
    }

    /**
     * 5.1
     */
   class GenericTest {
        //这个类是个泛型类，在上面已经介绍过
        public class Generic<T>{
            private T key;

            public Generic(T key) {
                this.key = key;
            }

            //我想说的其实是这个，虽然在方法中使用了泛型，但是这并不是一个泛型方法。
            //这只是类中一个普通的成员方法，只不过他的返回值是在声明泛型类已经声明过的泛型。
            //所以在这个方法中才可以继续使用 T 这个泛型。
            public T getKey(){
                return key;
            }

            /**
             * 这个方法显然是有问题的，在编译器会给我们提示这样的错误信息"cannot reslove symbol E"
             * 因为在类的声明中并未声明泛型E，所以在使用E做形参和返回值类型时，编译器会无法识别。
             public E setKey(E key){
             this.key = keu
             }
             */
        }

        /**
         * 这才是一个真正的泛型方法。
         * 首先在public与返回值之间的<T>必不可少，这表明这是一个泛型方法，并且声明了一个泛型T
         * 这个T可以出现在这个泛型方法的任意位置.
         * 泛型的数量也可以为任意多个
         *    如：public <T,K> K showKeyName(Generic<T> container){
         *        ...
         *        }
         */
        public <T> T showKeyName(Generic<T> container){
            System.out.println("container key :" + container.getKey());
            //当然这个例子举的不太合适，只是为了说明泛型方法的特性。
            T test = container.getKey();
            return test;
        }

        //这也不是一个泛型方法，这就是一个普通的方法，只是使用了Generic<Number>这个泛型类做形参而已。
        public void showKeyValue1(Generic<Number> obj){
            Log.d("泛型测试","key value is " + obj.getKey());
        }

        //这也不是一个泛型方法，这也是一个普通的方法，只不过使用了泛型通配符?
        //同时这也印证了泛型通配符章节所描述的，?是一种类型实参，可以看做为Number等所有类的父类
        public void showKeyValue2(Generic<?> obj){
            Log.d("泛型测试","key value is " + obj.getKey());
        }

        /**
         * 这个方法是有问题的，编译器会为我们提示错误信息："UnKnown class 'E' "
         * 虽然我们声明了<T>,也表明了这是一个可以处理泛型的类型的泛型方法。
         * 但是只声明了泛型类型T，并未声明泛型类型E，因此编译器并不知道该如何处理E这个类型。
         public <T> T showKeyName(Generic<E> container){
         ...
         }
         */

        /**
         * 这个方法也是有问题的，编译器会为我们提示错误信息："UnKnown class 'T' "
         * 对于编译器来说T这个类型并未项目中声明过，因此编译也不知道该如何编译这个类。
         * 所以这也不是一个正确的泛型方法声明。
         public void showkey(T genericObj){

         }
         */
    }

    /**
     * 5.2
     * 泛型方法与可变参数
     * @param args
     * @param <T>
     */
    public <T> void printMsg( T... args){
        for(T t : args){
            Log.d("泛型测试","t is " + t);
            stringBuilder.append("泛型测试 t is " + t+"\n");
        }
    }
}
