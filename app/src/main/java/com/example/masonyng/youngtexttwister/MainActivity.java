//Mason Young
//Date: January 18, 2019
//Purpose: To create a game using grade 12 content
package com.example.masonyng.youngtexttwister;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Chronometer;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Chronometer simpleChronometer = (Chronometer) findViewById(R.id.time);
        simpleChronometer.start();
    }
    //moves to instructions screen
    public void toSecond(View view){
        Intent i = new Intent(this,
                Instructions.class);
        startActivity(i);
    }
    //level tracker
    int level = 1;
    //extra words indicator
    int extraWord = 0;
    //works with giveup button
    int playagain = -1;
    //answer row letters with images
    String top[]= {" ", " ", " ", " ", " ", " "};

    //starting bottom letters
    String bottom[]= {"s", "g", "s", "p", "a", "r"};

    //level2
    String level2[]= {"i", "p", "z", "e", "r", "s"};

    //level3
    String level3[]={"d", "f", "e", "t", "a", "h"};

    //all answers on board
    // spaces accommodate for extra space in answer string array
    String answers[] = {"ass   ", "gap   ", "gas   ", "par   ", "rag   ", "rap   ", "sag   ", "sap   ", "gaps  ", "gasp  ", "pars  ","pass  ", "rags  ", "raps  ", "rasp  ", "sags  ","gasps ", "grasp ", "grass ", "spars ","grasps"};
    String ans1[] = {"ire   ", "per   ", "pie   ", "rep   ", "rip   ", "sip   ", "sir   ", "zip   ", "pier  ", "pies  ", "ripe  ","rips  ", "rise  ", "sire  ", "size  ", "zips  ","piers ", "pries ", "prize ", "ripes ","prizes"};
    String ans2[] = {"ate   ", "eat   ", "fad   ", "fat   ", "had   ", "hat   ", "tad   ", "the   ", "daft  ", "date  ", "deaf  ","fade  ", "fate  ", "feat  ", "hate  ", "head  ","death ", "defat ", "fated ", "hated ","hafted"};

    //Scoring
    int score = 0;

    //original answers for revealing for giveup
    String o1[] = {"ass   ", "gap   ", "gas   ", "par   ", "rag   ", "rap   ", "sag   ", "sap   ", "gaps  ", "gasp  ", "pars  ","pass  ", "rags  ", "raps  ", "rasp  ", "sags  ","gasps ", "grasp ", "grass ", "spars ","grasps"};
    String o2[] = {"ire   ", "per   ", "pie   ", "rep   ", "rip   ", "sip   ", "sir   ", "zip   ", "pier  ", "pies  ", "ripe  ","rips  ", "rise  ", "sire  ", "size  ", "zips  ","piers ", "pries ", "prize ", "ripes ","prizes"};
    String o3[] = {"ate   ", "eat   ", "fad   ", "fat   ", "had   ", "hat   ", "tad   ", "the   ", "daft  ", "date  ", "deaf  ","fade  ", "fate  ", "feat  ", "hate  ", "head  ","death ", "defat ", "fated ", "hated ","hafted"};

    //bottom row first letter
    public void letter1(View view){
        //prevents user from crashing game for used letters
        if (bottom[0].equals(" "))
            return;
        else {
            TextView let1 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.letter1);
            let1.setText(" ");
            moveup(0);
            bottom[0] = " ";
        }
        TextView t = (TextView)findViewById(R.id.tip);
        t.setText("");
    }

    //bottom row second letter
    public void letter2(View view){
        TextView t = (TextView)findViewById(R.id.tip);
        t.setText("");
        if (bottom[1].equals(" "))
            return;
        else {
            TextView let2 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.letter2);
            let2.setText(" ");
            moveup(1);
            bottom[1] = " ";
        }
    }

    //bottom row third letter
    public void letter3(View view){
        TextView t = (TextView)findViewById(R.id.tip);
        t.setText("");
        if (bottom[2].equals(" "))
            return;
        else {
            TextView let3 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.letter3);
            let3.setText(" ");
            moveup(2);
            bottom[2] = " ";
        }
    }

    //bottom row fourth letter
    public void letter4(View view){
        TextView t = (TextView)findViewById(R.id.tip);
        t.setText("");
        if (bottom[3].equals(" "))
            return;
        else {
            TextView let4 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.letter4);
            let4.setText(" ");
            moveup(3);
            bottom[3] = " ";
        }
    }

    //bottom row fifth letter
    public void letter5(View view){
        TextView t = (TextView)findViewById(R.id.tip);
        t.setText("");
        if (bottom[4].equals(" "))
            return;
        else {
            TextView let5 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.letter5);
            let5.setText(" ");
            moveup(4);
            bottom[4] = " ";
        }
    }

    //bottom row sixth letter
    public void letter6(View view){
        TextView t = (TextView)findViewById(R.id.tip);
        t.setText("");
        if (bottom[5].equals(" "))
            return;
        else {
            TextView let6 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.letter6);
            let6.setText(" ");
            moveup(5);
            bottom[5] = " ";
        }
    }

    //top row first letter
    public void box1(View view) {
        //prevents users from crashing game by clicking empty button
        if (top[0].equals(" "))
            return;
        else {
            ImageView box1 = (ImageView) findViewById(com.example.masonyng.youngtexttwister.R.id.box1);
            box1.setImageResource(com.example.masonyng.youngtexttwister.R.drawable.gamebox);
            movedown(0);
            top[0] = " ";
        }
    }

    //top row second letter
    public void box2(View view) {
        if (top[1].equals(" "))
            return;
        else {
            ImageView box2 = (ImageView) findViewById(com.example.masonyng.youngtexttwister.R.id.box2);
            box2.setImageResource(com.example.masonyng.youngtexttwister.R.drawable.gamebox);
            movedown(1);
            top[1] = " ";
        }
    }

    //top row third letter
    public void box3(View view) {
        if (top[2].equals(" "))
            return;
        else {
            ImageView box3 = (ImageView) findViewById(com.example.masonyng.youngtexttwister.R.id.box3);
            box3.setImageResource(com.example.masonyng.youngtexttwister.R.drawable.gamebox);
            movedown(2);
            top[2] = " ";
        }
    }

    //top row fourth letter
    public void box4(View view) {
        if (top[3].equals(" "))
            return;
        else {
            ImageView box4 = (ImageView) findViewById(com.example.masonyng.youngtexttwister.R.id.box4);
            box4.setImageResource(com.example.masonyng.youngtexttwister.R.drawable.gamebox);
            movedown(3);
            top[3] = " ";
        }
    }

    //top row fifth letter
    public void box5(View view) {
        if (top[4].equals(" "))
            return;
        else {
            ImageView box5 = (ImageView) findViewById(com.example.masonyng.youngtexttwister.R.id.box5);
            box5.setImageResource(com.example.masonyng.youngtexttwister.R.drawable.gamebox);
            movedown(4);
            top[4] = " ";
        }
    }

    //top row sixth letter
    public void box6(View view) {
        if (top[5].equals(" "))
            return;
        else {
            ImageView box6 = (ImageView) findViewById(com.example.masonyng.youngtexttwister.R.id.box6);
            box6.setImageResource(com.example.masonyng.youngtexttwister.R.drawable.gamebox);
            movedown(5);
            top[5] = " ";
        }
    }

    //clear clicked to clear top row
    public void clear (View view){
        clear1();
    }
    //separate from clear method to use in other methods
    public void clear1 (){
        ImageView box1 = (ImageView) findViewById(com.example.masonyng.youngtexttwister.R.id.box1);
        ImageView box2 = (ImageView) findViewById(com.example.masonyng.youngtexttwister.R.id.box2);
        ImageView box3 = (ImageView) findViewById(com.example.masonyng.youngtexttwister.R.id.box3);
        ImageView box4 = (ImageView) findViewById(com.example.masonyng.youngtexttwister.R.id.box4);
        ImageView box5 = (ImageView) findViewById(com.example.masonyng.youngtexttwister.R.id.box5);
        ImageView box6 = (ImageView) findViewById(com.example.masonyng.youngtexttwister.R.id.box6);
        if (!top[0].equals(" ")) {
            box1.setImageResource(com.example.masonyng.youngtexttwister.R.drawable.gamebox);
            movedown(0);
            top[0] = " ";
        }
        if (!top[1].equals(" ")) {
            box2.setImageResource(com.example.masonyng.youngtexttwister.R.drawable.gamebox);
            movedown(1);
            top[1] = " ";
        }
        if (!top[2].equals(" ")) {
            box3.setImageResource(com.example.masonyng.youngtexttwister.R.drawable.gamebox);
            movedown(2);
            top[2] = " ";
        }
        if (!top[3].equals(" ")) {
            box4.setImageResource(com.example.masonyng.youngtexttwister.R.drawable.gamebox);
            movedown(3);
            top[3] = " ";
        }
        if (!top[4].equals(" ")) {
            box5.setImageResource(com.example.masonyng.youngtexttwister.R.drawable.gamebox);
            movedown(4);
            top[4] = " ";
        }
        if (!top[5].equals(" ")) {
            box6.setImageResource(com.example.masonyng.youngtexttwister.R.drawable.gamebox);
            movedown(5);
            top[5] = " ";
        }
    }

    //checks answer to see if correct
    public void enter(View view){
        TextView t = (TextView)findViewById(R.id.tip);
        String answer = top[0]+top[1]+top[2]+top[3]+top[4]+top[5];
        int pos = -1;
        for (int i = 0; i < answers.length;i++) {
            if (answer.equals(answers[i]))
                pos = i;
            else
                tipsHelp(answer);
        }
        extraWord++;
        if (pos < 8) {
            CheckForThree(pos);
            clear1();
        }
        else if (pos < 16) {
            score+=500;
            CheckForFour(pos);
            clear1();
        }
        else if (pos<20) {
            score+=1000;
            CheckForFive(pos);
            clear1();
        }
        else if (pos>19) {
            score+=2000;
            CheckForSix(pos);
            clear1();
        }
        else {
            clear1();
        }
        if (score>=11600)
            win();
        setScore(score);
    }

    //extra words
    public void tipsHelp(String ans){
        TextView t = (TextView) findViewById(R.id.tip);
        //extra words not in answer box
        if (ans.equals ("saps  ") || ans.equals ("asp   ") || ans.equals ("gar   ") || ans.equals ("asps  ") || ans.equals ("spa   ") || ans.equals ("gars  ") || ans.equals ("spar  ") || ans.equals ("saps  ") || ans.equals ("asp   ") || ans.equals ("gar   ") || ans.equals ("asps  ") || ans.equals ("spa   ") || ans.equals ("gars  ") || ans.equals ("spas  ") || ans.equals ("rasps ") || ans.equals ("spire ") || ans.equals("aft   ") || ans.equals("eta   ")|| ans.equals("fed   ")|| ans.equals("tea   ")|| ans.equals("ted   ")|| ans.equals("deft  ")|| ans.equals("feta  ")|| ans.equals("haft  ")|| ans.equals("heat  ")|| ans.equals("heft  ")){
            if(extraWord==0)
                t.setText("You have discovered an extra word out of the list!");
            else if (extraWord==1)
                t.setText("Valid word... added to extra words list");
            else if (extraWord==2)
                t.setText("Does not match a word in the answer box...  +1");
            else
                extraWord=0;
        }
    }

    //win conditions & actions to move up in levels to win
    public void win (){
        TextView t = (TextView) findViewById(R.id.tip);
        score=0;
        level++;
        TextView lvl = (TextView) findViewById(R.id.level);
        if (level==2) {
            t.setText("Congratulations! You are now on level 2");
            for (int i = 0; i < 6; i++)
                bottom[i] = level2[i];
            lvl.setText("Lvl: 2");
        }
        else if (level==3) {
            t.setText("Congratulations! You are now on level 3");
            lvl.setText("Lvl: 3");
            for (int i = 0; i < 6; i++)
                bottom[i] = level3[i];
        }
        else if (level==4)
            toWin();
        TextView let1 = (TextView) findViewById(R.id.letter1);
        TextView let2 = (TextView) findViewById(R.id.letter2);
        TextView let3 = (TextView) findViewById(R.id.letter3);
        TextView let4 = (TextView) findViewById(R.id.letter4);
        TextView let5 = (TextView) findViewById(R.id.letter5);
        TextView let6 = (TextView) findViewById(R.id.letter6);
        let1.setText(bottom[0]);
        let2.setText(bottom[1]);
        let3.setText(bottom[2]);
        let4.setText(bottom[3]);
        let5.setText(bottom[4]);
        let6.setText(bottom[5]);
        clearBoard();
    }

    //goes to winning screen
    public void toWin(){
        Intent i = new Intent(this,
                win.class);
        startActivity(i);
    }
    //clears game board
    public void clearBoard(){
        //3 letter word clears
        TextView three1 = (TextView) findViewById(R.id.three1);
        TextView three2 = (TextView) findViewById(R.id.three2);
        TextView three3 = (TextView) findViewById(R.id.three3);
        TextView three4 = (TextView) findViewById(R.id.three4);
        TextView three5 = (TextView) findViewById(R.id.three5);
        TextView three6 = (TextView) findViewById(R.id.three6);
        TextView three7 = (TextView) findViewById(R.id.three7);
        TextView three8 = (TextView) findViewById(R.id.three8);
        //4 letter word clears
        TextView four1 = (TextView) findViewById(R.id.four1);
        TextView four2 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.four2);
        TextView four3 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.four3);
        TextView four4 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.four4);
        TextView four5 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.four5);
        TextView four6 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.four6);
        TextView four7 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.four7);
        TextView four8 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.four8);
        //5 letter words clears
        TextView five1 = (TextView) findViewById(R.id.five1);
        TextView five2 = (TextView) findViewById(R.id.five2);
        TextView five3 = (TextView) findViewById(R.id.five3);
        TextView five4 = (TextView) findViewById(R.id.five4);
        TextView six1 = (TextView) findViewById(R.id.six1);
        three1.setText("_ _ _");
        three2.setText("_ _ _");
        three3.setText("_ _ _");
        three4.setText("_ _ _");
        three5.setText("_ _ _");
        three6.setText("_ _ _");
        three7.setText("_ _ _");
        three8.setText("_ _ _");
        four1.setText("_ _ _ _");
        four2.setText("_ _ _ _");
        four3.setText("_ _ _ _");
        four4.setText("_ _ _ _");
        four5.setText("_ _ _ _");
        four6.setText("_ _ _ _");
        four7.setText("_ _ _ _");
        four8.setText("_ _ _ _");
        five1.setText("_ _ _ _ _");
        five2.setText("_ _ _ _ _");
        five3.setText("_ _ _ _ _");
        five4.setText("_ _ _ _ _");
        six1.setText("_ _ _ _ _ _");

    }
    //moves letter to closest blank available space from bottom to top
    public void moveup (int place){
        int newpos = -1;
        //cycles through for open spot and gives that position for the letter clicked
        for(int i = 0; i<top.length; i++) {
            if (top[i].equals(" ") && newpos == -1) {
                newpos = i;
            }
        }
        placeinTop(bottom[place],newpos);
        if (newpos == -1)
            placeinBottom(bottom[place], newpos);
    }

    //moves letter to closest blank available space from top to bottom
    public void movedown (int place){
        int newpos = -1;
        //cycles through for open spot and gives that position for the letter clicked
        for(int i = 0; i<bottom.length;i++) {
            if (bottom[i].equals(" ") && newpos == -1)
                newpos = i;
        }
        placeinBottom(top[place],newpos);
        if(newpos==-1)
            placeinTop(top[place], newpos);
    }

    //places letters from bottom row into top row
    public void placeinTop (String letter, int newpos){
        ImageView box1 = (ImageView) findViewById(com.example.masonyng.youngtexttwister.R.id.box1);
        ImageView box2 = (ImageView) findViewById(com.example.masonyng.youngtexttwister.R.id.box2);
        ImageView box3 = (ImageView) findViewById(com.example.masonyng.youngtexttwister.R.id.box3);
        ImageView box4 = (ImageView) findViewById(com.example.masonyng.youngtexttwister.R.id.box4);
        ImageView box5 = (ImageView) findViewById(com.example.masonyng.youngtexttwister.R.id.box5);
        ImageView box6 = (ImageView) findViewById(com.example.masonyng.youngtexttwister.R.id.box6);
        top[newpos]=letter;
        if (newpos==0)
            updateImage(letter, box1);
        else if (newpos==1)
            updateImage(letter,box2);
        else if (newpos==2)
            updateImage(letter,box3);
        else if (newpos ==3)
            updateImage(letter,box4);
        else if (newpos==4)
            updateImage(letter,box5);
        else if (newpos==5)
            updateImage(letter,box6);

    }

    //places letters from top row into bottom row
    public void placeinBottom (String letter, int newpos){
        TextView let1 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.letter1);
        TextView let2 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.letter2);
        TextView let3 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.letter3);
        TextView let4 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.letter4);
        TextView let5 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.letter5);
        TextView let6 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.letter6);
        bottom[newpos]=letter;
        if (newpos==0)
            updateLetter(letter,let1);
        else if (newpos==1)
            updateLetter(letter,let2);
        else if (newpos==2)
            updateLetter(letter,let3);
        else if (newpos ==3)
            updateLetter(letter,let4);
        else if (newpos==4)
            updateLetter(letter,let5);
        else if (newpos==5)
            updateLetter(letter,let6);
    }

    //changes bottom row to letters accordingly
    public void updateLetter (String letter, TextView j){
        if (letter.equals ("a"))
            j.setText("a");
        else if (letter.equals("d"))
            j.setText("d");
        else if (letter.equals ("e"))
            j.setText("e");
        else if (letter.equals ("f"))
            j.setText("f");
        else if (letter.equals ("g"))
            j.setText("g");
        else if (letter.equals ("h"))
            j.setText("h");
        else if (letter.equals ("i"))
            j.setText("i");
        else if (letter.equals ("p"))
            j.setText("p");
        else if (letter.equals ("r"))
            j.setText("r");
        else if (letter.equals ("s"))
            j.setText("s");
        else if (letter.equals ("t"))
            j.setText("t");
        else if (letter.equals ("z"))
            j.setText("z");
    }

    //changes top row to images of letters accordingly
    public void updateImage (String letter, ImageView i){
        if (letter.equals ("a"))
            i.setImageResource(R.drawable.a);
        else if (letter.equals("d"))
            i.setImageResource(R.drawable.d);
        else if (letter.equals ("e"))
            i.setImageResource(R.drawable.e);
        else if (letter.equals ("f"))
            i.setImageResource(R.drawable.f);
        else if (letter.equals ("g"))
            i.setImageResource(R.drawable.g);
        else if (letter.equals ("h"))
            i.setImageResource(R.drawable.h);
        else if (letter.equals ("i"))
            i.setImageResource(R.drawable.i);
        else if (letter.equals ("p"))
            i.setImageResource(R.drawable.p);
        else if (letter.equals ("r"))
            i.setImageResource(R.drawable.r);
        else if (letter.equals ("s"))
            i.setImageResource(R.drawable.s);
        else if (letter.equals ("t"))
            i.setImageResource(R.drawable.t);
        else if (letter.equals ("z"))
            i.setImageResource(R.drawable.z);
    }

    //checks for three letter words
    public void CheckForThree(int num){
        //all 3 letter answers
        TextView three1 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.three1);
        TextView three2 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.three2);
        TextView three3 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.three3);
        TextView three4 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.three4);
        TextView three5 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.three5);
        TextView three6 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.three6);
        TextView three7 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.three7);
        TextView three8 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.three8);
            if (num == 0) {
                three1.setText(answers[num]);
                nextLevel(num);
                score += 200;
            }
            if (num >= 1) {
                if (num == 1) {
                    three2.setText(answers[num]);
                    nextLevel(num);
                }
                else if (num == 2) {
                    three3.setText(answers[num]);
                    nextLevel(num);
                }
                else if (num == 3) {
                    three4.setText(answers[num]);
                    nextLevel(num);
                }
                else if (num == 4) {
                    three5.setText(answers[num]);
                    nextLevel(num);
                }
                else if (num == 5) {
                    three6.setText(answers[num]);
                    nextLevel(num);
                }
                else if (num == 6){
                    three7.setText(answers[num]);
                    nextLevel(num);
                }
                else if (num == 7) {
                    three8.setText(answers[num]);
                    nextLevel(num);
                }
                score += 200;
            }
    }

    //checks for four letter words
    public void CheckForFour (int num){
        //all 4 letter answers
        TextView four1 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.four1);
        TextView four2 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.four2);
        TextView four3 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.four3);
        TextView four4 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.four4);
        TextView four5 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.four5);
        TextView four6 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.four6);
        TextView four7 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.four7);
        TextView four8 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.four8);
        if (num==8) {
            four1.setText(answers[num]);
            nextLevel(num);
        }
        else if (num==9) {
            four2.setText(answers[num]);
            nextLevel(num);
        }
        else if (num==10) {
            four3.setText(answers[num]);
            nextLevel(num);
        }
        else if (num==11) {
            four4.setText(answers[num]);
            nextLevel(num);
        }
        else if (num==12) {
            four5.setText(answers[num]);
            nextLevel(num);
        }
        else if (num==13) {
            four6.setText(answers[num]);
            nextLevel(num);
        }
        else if (num==14) {
            four7.setText(answers[num]);
            nextLevel(num);
        }
        else if (num==15) {
            four8.setText(answers[num]);
            nextLevel(num);
        }
    }

    //checks for five letter words
    public void CheckForFive(int num){
        TextView five1 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.five1);
        TextView five2 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.five2);
        TextView five3 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.five3);
        TextView five4 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.five4);
        if (num==16) {
            five1.setText(answers[num]);
            nextLevel(num);
        }
        else if (num==17) {
            five2.setText(answers[num]);
            nextLevel(num);
        }
        else if (num==18) {
            five3.setText(answers[num]);
            nextLevel(num);
        }
        else if (num==19) {
            five4.setText(answers[num]);
            nextLevel(num);
        }
    }

    //checks for six letter works
    public void CheckForSix(int num){
        TextView six1 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.six1);
        if (num==20) {
            six1.setText(answers[num]);
            nextLevel(num);
        }
    }

    //sets the score
    public void setScore (int num){
        TextView score = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.score);
        score.setText("Score: "+num);
    }

    //reveals current level answers
    public void giveup (View view){
        playagain++;

        if (level==1)
            showLevel1();
        else if (level==2)
            showLevel2();
        else if (level==3)
            showLevel3();
        if (playagain==1)
            toSplash();


    }

    //changes array for game to next level(new array of answers)
    public void nextLevel (int newpos){
        if (level == 1)
            answers[newpos]= ans1[newpos];
        else if (level == 2)
            answers[newpos]= ans2[newpos];
    }

    //when give up. reveals for level 1
    public void showLevel1(){
        TextView three1 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.three1);
        TextView three2 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.three2);
        TextView three3 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.three3);
        TextView three4 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.three4);
        TextView three5 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.three5);
        TextView three6 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.three6);
        TextView three7 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.three7);
        TextView three8 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.three8);
        TextView four1 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.four1);
        TextView four2 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.four2);
        TextView four3 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.four3);
        TextView four4 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.four4);
        TextView four5 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.four5);
        TextView four6 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.four6);
        TextView four7 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.four7);
        TextView four8 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.four8);
        TextView five1 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.five1);
        TextView five2 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.five2);
        TextView five3 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.five3);
        TextView five4 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.five4);
        TextView six1 = (TextView) findViewById(R.id.six1);
        TextView let1 = (TextView) findViewById(R.id.letter1);
        TextView let2 = (TextView) findViewById(R.id.letter2);
        TextView let3 = (TextView) findViewById(R.id.letter3);
        TextView let4 = (TextView) findViewById(R.id.letter4);
        TextView let5 = (TextView) findViewById(R.id.letter5);
        TextView let6 = (TextView) findViewById(R.id.letter6);
        TextView g = (TextView) findViewById(R.id.giveup);
        g.setText("Play again?");
        TextView a = (TextView) findViewById(R.id.clear);
        a.setText(" ");
        TextView b = (TextView) findViewById(R.id.enter);
        b.setText(" ");
        let1.setText(" ");
        let2.setText(" ");
        let3.setText(" ");
        let4.setText(" ");
        let5.setText(" ");
        let6.setText(" ");
        for(int i = 0; i<6;i++)
            bottom[i]=" ";
        three1.setText(o1[0]);
        three2.setText(o1[1]);
        three3.setText(o1[2]);
        three4.setText(o1[3]);
        three5.setText(o1[4]);
        three6.setText(o1[5]);
        three7.setText(o1[6]);
        three8.setText(o1[7]);
        four1.setText(o1[8]);
        four2.setText(o1[9]);
        four3.setText(o1[10]);
        four4.setText(o1[11]);
        four5.setText(o1[12]);
        four6.setText(o1[13]);
        four7.setText(o1[14]);
        four8.setText(o1[15]);
        five1.setText(o1[16]);
        five2.setText(o1[17]);
        five3.setText(o1[18]);
        five4.setText(o1[19]);
        six1.setText(o1[20]);
    }

    //when give up. reveals for level 2
    public void showLevel2(){
        TextView three1 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.three1);
        TextView three2 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.three2);
        TextView three3 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.three3);
        TextView three4 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.three4);
        TextView three5 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.three5);
        TextView three6 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.three6);
        TextView three7 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.three7);
        TextView three8 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.three8);
        TextView four1 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.four1);
        TextView four2 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.four2);
        TextView four3 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.four3);
        TextView four4 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.four4);
        TextView four5 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.four5);
        TextView four6 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.four6);
        TextView four7 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.four7);
        TextView four8 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.four8);
        TextView five1 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.five1);
        TextView five2 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.five2);
        TextView five3 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.five3);
        TextView five4 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.five4);
        TextView six1 = (TextView) findViewById(R.id.six1);
        TextView let1 = (TextView) findViewById(R.id.letter1);
        TextView let2 = (TextView) findViewById(R.id.letter2);
        TextView let3 = (TextView) findViewById(R.id.letter3);
        TextView let4 = (TextView) findViewById(R.id.letter4);
        TextView let5 = (TextView) findViewById(R.id.letter5);
        TextView let6 = (TextView) findViewById(R.id.letter6);
        TextView g = (TextView) findViewById(R.id.giveup);
        g.setText("Play again?");
        TextView a = (TextView) findViewById(R.id.clear);
        a.setText(" ");
        TextView b = (TextView) findViewById(R.id.enter);
        b.setText(" ");
        let1.setText(" ");
        let2.setText(" ");
        let3.setText(" ");
        let4.setText(" ");
        let5.setText(" ");
        let6.setText(" ");
        for(int i = 0; i<6;i++)
            bottom[i]=" ";
        three1.setText(o2[0]);
        three2.setText(o2[1]);
        three3.setText(o2[2]);
        three4.setText(o2[3]);
        three5.setText(o2[4]);
        three6.setText(o2[5]);
        three7.setText(o2[6]);
        three8.setText(o2[7]);
        four1.setText(o2[8]);
        four2.setText(o2[9]);
        four3.setText(o2[10]);
        four4.setText(o2[11]);
        four5.setText(o2[12]);
        four6.setText(o2[13]);
        four7.setText(o2[14]);
        four8.setText(o2[15]);
        five1.setText(o2[16]);
        five2.setText(o2[17]);
        five3.setText(o2[18]);
        five4.setText(o2[19]);
        six1.setText(o2[20]);
    }

    //when give up. reveals for level 3
    public void showLevel3(){
        TextView three1 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.three1);
        TextView three2 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.three2);
        TextView three3 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.three3);
        TextView three4 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.three4);
        TextView three5 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.three5);
        TextView three6 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.three6);
        TextView three7 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.three7);
        TextView three8 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.three8);
        TextView four1 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.four1);
        TextView four2 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.four2);
        TextView four3 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.four3);
        TextView four4 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.four4);
        TextView four5 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.four5);
        TextView four6 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.four6);
        TextView four7 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.four7);
        TextView four8 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.four8);
        TextView five1 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.five1);
        TextView five2 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.five2);
        TextView five3 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.five3);
        TextView five4 = (TextView) findViewById(com.example.masonyng.youngtexttwister.R.id.five4);
        TextView six1 = (TextView) findViewById(R.id.six1);
        TextView let1 = (TextView) findViewById(R.id.letter1);
        TextView let2 = (TextView) findViewById(R.id.letter2);
        TextView let3 = (TextView) findViewById(R.id.letter3);
        TextView let4 = (TextView) findViewById(R.id.letter4);
        TextView let5 = (TextView) findViewById(R.id.letter5);
        TextView let6 = (TextView) findViewById(R.id.letter6);
        TextView g = (TextView) findViewById(R.id.giveup);
        g.setText("Play again?");
        TextView a = (TextView) findViewById(R.id.clear);
        a.setText(" ");
        TextView b = (TextView) findViewById(R.id.enter);
        b.setText(" ");
        let1.setText(" ");
        let2.setText(" ");
        let3.setText(" ");
        let4.setText(" ");
        let5.setText(" ");
        let6.setText(" ");
        for(int i = 0; i<6;i++)
            bottom[i]=" ";
        three1.setText(o3[0]);
        three2.setText(o3[1]);
        three3.setText(o3[2]);
        three4.setText(o3[3]);
        three5.setText(o3[4]);
        three6.setText(o3[5]);
        three7.setText(o3[6]);
        three8.setText(o3[7]);
        four1.setText(o3[8]);
        four2.setText(o3[9]);
        four3.setText(o3[10]);
        four4.setText(o3[11]);
        four5.setText(o3[12]);
        four6.setText(o3[13]);
        four7.setText(o3[14]);
        four8.setText(o3[15]);
        five1.setText(o3[16]);
        five2.setText(o3[17]);
        five3.setText(o3[18]);
        five4.setText(o3[19]);
        six1.setText(o3[20]);
    }

    //moves to splash screen
    public void toSplash(){
        Intent i = new Intent(this,
                splash.class);
        startActivity(i);
    }

}
