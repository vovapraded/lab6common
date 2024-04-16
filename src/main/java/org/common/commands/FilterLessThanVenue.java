package org.common.commands;


import org.common.dto.Ticket;
import org.common.utility.InvalidFormatException;
import org.common.utility.*;


import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * Output elements with venue.capacity less than this number
 */
public class FilterLessThanVenue extends Command implements Serializable {
    @Serial
    private static final long serialVersionUID = "FilterLessThanVenue".hashCode();



    @Override
    public void execute() {
        var capacityStr = stringArg;
        //если у каких-то билетов capacity=null то они в любом случае выписываются
            if (!Validator.validate(capacityStr,TypesOfArgs.Long,true)){
                throw new InvalidFormatException("Вместимость должна быть числом");
            }
            Long capacity= Long.parseLong(capacityStr);
            List<Ticket> filtered = collection.filterLessThanVenue(capacity);
            if (filtered.isEmpty()){
                console.addToSend("Нет таких элементов");
            }
            for (Ticket ticket : filtered){
                console.addToSend(ticket.toString());
            }
        console.send();

    }
}