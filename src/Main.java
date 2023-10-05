import jdk.dynalink.Operation;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {



        Panel cas1 = new Panel(
                new Coin(Coin.STATE.GOLD), new Coin(Coin.STATE.GOLD),new Coin(Coin.STATE.GOLD),

                new Coin(Coin.STATE.SILVER), new Coin(Coin.STATE.SILVER),new Coin(Coin.STATE.SILVER),

                new Coin(Coin.STATE.GOLD), new Coin(Coin.STATE.GOLD), new Coin(Coin.STATE.GOLD));

        Panel panelToSolve = new Panel(
                new Coin(Coin.STATE.SILVER), new Coin(Coin.STATE.GOLD),new Coin(Coin.STATE.GOLD),
                new Coin(Coin.STATE.GOLD), new Coin(Coin.STATE.SILVER),new Coin(Coin.STATE.GOLD),
                new Coin(Coin.STATE.GOLD), new Coin(Coin.STATE.GOLD), new Coin(Coin.STATE.SILVER));

       panelToSolve.isSolvable();
       cas1.isSolvable();

       System.out.println(Panel.allSubsetOfOperations);
    }

    public static void calcSubset(List<Panel.OPERATION> A, List<List<Panel.OPERATION>> res, List<Panel.OPERATION> subset, int index) {
        res.add(new ArrayList<>(subset));
        for (int i = index; i < A.size(); i++) {
            subset.add(A.get(i));
            calcSubset(A, res, subset, i + 1);
            subset.remove(subset.size() - 1);
        }
    }

    public static List<List<Panel.OPERATION>> subsets(List<Panel.OPERATION> A)
    {
        List<Panel.OPERATION> subset = new ArrayList<>();
        List<List<Panel.OPERATION>> res = new ArrayList<>();
        int index = 0;
        calcSubset(A, res, subset, index);
        return res;
    }





}