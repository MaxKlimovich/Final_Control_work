package Programm;

public class Dog extends Animal {
    public Dog(String name, String skills) {
        super(name, skills);
    }

    @Override
    public void commands() {
        System.out.println("Команды для собаки " + getName() + ": " + getSkills());
    }

    @Override
    public void teachNewCommand(String command) {
        String updatedSkills = getSkills() + "," + command;
        setSkills(updatedSkills);
        System.out.println("Собака " + getName() + " научилась новой команде: " + command);
    }
}