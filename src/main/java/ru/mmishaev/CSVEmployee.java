package ru.mmishaev;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVEmployee {
    public void addCSVRecord(Employee employee) {
        String fileName = "data.csv";
        File csvData = new File(fileName);
        try(CSVWriter csvWrtr = new CSVWriter(new FileWriter(csvData, true),
                CSVWriter.DEFAULT_SEPARATOR,
                CSVWriter.NO_QUOTE_CHARACTER,
                CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                CSVWriter.DEFAULT_LINE_END)){
            csvWrtr.writeNext(new String[]{String.valueOf(employee.getId()),
                    employee.getFirstName(),
                    employee.getLastName(),
                    employee.getCountry(),
                    String.valueOf(employee.getAge())});
            //csvWrtr.writeNext(new String[]{"1", "John", "Doe", "USA", "25"});
            //csvWrtr.writeNext(new String[]{"2", "Ivan", "Petroff", "Russia", "35"});
        } catch(IOException exIO) {
            exIO.printStackTrace();
        }
        System.out.println("An entry has been added");
    }

    public List<Employee> parserCSV(String[] columnMapping, String fileName) {
        List<Employee> lstOfEmpl = new java.util.ArrayList<Employee>();
        try(CSVReader csvReader = new CSVReader(new FileReader(fileName))) {
            ColumnPositionMappingStrategy<Employee> strategy = new ColumnPositionMappingStrategy<>();
            strategy.setType(Employee.class);
            //strategy.setColumnMapping("id", "firstName", "lastName", "country", "age");
            strategy.setColumnMapping(columnMapping);
            CsvToBean<Employee> ctb = new CsvToBeanBuilder<Employee>(csvReader)
                    .withMappingStrategy(strategy)
                    .build();
            lstOfEmpl = ctb.parse();
            lstOfEmpl.forEach(System.out::println);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return lstOfEmpl;
    }
}
