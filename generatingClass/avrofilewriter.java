
import pace.Schema;
import org.apache.avro.specific.*;
import org.apache.avro.file.*;
import org.apache.avro.io.*;
import java.io.*;

public class avrofilewriter{
	public static void main(String[] args){
		Schema schema1 = new Schema();
		Schema schema2 = new Schema();
		Schema schema3 = new Schema();
		Schema schema4 = new Schema();
		Schema schema5 = new Schema();

		schema5.setName("xyz");
		schema4.setName("xyz");
		schema3.setName("xyz");
		schema2.setName("xyz");
		schema1.setName("xyz");

		schema1.setAge(1);
		schema2.setAge(1);
		schema3.setAge(1);
		schema4.setAge(1);
		schema5.setAge(1);


		DatumWriter<Schema> writer = new SpecificDatumWriter<Schema>(pace.Schema.class);
		DataFileWriter<Schema> data = new DataFileWriter<Schema>(writer);

		data.create(schema1.getSchema(),new File("./person.avro"));
		data.append(schema1);
		data.append(schema2);
		data.append(schema3);
		data.append(schema4);
		data.append(schema5);

		writer.close();
		data.close();

	}

}