package org.common.commands;


import org.common.dto.Ticket;
import org.common.managers.*;
import org.common.utility.*;


import java.io.Serial;
import java.io.Serializable;

/**
 * The remove items with a price higher than the specified one command
 */
public class RemoveGreater extends Command implements Serializable {
    @Serial
    private static final long serialVersionUID = "RemoveGreater".hashCode();



    @Override
    public void execute() {
            Ticket ticket = ticketArg;
            collection.removeGreater(ticket);
            console.addToSend("Удалено успешно");
        console.send();

    }
}