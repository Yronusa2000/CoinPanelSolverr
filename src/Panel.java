import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Panel {

    public enum OPERATION{
        L1,
        L2,
        L3,

        C1,
        C2,
        C3,

        DIAG1,
        DIAG2
    }
    Coin a1;
    Coin a2;
    Coin a3;

    Coin b1;
    Coin b2;
    Coin b3;

    Coin c1;
    Coin c2;
    Coin c3;

    static Panel.OPERATION[] opArray = new Panel.OPERATION[]{
            Panel.OPERATION.L1,
            Panel.OPERATION.L2,
            Panel.OPERATION.L3,

            Panel.OPERATION.C1,
            Panel.OPERATION.C2,
            Panel.OPERATION.C3,

            Panel.OPERATION.DIAG1,
            Panel.OPERATION.DIAG2,

    };

    static List<Panel.OPERATION> op = Arrays.asList(opArray);
    public static final List<List<Panel.OPERATION>> allSubsetOfOperations = Main.subsets(op);


    public Panel(Coin a1, Coin a2, Coin a3, Coin b1, Coin b2, Coin b3, Coin c1, Coin c2, Coin c3) {

        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;

        this.b1 = b1;
        this.b2 = b2;
        this.b3 = b3;

        this.c1 = c1;
        this.c2 = c2;
        this.c3 = c3;
    }

    public void operate(OPERATION op){
        switch(op){
            case L1:
                this.l1();
                break;
            case L2:
                this.l2();
                break;
            case L3:
                this.l3();
                break;

            case C1:
                this.col1();
                break;
            case C2:
                this.col2();
                break;
            case C3:
                this.col3();
                break;
            case DIAG1:
                this.diag1();
                break;
            case DIAG2:
                this.diag2();

        }
    }

    public void operate(List<OPERATION> ops){
        for(OPERATION op : ops){
            this.operate(op);
        }
    }

    public List<Coin> getCoins(){
        List<Coin> coins = new ArrayList<>();
        coins.add(this.a1);
        coins.add(this.a2);
        coins.add(this.a3);

        coins.add(this.b1);
        coins.add(this.b2);
        coins.add(this.b3);

        coins.add(this.c1);
        coins.add(this.c2);
        coins.add(this.c3);

        return coins;
    }

    public boolean isComplete(){

        Panel completeGoldPanel = new Panel(
                new Coin(Coin.STATE.GOLD), new Coin(Coin.STATE.GOLD), new Coin(Coin.STATE.GOLD),
                new Coin(Coin.STATE.GOLD), new Coin(Coin.STATE.GOLD),new Coin(Coin.STATE.GOLD),
                new Coin(Coin.STATE.GOLD), new Coin(Coin.STATE.GOLD), new Coin(Coin.STATE.GOLD));

        Panel completeSilverPanel = new Panel(
                new Coin(Coin.STATE.SILVER), new Coin(Coin.STATE.SILVER),new Coin(Coin.STATE.SILVER),
                new Coin(Coin.STATE.SILVER), new Coin(Coin.STATE.SILVER),new Coin(Coin.STATE.SILVER),
                new Coin(Coin.STATE.SILVER), new Coin(Coin.STATE.SILVER), new Coin(Coin.STATE.SILVER));

        return (this.equals(completeGoldPanel) || this.equals(completeSilverPanel));
    }

    public boolean equals(Panel save){
        List<Coin> coins = this.getCoins();
        List<Coin> coins2 = save.getCoins();
        for(int i = 0; i < coins.toArray().length; i++){
            if(!coins.get(i).equals(coins2.get(i))){
                return false;
            }

        }

        return true;
    }



    public void l1(){
        this.a1.flip();
        this.a2.flip();
        this.a3.flip();
    }



    public void l2(){
        this.b1.flip();
        this.b2.flip();
        this.b3.flip();
    }
    public void l3(){
        this.c1.flip();
        this.c2.flip();
        this.c3.flip();
    }

    public void col1(){
        this.a1.flip();
        this.b1.flip();
        this.c1.flip();
    }

    public void col2(){
        this.a2.flip();
        this.b2.flip();
        this.c2.flip();
    }
    public void col3(){
        this.a3.flip();
        this.b3.flip();
        this.c3.flip();
    }

    public void diag1(){
        this.a1.flip();
        this.b2.flip();
        this.c3.flip();
    }

    public void diag2(){
        this.a3.flip();
        this.b2.flip();
        this.c1.flip();
    }

    public void display(){
        System.out.println(this.a1.toString() + " " + this.a2.toString() + " " + this.a3.toString());
        System.out.println(this.b1.toString() + " " + this.b2.toString() + " " + this.b3.toString());
        System.out.println(this.c1.toString() + " " + this.c2.toString() + " " + this.c3.toString());
        System.out.println();
    }

    public List<OPERATION> isSolvable(){
        Panel save = this;

        for(List<Panel.OPERATION> operationSubset : allSubsetOfOperations){

            this.operate(operationSubset);

            if(this.isComplete()){
                System.out.println("SOLVABLE !!!");
                System.out.println(operationSubset);
                return operationSubset;
            }

            else{
                this.set(save);
                // RESET le panel pr passer à autre chose.
            }
        }

        System.out.println("UNSOLVABLE");
        return null;
    }

    private void set(Panel save) {

        this.a1.state = save.a1.getState();
        this.a2.state = save.a2.getState();
        this.a3.state = save.a3.getState();

        this.b1.state = save.b1.getState();
        this.b2.state = save.b2.getState();
        this.b3.state = save.b3.getState();

        this.c1.state = save.c1.getState();
        this.c2.state = save.c2.getState();
        this.c3.state = save.c3.getState();
    }
}
