package org.common.commands;

import org.common.dto.Ticket;
import org.common.utility.Console;

import java.io.Serial;
import java.io.Serializable;

/**
 * The command to update the ticket
 */
public class Update extends Command implements Serializable {
    @Serial
    private static final long serialVersionUID = "Update".hashCode();



    public void execute(){
        var idstr = stringArg;
        Long id = ValidateId.validateId(idstr,false,collection);
        collection.removeElement(id);
            Insert ins = new Insert ();
            ins.setStringArg(stringArg);
            ins.setTicketArg(ticketArg);
            ins.setConsole(console);
            ins.execute();

    }
}
