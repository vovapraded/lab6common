package org.common.commands;

import org.common.dto.Ticket;
import org.common.utility.Console;
import org.common.utility.InvalidFormatException;

import java.io.Serial;
import java.io.Serializable;

/**
 * The command to update the ticket
 */
public class Update extends Command implements Serializable {
    @Serial
    private static final long serialVersionUID = "Update".hashCode();



    public void execute(){
        var idStr = stringArg;
        Long id = null;
        try {
            id = ValidateId.validateId(idStr, false, collection);
        }catch (InvalidFormatException e){
            e.setAddress(getAddress());
            throw e;
        }        collection.removeElement(id);
            Insert ins = new Insert ();
            ins.setStringArg(stringArg);
            ins.setTicketArg(ticketArg);
            ins.setConsole(console);
            ins.setAddress(getAddress());
            ins.execute();

    }
}
