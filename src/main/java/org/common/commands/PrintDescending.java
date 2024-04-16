package org.common.commands;

import org.common.utility.Console;

import java.io.Serial;
import java.io.Serializable;
import java.util.Comparator;

/**
 * The command to display the collection in reverse order
 */
public class PrintDescending extends Command implements Serializable {
    @Serial
    private static final long serialVersionUID = "PrintDescending".hashCode();


    @Override
    public void execute() {
        if (collection.getHashMap().isEmpty()){
            console.addToSend("Коллекция пуста");
        }
        else{
            collection.getHashMap().values().stream()
                    .sorted(Comparator.reverseOrder())
                    .forEach(ticket -> console.addToSend(ticket.toString()) );
        }
        console.send();

    }
}