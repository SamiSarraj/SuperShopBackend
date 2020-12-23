package com.sami.supershop.utility;

import java.util.ArrayList;
import java.util.List;

public class DataStructureUtils {
    public static <T> List<T> toList(Iterable<T> iter) {
        List<T> list = new ArrayList<T>();
        iter.forEach(list::add);
        return list;
    }
}
