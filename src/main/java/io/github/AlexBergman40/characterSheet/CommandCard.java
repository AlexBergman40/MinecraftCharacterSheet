package io.github.AlexBergman40.characterSheet;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;

import java.util.List;
import java.util.Random;

public class CommandCard implements CommandExecutor, TabExecutor {
    public static Random rand = new Random();

    Sheet character = new Sheet("Mysterious Figure");

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        if (args.length == 0){
            character.printSheet(commandSender);
            return true;
        }
        if (args.length >= 2){
            return character.editSheet(args, commandSender);
        }

        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        return List.of();
    }
}
