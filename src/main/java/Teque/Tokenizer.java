package Teque;

import java.util.Arrays;

public class Tokenizer {
    public static Command tokenize(String fullCommand) {
        String[] commandAndIdx = fullCommand.split("\\s+");
        String command = commandAndIdx[0];
        String idxOrValue = commandAndIdx[1];
        String[] parsedCommand = command.split("_");
        if (parsedCommand.length > 1) {
            return new Command(parsedCommand[0], parsedCommand[1], idxOrValue);
        }
        return new Command(parsedCommand[0], idxOrValue);
    }
}
