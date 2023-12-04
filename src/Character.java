import java.util.Objects;

public class Character {
    public String name;
    protected double maxHp = 100;
    protected double maxMana = 50;
    protected double runSpeed;
    protected double atk;
    protected double def;
    protected double matk;
    protected int lvl;
    protected String classHero;

    protected Accessory accessory;
    protected Character(String name,Accessory accessory){
        this.name = name;
        this.runSpeed+=100;
        if(accessory!=null){

            if(Objects.equals(accessory.type, "Ring")){
                this.accessory=new Ring(accessory.name,accessory.lvl);
                this.matk=this.matk+this.accessory.getMatk();
            }
            if(Objects.equals(accessory.type, "Boots")){
                this.accessory= new Boots(accessory.name,accessory.lvl);
                this.runSpeed=this.runSpeed-this.accessory.getHeavy()+this.accessory.getRunSpeed();

            }
        }
    }
    public void attack(Character op){
        if(atk>op.def) {
            double damage = atk-op.def;
            System.out.println(this.name+" attacked "+op.name+" "+damage +" damage ");
            if(op.maxHp<=damage){
                op.maxHp=0;
                this.levelUp();
                System.out.println(op.name+" is dead!");
            }else{
                op.maxHp-=atk-op.def;
            }
        }else{
            System.out.println(this.name+" attacked "+op.name+ " 0 damage ");
        }
    }
    protected void levelUp(){
        System.out.println(this.name+" level up!");
        lvl++;
        maxHp=100+(10*lvl);
        maxMana=100+(10*lvl);
        runSpeed= 10 +(2*lvl);
        if(classHero.equals("Mage")){
            matk = 20+(2*lvl);
            atk = 10+(lvl);
            def = 5+(lvl);
        }
        if(classHero.equals("Thief")){
            atk = 20+(2*lvl);
            def = 10+(lvl);
        }
        if(accessory!=null) {
            if(Objects.equals(accessory.type, "Ring")){
                this.accessory= new Ring(accessory.name,accessory.getLvl()+1);
                this.matk+=accessory.getMatk();

            }
            if(Objects.equals(accessory.type, "Boots")){

                this.accessory= new Boots(accessory.name,accessory.getLvl()+1);
                this.runSpeed=this.runSpeed-this.accessory.getHeavy()+this.accessory.getRunSpeed();


            }

        }
    }
    public void show(){
        System.out.println("Name :"+name);
        System.out.println("Hp : "+this.maxHp);
        System.out.println("Mana : "+this.maxMana);
        System.out.println("damage : "+ this.atk);
        System.out.println("def : "+ this.def);
        System.out.println("magic attack : "+matk);
        System.out.println("level : "+this.lvl);
        System.out.println("runSpeed : "+this.runSpeed);
        System.out.println("Class : "+this.classHero);
        if(accessory==null) System.out.println("accessory : none");
        else System.out.println("accessory : "+accessory.name);

    }

}
