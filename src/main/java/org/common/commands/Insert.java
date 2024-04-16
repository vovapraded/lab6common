package org.common.commands;


import org.common.utility.Console;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * Add item command
 */
public class Insert extends Command implements Serializable {
    @Serial
    private static final long serialVersionUID = "Insert".hashCode();


    @Override
    public void execute() {
        var idStr = stringArg;
        Long id = ValidateId.validateId(idStr, true, collection);
        ticketArg.setId(id);
        ticketArg.setCreationDate(new Date());
        collection.insertElement(ticketArg);
        console.addToSend("Билет успешно введён");
        console.send();
    }
}