import java.util.Objects;

public class Mage implements Character{
    public String name;
    public String name(){return this.name;}
    protected double maxHp = 100;
    public double maxHp(){return this.maxHp;}
    public void setMaxHp(double i){this.maxHp=i;}
    protected double maxMana = 50;
    public double maxMana(){return this.maxMana;}
    public void setMaxMana(double i){this.maxMana=i;}
    protected double runSpeed;
    public double runSpeed(){return this.runSpeed;}
    public void setRunSpeed(double i){this.runSpeed=i;}
    protected double atk;
    public double atk(){return this.atk;}
    public void setAtk(double i){this.atk = i;}
    protected double def;
    public double def(){return this.def;}
    public void setDef(double i){this.def = i;}
    protected double matk;
    public void setMatk(double i){this.matk = i;}
    public double getMatk(){return this.atk;}
    protected int lvl;
    public int getLvl(){return this.lvl;}
    public void setLvl(int t){this.lvl=t;}
    protected String classHero;
    public String classHero(){return this.classHero;}

    protected Accessory accessory;
    public Accessory accessory(){return this.accessory;}
    public void setAccessory(Accessory i,String t) {
        if (t.equals("Ring")) this.accessory = new Ring(i.name(), i.getLvl() + 1);
        if (t.equals("Boots")) this.accessory = new Boots(i.name(), i.getLvl() + 1);
    }
    public Mage(String name,Accessory accessory){
        this.name = name;
        this.runSpeed+=100;
        if(accessory!=null){

            if(Objects.equals(accessory.type(), "Ring")){
                this.accessory=new Ring(accessory.name(),accessory.getLvl());
                this.matk=this.matk+this.accessory.getMatk();
            }
            if(Objects.equals(accessory.type(), "Boots")){
                this.accessory= new Boots(accessory.name(),accessory.getLvl());
                this.runSpeed=this.runSpeed-this.accessory.getHeavy()+this.accessory.getRunSpeed();

            }
        }
        this.matk+=20;
        this.atk+= 10;
        this.def+= 5;
        classHero="Mage";
    }

    /**
     * This player use magic attack to other player
     * effect: decrease opponent's hp depend on matk
     * @param 1 character that exist
     */
    public void magicAttack(Character op){
        if(maxMana>=20){
            maxMana-=20;
            double damage = matk*2;
            System.out.println(this.name+" used magic attack to "+op.name()+" "+damage +" damage ");
            if(op.maxHp()<=damage){
                op.setMaxHp(0);
                this.levelUp();
                System.out.println(op.name()+" is dead!");
            }else{
                op.setMaxHp(op.maxHp()-damage);
            }
        }else{
            System.out.println(this.name+" : Not enough mana!");
        }
    }
}
