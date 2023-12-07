public interface Accessory {
    /**get name of accessory
     *
     * @return name of accessory
     */
    String name();
    /**get type of accessory
     *
     * @return type of accessory
     */
    String type();

    /**get matk of accessory
     *
     * @return matk of accessory
     */
    double getMatk();

    /**get heavy of accessory
     *
     * @return heavy of accessory
     */
    double getHeavy();

    /**get runSpeed of accessory
     *
     * @return runSpeed of accessory
     */
    double getRunSpeed();

    /**get level of accessory
     *
     * @return level of accessory
     */
    int getLvl();
}
