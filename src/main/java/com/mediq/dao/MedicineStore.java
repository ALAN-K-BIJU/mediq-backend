package com.mediq.dao;

import com.google.gson.Gson;
import com.mediq.model.Medicine;

import java.util.ArrayList;
import java.util.List;

public class MedicineStore {
    private static final List<Medicine> store = new ArrayList<>();
    private static final Gson gson = new Gson();

    public static void add(Medicine m) {
        store.add(m);
    }

    public static String listAllAsJson() {
        return gson.toJson(store);
    }
}