

public class Thief extends Character{
    public Thief(String name,Accessory accessory){
        super(name,accessory);
        this.atk += 20;
        this.def += 10;
        this.matk += 0;
        classHero="Thief";


    }
    public void doubleAttack(Character op){
        if(maxMana>=10) {
            maxMana-=10;
            if (atk > op.def) {
                double damage = (atk * 2) - op.def;
                System.out.println(this.name + " used double attack to " + op.name + " " + damage + " damage ");
                if (op.maxHp <= damage) {
                    op.maxHp = 0;
                    this.levelUp();
                    System.out.println(op.name + " is dead!");
                } else {
                    op.maxHp -= (atk * 2) - op.def;
                }
            } else {
                System.out.println(this.name + " used double attack to " + op.name + " 0 damage ");
            }
        }else{
            System.out.println(this.name+" : Not enough mana!");
        }
    }


}
