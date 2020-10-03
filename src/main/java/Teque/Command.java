package Teque;

import java.util.Objects;
import java.util.Optional;

public class Command {
    public int getIdxOrValue() {
        return idxOrValue;
    }

    enum CommandType {
        GET, PUSH_BACK, PUSH_MIDDLE, PUSH_FRONT;
    }
    private String command;
    private Optional<String> detail;
    private int idxOrValue;

    public Command(String command, String detail, String value) {
        this.command = command;
        this.detail = Optional.of(detail);
        this.idxOrValue = Integer.parseInt(value);
    }
    public Command(String command, String idx) {
        this.command = command;
        this.detail = Optional.empty();
        this.idxOrValue = Integer.parseInt(idx);
    }
    public CommandType getCommandType() {
        if (detail.isEmpty()) {
            return CommandType.GET;
        }

        if (Objects.equals(detail.get(), "back")) {
            return CommandType.PUSH_BACK;
        } else if (Objects.equals(detail.get(), "middle")) {
            return CommandType.PUSH_MIDDLE;
        } else { //we assume valid input
            return CommandType.PUSH_FRONT;
        }
    }

}
