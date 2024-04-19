package org.common.commands;

import org.common.utility.Console;

import java.io.Serial;
import java.io.Serializable;

/**
 * The shutdown command
 */
public class Exit extends Command implements Serializable {
    @Serial
    private static final long serialVersionUID = "Exit".hashCode();


    @Override
    public void execute() {
        console.addToSend("Завершение работы",getAddress());
        console.send(getAddress());
        System.exit(0);
    }
}
