package ru.lesson.lessons.Pets;

import ru.lesson.lessons.Animal;
import ru.lesson.lessons.IPet;

public class Cow implements IPet{

    private static final String COW_SOUND = "MU-MUU...";
    private final Animal cow;

    public Cow(final Animal cow) {
        this.cow = cow;
    }
    public Cow(String cow) {
        this(new Animal(cow));
    }
    @Override
    public String getName() {
        return this.cow.getName();
    }
    @Override
    public void setName(String name) {
        this.cow.setName(name);
    }
    @Override
    public void getVoice(){
        System.out.println(String.format("%s speaks: %s",this.getName(),COW_SOUND));
    }
    @Override
    public String getPetType(){
        return "cow";
    }
}
