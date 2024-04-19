package org.common.commands;

import org.common.utility.Console;

import java.io.Serial;
import java.io.Serializable;

/**
 * The clear collection command
 */
public class Clear extends Command implements Serializable {
    @Serial
    private static final long serialVersionUID = "Clear".hashCode();


    @Override
    public void execute() {
        collection.clearCollection();
        console.addToSend("Коллекция очищена",getAddress());
        console.send(getAddress());
    }
}
