package org.common.commands;

import org.common.dto.Ticket;
import org.common.managers.*;
import org.common.utility.*;

import java.io.Serial;
import java.io.Serializable;


/**
 * The command to replace the item price if it is higher
 */
public class ReplaceIfGreater extends Command implements Serializable {
    @Serial
    private static final long serialVersionUID = "ReplaceIfGreater".hashCode();


    public void execute(){
        var idstr = stringArg;
        ValidateId.validateId(idstr,false,collection);
        Long id = Long.parseLong(idstr);
        Ticket oldTicket = collection.getElement(id);
        System.out.println(oldTicket);
        Ticket newTicket = ticketArg ;
        System.out.println(newTicket);

        if (newTicket.compareTo(oldTicket)>0){
            console.addToSend("Операция прошла успешно. Замена произошла");
            collection.removeElement(id);
            newTicket.setId(id);
            collection.insertElement(newTicket);
        }
        else {
            console.addToSend("Операция прошла успешно. Замена не произошла");
        }
        console.send();

    }
}
