public class Lab05 {
    public static void main(String[] args) {

        Mage wayu = new Mage("wayu", new Ring("Lord",0));
        Thief non = new Thief("non", new Boots("non Booties",0));

        System.out.println("Show hero after created /////////////");
        wayu.show();
        System.out.println("////");
        non.show();

        System.out.println("Attack phase ///////////////////");

        non.attack(wayu);
        wayu.attack(non);
        wayu.magicAttack(non);



        wayu.show();
        System.out.println("///");
        non.show();

        System.out.println("Dead and lvl up phase/////////////////");
        non.doubleAttack(wayu);
        non.doubleAttack(wayu);
        non.doubleAttack(wayu);
        non.show();
    }
}
