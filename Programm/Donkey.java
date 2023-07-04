package Programm;

public class Donkey extends Animal {
    public Donkey(String name, String skills) {
        super(name, skills);
    }

    @Override
    public void commands() {
        System.out.println("Команды для осла " + getName() + ": " + getSkills());
    }

    @Override
    public void teachNewCommand(String command) {
        String updatedSkills = getSkills() + "," + command;
        setSkills(updatedSkills);
        System.out.println("Осёл " + getName() + " научилася новой команде: " + command);
    }
}