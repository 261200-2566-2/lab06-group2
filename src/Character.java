import java.util.Objects;

public interface Character {
    /**
     * Return name
     * @return player's name
     */
    String name();

    /**
     * Return max HP
     * @return player's maxHP
     */
    double maxHp();

    /**
     * Set max HP
     * effects : change player's HP
     * @param number that want to change
     */
    void setMaxHp(double i);
    /**
     * Return max mana
     * @return player's maxMana
     */
    double maxMana();
    /**
     * Set max mana
     * effects : change player's mana
     * @param number that want to change
     */
    void setMaxMana(double i);
    /**
     * Return speed
     * @return player's runSpeed
     */
    double runSpeed();
    /**
     * Set speed
     * effects : change player's runSpeed
     * @param number that want to change
     */
    void setRunSpeed(double i);
    /**
     * Return atk
     * @return player's atk
     */
    double atk();
    /**
     * Set atk
     * effects : change player's atk
     * @param number that want to change
     */
    void setAtk(double i);
    /**
     * Return def
     * @return player's def
     */
    double def();
    /**
     * Set defense
     * effects : change player's def
     * @param number that want to change
     */
    void setDef(double i);
    /**
     * Return magic attack
     * @return player's matk
     */
    double getMatk();
    /**
     * Set magic attack
     * effects : change player's matk
     * @param number that want to change
     */
    void setMatk(double i);
    /**
     * Return level
     * @return player's lvl
     */
    int getLvl();
    /**
     * Set level
     * effects : change player's lvl
     * @param number that want to change
     */
    void setLvl(int i);
    /**
     * Return class
     * @return player's classHero
     */
    String classHero();
    /**
     * Return accessory
     * @return player's accessory
     */
    Accessory accessory();
    /**
     * Set accessory
     * effects : change player's accessory and level up that accessory
     * @param accessory that want to change
     */
    void setAccessory(Accessory i,String t);

    /**
     * make this player attack other player
     * effects: decrease HP of other player depend on ATK
     * @param 1 Character that exist
     */
    default void attack(Character op){
        if(atk()>op.def()) {
            double damage = atk()-op.def();
            System.out.println(this.name()+" attacked "+op.name()+" "+damage +" damage ");
            if(op.maxHp()<=damage){
                op.setMaxHp(0);
                this.levelUp();
                System.out.println(op.name()+" is dead!");
            }else{
                op.setMaxHp(op.maxHp()-(atk()-op.def()));
            }
        }else{
            System.out.println(this.name()+" attacked "+op.name()+ " 0 damage ");
        }
    }

    /**
     * make user and accessory level up and get buff stat
     * effects:Increase lvl , ATK , speed , def , matk , change accessory
     */
    default void levelUp(){
        System.out.println(this.name()+" level up!");
        setLvl(this.getLvl()+1);
        setMaxHp(100+(10*this.getLvl()));
        setMaxMana(100+(10*getLvl()));
        setRunSpeed(10 +(2*getLvl()));
        if(classHero().equals("Mage")){
            setMatk(20+(2*getLvl()));
            setAtk(10+(getLvl()));
            setDef(5+getLvl());
        }
        if(classHero().equals("Thief")){
            setAtk(20+(2*getLvl()));
            setDef(10+getLvl());
        }
        if(accessory()!=null) {
            if(Objects.equals(accessory().type(), "Ring")){
                setAccessory(this.accessory(),"Ring");
                setMatk(getMatk()+accessory().getMatk());

            }
            if(Objects.equals(accessory().type(), "Boots")){
                setAccessory(this.accessory(),"Boots");
                setRunSpeed(runSpeed()- accessory().getHeavy() + accessory().getRunSpeed());
            }

        }
    }

    /**
     * Show stat of player
     */
    default void show(){
        System.out.println("Name :"+name());
        System.out.println("Hp : "+this.maxHp());
        System.out.println("Mana : "+this.maxMana());
        System.out.println("damage : "+ this.atk());
        System.out.println("def : "+ this.def());
        System.out.println("magic attack : "+getMatk());
        System.out.println("level : "+this.getLvl());
        System.out.println("runSpeed : "+this.runSpeed());
        System.out.println("Class : "+this.classHero());
        if(accessory()==null) System.out.println("accessory : none");
        else System.out.println("accessory : "+accessory().name());
    }
}
