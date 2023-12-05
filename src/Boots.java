public class Boots implements Accessory{
    public String name;
    protected double heavy;
    protected  int lvl;
    protected double runSpeed;
    protected double matk;
    public String type;
    public String name(){return name;}
    public String type(){return type;}
    public double getMatk(){
        return matk;
    }

    public double getHeavy(){
        return heavy;
    }

    public double getRunSpeed(){
        return runSpeed;
    }
    public int getLvl(){
        return lvl;
    }
    public Boots(String name,int lvl){
        this.name=name;
        this.type="Boots";
        this.lvl=lvl;
        runSpeed+=10+(lvl);
        heavy=10+(0.1*lvl);
    }




}
