package org.common.commands;

import org.common.managers.Collection;
import org.common.utility.InvalidFormatException;
import org.common.utility.*;


/**
 * A class for checking element IDs
 */
public class ValidateId {
    public static Long validateId(String idstr, boolean mustBeUnique, Collection collection){
        if (!Validator.validate(idstr, TypesOfArgs.Long,false)){
            throw new InvalidFormatException("Id должен быть числом");
        }
        Long id = Long.parseLong(idstr);
        if (id<=0){
            throw new InvalidFormatException("Id должен быть больше нуля");
        }
        String ne = mustBeUnique ? "" :" не";
        if (mustBeUnique == collection.getHashMap().containsKey(id)) {
            throw new InvalidFormatException("Неправильный формат ввода id"+ne +" должен быть уникальным");
        }
        return Long.parseLong(idstr);
    }
}
