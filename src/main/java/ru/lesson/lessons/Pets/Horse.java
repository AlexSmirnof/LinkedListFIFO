package ru.lesson.lessons.Pets;


import ru.lesson.lessons.Animal;
import ru.lesson.lessons.IPet;

public class Horse implements IPet {

    private static final String HORSE_SOUND = "II-III FR....";
    private final Animal horse;

    public Horse(final Animal horse) {
        this.horse = horse;
    }
    public Horse(String name) {
        this(new Animal(name));
    }
    @Override
    public String getName() {
        return this.horse.getName();
    }
    @Override
    public void setName(String name) {
        this.horse.setName(name);
    }
    @Override
    public void getVoice(){
        System.out.println(String.format("%s speaks: %s",this.getName(),HORSE_SOUND));
    }
    @Override
    public String getPetType(){
        return "horse";
    }
}
