package ru.lesson.lessons;

public class Dog implements IPet {

    public static final String DOG_SOUND = "GAV-GAV...";
    private final Animal dog;

    public Dog(final Animal dog) {
        this.dog = dog;
    }
    public Dog(String name){
        this(new Animal(name));
    }
    @Override
    public String getName() {
        return this.dog.getName();
    }
    @Override
    public void setName(String name) {
        this.dog.setName(name);
    }
    @Override
    public void getVoice(){
        System.out.println(String.format("%s speaks: %s",this.getName(),DOG_SOUND));
    }
    @Override
    public String getPetType(){
        return "dog";
    }
}
