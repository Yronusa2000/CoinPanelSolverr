import jdk.dynalink.Operation;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Coin {



    public enum STATE{
        GOLD,
        SILVER
    }

    public STATE state;


    public Coin(STATE state) {
        this.state = state;
    }

    public void flip(){
        if(this.state == STATE.GOLD){
            this.state = STATE.SILVER;
        }

        else{
            this.state = STATE.GOLD;
        }

    }

    public String toString(){
        if(this.state == STATE.GOLD){
            return "O";
        }

       else{
            return "X";
        }
    }

    public void display(){
        System.out.print(this.toString());
    }

    public Coin.STATE getState(){
        return this.state;
    }
    public boolean equals(Coin c){
        return this.state == c.state;
    }

}
