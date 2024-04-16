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
        console.addToSend("Завершение работы");
        console.send();
        System.exit(0);
    }
}
