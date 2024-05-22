package ru.mmishaev;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        //CSV TO JSON
        CSVEmployee csvEmployee = new CSVEmployee();
        Employee employee1 = new Employee(1, "John", "Doe", "USA", 25);
        Employee employee2 = new Employee(2, "Ivan", "Petroff", "RU", 35);
        csvEmployee.addCSVRecord(employee1);
        csvEmployee.addCSVRecord(employee2);

        String[] columnMapping = {"id", "firstName", "lastName", "country", "age"};
        String fileName = "data.csv";
        List<Employee> list = csvEmployee.parserCSV(columnMapping, fileName);
        System.out.println(list + System.lineSeparator());

        JSONEmployee jsonEmployee = new JSONEmployee();
        String csvToJsonEmployeeString = jsonEmployee.listToJSON(list);
        System.out.println(csvToJsonEmployeeString);

        //XML TO JSON
        XMLEmployee xmlemployee = new XMLEmployee();
        xmlemployee.XMLEmployeeCreator();
        fileName = "output.xml";
        List<Employee> listXML = xmlemployee.parseXML(fileName);
        System.out.println(listXML);
        String xmlToJsonEmployeeString = jsonEmployee.listToJSON(listXML);

        fileName = "CSVToJSON.json";
        jsonEmployee.writeJSON(fileName, csvToJsonEmployeeString);
        fileName = "XMLToJSON.json";
        jsonEmployee.writeJSON(fileName, xmlToJsonEmployeeString);
    }
}