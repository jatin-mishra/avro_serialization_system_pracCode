
import java.io.File;
import java.io.IOException;

import org.apache.avro.Schema;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.generic.GenericDatumReader;
import org.apache.avro.generic.GenericData;


public class deserializationUsingParser{
	public static void main(String[] args) throws Exception{

		Schema schema = new Schema.Parser().parse("./Schema.avsc");

		DatumReader<GenericRecord> reader = new GenericDatumReader<GenericRecord>(schema);
		DataFileReader<GenericRecord> filereader = new DataFileReader<GenericRecord>(new File("data.txt"),reader);

		GenericRecord record = null;
		while(filereader.hasNext()){
			record = filereader.next(record);
			System.out.println(record);
		}

		System.out.println("done");
	}
}