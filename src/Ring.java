public class Ring extends Accessory{
    /**Create constructor of Ring
     * effects:create object
     * @param name String to name object
     * @param lvl value to set Level of object
     */
    public Ring(String name,int lvl){
        super(name,lvl,"Ring");
        matk+=10+(lvl);
    }

}
