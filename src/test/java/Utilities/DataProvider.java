package Utilities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class DataProvider {

	Fillo fillo = new Fillo();
	Connection connection;

	// Write the value into Excel

	public void writeExcelData(String testCaseID, String sheetName, String Columnname, String columnvalue)
			throws FilloException, IOException {
		connection = fillo.getConnection("./Testdata/Fillo1.xlsx");
		String strQuery = "Update " + sheetName + " Set " + Columnname + "='" + columnvalue + "' where TestCaseID='"
				+ testCaseID + "' ";
		connection.executeUpdate(strQuery);
		connection.close();

	}

	// Read the values form Excel
	public static HashMap<String, String> excelHashMapValues = new HashMap<String, String>();

	public HashMap<String, String> extractExcelData(String testCaseID, String sheetName)
			throws FilloException, IOException {
		connection = fillo.getConnection("./Testdata/Fillo.xlsx");
		String strQuery = "Select * from " + sheetName + " " + "where testcaseID" + " ='" + testCaseID + "'";
		Recordset recordset = connection.executeQuery(strQuery);
		while (recordset.next()) {
			ArrayList<String> ColCollection = recordset.getFieldNames();
			int Iter;
			int size = ColCollection.size();
			for (Iter = 0; Iter <= (size - 1); Iter++) {
				String ColName = ColCollection.get(Iter);
				String ColValue = recordset.getField(ColName);
				excelHashMapValues.put(ColName, ColValue);
			}
		}
		recordset.close();
		connection.close();
		return excelHashMapValues;
	}

}
