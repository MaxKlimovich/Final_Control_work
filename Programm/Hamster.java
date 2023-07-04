package Programm;

public class Hamster extends Animal {
    public Hamster(String name, String skills) {
        super(name, skills);
    }

    @Override
    public void commands() {
        System.out.println("Команды для хомяка " + getName() + ": " + getSkills());
    }

    @Override
    public void teachNewCommand(String command) {
        String updatedSkills = getSkills() + "," + command;
        setSkills(updatedSkills);
        System.out.println("Хомяк " + getName() + " научилася новой команде: " + command);
    }
}