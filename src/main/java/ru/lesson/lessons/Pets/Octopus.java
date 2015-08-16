package ru.lesson.lessons.Pets;

import ru.lesson.lessons.Animal;
import ru.lesson.lessons.IPet;


public class Octopus implements IPet {

    private static final String OCTOPUS_SOUND = "BUL-BUL...";
    private final Animal octopus;

    public Octopus(final Animal octopus) {
        this.octopus = octopus;
    }
    public Octopus(String name) {
        this(new Animal(name));
    }
    @Override
    public String getName() {
        return this.octopus.getName();
    }
    @Override
    public void setName(String name) {
        this.octopus.setName(name);
    }
    @Override
    public void getVoice(){
        System.out.println(String.format("%s speaks: %s",this.getName(),OCTOPUS_SOUND));
    }
    @Override
    public String getPetType(){
        return "octopus";
    }
}
