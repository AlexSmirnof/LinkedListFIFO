package ru.lesson.lessons.Pets;


import ru.lesson.lessons.Animal;
import ru.lesson.lessons.IPet;

public class Snake implements IPet {

    private static final String SNAKE_SOUND = "SS-SSS...";
    private final Animal snake;

    public Snake(final Animal snake) {
        this.snake = snake;
    }
    public Snake(String name) {
        this(new Animal(name));
    }
    @Override
    public String getName() {
        return this.snake.getName();
    }
    @Override
    public void setName(String name) {
        this.snake.setName(name);
    }
    @Override
    public void getVoice(){
        System.out.println(String.format("%s speaks: %s",this.getName(),SNAKE_SOUND));
    }
    @Override
    public String getPetType(){
        return "snake";
    }
}
