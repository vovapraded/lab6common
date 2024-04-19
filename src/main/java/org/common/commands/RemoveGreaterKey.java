package org.common.commands;


import org.common.utility.Console;
import org.common.utility.InvalidFormatException;

import java.io.Serial;
import java.io.Serializable;

/**
 * The command to delete items with an id greater than the specified number
 */
public class RemoveGreaterKey extends Command implements  Serializable {
    @Serial
    private static final long serialVersionUID = "RemoveGreaterKey".hashCode();



    @Override
    public void execute() {
            var idStr=stringArg;
            Long id = null;
        try {
            ValidateId.validateId(idStr, false, collection);
        }catch (InvalidFormatException e){
            e.setAddress(getAddress());
            throw e;
        }            int sizeBefore = collection.getCountOfElements();
            collection.removeGreaterKey(id);
            int sizeAfter = collection.getCountOfElements();
            if (sizeAfter != sizeBefore) {
                console.addToSend("Успешно удалено",getAddress());
            }else {
                console.addToSend("Нет таких элементов",getAddress());
            }
        console.send(getAddress());



    }
}