public class Boots extends Accessory{
    /**Create Boots object
     * effects:create object
     * @param name String to name object
     * @param lvl value to set Level of object
     */
    public Boots(String name,int lvl){
        super(name,lvl,"Boots");
        runSpeed+=10+(lvl);
        heavy=10+(0.1*lvl);
    }




}
