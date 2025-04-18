package com.mediq;

import com.mediq.dao.MedicineStore;
import com.mediq.model.Medicine;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
    	port(9090);
        staticFiles.location("/public");

        post("/donate", (req, res) -> {
            String name = req.queryParams("name");
            String expiry = req.queryParams("expiry");
            String quantity = req.queryParams("quantity");

            Medicine m = new Medicine(name, expiry, Integer.parseInt(quantity));
            MedicineStore.add(m);

            res.redirect("/");
            return null;
        });

        get("/list", (req, res) -> MedicineStore.listAllAsJson());
    }
}