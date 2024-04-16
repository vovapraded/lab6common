package org.common.commands;

import org.common.utility.Console;

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
        collection.removeElement(ValidateId.validateId(idStr,false,collection));
        console.addToSend("Элемент удалён");
        console.send();

    }
}