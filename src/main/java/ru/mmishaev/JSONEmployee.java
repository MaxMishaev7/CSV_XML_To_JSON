package ru.mmishaev;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.PrintWriter;
import java.util.List;

public class JSONEmployee {
    public String listToJSON(List<Employee> employees) {
        JSONArray jarr = new JSONArray();
        for (Employee empl : employees) {
            JSONObject jo = new JSONObject();
            jo.put("id", String.valueOf(empl.getId()));
            jo.put("firstName", empl.getFirstName());
            jo.put("lastName", empl.getLastName());
            jo.put("age", String.valueOf(empl.getAge()));
            jarr.add(jo);
        }
        return jarr.toJSONString();
    }

    public void writeJSON(String fileName, String jsonString) {
        try(PrintWriter pw = new PrintWriter(new java.io.FileOutputStream(fileName))) {
            pw.write(jsonString);
            pw.flush();
        } catch(java.io.FileNotFoundException ex) {
            ex.printStackTrace();
        }
        System.out.println("JSONFile '" + fileName + "' has been created");
    }
}
