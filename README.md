# GoEuro
GoEuro Repository
This project aims to generate a CSV file based on a searched expression informed as argument of the JAR execution.

The execution makes a call to a goEuro API that returns a JSON array data.

The array data of the JSON is transformed in CSV lines.

The CSV File is generated at the jar execution path as the following aspect: File_%expression%_yyyyMMddHHmmss.CSV
