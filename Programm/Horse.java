package Programm;

public class Horse extends Animal {
    public Horse(String name, String skills) {
        super(name, skills);
    }

    @Override
    public void commands() {
        System.out.println("Команды для лошади " + getName() + ": " + getSkills());
    }

    @Override
    public void teachNewCommand(String command) {
        String updatedSkills = getSkills() + "," + command;
        setSkills(updatedSkills);
        System.out.println("Лошадь " + getName() + " научилась новой команде: " + command);
    }
}