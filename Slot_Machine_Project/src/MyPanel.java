import java.awt.*;
import java.awt.event.*;

import java.io.IOException;
import java.net.URI;
import java.nio.file.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.Timer;
import javax.swing.event.ChangeListener;

import java.util.Random;



public class MyPanel extends JPanel implements Runnable{


    Vector<String> paths;
    Vector<String> pths;
    Vector<Imagine> lista1;
    Vector<Imagine> lista2;
    Vector<Imagine> lista3;
    int balance;
    boolean isMoney;
    int bet;
    boolean win_7;
    int win_prize;
    boolean win_heart;
    boolean win_book;
    boolean win_crown;
    boolean win_diamond;
    boolean win_star;
    boolean isSpinning;
    boolean line1;
    boolean line2;
    boolean line3;
    boolean diagonal1;
    boolean diagonal2;
    boolean won;
    int step;


    Thread t;
    GameUtils utils;

    MyPanel() {

        utils=new GameUtils();
        paths = new Vector<String>();
        lista1 = new Vector<Imagine>();
        lista2 = new Vector<Imagine>();
        lista3 = new Vector<Imagine>();
        pths=new Vector<>();
        balance = 10000;
        win_7=false;
        won=false;
        isMoney=true;
        win_book=false;
        win_crown=false;
        win_heart=false;
        win_diamond=false;
        win_star=false;
        win_prize=0;
        isSpinning=false;
        step=0;
        line1=false;
        line2=false;
        line3=false;
        diagonal1=false;
        diagonal2=false;
        t=new Thread(this);

        //Vector<String> pth = new Vector<>();
        pths= GameUtils.Init_paths();
        InitPaths();

        t.start();


    }


    public void paintComponent(Graphics g) {


        if(!isMoney)
        {
            super.paintComponent(g);
            for (Imagine x : lista1) {
                x.drawImagine(g, x.getCoordX(), x.getCoordY());
            }
            for (Imagine x : lista2) {
                x.drawImagine(g, x.getCoordX(), x.getCoordY());
            }
            for (Imagine x : lista3) {
                x.drawImagine(g, x.getCoordX(), x.getCoordY());
            }

            g.setColor(Color.orange);
            g.fillRect(300, 0, 7, 605);


            g.fillRect(600, 0, 7, 605);


            g.fillRect(0, 200, 1000, 7);

            g.fillRect(0, 400, 1000, 7);

            g.setColor(Color.darkGray);
            g.fillRect(0, 600, 1000, 120);

            g.setColor(Color.blue);
            g.fillRect(0, 600, 1000, 5);
            g.setColor(Color.lightGray);
            g.setFont(new Font("TimesRoman", Font.BOLD, 40));
            g.drawString("BALANCE", 30, 640);


            g.setColor(Color.lightGray);
            g.setFont(new Font("TimesRoman", Font.BOLD, 40));
            g.drawString("BET", 700, 640);

            g.setColor(Color.blue);
            g.fillRect(0, 705, 1000, 20);

            if(balance>=25 && balance-bet<0)
            {
                g.setColor(Color.lightGray);
                g.fillRect(280, 380, 400, 70);
                g.setColor(Color.black);
                g.setFont(new Font("TimesRoman", Font.BOLD, 25));
                g.drawString("Please change to a smaller bet.", 280, 430);


                g.setColor(Color.lightGray);
                g.setFont(new Font("TimesRoman", Font.BOLD, 40));
                g.drawString(String.valueOf(balance), 60, 690);
                isMoney=true;
            }
            else
            {
                g.setColor(Color.RED);
                g.setFont(new Font("TimesRoman", Font.BOLD, 20));
                g.drawString("Please insert credits.", 60, 690);
            }

        }


        else if(isSpinning && step==0)
        {
            super.paintComponent(g);
            for (Imagine x : lista1) {
                x.drawImagine(g, x.getCoordX(), x.getCoordY());
            }
            for (Imagine x : lista2) {
                x.drawImagine(g, x.getCoordX(), x.getCoordY());
            }
            for (Imagine x : lista3) {
                x.drawImagine(g, x.getCoordX(), x.getCoordY());
            }

            g.setColor(Color.orange);
            g.fillRect(300, 0, 7, 605);


            g.fillRect(600, 0, 7, 605);


            g.fillRect(0, 200, 1000, 7);

            g.fillRect(0, 400, 1000, 7);

            g.setColor(Color.darkGray);
            g.fillRect(0, 600, 1000, 120);

            g.setColor(Color.blue);
            g.fillRect(0, 600, 1000, 5);
            g.setColor(Color.lightGray);
            g.setFont(new Font("TimesRoman", Font.BOLD, 40));
            g.drawString("BALANCE", 30, 640);


            g.setColor(Color.lightGray);
            g.setFont(new Font("TimesRoman", Font.BOLD, 40));
            g.drawString("BET", 700, 640);

            g.setColor(Color.blue);
            g.fillRect(0, 705, 1000, 20);

            if(balance>=0)
            {
                g.setColor(Color.lightGray);
                g.drawString(String.valueOf(balance), 60, 690);
            }
            else
            {
                g.setColor(Color.RED);
                g.setFont(new Font("TimesRoman", Font.BOLD, 20));
                g.drawString("Please insert credits.", 60, 690);
            }



            g.setColor(Color.BLUE);
            g.fillRect(70, 230, 800, 100);

            g.setColor(Color.MAGENTA);
            g.setFont(new Font("TimesRoman", Font.BOLD, 80));
            g.drawString("SESSION STARTED", 80, 300);




        }

        else if(isSpinning && step>0)
        {
            super.paintComponent(g);
            for (Imagine x : lista1) {
                x.drawImagine(g, x.getCoordX(), x.getCoordY());
            }
            for (Imagine x : lista2) {
                x.drawImagine(g, x.getCoordX(), x.getCoordY());
            }
            for (Imagine x : lista3) {
                x.drawImagine(g, x.getCoordX(), x.getCoordY());
            }

            g.setColor(Color.orange);
            g.fillRect(300, 0, 7, 605);


            g.fillRect(600, 0, 7, 605);


            g.fillRect(0, 200, 1000, 7);

            g.fillRect(0, 400, 1000, 7);

            g.setColor(Color.darkGray);
            g.fillRect(0, 600, 1000, 120);

            g.setColor(Color.blue);
            g.fillRect(0, 600, 1000, 5);
            g.setColor(Color.lightGray);
            g.setFont(new Font("TimesRoman", Font.BOLD, 40));
            g.drawString("BALANCE", 30, 640);


            g.setColor(Color.lightGray);
            g.setFont(new Font("TimesRoman", Font.BOLD, 40));
            g.drawString("BET", 700, 640);

            g.setColor(Color.blue);
            g.fillRect(0, 705, 1000, 20);

            if(balance>=0)
            {
                g.setColor(Color.lightGray);
                g.drawString(String.valueOf(balance), 60, 690);
            }
            else
            {
                g.setColor(Color.RED);
                g.setFont(new Font("TimesRoman", Font.BOLD, 20));
                g.drawString("Please insert credits.", 60, 690);
            }
        }

        else
        {
            if(step>0 && line1 && !line2 && !line3 && !diagonal1 && !diagonal2)
            {
                super.paintComponent(g);
                for (Imagine x : lista1) {
                    x.drawImagine(g, x.getCoordX(), x.getCoordY());
                }
                for (Imagine x : lista2) {
                    x.drawImagine(g, x.getCoordX(), x.getCoordY());
                }
                for (Imagine x : lista3) {
                    x.drawImagine(g, x.getCoordX(), x.getCoordY());
                }

                g.setColor(Color.orange);
                g.fillRect(300, 0, 7, 605);


                g.fillRect(600, 0, 7, 605);


                g.fillRect(0, 200, 1000, 7);

                g.fillRect(0, 400, 1000, 7);

                g.setColor(Color.darkGray);
                g.fillRect(0, 600, 1000, 120);

                g.setColor(Color.blue);
                g.fillRect(0, 600, 1000, 5);
                g.setColor(Color.lightGray);
                g.setFont(new Font("TimesRoman", Font.BOLD, 40));
                g.drawString("BALANCE", 30, 640);


                g.setColor(Color.lightGray);
                g.setFont(new Font("TimesRoman", Font.BOLD, 40));
                g.drawString("BET", 700, 640);

                g.setColor(Color.blue);
                g.fillRect(0, 705, 1000, 20);

                if(balance>=0)
                {
                    g.setColor(Color.lightGray);
                    g.drawString(String.valueOf(balance), 60, 690);
                }
                else
                {
                    g.setColor(Color.RED);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 20));
                    g.drawString("Please insert credits.", 60, 690);
                }

                g.setColor(Color.RED);
                g.fillRect(0, 0, 1000, 7);
                g.fillRect(0, 0, 7, 200);
                g.fillRect(0, 200, 1000, 7);
                g.fillRect(895, 0, 7, 200);
                g.fillRect(300, 0, 7, 200);
                g.fillRect(600, 0, 7, 200);

                line1=false;



                if(win_7) {
                    g.setColor(Color.darkGray);
                    g.fillRect(280, 380, 300, 70);
                    g.setColor(Color.RED);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 30));
                    g.drawString(" BIG WIN!!!   777", 280, 430);

                    g.setColor(Color.lightGray);
                    g.fillRect(200, 580, 150, 40);
                    g.setColor(Color.green);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 25));
                    g.drawString(String.valueOf(win_prize), 240, 610);


                    g.setColor(Color.green);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 25));
                    g.drawString("+", 220, 610);

                    win_7=false;
                }

                else if(win_heart)
                {
                    g.setColor(Color.darkGray);
                    g.fillRect(280, 380, 450, 70);
                    g.setColor(Color.RED);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 30));
                    g.drawString(" BIG WIN! BLACK HEARTED", 280, 430);
                    win_heart=false;
                    g.setColor(Color.lightGray);
                    g.fillRect(200, 580, 150, 40);
                    g.setColor(Color.green);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 25));
                    g.drawString(String.valueOf(win_prize), 240, 610);
                    g.setColor(Color.green);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 25));
                    g.drawString("+", 220, 610);
                }

                else if(win_diamond)
                {
                    g.setColor(Color.darkGray);
                    g.fillRect(280, 380, 500, 70);
                    g.setColor(Color.RED);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 30));
                    g.drawString(" WIN!!! Shining diamonds...", 280, 430);
                    win_diamond=false;
                    g.setColor(Color.lightGray);
                    g.fillRect(200, 580, 150, 40);
                    g.setColor(Color.green);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 25));
                    g.drawString(String.valueOf(win_prize), 240, 610);
                    g.setColor(Color.green);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 25));
                    g.drawString("+", 220, 610);
                }

                else if(win_book)
                {
                    g.setColor(Color.darkGray);
                    g.fillRect(280, 380, 450, 70);
                    g.setColor(Color.RED);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 30));
                    g.drawString(" WIN!!! Hittin' books!", 280, 430);
                    win_book=false;
                    g.setColor(Color.lightGray);
                    g.fillRect(200, 580, 150, 40);
                    g.setColor(Color.green);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 25));
                    g.drawString(String.valueOf(win_prize), 240, 610);
                    g.setColor(Color.green);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 25));
                    g.drawString("+", 220, 610);
                }
                else if(win_star)
                {
                    g.setColor(Color.darkGray);
                    g.fillRect(280, 380, 430, 70);
                    g.setColor(Color.RED);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 30));
                    g.drawString(" WIN!!! Follow the stars!", 280, 430);
                    win_star=false;
                    g.setColor(Color.lightGray);
                    g.fillRect(200, 580, 150, 40);
                    g.setColor(Color.green);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 25));
                    g.drawString(String.valueOf(win_prize), 240, 610);
                    g.setColor(Color.green);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 25));
                    g.drawString("+", 220, 610);
                }

                else if(win_crown)
                {
                    g.setColor(Color.darkGray);
                    g.fillRect(280, 380, 500, 70);
                    g.setColor(Color.RED);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 30));
                    g.drawString(" BIG WIN! The crown, king!", 280, 430);
                    win_crown=false;
                    g.setColor(Color.lightGray);
                    g.fillRect(200, 580, 150, 40);
                    g.setColor(Color.green);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 25));
                    g.drawString(String.valueOf(win_prize), 240, 610);
                    g.setColor(Color.green);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 25));
                    g.drawString("+", 220, 610);
                }





            }

            else if(step>0 && line2 && !line1 && !line3 && !diagonal1 && !diagonal2)
            {
                super.paintComponent(g);
                for (Imagine x : lista1) {
                    x.drawImagine(g, x.getCoordX(), x.getCoordY());
                }
                for (Imagine x : lista2) {
                    x.drawImagine(g, x.getCoordX(), x.getCoordY());
                }
                for (Imagine x : lista3) {
                    x.drawImagine(g, x.getCoordX(), x.getCoordY());
                }

                g.setColor(Color.orange);
                g.fillRect(300, 0, 7, 605);


                g.fillRect(600, 0, 7, 605);


                g.fillRect(0, 200, 1000, 7);

                g.fillRect(0, 400, 1000, 7);

                g.setColor(Color.darkGray);
                g.fillRect(0, 600, 1000, 120);

                g.setColor(Color.blue);
                g.fillRect(0, 600, 1000, 5);
                g.setColor(Color.lightGray);
                g.setFont(new Font("TimesRoman", Font.BOLD, 40));
                g.drawString("BALANCE", 30, 640);


                g.setColor(Color.lightGray);
                g.setFont(new Font("TimesRoman", Font.BOLD, 40));
                g.drawString("BET", 700, 640);

                g.setColor(Color.blue);
                g.fillRect(0, 705, 1000, 20);

                if(balance>=0)
                {
                    g.setColor(Color.lightGray);
                    g.drawString(String.valueOf(balance), 60, 690);
                }
                else
                {
                    g.setColor(Color.RED);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 20));
                    g.drawString("Please insert credits.", 60, 690);
                }

                g.setColor(Color.RED);
                g.fillRect(0,200,1000,7);
                g.fillRect(0,200,7,200);
                g.fillRect(0,400,1000,7);
                g.fillRect(895,200,7,200);
                g.fillRect(300,200,7,200);
                g.fillRect(600,200,7,200);
                line2=false;



                if(win_7) {
                    g.setColor(Color.darkGray);
                    g.fillRect(280, 380, 300, 70);
                    g.setColor(Color.RED);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 30));
                    g.drawString(" BIG WIN!!!   777", 280, 430);

                    g.setColor(Color.lightGray);
                    g.fillRect(200, 580, 150, 40);
                    g.setColor(Color.green);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 25));
                    g.drawString(String.valueOf(win_prize), 240, 610);
                    System.out.print(win_prize);
                    System.out.print("  step= ");
                    System.out.print(step);
                    System.out.print("\n");

                    g.setColor(Color.green);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 25));
                    g.drawString("+", 220, 610);
                    System.out.println("PAINTED 7");
                    win_7=false;
                }

                else if(win_heart)
                {
                    g.setColor(Color.darkGray);
                    g.fillRect(280, 380, 450, 70);
                    g.setColor(Color.RED);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 30));
                    g.drawString(" BIG WIN! BLACK HEARTED", 280, 430);
                    win_heart=false;
                    g.setColor(Color.lightGray);
                    g.fillRect(200, 580, 150, 40);
                    g.setColor(Color.green);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 25));
                    g.drawString(String.valueOf(win_prize), 240, 610);
                    g.setColor(Color.green);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 25));
                    g.drawString("+", 220, 610);
                }

                else if(win_diamond)
                {
                    g.setColor(Color.darkGray);
                    g.fillRect(280, 380, 500, 70);
                    g.setColor(Color.RED);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 30));
                    g.drawString(" WIN!!! Shining diamonds...", 280, 430);
                    win_diamond=false;
                    g.setColor(Color.lightGray);
                    g.fillRect(200, 580, 150, 40);
                    g.setColor(Color.green);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 25));
                    g.drawString(String.valueOf(win_prize), 240, 610);
                    g.setColor(Color.green);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 25));
                    g.drawString("+", 220, 610);
                }

                else if(win_book)
                {
                    g.setColor(Color.darkGray);
                    g.fillRect(280, 380, 450, 70);
                    g.setColor(Color.RED);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 30));
                    g.drawString(" WIN!!! Hittin' books!", 280, 430);
                    win_book=false;
                    g.setColor(Color.lightGray);
                    g.fillRect(200, 580, 150, 40);
                    g.setColor(Color.green);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 25));
                    g.drawString(String.valueOf(win_prize), 240, 610);
                    g.setColor(Color.green);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 25));
                    g.drawString("+", 220, 610);
                }
                else if(win_star)
                {
                    g.setColor(Color.darkGray);
                    g.fillRect(280, 380, 430, 70);
                    g.setColor(Color.RED);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 30));
                    g.drawString(" WIN!!! Follow the stars!", 280, 430);
                    win_star=false;
                    g.setColor(Color.lightGray);
                    g.fillRect(200, 580, 150, 40);
                    g.setColor(Color.green);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 25));
                    g.drawString(String.valueOf(win_prize), 240, 610);
                    g.setColor(Color.green);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 25));
                    g.drawString("+", 220, 610);
                }

                else if(win_crown)
                {
                    g.setColor(Color.darkGray);
                    g.fillRect(280, 380, 500, 70);
                    g.setColor(Color.RED);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 30));
                    g.drawString(" BIG WIN! The crown, king!", 280, 430);
                    win_crown=false;
                    g.setColor(Color.lightGray);
                    g.fillRect(200, 580, 150, 40);
                    g.setColor(Color.green);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 25));
                    g.drawString(String.valueOf(win_prize), 240, 610);
                    g.setColor(Color.green);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 25));
                    g.drawString("+", 220, 610);
                }





            }

            else if(step>0 && line3 && !line2 && !line1 && !diagonal1 && !diagonal2)
            {
                super.paintComponent(g);
                for (Imagine x : lista1) {
                    x.drawImagine(g, x.getCoordX(), x.getCoordY());
                }
                for (Imagine x : lista2) {
                    x.drawImagine(g, x.getCoordX(), x.getCoordY());
                }
                for (Imagine x : lista3) {
                    x.drawImagine(g, x.getCoordX(), x.getCoordY());
                }

                g.setColor(Color.orange);
                g.fillRect(300, 0, 7, 605);


                g.fillRect(600, 0, 7, 605);


                g.fillRect(0, 200, 1000, 7);

                g.fillRect(0, 400, 1000, 7);

                g.setColor(Color.darkGray);
                g.fillRect(0, 600, 1000, 120);

                g.setColor(Color.blue);
                g.fillRect(0, 600, 1000, 5);
                g.setColor(Color.lightGray);
                g.setFont(new Font("TimesRoman", Font.BOLD, 40));
                g.drawString("BALANCE", 30, 640);


                g.setColor(Color.lightGray);
                g.setFont(new Font("TimesRoman", Font.BOLD, 40));
                g.drawString("BET", 700, 640);

                g.setColor(Color.blue);
                g.fillRect(0, 705, 1000, 20);

                if(balance>=0)
                {
                    g.setColor(Color.lightGray);
                    g.drawString(String.valueOf(balance), 60, 690);
                }
                else
                {
                    g.setColor(Color.RED);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 20));
                    g.drawString("Please insert credits.", 60, 690);
                }

                g.setColor(Color.RED);
                g.fillRect(0,400,1000,7);
                g.fillRect(0,400,7,200);
                g.fillRect(0,600,1000,7);
                g.fillRect(895,400,7,200);
                g.fillRect(300,400,7,200);
                g.fillRect(600,400,7,200);
                line3=false;



                if(win_7) {
                    g.setColor(Color.darkGray);
                    g.fillRect(280, 380, 300, 70);
                    g.setColor(Color.RED);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 30));
                    g.drawString(" BIG WIN!!!   777", 280, 430);

                    g.setColor(Color.lightGray);
                    g.fillRect(200, 580, 150, 40);
                    g.setColor(Color.green);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 25));
                    g.drawString(String.valueOf(win_prize), 240, 610);
                    System.out.print(win_prize);
                    System.out.print("  step= ");
                    System.out.print(step);
                    System.out.print("\n");

                    g.setColor(Color.green);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 25));
                    g.drawString("+", 220, 610);
                    System.out.println("PAINTED 7");
                    win_7=false;
                }

                else if(win_heart)
                {
                    g.setColor(Color.darkGray);
                    g.fillRect(280, 380, 450, 70);
                    g.setColor(Color.RED);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 30));
                    g.drawString(" BIG WIN! BLACK HEARTED", 280, 430);
                    win_heart=false;
                    g.setColor(Color.lightGray);
                    g.fillRect(200, 580, 150, 40);
                    g.setColor(Color.green);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 25));
                    g.drawString(String.valueOf(win_prize), 240, 610);
                    g.setColor(Color.green);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 25));
                    g.drawString("+", 220, 610);
                }

                else if(win_diamond)
                {
                    g.setColor(Color.darkGray);
                    g.fillRect(280, 380, 500, 70);
                    g.setColor(Color.RED);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 30));
                    g.drawString(" WIN!!! Shining diamonds...", 280, 430);
                    win_diamond=false;
                    g.setColor(Color.lightGray);
                    g.fillRect(200, 580, 150, 40);
                    g.setColor(Color.green);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 25));
                    g.drawString(String.valueOf(win_prize), 240, 610);
                    g.setColor(Color.green);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 25));
                    g.drawString("+", 220, 610);
                }

                else if(win_book)
                {
                    g.setColor(Color.darkGray);
                    g.fillRect(280, 380, 450, 70);
                    g.setColor(Color.RED);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 30));
                    g.drawString(" WIN!!! Hittin' books!", 280, 430);
                    win_book=false;
                    g.setColor(Color.lightGray);
                    g.fillRect(200, 580, 150, 40);
                    g.setColor(Color.green);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 25));
                    g.drawString(String.valueOf(win_prize), 240, 610);
                    g.setColor(Color.green);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 25));
                    g.drawString("+", 220, 610);
                }
                else if(win_star)
                {
                    g.setColor(Color.darkGray);
                    g.fillRect(280, 380, 430, 70);
                    g.setColor(Color.RED);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 30));
                    g.drawString(" WIN!!! Follow the stars!", 280, 430);
                    win_star=false;
                    g.setColor(Color.lightGray);
                    g.fillRect(200, 580, 150, 40);
                    g.setColor(Color.green);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 25));
                    g.drawString(String.valueOf(win_prize), 240, 610);
                    g.setColor(Color.green);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 25));
                    g.drawString("+", 220, 610);
                }

                else if(win_crown)
                {
                    g.setColor(Color.darkGray);
                    g.fillRect(280, 380, 500, 70);
                    g.setColor(Color.RED);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 30));
                    g.drawString(" BIG WIN! The crown, king!", 280, 430);
                    win_crown=false;
                    g.setColor(Color.lightGray);
                    g.fillRect(200, 580, 150, 40);
                    g.setColor(Color.green);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 25));
                    g.drawString(String.valueOf(win_prize), 240, 610);
                    g.setColor(Color.green);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 25));
                    g.drawString("+", 220, 610);
                }





            }

            else if(step>0 && diagonal1 && !line1 && !line2 && !line3 && !diagonal2)
            {
                super.paintComponent(g);
                for (Imagine x : lista1) {
                    x.drawImagine(g, x.getCoordX(), x.getCoordY());
                }
                for (Imagine x : lista2) {
                    x.drawImagine(g, x.getCoordX(), x.getCoordY());
                }
                for (Imagine x : lista3) {
                    x.drawImagine(g, x.getCoordX(), x.getCoordY());
                }

                g.setColor(Color.orange);
                g.fillRect(300, 0, 7, 605);


                g.fillRect(600, 0, 7, 605);


                g.fillRect(0, 200, 1000, 7);

                g.fillRect(0, 400, 1000, 7);

                g.setColor(Color.darkGray);
                g.fillRect(0, 600, 1000, 120);

                g.setColor(Color.blue);
                g.fillRect(0, 600, 1000, 5);
                g.setColor(Color.lightGray);
                g.setFont(new Font("TimesRoman", Font.BOLD, 40));
                g.drawString("BALANCE", 30, 640);


                g.setColor(Color.lightGray);
                g.setFont(new Font("TimesRoman", Font.BOLD, 40));
                g.drawString("BET", 700, 640);

                g.setColor(Color.blue);
                g.fillRect(0, 705, 1000, 20);

                if(balance>=0)
                {
                    g.setColor(Color.lightGray);
                    g.drawString(String.valueOf(balance), 60, 690);
                }
                else
                {
                    g.setColor(Color.RED);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 20));
                    g.drawString("Please insert credits.", 60, 690);
                }

                g.setColor(Color.RED);
                g.fillRect(0,0,300,7);
                g.fillRect(300,0,7,200);
                g.fillRect(0,200,300,7);
                g.fillRect(0,0,7,200);

                g.fillRect(300,200,300,7);
                g.fillRect(600,200,7,200);
                g.fillRect(300,400,300,7);
                g.fillRect(300,200,7,200);

                g.fillRect(600,400,300,7);
                g.fillRect(895,400,7,200);
                g.fillRect(600,600,300,7);
                g.fillRect(600,400,7,200);
                diagonal1=false;



                if(win_7) {
                    g.setColor(Color.darkGray);
                    g.fillRect(280, 380, 300, 70);
                    g.setColor(Color.RED);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 30));
                    g.drawString(" BIG WIN!!!   777", 280, 430);

                    g.setColor(Color.lightGray);
                    g.fillRect(200, 580, 150, 40);
                    g.setColor(Color.green);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 25));
                    g.drawString(String.valueOf(win_prize), 240, 610);
                    System.out.print(win_prize);
                    System.out.print("  step= ");
                    System.out.print(step);
                    System.out.print("\n");

                    g.setColor(Color.green);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 25));
                    g.drawString("+", 220, 610);
                    System.out.println("PAINTED 7");
                    win_7=false;
                }

                else if(win_heart)
                {
                    g.setColor(Color.darkGray);
                    g.fillRect(280, 380, 450, 70);
                    g.setColor(Color.RED);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 30));
                    g.drawString(" BIG WIN! BLACK HEARTED", 280, 430);
                    win_heart=false;
                    g.setColor(Color.lightGray);
                    g.fillRect(200, 580, 150, 40);
                    g.setColor(Color.green);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 25));
                    g.drawString(String.valueOf(win_prize), 240, 610);
                    g.setColor(Color.green);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 25));
                    g.drawString("+", 220, 610);
                }

                else if(win_diamond)
                {
                    g.setColor(Color.darkGray);
                    g.fillRect(280, 380, 500, 70);
                    g.setColor(Color.RED);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 30));
                    g.drawString(" WIN!!! Shining diamonds...", 280, 430);
                    win_diamond=false;
                    g.setColor(Color.lightGray);
                    g.fillRect(200, 580, 150, 40);
                    g.setColor(Color.green);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 25));
                    g.drawString(String.valueOf(win_prize), 240, 610);
                    g.setColor(Color.green);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 25));
                    g.drawString("+", 220, 610);
                }

                else if(win_book)
                {
                    g.setColor(Color.darkGray);
                    g.fillRect(280, 380, 450, 70);
                    g.setColor(Color.RED);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 30));
                    g.drawString(" WIN!!! Hittin' books!", 280, 430);
                    win_book=false;
                    g.setColor(Color.lightGray);
                    g.fillRect(200, 580, 150, 40);
                    g.setColor(Color.green);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 25));
                    g.drawString(String.valueOf(win_prize), 240, 610);
                    g.setColor(Color.green);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 25));
                    g.drawString("+", 220, 610);
                }
                else if(win_star)
                {
                    g.setColor(Color.darkGray);
                    g.fillRect(280, 380, 430, 70);
                    g.setColor(Color.RED);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 30));
                    g.drawString(" WIN!!! Follow the stars!", 280, 430);
                    win_star=false;
                    g.setColor(Color.lightGray);
                    g.fillRect(200, 580, 150, 40);
                    g.setColor(Color.green);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 25));
                    g.drawString(String.valueOf(win_prize), 240, 610);
                    g.setColor(Color.green);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 25));
                    g.drawString("+", 220, 610);
                }

                else if(win_crown)
                {
                    g.setColor(Color.darkGray);
                    g.fillRect(280, 380, 500, 70);
                    g.setColor(Color.RED);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 30));
                    g.drawString("   BIG WIN! The crown, king!", 280, 430);
                    win_crown=false;
                    g.setColor(Color.lightGray);
                    g.fillRect(200, 580, 150, 40);
                    g.setColor(Color.green);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 25));
                    g.drawString(String.valueOf(win_prize), 240, 610);
                    g.setColor(Color.green);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 25));
                    g.drawString("+", 220, 610);
                }





            }

            else if(step>0 && diagonal2 && !line1 && !line2 && !line3 && !diagonal1)
            {
                super.paintComponent(g);
                for (Imagine x : lista1) {
                    x.drawImagine(g, x.getCoordX(), x.getCoordY());
                }
                for (Imagine x : lista2) {
                    x.drawImagine(g, x.getCoordX(), x.getCoordY());
                }
                for (Imagine x : lista3) {
                    x.drawImagine(g, x.getCoordX(), x.getCoordY());
                }

                g.setColor(Color.orange);
                g.fillRect(300, 0, 7, 605);


                g.fillRect(600, 0, 7, 605);


                g.fillRect(0, 200, 1000, 7);

                g.fillRect(0, 400, 1000, 7);

                g.setColor(Color.darkGray);
                g.fillRect(0, 600, 1000, 120);

                g.setColor(Color.blue);
                g.fillRect(0, 600, 1000, 5);
                g.setColor(Color.lightGray);
                g.setFont(new Font("TimesRoman", Font.BOLD, 40));
                g.drawString("BALANCE", 30, 640);


                g.setColor(Color.lightGray);
                g.setFont(new Font("TimesRoman", Font.BOLD, 40));
                g.drawString("BET", 700, 640);

                g.setColor(Color.blue);
                g.fillRect(0, 705, 1000, 20);

                if(balance>=0)
                {
                    g.setColor(Color.lightGray);
                    g.drawString(String.valueOf(balance), 60, 690);
                }
                else
                {
                    g.setColor(Color.RED);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 20));
                    g.drawString("Please insert credits.", 60, 690);
                }

                g.setColor(Color.RED);
                g.fillRect(0,400,300,7);
                g.fillRect(300,400,7,200);
                g.fillRect(0,600,300,7);
                g.fillRect(0,400,7,200);

                g.fillRect(300,200,300,7);
                g.fillRect(600,200,7,200);
                g.fillRect(300,400,300,7);
                g.fillRect(300,200,7,200);

                g.fillRect(600,0,300,7);
                g.fillRect(893,0,7,200);
                g.fillRect(600,200,300,7);
                g.fillRect(600,0,7,200);
                diagonal2=false;



                if(win_7) {
                    g.setColor(Color.darkGray);
                    g.fillRect(280, 380, 300, 70);
                    g.setColor(Color.RED);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 30));
                    g.drawString("    BIG WIN!!!   777", 280, 430);

                    g.setColor(Color.lightGray);
                    g.fillRect(200, 580, 150, 40);
                    g.setColor(Color.green);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 25));
                    g.drawString(String.valueOf(win_prize), 240, 610);
                    System.out.print(win_prize);
                    System.out.print("  step= ");
                    System.out.print(step);
                    System.out.print("\n");

                    g.setColor(Color.green);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 25));
                    g.drawString("+", 220, 610);
                    System.out.println("PAINTED 7");
                    win_7=false;
                }

                else if(win_heart)
                {
                    g.setColor(Color.darkGray);
                    g.fillRect(280, 380, 450, 70);
                    g.setColor(Color.RED);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 30));
                    g.drawString("   BIG WIN! BLACK HEARTED", 280, 430);
                    win_heart=false;
                    g.setColor(Color.lightGray);
                    g.fillRect(200, 580, 150, 40);
                    g.setColor(Color.green);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 25));
                    g.drawString(String.valueOf(win_prize), 240, 610);
                    g.setColor(Color.green);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 25));
                    g.drawString("+", 220, 610);
                }

                else if(win_diamond)
                {
                    g.setColor(Color.darkGray);
                    g.fillRect(280, 380, 500, 70);
                    g.setColor(Color.RED);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 30));
                    g.drawString("   WIN!!! Shining diamonds...", 280, 430);
                    win_diamond=false;
                    g.setColor(Color.lightGray);
                    g.fillRect(200, 580, 150, 40);
                    g.setColor(Color.green);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 25));
                    g.drawString(String.valueOf(win_prize), 240, 610);
                    g.setColor(Color.green);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 25));
                    g.drawString("+", 220, 610);
                }

                else if(win_book)
                {
                    g.setColor(Color.darkGray);
                    g.fillRect(280, 380, 450, 70);
                    g.setColor(Color.RED);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 30));
                    g.drawString("   WIN!!! Hittin' books!", 280, 430);
                    win_book=false;
                    g.setColor(Color.lightGray);
                    g.fillRect(200, 580, 150, 40);
                    g.setColor(Color.green);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 25));
                    g.drawString(String.valueOf(win_prize), 240, 610);
                    g.setColor(Color.green);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 25));
                    g.drawString("+", 220, 610);
                }
                else if(win_star)
                {
                    g.setColor(Color.darkGray);
                    g.fillRect(280, 380, 430, 70);
                    g.setColor(Color.RED);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 30));
                    g.drawString("   WIN!!! Follow the stars!", 280, 430);
                    win_star=false;
                    g.setColor(Color.lightGray);
                    g.fillRect(200, 580, 150, 40);
                    g.setColor(Color.green);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 25));
                    g.drawString(String.valueOf(win_prize), 240, 610);
                    g.setColor(Color.green);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 25));
                    g.drawString("+", 220, 610);
                }

                else if(win_crown)
                {
                    g.setColor(Color.darkGray);
                    g.fillRect(280, 380, 500, 70);
                    g.setColor(Color.RED);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 30));
                    g.drawString("  BIG WIN! The crown, king!", 280, 430);
                    win_crown=false;
                    g.setColor(Color.lightGray);
                    g.fillRect(200, 580, 150, 40);
                    g.setColor(Color.green);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 25));
                    g.drawString(String.valueOf(win_prize), 240, 610);
                    g.setColor(Color.green);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 25));
                    g.drawString("+", 220, 610);
                }





            }

            else if(step>0 && line1 && line2 && line3 && diagonal1 && diagonal2)
            {
                super.paintComponent(g);
                for (Imagine x : lista1) {
                    x.drawImagine(g, x.getCoordX(), x.getCoordY());
                }
                for (Imagine x : lista2) {
                    x.drawImagine(g, x.getCoordX(), x.getCoordY());
                }
                for (Imagine x : lista3) {
                    x.drawImagine(g, x.getCoordX(), x.getCoordY());
                }

                g.setColor(Color.orange);
                g.fillRect(300, 0, 7, 605);


                g.fillRect(600, 0, 7, 605);


                g.fillRect(0, 200, 1000, 7);

                g.fillRect(0, 400, 1000, 7);

                g.setColor(Color.darkGray);
                g.fillRect(0, 600, 1000, 120);

                g.setColor(Color.blue);
                g.fillRect(0, 600, 1000, 5);
                g.setColor(Color.lightGray);
                g.setFont(new Font("TimesRoman", Font.BOLD, 40));
                g.drawString("BALANCE", 30, 640);


                g.setColor(Color.lightGray);
                g.setFont(new Font("TimesRoman", Font.BOLD, 40));
                g.drawString("BET", 700, 640);

                g.setColor(Color.blue);
                g.fillRect(0, 705, 1000, 20);

                if(balance>=0)
                {
                    g.setColor(Color.lightGray);
                    g.drawString(String.valueOf(balance), 60, 690);
                }
                else
                {
                    g.setColor(Color.RED);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 20));
                    g.drawString("Please insert credits.", 60, 690);
                }

                g.setColor(Color.RED);
                g.fillRect(0, 0, 1000, 7);
                g.fillRect(0, 0, 7, 200);
                g.fillRect(0, 200, 1000, 7);
                g.fillRect(895, 0, 7, 200);
                g.fillRect(300, 0, 7, 200);
                g.fillRect(600, 0, 7, 200);

                line1=false;

                g.setColor(Color.RED);
                g.fillRect(0,200,1000,7);
                g.fillRect(0,200,7,200);
                g.fillRect(0,400,1000,7);
                g.fillRect(895,200,7,200);
                g.fillRect(300,200,7,200);
                g.fillRect(600,200,7,200);
                line2=false;


                g.setColor(Color.RED);
                g.fillRect(0,400,1000,7);
                g.fillRect(0,400,7,200);
                g.fillRect(0,600,1000,7);
                g.fillRect(895,400,7,200);
                g.fillRect(300,400,7,200);
                g.fillRect(600,400,7,200);
                line3=false;


                g.setColor(Color.RED);
                g.fillRect(0,0,300,7);
                g.fillRect(300,0,7,200);
                g.fillRect(0,200,300,7);
                g.fillRect(0,0,7,200);

                g.fillRect(300,200,300,7);
                g.fillRect(600,200,7,200);
                g.fillRect(300,400,300,7);
                g.fillRect(300,200,7,200);

                g.fillRect(600,400,300,7);
                g.fillRect(895,400,7,200);
                g.fillRect(600,600,300,7);
                g.fillRect(600,400,7,200);
                diagonal1=false;

                g.setColor(Color.RED);
                g.fillRect(0,400,300,7);
                g.fillRect(300,400,7,200);
                g.fillRect(0,600,300,7);
                g.fillRect(0,400,7,200);

                g.fillRect(300,200,300,7);
                g.fillRect(600,200,7,200);
                g.fillRect(300,400,300,7);
                g.fillRect(300,200,7,200);

                g.fillRect(600,0,300,7);
                g.fillRect(893,0,7,200);
                g.fillRect(600,200,300,7);
                g.fillRect(600,0,7,200);
                diagonal2=false;



                g.setColor(Color.darkGray);
                g.fillRect(280, 380, 300, 70);
                g.setColor(Color.RED);
                g.setFont(new Font("TimesRoman", Font.BOLD, 30));
                g.drawString("   THAT'S A FULL!!!", 280, 430);

                g.setColor(Color.lightGray);
                g.fillRect(200, 580, 150, 40);
                g.setColor(Color.green);
                g.setFont(new Font("TimesRoman", Font.BOLD, 25));
                g.drawString(String.valueOf(win_prize), 240, 610);


                g.setColor(Color.green);
                g.setFont(new Font("TimesRoman", Font.BOLD, 25));
                g.drawString("+", 220, 610);

                win_7=false;
                win_heart=false;
                win_book=false;
                win_crown=false;
                win_diamond=false;
                win_star=false;
            }
            else if(step>0)
            {
                super.paintComponent(g);
                for (Imagine x : lista1) {
                    x.drawImagine(g, x.getCoordX(), x.getCoordY());
                }
                for (Imagine x : lista2) {
                    x.drawImagine(g, x.getCoordX(), x.getCoordY());
                }
                for (Imagine x : lista3) {
                    x.drawImagine(g, x.getCoordX(), x.getCoordY());
                }

                g.setColor(Color.orange);
                g.fillRect(300, 0, 7, 605);


                g.fillRect(600, 0, 7, 605);


                g.fillRect(0, 200, 1000, 7);

                g.fillRect(0, 400, 1000, 7);

                g.setColor(Color.darkGray);
                g.fillRect(0, 600, 1000, 120);

                g.setColor(Color.blue);
                g.fillRect(0, 600, 1000, 5);
                g.setColor(Color.lightGray);
                g.setFont(new Font("TimesRoman", Font.BOLD, 40));
                g.drawString("BALANCE", 30, 640);


                g.setColor(Color.lightGray);
                g.setFont(new Font("TimesRoman", Font.BOLD, 40));
                g.drawString("BET", 700, 640);

                g.setColor(Color.blue);
                g.fillRect(0, 705, 1000, 20);

                if(balance>=0)
                {
                    g.setColor(Color.lightGray);
                    g.drawString(String.valueOf(balance), 60, 690);
                }
                else
                {
                    g.setColor(Color.RED);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 20));
                    g.drawString("Please insert credits.", 60, 690);
                }


                if(line1)
                {
                    g.setColor(Color.RED);
                    g.fillRect(0, 0, 1000, 7);
                    g.fillRect(0, 0, 7, 200);
                    g.fillRect(0, 200, 1000, 7);
                    g.fillRect(895, 0, 7, 200);
                    g.fillRect(300, 0, 7, 200);
                    g.fillRect(600, 0, 7, 200);

                    line1=false;
                }

                if(line2)
                {
                    g.setColor(Color.RED);
                    g.fillRect(0,200,1000,7);
                    g.fillRect(0,200,7,200);
                    g.fillRect(0,400,1000,7);
                    g.fillRect(895,200,7,200);
                    g.fillRect(300,200,7,200);
                    g.fillRect(600,200,7,200);
                    line2=false;
                }

                if(line3)
                {
                    g.setColor(Color.RED);
                    g.fillRect(0,400,1000,7);
                    g.fillRect(0,400,7,200);
                    g.fillRect(0,600,1000,7);
                    g.fillRect(895,400,7,200);
                    g.fillRect(300,400,7,200);
                    g.fillRect(600,400,7,200);
                    line3=false;
                }

                if(diagonal1)
                {
                    g.setColor(Color.RED);
                    g.fillRect(0,0,300,7);
                    g.fillRect(300,0,7,200);
                    g.fillRect(0,200,300,7);
                    g.fillRect(0,0,7,200);

                    g.fillRect(300,200,300,7);
                    g.fillRect(600,200,7,200);
                    g.fillRect(300,400,300,7);
                    g.fillRect(300,200,7,200);

                    g.fillRect(600,400,300,7);
                    g.fillRect(895,400,7,200);
                    g.fillRect(600,600,300,7);
                    g.fillRect(600,400,7,200);
                    diagonal1=false;
                }

                if(diagonal2)
                {
                    g.setColor(Color.RED);
                    g.fillRect(0,400,300,7);
                    g.fillRect(300,400,7,200);
                    g.fillRect(0,600,300,7);
                    g.fillRect(0,400,7,200);

                    g.fillRect(300,200,300,7);
                    g.fillRect(600,200,7,200);
                    g.fillRect(300,400,300,7);
                    g.fillRect(300,200,7,200);

                    g.fillRect(600,0,300,7);
                    g.fillRect(893,0,7,200);
                    g.fillRect(600,200,300,7);
                    g.fillRect(600,0,7,200);
                    diagonal2=false;
                }

                if(win_prize!=0)
                {
                    g.setColor(Color.darkGray);
                    g.fillRect(280, 380, 300, 70);
                    g.setColor(Color.RED);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 30));
                    g.drawString("   BIG WIN!!!", 280, 430);

                    g.setColor(Color.lightGray);
                    g.fillRect(200, 580, 150, 40);
                    g.setColor(Color.green);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 25));
                    g.drawString(String.valueOf(win_prize), 240, 610);
                    System.out.print(win_prize);
                    System.out.print("  step= ");
                    System.out.print(step);
                    System.out.print("\n");

                    g.setColor(Color.green);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 25));
                    g.drawString("+", 220, 610);

                    win_7=false;
                    win_heart=false;
                    win_book=false;
                    win_crown=false;
                    win_diamond=false;
                    win_star=false;
                }

            }

        }

    }





    public int verifySameLine(Imagine x1, Imagine x2, Imagine x3){

        if(x1.getCoordY()==x2.getCoordY() && x2.getCoordY()==x3.getCoordY() && x1.getNumber()==x2.getNumber() && x2.getNumber()==x3.getNumber())
        {
            if(x1.getNumber()==0) {
                win_7=true;
                win_prize=win_prize+100*bet;
            }
            else if(x1.getNumber()==1) {
                win_heart=true;
                win_prize=win_prize+75*bet;
            }
            else if(x1.getNumber()==2) {
                win_book=true;
                win_prize=win_prize+50*bet;
            }
            else if(x1.getNumber()==3){
                win_crown=true;
                win_prize=win_prize+30*bet;
            }
            else if(x1.getNumber()==4) {
                win_diamond=true;
                win_prize=win_prize+25*bet;
            }
            else if(x1.getNumber()==5){
                win_star=true;
                win_prize=win_prize+10*bet;
            }

            if(win_prize!=0)
                return 1;




        }
        return 0;
    }

    public int verifyDiagonal(Imagine x1, Imagine x2, Imagine x3){


        if(x1.getNumber()==x2.getNumber() && x2.getNumber()==x3.getNumber())
        {
            if(x1.getNumber()==0) {
                win_7=true;
                win_prize=win_prize+100*bet;
            }
            else if(x1.getNumber()==1) {
                win_heart=true;
                win_prize=win_prize+75*bet;
            }
            else if(x1.getNumber()==2) {
                win_book=true;
                win_prize=win_prize+50*bet;
            }
            else if(x1.getNumber()==3) {
                win_crown=true;
                win_prize=win_prize+30*bet;
            }
            else if(x1.getNumber()==4) {
                win_diamond=true;
                win_prize=win_prize+25*bet;
            }
            else if(x1.getNumber()==5) {
                win_star=true;
                win_prize=win_prize+10*bet;
            }

            if(win_prize!=0)
            {
                return 1;
            }




        }
        return 0;
    }



    public void Win(){
        win_prize=0;
        if(verifySameLine(lista1.get(lista1.size()-1), lista2.get(lista2.size()-1), lista3.get(lista3.size()-1))==1)
        {
            line1=true;
            won=true;
        }
        if(verifySameLine(lista1.get(lista1.size()-2), lista2.get(lista2.size()-2), lista3.get(lista3.size()-2))==1)
        {
            line2=true;
            won=true;
        }
        if(verifySameLine(lista1.get(lista1.size()-3), lista2.get(lista2.size()-3), lista3.get(lista3.size()-3))==1)
        {
            line3=true;
            won=true;
        }
        if(verifyDiagonal(lista1.get(lista1.size()-1),lista2.get(lista2.size()-2),lista3.get(lista3.size()-3))==1)
        {
            diagonal1=true;
            won=true;
        }
        if(verifyDiagonal(lista1.get(lista1.size()-3),lista2.get(lista2.size()-2),lista3.get(lista3.size()-1))==1)
        {
            diagonal2=true;
            won=true;
        }
        repaint();
        balance=balance+win_prize;
        won=false;



    }

    public void InitPaths() {
        paths.clear();

        paths.add(pths.get(0));
        paths.add(pths.get(1));
        paths.add(pths.get(2));
        paths.add(pths.get(3));
        paths.add(pths.get(4));
        paths.add(pths.get(5));



//        paths.add("C:\\Users\\Daniel\\Desktop\\facultate\\An 2\\SEM1\\Mip Labs\\ProjectMIP\\Project\\src\\7.png");
//        paths.add("C:\\Users\\Daniel\\Desktop\\facultate\\An 2\\SEM1\\Mip Labs\\ProjectMIP\\Project\\src\\7.png");
//        paths.add("C:\\Users\\Daniel\\Desktop\\facultate\\An 2\\SEM1\\Mip Labs\\ProjectMIP\\Project\\src\\7.png");
//        paths.add("C:\\Users\\Daniel\\Desktop\\facultate\\An 2\\SEM1\\Mip Labs\\ProjectMIP\\Project\\src\\7.png");
//        paths.add("C:\\Users\\Daniel\\Desktop\\facultate\\An 2\\SEM1\\Mip Labs\\ProjectMIP\\Project\\src\\7.png");
//        paths.add("C:\\Users\\Daniel\\Desktop\\facultate\\An 2\\SEM1\\Mip Labs\\ProjectMIP\\Project\\src\\7.png");


    }



    public void setBet(String option) {
        bet = Integer.parseInt(option);
    }

    public void verifyBet()
    {
        isMoney= balance - bet >= 0;
    }

    public void UpdateBalance(){
        balance=balance-bet;
    }

    public void increaseStep(){
        step++;
    }


    public void updateThread(){
        t=new Thread(this);
        t.start();
    }

    public void run(){
        verifyBet();
        if(isMoney)
        {
            utils.CreateLists(step,lista1,lista2,lista3,paths);
            if(Thread.currentThread()==t)
            {
                isSpinning=true;
            }

            while(isSpinning){
                if(step>0)
                {
                    UpdateBalance();
                }
                int coord1 = lista1.get(17).getCoordY();
                while (coord1<0) {
                    for (Imagine x : lista1) {
                        x.setCoordY(x.getCoordY() + 10);

                    }

                    coord1 = coord1 + 10;
                    try {
                        Thread.sleep(3);
                    }catch(InterruptedException e)
                    {

                    }
                    repaint();

                }
                int coord2 = lista2.get(17).getCoordY();
                while (coord2 < 0) {
                    for (Imagine x : lista2) {
                        x.setCoordY(x.getCoordY() + 10);

                    }


                    try {
                        Thread.sleep(3);
                    }catch(InterruptedException e)
                    {

                    }
                    coord2 = coord2 + 10;
                    repaint();

                }

                int coord3 = lista3.get(17).getCoordY();
                while (coord3 < 0) {
                    for (Imagine x : lista3) {
                        x.setCoordY(x.getCoordY() + 10);

                    }

                    try {
                        Thread.sleep(3);
                    }catch(InterruptedException e)
                    {

                    }
                    coord3 = coord3 + 10;
                    repaint();
                }

                isSpinning=false;

            }

            if(step==0)
                increaseStep();

            else if(step>0)
            {
                Win();
                increaseStep();
            }
        }

        else
        {
            repaint();
        }
    }

}



