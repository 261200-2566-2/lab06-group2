public class Accessory {
    public String name;
    protected double heavy;
    protected  int lvl;
    protected double runSpeed;
    protected double matk;
    public String type;

    /**Constructor of Accessory for create object
     *effects:create object
     * @param name String to name object
     * @param lvl value to set Level of Accessory
     * @param type String to set type of Accessory
     */
    protected Accessory(String name,int lvl,String type){
        this.name=name;
        this.type=type;
        this.lvl=lvl;
    }


    /**Return matk
     *
     * @return matk of Accessory
     */
    public double getMatk(){
        return matk;
    }

    /**Return heavy
     *
     * @return heavy of Accessory
     */
    public double getHeavy(){
        return heavy;
    }

    /**Return runSpeed
     *
     * @return runSpeed of Accessory
     */
    public double getRunSpeed(){
        return runSpeed;
    }

    /**Return Level
     *
     * @return Level of Accessory
     */
    public int getLvl(){
        return lvl;
    }

}
