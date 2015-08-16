package ru.lesson.lessons.Pets;

import ru.lesson.lessons.Animal;
import ru.lesson.lessons.IPet;


public class Mouse implements IPet {

    private static final String MOUSE_SOUND = "PI-PII...";
    private final Animal mouse;

    public Mouse(final Animal mouse) {
        this.mouse = mouse;
    }
    public Mouse(String name) {
        this(new Animal(name));
    }
    @Override
    public String getName() {
        return this.mouse.getName();
    }
    @Override
    public void setName(String name) {
        this.mouse.setName(name);
    }
    @Override
    public void getVoice(){
        System.out.println(String.format("%s speaks: %s",this.getName(),MOUSE_SOUND));
    }
    @Override
    public String getPetType(){
        return "mouse";
    }
}
