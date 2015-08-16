package ru.lesson.lessons;

public class Cat implements IPet {

    private static final String CAT_SOUND = "MYAU-MYAU...";
    private final Animal cat;

    public Cat(final Animal cat) {
        this.cat = cat;
    }
    public Cat(String name) {
        this(new Animal(name));
    }
    @Override
    public String getName() {
        return this.cat.getName();
    }
    @Override
    public void setName(String name) {
        this.cat.setName(name);
    }
    @Override
    public void getVoice(){
        System.out.println(String.format("%s speaks: %s",this.getName(),CAT_SOUND));
    }
    @Override
    public String getPetType(){
        return "cat";
    }
}
