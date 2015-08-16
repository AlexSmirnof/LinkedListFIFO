package ru.lesson.lessons.Pets;

import ru.lesson.lessons.Animal;
import ru.lesson.lessons.IPet;


public class Bird implements IPet {

    private static final String BIRD_SOUND = "CHICK-CHIRICK...";
    private final Animal bird;

    public Bird(final Animal bird) {
        this.bird = bird;
    }
    public Bird(String name) {
        this(new Animal(name));
    }
    @Override
    public String getName() {
        return this.bird.getName();
    }
    @Override
    public void setName(String name) {
        this.bird.setName(name);
    }
    @Override
    public void getVoice(){
        System.out.println(String.format("%s speaks: %s",this.getName(),BIRD_SOUND));
    }
    @Override
    public String getPetType(){
        return "bird";
    }
}
