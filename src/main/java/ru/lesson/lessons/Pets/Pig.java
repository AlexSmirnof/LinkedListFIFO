package ru.lesson.lessons.Pets;


import ru.lesson.lessons.Animal;
import ru.lesson.lessons.IPet;

public class Pig implements IPet {

    private static final String PIG_SOUND = "HRYU-HRYU...";
    private final Animal pig;

    public Pig(final Animal pig) {
        this.pig = pig;
    }
    public Pig(String name) {
        this(new Animal(name));
    }
    @Override
    public String getName() {
        return this.pig.getName();
    }
    @Override
    public void setName(String name) {
        this.pig.setName(name);
    }
    @Override
    public void getVoice(){
        System.out.println(String.format("%s speaks: %s",this.getName(),PIG_SOUND));
    }
    @Override
    public String getPetType(){
        return "pig";
    }
}
