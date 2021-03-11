import java.awt.*;
import java.awt.event.*;

import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Vector;
import javax.swing.*;
import javax.swing.Timer;
import javax.swing.event.ChangeListener;

import java.util.Random;


public class GameUtils {
    int NumberImage1;
    int NumberImage2;
    int NumberImage3;
    int NumberImage4;
    int NumberImage5;
    int NumberImage6;
    int NumberImage7;
    int NumberImage8;
    int NumberImage9;


    public void CreateLists(int step, Vector<Imagine> lista1, Vector<Imagine> lista2, Vector<Imagine> lista3, Vector<String> paths) {
        Random rand = new Random();


        if(step==0)
        {
            lista1.clear();
            for (int index = 400; index >= -3000; index = index - 200) {
                int rand_int = rand.nextInt(6);
                Imagine x = new Imagine(0, index, rand_int, paths.get(rand_int));
                lista1.add(x);
                if(index==-2600)
                {
                    NumberImage1=rand_int;
                }
                if(index==-2800)
                {
                    NumberImage2=rand_int;
                }
                if(index==-3000)
                {
                    NumberImage3=rand_int;
                }
            }
            //lista1.get(0) va fi pe linia 3 coloana 1 get(1) linia 2 coloana 1 get(0) linia 1 coloana 1
            Random rand1 = new Random();

            lista2.clear();
            for (int index = 400; index >= -3000; index = index - 200) {
                int rand_int = rand1.nextInt(6);
                Imagine x = new Imagine(300, index, rand_int, paths.get(rand_int));
                lista2.add(x);
                if(index==-2600)
                {
                    NumberImage4=rand_int;
                }
                if(index==-2800)
                {
                    NumberImage5=rand_int;
                }
                if(index==-3000)
                {
                    NumberImage6=rand_int;
                }
            }


            Random rand2 = new Random();

            lista3.clear();
            for (int index = 400; index >= -3000; index = index - 200) {
                int rand_int = rand2.nextInt(6);
                Imagine x = new Imagine(600, index, rand_int, paths.get(rand_int));
                lista3.add(x);
                if(index==-2600)
                {
                    NumberImage7=rand_int;
                }
                if(index==-2800)
                {
                    NumberImage8=rand_int;
                }
                if(index==-3000)
                {
                    NumberImage9=rand_int;
                }
            }
        }
        else
        {

            lista1.clear();
            Imagine imagine=new Imagine(0,400,NumberImage1,paths.get(NumberImage1));
            lista1.add(imagine);
            Imagine imagine1=new Imagine(0,200,NumberImage2,paths.get(NumberImage2));
            lista1.add(imagine1);
            Imagine imagine2=new Imagine(0,0,NumberImage3,paths.get(NumberImage3));
            lista1.add(imagine2);
            for (int index = -200; index >= -3000; index = index - 200) {
                int rand_int = rand.nextInt(6);
                Imagine x = new Imagine(0, index, rand_int, paths.get(rand_int));

                lista1.add(x);


                if(index==-2600)
                {
                    NumberImage1=rand_int;

                }
                if(index==-2800)
                {
                    NumberImage2=rand_int;

                }
                if(index==-3000)
                {
                    NumberImage3=rand_int;

                }

            }







            Random rand1 = new Random();

            lista2.clear();
            Imagine imagine3=new Imagine(300,400,NumberImage4,paths.get(NumberImage4));
            lista2.add(imagine3);
            Imagine imagine4=new Imagine(300,200,NumberImage5,paths.get(NumberImage5));
            lista2.add(imagine4);
            Imagine imagine5=new Imagine(300,0,NumberImage6,paths.get(NumberImage6));
            lista2.add(imagine5);

            for (int index = -200; index >= -3000; index = index - 200) {
                int rand_int = rand1.nextInt(6);
                Imagine x = new Imagine(300, index, rand_int, paths.get(rand_int));
                lista2.add(x);

                if(index==-2600)
                {
                    NumberImage4=rand_int;

                }
                if(index==-2800)
                {
                    NumberImage5=rand_int;

                }
                if(index==-3000)
                {
                    NumberImage6=rand_int;

                }
            }


            Random rand2 = new Random();

            lista3.clear();

            Imagine imagine6=new Imagine(600,400,NumberImage7,paths.get(NumberImage7));
            lista3.add(imagine6);
            Imagine imagine7=new Imagine(600,200,NumberImage8,paths.get(NumberImage8));
            lista3.add(imagine7);
            Imagine imagine8=new Imagine(600,0,NumberImage9,paths.get(NumberImage9));
            lista3.add(imagine8);

            for (int index = -200; index >= -3000; index = index - 200) {
                int rand_int = rand2.nextInt(6);
                Imagine x = new Imagine(600, index, rand_int, paths.get(rand_int));
                lista3.add(x);

                if(index==-2600)
                {
                    NumberImage7=rand_int;

                }
                if(index==-2800)
                {
                    NumberImage8=rand_int;

                }
                if(index==-3000)
                {
                    NumberImage9=rand_int;

                }
            }
        }


    }

    public static Vector<String> Init_paths(){

        Path path1= Paths.get("pictures\\7.png");
        Path path2=Paths.get("pictures\\blackHeart.png");
        Path path3=Paths.get("pictures\\book.png");
        Path path4=Paths.get("pictures\\crown.png");
        Path path5=Paths.get("pictures\\diamond.png");
        Path path6=Paths.get("pictures\\starBonus.png");
        String p1=path1.toAbsolutePath().toString();
        String p2=path2.toAbsolutePath().toString();
        String p3=path3.toAbsolutePath().toString();
        String p4=path4.toAbsolutePath().toString();
        String p5=path5.toAbsolutePath().toString();
        String p6=path6.toAbsolutePath().toString();

        Vector<String> pths=new Vector<>();

        pths.add(p1.replace("\\", "\\\\"));
        pths.add(p2.replace("\\", "\\\\"));
        pths.add(p3.replace("\\", "\\\\"));
        pths.add(p4.replace("\\", "\\\\"));
        pths.add(p5.replace("\\", "\\\\"));
        pths.add(p6.replace("\\", "\\\\"));

        return pths;
    }





}
