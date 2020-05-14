import java.io.File;
import java.io.IOException;

import org.apache.avro.Schema;
import org.apache.avro.file.DataFileWriter;

import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.generic.GenericRecord;

import org.apache.avro.io.DatumWriter;


public class serializationUsingParser{
	public static void main(String[] args) throws Exception{
		Schema schema = new Schema.Parser().parse(new File("schema.avsc"));

		GenericRecord genOne = new GenericData.Record(schema);

		genOne.put("name","jatin");
		genOne.put("age",20);

		GenericRecord genTwo = new GenericData.Record(schema);
		genTwo.put("name","dfgvfb");
		genTwo.put("age",19);

		DatumWriter<GenericRecord> writer = new GenericDatumWriter<GenericRecord>(schema);
		DatumFileWriter<GenericRecord> filewriter = new DataFileWriter<GenericRecord>(writer);

		filewriter.create(schema,new File("./person.avro"));
		filewriter.append(genOne);
		filewriter.append(genTwo);

		filewriter.close();
		System.out.println("serialization done");

	}
}