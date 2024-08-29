package io.github.AlexBergman40.characterSheet;

import org.bukkit.command.CommandSender;

public class Sheet {
    static String[] statNames = new String[]{"Strength", "Dexterity", "Constitution", "Intelligence", "Wisdom", "Charisma"};

    String characterName, characterClass;
    Integer[] statValues = new Integer[statNames.length];


    public Sheet(String characterName) {
        //if characterName exists
        //load sheet from file
        //else initialize character
        this.characterName = characterName;
        this.characterClass = "Commoner";
        int roll;
        for (int i = 0; i < statNames.length; i++) {
            roll = 0;
            for (int j = 0; j < 2; j++) {
                roll += CommandCard.rand.nextInt(6) + 1;
            }
            statValues[i] = roll;
        }
    }

    public boolean editSheet(String[] args, CommandSender sender) {
        if (args[0].equals("Name")) {
            int nameLength = args.length - 1;
            characterName = "";
            for (int i = 0; i < nameLength; i++) {
                characterName = characterName.concat(args[i + 1]).concat(" ");
            }
            sender.sendMessage("Name: ".concat(characterName));
            return true;
        }
        int i = 0;
        for (String statName : statNames) {
            if (statName.equals(args[0])) {
                try {
                    statValues[i] = Integer.parseInt(args[1]);
                }
                catch (NumberFormatException e) {
                    return false;
                }
                sender.sendMessage(statName.concat(": ").concat(String.valueOf(args[1])));
                return true;
            }
            i++;
        }
        return false;
    }

    public void printSheet(CommandSender commandSender){
        String sheet = "Name: ".concat(characterName);
        commandSender.sendMessage(sheet);
        sheet = "Class: ".concat(characterClass);
        commandSender.sendMessage(sheet);
        for (int i = 0; i < statNames.length; i++){
            sheet = statNames[i].concat(": ").concat(statValues[i].toString());
            commandSender.sendMessage(sheet);
        }
    }
}
