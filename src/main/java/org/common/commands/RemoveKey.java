package org.common.commands;

import org.common.utility.Console;
import org.common.utility.InvalidFormatException;

import java.io.Serial;
import java.io.Serializable;

/**
 * The delete item command
 */
public class RemoveKey extends Command implements Serializable {
    @Serial
    private static final long serialVersionUID = "RemoveKey".hashCode();


    public void execute(){
        var idStr = stringArg;
        Long id = null;
        try {
            id = ValidateId.validateId(idStr, false, collection);
        }catch (InvalidFormatException e){
            e.setAddress(getAddress());
            throw e;
        }
        collection.removeElement(id);
        console.addToSend("Элемент удалён",getAddress());
        console.send(getAddress());

    }
}
