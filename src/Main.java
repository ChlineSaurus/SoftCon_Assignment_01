public class Main {
    public static void main(String[] args) {
        assert 1==0;
        int x = 0;
        System.out.println("Hello world!");
        System.out.println(x);
        System.out.println("testing");
        int z=0;
       /* Battleship a=new Battleship();
        System.out.println(a.currenthitpoints());
        a.isHit();
        System.out.println(a.currenthitpoints());
        System.out.println(a.issunk());
        a.isHit();
        System.out.println(a.currenthitpoints());
        a.isHit();
        a.isHit();
        System.out.println(a.issunk());
        System.out.println(a.currenthitpoints());
        //the boat now has 0 hitpoints and ishit is called

        a.isHit();

        System.out.println(a.currenthitpoints());
        System.out.println(a.currenthitpoints());
        */

        GameManager first = new GameManager();
        first.ManageGame();
        Display test = new DisplayGrid();
        test.DisplayGrid();
        test.DisplayRecivedText();
    }
}
