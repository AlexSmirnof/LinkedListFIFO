package ru.lesson.lessons;

public interface IPet {
    /**
     * Returns name of the pet
     * @return name of the pet
     */
    String getName();
    /**
     * Set name for the pet
     * @param name Name for the pet
     */
    void setName(String name);
    /**
     * Get a specific voice for the pet
     */
    default void getVoice(){}
    /**
     * Get a type of the pet
     * @return Type of the pet
     */
    default String getPetType(){
       return null;
    }

}
